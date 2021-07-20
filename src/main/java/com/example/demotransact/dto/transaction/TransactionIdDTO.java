package com.example.demotransact.dto.transaction;

import lombok.Builder;
import lombok.Getter;

/**
 * DTO для получения только идентификатора Транзакции
 */
@Getter
@Builder
public class TransactionIdDTO {

    /**
     * Идентификатор Транзакции
     */
    private Long id;

}
