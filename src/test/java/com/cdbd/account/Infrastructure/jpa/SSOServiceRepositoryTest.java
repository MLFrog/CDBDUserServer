package com.cdbd.account.Infrastructure.jpa;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Timestamp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.cdbd.account.infrastructure.jpa.entity.SSOServiceEntity;
import com.cdbd.account.infrastructure.jpa.repository.SSOServiceRepository;

public class SSOServiceRepositoryTest extends RepositoryTestMain {

    private static final Logger logger = LoggerFactory.getLogger(SSOServiceRepositoryTest.class);

    @Autowired
    private SSOServiceRepository ssoServiceRepository;

    private SSOServiceEntity ssoServiceEntity;

    @BeforeEach
    public void setUp() {
        // given: SSOServiceEntity 객체를 준비
        ssoServiceEntity = new SSOServiceEntity();
        ssoServiceEntity.setSsoServiceId("Service001");
        ssoServiceEntity.setSsoServiceName("Service One");
        ssoServiceEntity.setSsoStatus("ACTIVE");
        ssoServiceEntity.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        ssoServiceEntity.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

        logger.info("객체 생성 확인: {}", ssoServiceEntity);
    }

    @Test
    public void SSO서비스생성하기() {
        // given: Entity 준비

        // when: 데이터를 저장하고 반환된 엔티티를 확인
        SSOServiceEntity savedEntity = ssoServiceRepository.save(ssoServiceEntity);

        // then: 저장된 엔티티의 필드 값이 정확한지 검증
        assertThat(savedEntity.getSsoServiceId()).isEqualTo("Service001");
        assertThat(savedEntity.getSsoServiceName()).isEqualTo("Service One");
        assertThat(savedEntity.getSsoStatus()).isEqualTo("ACTIVE");
        assertThat(savedEntity.getCreatedAt()).isNotNull();
        assertThat(savedEntity.getUpdatedAt()).isNotNull();

        logger.info("SSO 서비스 생성 테스트 완료: {}", savedEntity);
    }

    @Test
    public void SSO서비스조회하기() {
        // given: Entity를 저장
        ssoServiceRepository.save(ssoServiceEntity);

        // when: 특정 ssoServiceId로 엔티티 조회
        SSOServiceEntity foundEntity = ssoServiceRepository.findById("Service001").orElse(null);

        // then: 조회된 엔티티 값 검증
        assertThat(foundEntity).isNotNull();
        assertThat(foundEntity.getSsoServiceId()).isEqualTo("Service001");
        assertThat(foundEntity.getSsoServiceName()).isEqualTo("Service One");

        logger.info("SSO 서비스 조회 테스트 완료: {}", foundEntity);
    }

    @Test 
    public void SSO서비스삭제하기() {
        // given: Entity 저장
        ssoServiceRepository.save(ssoServiceEntity);

        // when: 엔티티 삭제
        ssoServiceRepository.deleteById("Service001");

        // then: 삭제 후 조회하여 null 반환되는지 검증
        SSOServiceEntity foundEntity = ssoServiceRepository.findById("Service001").orElse(null);

        assertThat(foundEntity).isNull();
        logger.info("SSO 서비스 삭제 테스트 완료. 삭제된 서비스 : 서비스ID(Service001)");
    }
}
