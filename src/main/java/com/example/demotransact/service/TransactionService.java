package com.example.demotransact.service;

import com.example.demotransact.dto.transaction.TransactionCreateRequestDTO;
import com.example.demotransact.dto.transaction.TransactionDTO;
import com.example.demotransact.dto.transaction.TransactionFilterDTO;
import com.example.demotransact.dto.transaction.TransactionIdDTO;
import com.example.demotransact.entity.AgreementEntity;
import com.example.demotransact.entity.EntityType;
import com.example.demotransact.entity.TransactionEntity;
import com.example.demotransact.exception.EntityNotFoundException;
import com.example.demotransact.mapping.TransactionMapping;
import com.example.demotransact.repository.AgreementRepository;
import com.example.demotransact.repository.TransactionRepository;
import com.example.demotransact.specification.TransactionSpecification;
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
