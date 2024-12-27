package com.cdbd.account.Infrastructure.jpa;
import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Timestamp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.cdbd.account.infrastructure.jpa.entity.UserAuthorityEntity;
import com.cdbd.account.infrastructure.jpa.repository.UserAuthorityRepository;

public class UserAuthorityRepositoryTest extends RepositoryTestMain {

    private static final Logger logger = LoggerFactory.getLogger(UserAuthorityRepositoryTest.class);

    @Autowired
    private UserAuthorityRepository userAuthorityRepository;

    private UserAuthorityEntity userAuthorityEntity;

    @BeforeEach
    public void setUp() {
        // given: UserAuthorityEntity 객체를 준비
        userAuthorityEntity = new UserAuthorityEntity();
        userAuthorityEntity.setUserID("user001");
        userAuthorityEntity.setUserRole("ADMIN");
        userAuthorityEntity.setAssignedAt(new Timestamp(System.currentTimeMillis()));

        logger.info("객체 생성 확인: {}", userAuthorityEntity);
    }

    @Test
    public void 사용자권한생성하기() {
        // given: Entity 준비

        // when: 데이터를 저장하고 반환된 엔티티를 확인
        UserAuthorityEntity savedEntity = userAuthorityRepository.save(userAuthorityEntity);

        // then: 저장된 엔티티의 필드 값이 정확한지 검증
        assertThat(savedEntity.getUserID()).isEqualTo("user001");
        assertThat(savedEntity.getUserRole()).isEqualTo("ADMIN");
        assertThat(savedEntity.getAssignedAt()).isNotNull();

        logger.info("사용자 권한 생성 테스트 완료: {}", savedEntity);
    }

    @Test
    public void 사용자권한조회하기() {
        // given: Entity를 저장
        userAuthorityRepository.save(userAuthorityEntity);

        // when: 특정 userID로 엔티티 조회
        UserAuthorityEntity foundEntity = userAuthorityRepository.findById("user001").orElse(null);

        // then: 조회된 엔티티 값 검증
        assertThat(foundEntity).isNotNull();
        assertThat(foundEntity.getUserID()).isEqualTo("user001");
        assertThat(foundEntity.getUserRole()).isEqualTo("ADMIN");

        logger.info("사용자 권한 조회 테스트 완료: {}", foundEntity);
    }

    @Test
    public void 사용자권한삭제하기() {
        // given: Entity 저장
        userAuthorityRepository.save(userAuthorityEntity);

        // when: 엔티티 삭제
        userAuthorityRepository.deleteById("user001");

        // then: 삭제 후 조회하여 null 반환되는지 검증
        UserAuthorityEntity foundEntity = userAuthorityRepository.findById("user001").orElse(null);

        assertThat(foundEntity).isNull();
        logger.info("사용자 권한 삭제 테스트 완료. 삭제된 권한 : 사용자ID(user001)");
    }
}
