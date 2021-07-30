package com.zigzzzag.transact_producer.service;

import com.zigzzzag.transact_producer.dto.TransactProducerDTO;
import com.zigzzzag.transact_producer.dto.TransactionDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransactionProduceService {

    private final KafkaTemplate<String, String> stringKafkaTemplate;
    private final KafkaTemplate<String, TransactionDTO> transactionKafkaTemplate;

    public void produceStrings(TransactProducerDTO dto) {
        for (int i = 0; i < dto.getCount(); i++) {
            sentStringMessage();
        }
    }

    public void produceTransactions(TransactProducerDTO dto) {
        for (int i = 0; i < dto.getCount(); i++) {
            sentTransactionMessage(i);
        }
    }

    private void sentTransactionMessage(int sum) {
        TransactionDTO dto = TransactionDTO.builder()
            .agreementId(1L)
            .transactionDateTime(Instant.now())
            .sum(new BigDecimal(sum))
            .commission(BigDecimal.ONE)
            .number(UUID.randomUUID().toString())
            .build();
        ListenableFuture<SendResult<String, TransactionDTO>> future = transactionKafkaTemplate.send("transact", dto);
        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onSuccess(SendResult<String, TransactionDTO> result) {
                log.info("Sent transactDTO=[{}] with offset=[{}]", dto, result.getRecordMetadata().offset());
            }

            @Override
            public void onFailure(Throwable ex) {
                log.error("Unable to send transactDTO=[{}] due to : {}", dto, ex.getMessage());
            }
        });
    }

    private void sentStringMessage() {
        String message = "Hello Sanya! random uuid = " + UUID.randomUUID() + ", now: " + Instant.now();
        ListenableFuture<SendResult<String, String>> future = stringKafkaTemplate.send("string_msg", message);

        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onSuccess(SendResult<String, String> result) {
                log.info("Sent message=[{}] with offset=[{}]", message, result.getRecordMetadata().offset());
            }

            @Override
            public void onFailure(Throwable ex) {
                log.info("Unable to send message=[{}] due to : {}", message, ex.getMessage());
            }
        });

    }
}
