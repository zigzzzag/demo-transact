package com.transact.service;

import com.transact.dto.agreement.*;
import com.transact.entity.AgreementEntity;
import com.transact.entity.EntityType;
import com.transact.exception.EntityNotFoundException;
import com.transact.mapping.AgreementMapping;
import com.transact.repository.AgreementRepository;
import com.transact.specification.AgreementSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class AgreementService {

    private final AgreementRepository agreementRepository;

    @Transactional(readOnly = true)
    public AgreementDTO getById(Long id) {
        return agreementRepository.findById(id)
            .map(AgreementMapping::toAgreementDTO)
            .orElseThrow(() -> new EntityNotFoundException(EntityType.AGREEMENT, id));
    }

    public AgreementIdDTO createAgreement(AgreementCreateRequestDTO dto) {
        return Optional.of(dto)
            .map(AgreementMapping::toAgreementEntity)
            .map(agreementRepository::save)
            .map(AgreementMapping::toAgreementIdDTO)
            .orElse(null);
    }

    public AgreementIdDTO updateAgreement(Long id, AgreementUpdateRequestDTO dto) {
        AgreementEntity agreement = agreementRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(EntityType.AGREEMENT, id));

        AgreementEntity agreementEntity = AgreementMapping.toAgreementEntity(agreement, dto);
        return AgreementMapping.toAgreementIdDTO(agreementRepository.save(agreementEntity));
    }

    @Transactional(readOnly = true)
    public Page<AgreementDTO> searchAgreements(AgreementFilterDTO filter, Pageable pageable) {
        return agreementRepository.findAll(AgreementSpecification.allAgreements(filter), pageable)
            .map(AgreementMapping::toAgreementDTO);
    }

    @Secured("ROLE_ADMIN")
    @Transactional(readOnly = true)
    public Page<AgreementDTO> secureSearchAgreements(AgreementFilterDTO filter, Pageable pageable) {
        return agreementRepository.findAll(AgreementSpecification.allAgreements(filter), pageable)
            .map(AgreementMapping::toAgreementDTO);
    }
}
