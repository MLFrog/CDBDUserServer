package com.cdbd.account.infrastructure.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdbd.account.infrastructure.jpa.entity.UserAuthorityEntity;

@Repository
public interface UserAuthorityRepository extends JpaRepository<UserAuthorityEntity, String>{

}
