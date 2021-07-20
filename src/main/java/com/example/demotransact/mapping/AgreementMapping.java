package com.example.demotransact.mapping;

import com.example.demotransact.dto.agreement.AgreementCreateRequestDTO;
import com.example.demotransact.dto.agreement.AgreementDTO;
import com.example.demotransact.dto.agreement.AgreementIdDTO;
import com.example.demotransact.dto.agreement.AgreementUpdateRequestDTO;
import com.example.demotransact.entity.AgreementEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AgreementMapping {

    public static AgreementDTO toAgreementDTO(AgreementEntity entity) {
        return AgreementDTO.builder()
                .id(entity.getId())
                .number(entity.getNumber())
                .openDate(entity.getOpenDate())
                .orgName(entity.getOrgName())
                .inn(entity.getInn())
                .kpp(entity.getKpp())
                .build();
    }

    public static AgreementEntity toAgreementEntity(AgreementCreateRequestDTO dto) {
        AgreementEntity result = new AgreementEntity();
        result.setNumber(dto.getNumber());
        result.setOpenDate(dto.getOpenDate());
        result.setOrgName(dto.getOrgName());
        result.setInn(dto.getInn());
        result.setKpp(dto.getKpp());
        return result;
    }

    public static AgreementEntity toAgreementEntity(AgreementEntity entity, AgreementUpdateRequestDTO dto) {
        entity.setNumber(dto.getNumber());
        entity.setOpenDate(dto.getOpenDate());
        entity.setOrgName(dto.getOrgName());
        entity.setInn(dto.getInn());
        entity.setKpp(dto.getKpp());
        return entity;
    }

    public static AgreementIdDTO toAgreementIdDTO(AgreementEntity entity) {
        return AgreementIdDTO.builder()
                .id(entity.getId())
                .build();
    }
}
