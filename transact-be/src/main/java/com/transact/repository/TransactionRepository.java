package com.transact.repository;

import com.transact.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<TransactionEntity, Long>, JpaSpecificationExecutor<TransactionEntity> {
}
