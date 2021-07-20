package com.example.demotransact.service;

import com.example.demotransact.BasicTest;
import com.example.demotransact.dto.agreement.AgreementDTO;
import com.example.demotransact.dto.agreement.AgreementFilterDTO;
import com.example.demotransact.util.TestData;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Pageable;

import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class AgreementServiceTest extends BasicTest {

    @BeforeAll
    static void setup() {
        log.info("@BeforeAll - executes once before all test methods in this class");
    }

    @BeforeEach
    void init() {
        log.info("@BeforeEach - executes before each test method in this class");
    }

    @Test
    void createAgreementSuccessTest() {
        var createRequest = TestData.agreementCreateRequestDTO();
        var agreementIdDTO = agreementService.createAgreement(createRequest);
        var agreementDTO = agreementService.getById(agreementIdDTO.getId());

        assertThat(agreementDTO)
                .usingRecursiveComparison()
                // todo remove openDate. Is need create schema with TIMESTAMP(9) WITH TIME ZONE
                // https://github.com/h2database/h2database/issues/1178
                .ignoringFields("id")
                .isEqualTo(createRequest);
    }

    @Test
    void updateAgreementSuccessTest() {
        var createRequest = TestData.agreementCreateRequestDTO();
        var agreementIdDTO = agreementService.createAgreement(createRequest);
        var agreementDTO = agreementService.getById(agreementIdDTO.getId());

        var updateRequest = TestData.agreementUpdateRequestDTO();
        agreementService.updateAgreement(agreementIdDTO.getId(), updateRequest);

        agreementDTO = agreementService.getById(agreementIdDTO.getId());
        assertThat(agreementDTO)
                .usingRecursiveComparison()
                // todo remove openDate. Is need create schema with TIMESTAMP(9) WITH TIME ZONE
                // https://github.com/h2database/h2database/issues/1178
                .ignoringFields("id")
                .isEqualTo(updateRequest);
    }

    @Test
    void searchAgreementsSuccessTest() {
        var cr1 = TestData.agreementCreateRequestDTO();
        var agr1 = agreementService.createAgreement(cr1);

        var cr2 = TestData.agreementCreateRequestDTO();
        var agr2 = agreementService.createAgreement(cr2);

        var cr3 = TestData.agreementCreateRequestDTO();
        var agr3 = agreementService.createAgreement(cr3);

        var agrIds = Set.of(agr1.getId(), agr2.getId(), agr3.getId());
        AgreementFilterDTO filter = AgreementFilterDTO.builder()
                .ids(agrIds)
                .build();
        var page = agreementService.searchAgreements(filter, Pageable.unpaged());
        assertEquals(3, page.getTotalElements());
        assertEquals(
                agrIds,
                page.getContent().stream().map(AgreementDTO::getId).collect(Collectors.toSet())
        );
    }
}