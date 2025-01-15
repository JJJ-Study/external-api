package com.f1v3.demo.book.kakao;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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

    @GetMapping("/search/{query}")
    public ResponseEntity<BookSearchResponse> searchBook(@PageableDefault Pageable pageable,
                                                         @PathVariable String query) {
        return ResponseEntity
                .ok(bookSearchService.searchBook(query));
    }
}
