package com.transact.dto.agreement;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.Instant;

/**
 * DTO для получения Договора
 */
@Getter
@Builder
@AllArgsConstructor
public class AgreementDTO {

    /**
     * Идентификатор Договора
     */
    private Long id;

    /**
     * Номер договора
     */
    private String number;

    /**
     * Дата открытия договора
     */
    private Instant openDate;

    /**
     * Наименование юридического лица
     */
    private String orgName;

    /**
     * ИНН
     */
    private String inn;

    /**
     * КПП
     */
    private String kpp;
}
