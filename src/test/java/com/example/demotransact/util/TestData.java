package com.example.demotransact.util;

import com.example.demotransact.dto.agreement.AgreementCreateRequestDTO;
import com.example.demotransact.dto.agreement.AgreementUpdateRequestDTO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;

import java.time.Instant;

import static java.time.temporal.ChronoUnit.MILLIS;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TestData {

    public static AgreementCreateRequestDTO agreementCreateRequestDTO() {
        return AgreementCreateRequestDTO.builder()
                .number(RandomStringUtils.randomNumeric(100))
                .openDate(Instant.now().truncatedTo(MILLIS))
                .orgName(RandomStringUtils.randomNumeric(100))
                .inn(RandomStringUtils.randomNumeric(100))
                .kpp(RandomStringUtils.randomNumeric(100))
                .build();
    }

    public static AgreementUpdateRequestDTO agreementUpdateRequestDTO() {
        return AgreementUpdateRequestDTO.builder()
                .number(RandomStringUtils.randomNumeric(100))
                .openDate(Instant.now().truncatedTo(MILLIS))
                .orgName(RandomStringUtils.randomNumeric(100))
                .inn(RandomStringUtils.randomNumeric(100))
                .kpp(RandomStringUtils.randomNumeric(100))
                .build();
    }
}
