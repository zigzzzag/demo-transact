package com.transact.service;

import com.transact.dto.transaction.TransactionCreateRequestDTO;
import com.transact.dto.transaction.TransactionDTO;
import com.transact.dto.transaction.TransactionFilterDTO;
import com.transact.dto.transaction.TransactionIdDTO;
import com.transact.entity.EntityType;
import com.transact.entity.TransactionEntity;
import com.transact.exception.EntityNotFoundException;
import com.transact.mapping.TransactionMapping;
import com.transact.repository.AgreementRepository;
import com.transact.repository.TransactionRepository;
import com.transact.specification.TransactionSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class TransactionService {

    private final AgreementRepository agreementRepository;
    private final TransactionRepository transactionRepository;

    public TransactionIdDTO createTransaction(Long agreementId, TransactionCreateRequestDTO dto) {
        agreementRepository.findById(agreementId)
                .orElseThrow(() -> new EntityNotFoundException(EntityType.AGREEMENT, agreementId));

        TransactionEntity transactionEntity = TransactionMapping.toTransactionEntity(agreementId, dto);
        return TransactionMapping.toTransactionIdDTO(transactionRepository.save(transactionEntity));
    }

    public void deleteTransaction(Long id) {
        // todo hard delete isn`t good, better, for example, change status to DELETED
        transactionRepository.findById(id)
                .ifPresent(transactionRepository::delete);
    }

    @Transactional(readOnly = true)
    public Page<TransactionDTO> searchTransactions(TransactionFilterDTO filter, Pageable pageable) {
        return transactionRepository.findAll(TransactionSpecification.allTransactions(filter), pageable)
                .map(TransactionMapping::toTransactionDTO);
    }
}
