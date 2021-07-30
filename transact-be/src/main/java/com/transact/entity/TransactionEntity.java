package com.transact.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * Транзакция
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "DT_TRANSACTION")
public class TransactionEntity {

    /**
     * Идентификатор Транзакции
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Идентификатор Договора
     */
    @Column(name = "AGREEMENT_ID")
    private Long agreementId;

    /**
     * Дата и время проведения транзакции
     */
    @Column(name = "TRANSACTION_DATETIME")
    private Instant transactionDateTime;

    /**
     * Сумма транзакции
     */
    @Column(name = "TRANSACTION_SUM")
    private BigDecimal sum;

    /**
     * Сумма комиссии
     */
    @Column(name = "COMMISSION")
    private BigDecimal commission;

    /**
     * Уникальный номер транзакции
     */
    @Column(name = "TRANSACTION_NUM")
    private String number;
}
