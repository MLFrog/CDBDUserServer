package com.cdbd.account.infrastructure.jpa.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "USER_INFO")
public class UserEntity {
	@Id
	@Column(name = "userID") //직원아이디 (PK)
    private String userID;
	
	@Column(name = "userName") //직원이름
    private String userName;
	
	@Column(name = "password") //비밀번호
	private String password;
	
	@Column(name = "empno") //사원번호
	private String empno;

	@Column(name = "createdAt", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp createdAt;
	
	@Column(name = "updatedAt", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp updatedAt;
}