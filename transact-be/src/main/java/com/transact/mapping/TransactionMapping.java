package com.transact.mapping;

import com.transact.dto.transaction.TransactionCreateRequestDTO;
import com.transact.dto.transaction.TransactionDTO;
import com.transact.dto.transaction.TransactionIdDTO;
import com.transact.entity.TransactionEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class TransactionMapping {

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

    public static TransactionCreateRequestDTO toTransactionCreateRequestDTO(TransactionDTO dto) {
        return TransactionCreateRequestDTO.builder()
            .transactionDateTime(dto.getTransactionDateTime())
            .sum(dto.getSum())
            .commission(dto.getCommission())
            .number(dto.getNumber())
            .build();
    }
}
