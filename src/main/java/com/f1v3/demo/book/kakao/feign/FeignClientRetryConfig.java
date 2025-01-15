package com.f1v3.demo.book.kakao.feign;

import feign.Retryer;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.TimeUnit;

/**
 * {class name}.
 *
 * @author 정승조
 * @version 2025. 01. 14.
 */
public class FeignClientRetryConfig {

    /**
     * OpenFeign Retryer Bean
     */
    @Bean
    Retryer.Default openFeinClientRetryer() {
        return new Retryer.Default(
                100,
                TimeUnit.SECONDS.toMillis(1L),
                5
        );
    }
}
