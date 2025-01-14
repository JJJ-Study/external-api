package com.f1v3.demo.book.kakao;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 정승조
 * @version 2025. 01. 14.
 */
@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookSearchService bookSearchService;

    @GetMapping("/search")
    public ResponseEntity<BookSearchResponse> searchBook(String query) {
        return ResponseEntity
                .ok(bookSearchService.searchBook(query));
    }
}
