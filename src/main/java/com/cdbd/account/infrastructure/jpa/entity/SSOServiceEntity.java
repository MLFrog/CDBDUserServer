package com.cdbd.account.infrastructure.jpa.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ssoService")
public class SSOServiceEntity {
	@Id
	@Column(name = "ssoServiceId") //sso서비스아이디 (FK)
    private String ssoServiceId;
	
	@Column(name = "ssoServiceName") //sso서비스이름
    private String ssoServiceName;

	@Column(name = "createdAt", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp createdAt;
	
	@Column(name = "updatedAt", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp updatedAt;
	
	@Column(name = "ssoServiceStatus") //sso서비스상태값
    private String ssoStatus;
}