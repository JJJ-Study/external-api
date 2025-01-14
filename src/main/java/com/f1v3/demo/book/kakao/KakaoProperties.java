package com.f1v3.demo.book.kakao;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Kakao API 설정 클래스
 *
 * @author 정승조
 * @version 2025. 01. 14.
 */
@Getter
@Setter
@Configuration
@ConfigurationProperties("kakao.api")
public class KakaoProperties {

    private String key;
}
