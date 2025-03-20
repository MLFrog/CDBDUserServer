// UserServiceImpl :
// UserService 인터페이스의 비즈니스 로직을 실제 구현한 곳.
// ex) UserJpaRepository를 사용하여 데이터를 조회, 저장하는 로직 작성 가능.
// 클라이언트에서 UserService 타입으로 호출하여 서비스 기능 이용 가능.

package com.cdbd.account.application.user.impl;

import org.springframework.stereotype.Service;

import com.cdbd.account.application.user.UserService;
import com.cdbd.account.infrastructure.jpa.entity.UserEntity;
import com.cdbd.account.infrastructure.jpa.repository.UserJpaRepository;

@Service // Spring이 자동으로 빈으로 등록하도록 함
public class UserServiceImpl implements UserService {

    private final UserJpaRepository userRepository;

    // UserServiceImpl이 UserJpaRepository 객체에 의존하고 있음을 의미.
    // Spring은 이 UserJpaRepository를 자동으로 생성하고, UserServiceImpl의 생성자에 주입하여, 
    // UserServiceImpl 클래스에서 해당 리포지토리를 사용하여 데이터베이스와 상호작용할 수 있도록 하는 역할.
    public UserServiceImpl(UserJpaRepository userRepository) {
        this.userRepository = userRepository;
    }

    // getUserData 메서드 구현: 사용자 이름을 기반으로 사용자 정보 조회
    @Override
    public UserEntity getUserData(String userName) {
    	System.out.println( "UserServiceImpl.java 탔음");
        return userRepository.findByUserName(userName); // JPA 레포지토리 사용
    }
}