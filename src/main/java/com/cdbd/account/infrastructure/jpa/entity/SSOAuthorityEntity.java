package com.cdbd.account.infrastructure.jpa.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ssoAuthority")
public class SSOAuthorityEntity {
	@Id
	@Column(name = "ssoId") //sso아이디 (FK)
    private String ssoId;
	
	@Column(name = "ssoServiceID") //sso서비스아이디 (FK)
    private String ssoServiceID;
	
	@Column(name = "ssoAccessLevel") //sso서비스접속권한등급
    private String ssoAccessLevel;
	
	@Column(name = "ssoAssignedAt", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") //sso접속시간
	private Timestamp ssoAssignedAt;
}