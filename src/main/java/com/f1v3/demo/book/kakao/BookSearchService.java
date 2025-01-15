package com.f1v3.demo.book.kakao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
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

        BookSearchResponse response = kakaoBookClient.searchBooks(
                "KakaoAK " + kakaoProperties.getKey(),
                query,
                "title"
        );

        log.info("response = {}", response);

        return response;
    }
}
