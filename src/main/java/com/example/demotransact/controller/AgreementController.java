package com.example.demotransact.controller;

import com.example.demotransact.dto.agreement.*;
import com.example.demotransact.dto.transaction.TransactionCreateRequestDTO;
import com.example.demotransact.dto.transaction.TransactionIdDTO;
import com.example.demotransact.service.AgreementService;
import com.example.demotransact.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import static com.example.demotransact.controller.ApiVersion.API_V1;

@RestController
@RequestMapping(API_V1 + "/agreements")
@RequiredArgsConstructor
public class AgreementController {

    private final AgreementService agreementService;
    private final TransactionService transactionService;

    @GetMapping("/{id}")
    public AgreementDTO getAgreement(@PathVariable Long id) {
        return agreementService.getById(id);
    }

    @PostMapping
    public AgreementIdDTO createAgreement(@RequestBody AgreementCreateRequestDTO dto) {
        return agreementService.createAgreement(dto);
    }

    @PutMapping("/{id}")
    public AgreementIdDTO updateAgreement(
        @PathVariable Long id,
        @RequestBody AgreementUpdateRequestDTO dto
    ) {
        return agreementService.updateAgreement(id, dto);
    }

    @PostMapping("/search")
    public Page<AgreementDTO> searchAgreements(
        @PageableDefault Pageable pageable,
        @RequestBody AgreementFilterDTO filter
    ) {
        return agreementService.searchAgreements(filter, pageable);
    }

    @PostMapping("/secure/search")
    public Page<AgreementDTO> searchSecureAgreements(
        @PageableDefault Pageable pageable,
        @RequestBody AgreementFilterDTO filter
    ) {
        return agreementService.secureSearchAgreements(filter, pageable);
    }

    @PostMapping("/{agreementId}/transactions")
    public TransactionIdDTO createTransaction(
        @PathVariable Long agreementId,
        @RequestBody TransactionCreateRequestDTO dto
    ) {
        return transactionService.createTransaction(agreementId, dto);
    }
}
