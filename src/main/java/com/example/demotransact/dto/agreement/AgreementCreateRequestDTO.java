package com.example.demotransact.dto.agreement;

import lombok.Builder;
import lombok.Getter;

import java.time.Instant;

/**
 * DTO для создания Договора
 */
@Getter
@Builder
public class AgreementCreateRequestDTO {

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
