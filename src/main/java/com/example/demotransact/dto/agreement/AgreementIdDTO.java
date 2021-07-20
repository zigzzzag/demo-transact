package com.example.demotransact.dto.agreement;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * DTO для получения только идентификатора Договора
 */
@Getter
@Builder
@AllArgsConstructor
public class AgreementIdDTO {

    /**
     * Идентификатор Договора
     */
    private Long id;

}
