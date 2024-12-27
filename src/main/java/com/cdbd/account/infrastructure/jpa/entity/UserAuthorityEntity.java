package com.cdbd.account.infrastructure.jpa.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "userAuthority")
public class UserAuthorityEntity {
	@Id
	@Column(name = "userID") //직원아이디 (FK)
    private String userID;
	
	@Column(name = "userRole") //직원권한코드
    private String userRole;
	
	@Column(name = "assignedAt", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") //사용자 접속 시간
	private Timestamp assignedAt;
}