package com.f1v3.demo.book.kakao;

import com.f1v3.demo.book.kakao.feign.KakaoBookFeignClient;
import com.f1v3.demo.book.kakao.rest.KakaoBookRestClient;
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

    private final KakaoBookFeignClient feignClient;
    private final KakaoBookRestClient restClient;
    private final KakaoProperties kakaoProperties;

    public BookSearchResponse searchBookByFeignClient(String query) {

        BookSearchResponse response = feignClient.searchBooks(
                "KakaoAK " + kakaoProperties.getKey(),
                query,
                "title"
        );

        log.info("response = {}", response);

        return response;
    }

    public BookSearchResponse searchBookByRestClient(String query) {

        BookSearchResponse response = restClient.searchBooks(
                query,
                "KakaoAK " + kakaoProperties.getKey()
        );

        log.info("response = {}", response);

        return response;
    }
}
