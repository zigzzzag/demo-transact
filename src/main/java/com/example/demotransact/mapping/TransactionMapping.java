package com.example.demotransact.mapping;

import com.example.demotransact.dto.transaction.TransactionCreateRequestDTO;
import com.example.demotransact.dto.transaction.TransactionDTO;
import com.example.demotransact.dto.transaction.TransactionIdDTO;
import com.example.demotransact.entity.TransactionEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TransactionMapping {

    public static TransactionEntity toTransactionEntity(Long agreementId, TransactionCreateRequestDTO dto) {
        TransactionEntity result = new TransactionEntity();
        result.setAgreementId(agreementId);
        result.setTransactionDateTime(dto.getTransactionDateTime());
        result.setSum(dto.getSum());
        result.setCommission(dto.getCommission());
        result.setNumber(dto.getNumber());
        return result;
    }

    public static TransactionIdDTO toTransactionIdDTO(TransactionEntity entity) {
        return TransactionIdDTO.builder()
                .id(entity.getId())
                .build();
    }

    public static TransactionDTO toTransactionDTO(TransactionEntity entity) {
        return TransactionDTO.builder()
                .id(entity.getId())
                .agreementId(entity.getAgreementId())
                .transactionDateTime(entity.getTransactionDateTime())
                .sum(entity.getSum())
                .commission(entity.getCommission())
                .number(entity.getNumber())
                .build();
    }
}
