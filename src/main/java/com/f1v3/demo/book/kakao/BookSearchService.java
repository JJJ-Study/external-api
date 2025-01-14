package com.f1v3.demo.book.kakao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author 정승조
 * @version 2025. 01. 14.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class BookSearchService {

    private final KakaoBookClient kakaoBookClient;
    private final KakaoProperties kakaoProperties;

    public BookSearchResponse searchBook(String query) {

        log.info("kakao key = {}", kakaoProperties.getKey());
        BookSearchResponse response = kakaoBookClient.searchBooks(
                "KakaoAK " + kakaoProperties.getKey(),
                "java",
                "title"
        );

        log.info("response = {}", response);

        return response;
    }
}
