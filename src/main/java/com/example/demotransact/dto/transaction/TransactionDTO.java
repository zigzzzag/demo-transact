package com.example.demotransact.dto.transaction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * DTO для получения Транзакции
 */
@Getter
@Builder
@AllArgsConstructor
public class TransactionDTO {

    /**
     * Идентификатор Транзакции
     */
    private Long id;

    /**
     * Идентификатор Договора
     */
    private Long agreementId;

    /**
     * Дата и время проведения транзакции
     */
    private Instant transactionDateTime;

    /**
     * Сумма транзакции
     */
    private BigDecimal sum;

    /**
     * Сумма комиссии
     */
    private BigDecimal commission;

    /**
     * Уникальный номер транзакции
     */
    private String number;
}
