package com.cdbd.account.infrastructure.jpa.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

// 키3개(사람이름, 전화번호)를 만들어서 값 가져오게끔 만들기 : 테이블에 전화번호를 따로 저장할 필요는 없음
// id 생성시 전화번호 입력하게 만들 것
// 테이블 id값 넣어주기
// api가져와서 활용할것
@Data
@Entity
@Table(name = "USER_INFO")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //자동 증가 전략
    @Column(name = "ID") //ID 컬럼을 추가
    private Long id;  //새로운 ID 컬럼을 추가
	
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