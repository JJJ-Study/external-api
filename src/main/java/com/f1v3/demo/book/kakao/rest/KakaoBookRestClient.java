package com.f1v3.demo.book.kakao.rest;

import com.f1v3.demo.book.kakao.BookSearchResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

/**
 * @author 정승조
 * @version 2025. 01. 15.
 */
@Component
public class KakaoBookRestClient {

    private static final String KAKAO_HOST = "https://dapi.kakao.com";
    private static final String KAKAO_API_SEARCH_BOOK = "/v3/search/book";

    private final RestClient restClient;

    public KakaoBookRestClient() {
        this.restClient = RestClient.builder()
                .baseUrl(KAKAO_HOST)
                .build();
    }

    public BookSearchResponse searchBooks(String query, String authorization) {

        return restClient.get()
                .uri(uri -> uri
                        .path(KAKAO_API_SEARCH_BOOK)
                        .queryParam("query", query)
                        .queryParam("target", "title")
                        .build())
                .header("Authorization", authorization)
                .retrieve()
                .body(BookSearchResponse.class);
    }
}
