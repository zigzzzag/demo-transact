package com.transact.dto.transaction;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * DTO для создания Транзакции
 */
@Getter
@Builder
public class TransactionCreateRequestDTO {

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
