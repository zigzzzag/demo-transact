package com.example.demotransact.repository;

import com.example.demotransact.entity.AgreementEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgreementRepository extends CrudRepository<AgreementEntity, Long>, JpaSpecificationExecutor<AgreementEntity> {
}
