package com.cdbd.account.infrastructure.jpa.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ssoService")
public class SSOServiceEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 증가 전략
    @Column(name = "ID") // ID 컬럼을 추가
    private Long id;  // 새로운 ID 컬럼을 추가
	
	@Column(name = "ssoId") //sso 통합로그인 id
    private String ssoId;
	
	@Column(name = "ssoServiceName") //sso 통합로그인 서비스이름
    private String ssoServiceName;

	@Column(name = "createdAt", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp createdAt;
	
	@Column(name = "updatedAt", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp updatedAt;
	
	@Column(name = "ssoServiceStatus") //sso서비스상태값
    private String ssoStatus;
}