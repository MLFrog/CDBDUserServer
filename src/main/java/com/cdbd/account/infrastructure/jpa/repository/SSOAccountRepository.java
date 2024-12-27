package com.cdbd.account.infrastructure.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdbd.account.infrastructure.jpa.entity.SSOAccountEntity;

@Repository
public interface SSOAccountRepository extends JpaRepository<SSOAccountEntity, String>{

}
