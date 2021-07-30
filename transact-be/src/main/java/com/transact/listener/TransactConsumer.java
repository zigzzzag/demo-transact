package com.transact.listener;

import com.transact.dto.transaction.TransactionCreateRequestDTO;
import com.transact.dto.transaction.TransactionDTO;
import com.transact.mapping.TransactionMapping;
import com.transact.service.TransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransactConsumer {

    private final TransactionService transactionService;

    @KafkaListener(id = "strId", topics = "string_msg")
    public void listen(String in) {
        log.info("message received: {}", in);
    }

    @KafkaListener(id = "transactId", topics = "transact", containerFactory = "transactionDTOKafkaListenerContainerFactory")
    public void listenTransaction(TransactionDTO dto) {
        TransactionCreateRequestDTO createDto = TransactionMapping.toTransactionCreateRequestDTO(dto);
        transactionService.createTransaction(dto.getAgreementId(), createDto);
        log.info("Transaction {} created!", dto);
    }
}
