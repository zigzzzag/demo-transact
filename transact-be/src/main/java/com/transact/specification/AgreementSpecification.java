package com.transact.specification;

import com.transact.dto.agreement.AgreementFilterDTO;
import com.transact.entity.AgreementEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class AgreementSpecification {

    public static Specification<AgreementEntity> allAgreements(AgreementFilterDTO filter) {
        return (r, cq, cb) -> {
            // todo add AgreementEntity_

            // todo refac
            List<Predicate> predicates = new ArrayList<>();
            if (!CollectionUtils.isEmpty(filter.getIds())) {
                predicates.add(cb.in(r.get("id")).value(filter.getIds()));
            }
            if (StringUtils.hasText(filter.getNumber())) {
                predicates.add(cb.like(r.get("number"), filter.getNumber()));
            }
            if (StringUtils.hasText(filter.getOrgName())) {
                predicates.add(cb.like(r.get("orgName"), filter.getOrgName()));
            }
            if (StringUtils.hasText(filter.getInn())) {
                predicates.add(cb.like(r.get("inn"), filter.getInn()));
            }
            if (StringUtils.hasText(filter.getKpp())) {
                predicates.add(cb.like(r.get("kpp"), filter.getKpp()));
            }
            // todo dateRange
            // cb.between()

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
