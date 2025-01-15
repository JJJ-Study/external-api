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
//            @RequestParam(value = "sort", defaultValue = "accuracy", required = false), // <- default 사용하는게 좋을 것 같음
//            @RequestParam(value = "page", defaultValue = "1", required = false) int page,       // 1 ~ 50
//            @RequestParam(value = "size", defaultValue = "10", required = false) int size,      // 1 ~ 50
            @RequestParam(value = "target", defaultValue = "title", required = false) String target               // title, isbn, publisher, person
    );
}
