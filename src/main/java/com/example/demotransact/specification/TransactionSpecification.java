package com.example.demotransact.specification;

import com.example.demotransact.dto.transaction.TransactionFilterDTO;
import com.example.demotransact.entity.TransactionEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TransactionSpecification {

    public static Specification<TransactionEntity> allTransactions(TransactionFilterDTO filter) {
        return (r, cq, cb) -> {
            // todo add TransactionEntity_

            List<Predicate> predicates = new ArrayList<>();
            // todo ids
            // cb.in(ids)
            // todo agreementIds
            // cb.in(agreementIds)
            // todo transactionDateTime dateTimeRange
            // cb.range(from, to)
            // todo sum range
            // cb.range(from, to)
            // todo commission range
            // cb.range(from, to)

            // todo refac
            if (StringUtils.hasText(filter.getNumber())) {
                predicates.add(cb.like(r.get("number"), filter.getNumber()));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
