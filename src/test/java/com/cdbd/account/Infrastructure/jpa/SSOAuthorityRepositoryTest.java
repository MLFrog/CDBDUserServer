package com.cdbd.account.Infrastructure.jpa;
import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Timestamp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.cdbd.account.infrastructure.jpa.entity.SSOAuthorityEntity;
import com.cdbd.account.infrastructure.jpa.repository.SSOAuthorityRepository;

public class SSOAuthorityRepositoryTest extends RepositoryTestMain {

    private static final Logger logger = LoggerFactory.getLogger(SSOAuthorityRepositoryTest.class);

    @Autowired
    private SSOAuthorityRepository ssoAuthorityRepository;

    private SSOAuthorityEntity ssoAuthorityEntity;

    @BeforeEach
    public void setUp() {
        // given: SSOAuthorityEntity 객체를 준비
        ssoAuthorityEntity = new SSOAuthorityEntity();
        ssoAuthorityEntity.setSsoId("SSO123");
        ssoAuthorityEntity.setSsoServiceID("Service001");
        ssoAuthorityEntity.setSsoAccessLevel("ADMIN");
        ssoAuthorityEntity.setSsoAssignedAt(new Timestamp(System.currentTimeMillis()));

        logger.info("객체 생성 확인: {}", ssoAuthorityEntity);
    }

    @Test
    public void SSO권한생성하기() {
        // given: Entity 준비

        // when: 데이터를 저장하고 반환된 엔티티를 확인
        SSOAuthorityEntity savedEntity = ssoAuthorityRepository.save(ssoAuthorityEntity);

        // then: 저장된 엔티티의 필드 값이 정확한지 검증
        assertThat(savedEntity.getSsoId()).isEqualTo("SSO123");
        assertThat(savedEntity.getSsoServiceID()).isEqualTo("Service001");
        assertThat(savedEntity.getSsoAccessLevel()).isEqualTo("ADMIN");
        assertThat(savedEntity.getSsoAssignedAt()).isNotNull();

        logger.info("SSO 권한 생성 테스트 완료: {}", savedEntity);
    }

    @Test
    public void SSO권한조회하기() {
        // given: Entity를 저장
        ssoAuthorityRepository.save(ssoAuthorityEntity);

        // when: 특정 ssoId와 ssoServiceID로 엔티티 조회
        SSOAuthorityEntity foundEntity = ssoAuthorityRepository.findById("SSO123").orElse(null);

        // then: 조회된 엔티티 값 검증
        assertThat(foundEntity).isNotNull();
        assertThat(foundEntity.getSsoId()).isEqualTo("SSO123");
        assertThat(foundEntity.getSsoServiceID()).isEqualTo("Service001");

        logger.info("SSO 권한 조회 테스트 완료: {}", foundEntity);
    }

    @Test 
    public void SSO권한삭제하기() {
        // given: Entity 저장
        ssoAuthorityRepository.save(ssoAuthorityEntity);

        // when: 엔티티 삭제
        ssoAuthorityRepository.deleteById("SSO123");

        // then: 삭제 후 조회하여 null 반환되는지 검증
        SSOAuthorityEntity foundEntity = ssoAuthorityRepository.findById("SSO123").orElse(null);

        assertThat(foundEntity).isNull();
        logger.info("SSO 권한 삭제 테스트 완료. 삭제된 권한 : SSO아이디(SSO123)");
    }
}
