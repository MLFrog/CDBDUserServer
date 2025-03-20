// UserService :
// 서비스 계층에서 제공해야 하는 비즈니스 로직을 처리하는 메서드를 정의한 인터페이스.
// ex) 사용자 등록, 사용자 정보 수정

package com.cdbd.account.application.user;

import com.cdbd.account.infrastructure.jpa.entity.UserEntity;

public interface UserService {
	   // UserEntity에 userName으로 데이터 접근
	   UserEntity getUserData(String userName);
}