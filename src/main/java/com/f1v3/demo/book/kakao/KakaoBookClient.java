package com.f1v3.demo.book.kakao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 정승조
 * @version 2025. 01. 14.
 */
@FeignClient(name = "book-api",
        url = "https://dapi.kakao.com",
        configuration = FeignClientRetryConfig.class)
public interface KakaoBookClient {

    @GetMapping("/v3/search/book")
    BookSearchResponse searchBooks(
            @RequestHeader(value = "Authorization", required = true) String authorization,
            @RequestParam(value = "query", required = true) String query,
            @RequestParam(value = "target", defaultValue = "title") String target
    );
}
