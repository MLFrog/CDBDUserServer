package com.cdbd.account.infrastructure.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdbd.account.infrastructure.jpa.entity.UserEntity;

@Repository
public interface UserJpaRepository extends JpaRepository<UserEntity, String>{

	UserEntity findByUserName(String userName);

}