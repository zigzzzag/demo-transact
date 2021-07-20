package com.example.demotransact.dto.transaction;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Set;

/**
 * DTO для поиска Транзакций
 */
@Getter
@Builder
public class TransactionFilterDTO {

    /**
     * Список идентификаторов Транзакций
     */
    private Set<Long> ids;

    /**
     * Список идентификаторов Договоров
     */
    private Set<Long> agreementIds;

    /**
     * Дата и время проведения транзакции
     */
    // todo dateRange
    private Instant transactionDateTime;

    /**
     * Сумма транзакции
     */
    // todo sumRange
    private BigDecimal sum;

    /**
     * Сумма комиссии
     */
    // todo sumRange
    private BigDecimal commission;

    /**
     * Уникальный номер транзакции
     */
    private String number;
}
