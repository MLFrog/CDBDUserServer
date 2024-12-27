package com.cdbd.account.Infrastructure.jpa;
import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Timestamp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.cdbd.account.infrastructure.jpa.entity.UserEntity;
import com.cdbd.account.infrastructure.jpa.repository.UserRepository;

public class UserRepositoryTest extends RepositoryTestMain {

    private static final Logger logger = LoggerFactory.getLogger(UserRepositoryTest.class);

    @Autowired
    private UserRepository userRepository;

    private UserEntity userEntity;

    @BeforeEach
    public void setUp() {
        // given: UserEntity 객체를 준비
        userEntity = new UserEntity();
        userEntity.setUserID("user001");
        userEntity.setUserName("John Doe");
        userEntity.setPassword("password123");
        userEntity.setEmpno("EMP001");
        userEntity.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        userEntity.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

        logger.info("객체 생성 확인: {}", userEntity);
    }

    @Test
    public void 사용자생성하기() {
        // given: Entity 준비

        // when: 데이터를 저장하고 반환된 엔티티를 확인
        UserEntity savedEntity = userRepository.save(userEntity);

        // then: 저장된 엔티티의 필드 값이 정확한지 검증
        assertThat(savedEntity.getUserID()).isEqualTo("user001");
        assertThat(savedEntity.getUserName()).isEqualTo("John Doe");
        assertThat(savedEntity.getPassword()).isEqualTo("password123");
        assertThat(savedEntity.getEmpno()).isEqualTo("EMP001");
        assertThat(savedEntity.getCreatedAt()).isNotNull();
        assertThat(savedEntity.getUpdatedAt()).isNotNull();

        logger.info("사용자 생성 테스트 완료: {}", savedEntity);
    }

    @Test
    public void 사용자조회하기() {
        // given: Entity를 저장
        userRepository.save(userEntity);

        // when: 특정 userID로 엔티티 조회
        UserEntity foundEntity = userRepository.findById("user001").orElse(null);

        // then: 조회된 엔티티 값 검증
        assertThat(foundEntity).isNotNull();
        assertThat(foundEntity.getUserID()).isEqualTo("user001");
        assertThat(foundEntity.getUserName()).isEqualTo("John Doe");
        assertThat(foundEntity.getPassword()).isEqualTo("password123");
        assertThat(foundEntity.getEmpno()).isEqualTo("EMP001");

        logger.info("사용자 조회 테스트 완료: {}", foundEntity);
    }

    @Test
    public void 사용자삭제하기() {
        // given: Entity 저장
        userRepository.save(userEntity);

        // when: 엔티티 삭제
        userRepository.deleteById("user001");

        // then: 삭제 후 조회하여 null 반환되는지 검증
        UserEntity foundEntity = userRepository.findById("user001").orElse(null);

        assertThat(foundEntity).isNull();
        logger.info("사용자 삭제 테스트 완료. 삭제된 사용자 : 사용자ID(user001)");
    }
}

