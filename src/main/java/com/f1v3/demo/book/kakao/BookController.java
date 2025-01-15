package com.f1v3.demo.book.kakao;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 정승조
 * @version 2025. 01. 14.
 */
@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookSearchService bookSearchService;

    @GetMapping("/search/feign/{query}")
    public ResponseEntity<BookSearchResponse> feignClientSearch(@PathVariable String query) {
        return ResponseEntity
                .ok(bookSearchService.searchBookByFeignClient(query));
    }

    @GetMapping("/search/rest/{query}")
    public ResponseEntity<BookSearchResponse> restClientSearch(@PathVariable String query) {
        return ResponseEntity
                .ok(bookSearchService.searchBookByRestClient(query));
    }
}
