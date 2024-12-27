package com.cdbd.account.Infrastructure.jpa;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Timestamp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.cdbd.account.infrastructure.jpa.entity.SSOAccountEntity;
import com.cdbd.account.infrastructure.jpa.repository.SSOAccountRepository;

public class SSOAccountRepositoryTest extends RepositoryTestMain {

    private static final Logger logger = LoggerFactory.getLogger(SSOAccountRepositoryTest.class);

    @Autowired
    private SSOAccountRepository ssoAccountRepository;

    private SSOAccountEntity ssoAccountEntity;

    @BeforeEach
    public void setUp() {
        // given: SSOAccountEntity 객체를 준비
        ssoAccountEntity = new SSOAccountEntity();
        ssoAccountEntity.setUserID("U001");
        ssoAccountEntity.setSsoProviderId("Provider001");
        ssoAccountEntity.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        ssoAccountEntity.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        ssoAccountEntity.setSsoStatus("ACTIVE");

        logger.info("객체 생성 확인: {}", ssoAccountEntity);
    }

    @Test
    public void SSO계정생성하기() {
        // given: Entity 준비

        // when: 데이터를 저장하고 반환된 엔티티를 확인
        SSOAccountEntity savedEntity = ssoAccountRepository.save(ssoAccountEntity);

        // then: 저장된 엔티티의 필드 값이 정확한지 검증
        assertThat(savedEntity.getUserID()).isEqualTo("U001");
        assertThat(savedEntity.getSsoProviderId()).isEqualTo("Provider001");
        assertThat(savedEntity.getSsoStatus()).isEqualTo("ACTIVE");

        logger.info("SSO 계정 생성 테스트 완료: {}", savedEntity);
    }

    @Test
    public void SSO계정조회하기() {
        // given: Entity를 저장
        ssoAccountRepository.save(ssoAccountEntity);

        // when: 특정 userID로 엔티티 조회
        SSOAccountEntity foundEntity = ssoAccountRepository.findById("U001").orElse(null);

        // then: 조회된 엔티티 값 검증
        assertThat(foundEntity).isNotNull();
        assertThat(foundEntity.getUserID()).isEqualTo("U001");

        logger.info("SSO 계정 조회 테스트 완료: {}", foundEntity);
    }

    @Test 
    public void SSO계정삭제하기() {
        // given: Entity 저장
        ssoAccountRepository.save(ssoAccountEntity);

        // when: 엔티티 삭제
        ssoAccountRepository.deleteById("U001");

        // then: 삭제 후 조회하여 null 반환되는지 검증
        SSOAccountEntity foundEntity = ssoAccountRepository.findById("U001").orElse(null);

        assertThat(foundEntity).isNull();
        logger.info("SSO 계정 삭제 테스트 완료. 삭제된 계정 : 사용자ID(U001)");
    }
}
