package com.transact.dto.agreement;

import lombok.Builder;
import lombok.Getter;

import java.time.Instant;
import java.util.Set;

/**
 * DTO для поиска Договоров
 */
@Getter
@Builder
public class AgreementFilterDTO {

    /**
     * Идентификаторы Договоров
     */
    private Set<Long> ids;

    /**
     * Номер договора
     */
    private String number;

    /**
     * Дата открытия договора
     */
    // todo change to dateRange
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
