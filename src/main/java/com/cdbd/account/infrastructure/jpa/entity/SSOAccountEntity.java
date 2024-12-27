package com.cdbd.account.infrastructure.jpa.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ssoAccount")
public class SSOAccountEntity {
	@Id
	@Column(name = "userID") //직원아이디 (PK)
    private String userID;
	
	@Column(name = "ssoProviderId") //sso제공자아이디
    private String ssoProviderId;

	@Column(name = "createdAt", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp createdAt;
	
	@Column(name = "updatedAt", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp updatedAt;
	
	@Column(name = "ssoStatus") //sso상태값
    private String ssoStatus;
	
}