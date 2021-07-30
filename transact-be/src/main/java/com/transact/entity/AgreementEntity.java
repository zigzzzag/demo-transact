package com.transact.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

/**
 * Договор
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "DT_AGREEMENT")
public class AgreementEntity {

    /**
     * Идентификатор Договора
     */
    @Id
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Номер договора
     */
    @Column(name = "AGR_NUMBER")
    private String number;

    /**
     * Дата открытия договора
     */
    @Column(name = "OPEN_DATE")
    private Instant openDate;

    /**
     * Наименование юридического лица
     */
    @Column(name = "ORG_NAME")
    private String orgName;

    /**
     * ИНН
     */
    @Column(name = "INN")
    private String inn;

    /**
     * КПП
     */
    @Column(name = "KPP")
    private String kpp;
}
