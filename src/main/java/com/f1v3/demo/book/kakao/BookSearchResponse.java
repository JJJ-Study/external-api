package com.f1v3.demo.book.kakao;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * @author 정승조
 * @version 2025. 01. 14.
 */
@ToString
@Getter
@NoArgsConstructor
public class BookSearchResponse {

    private List<Document> documents;
    private Meta meta;

    @ToString
    @Getter
    @NoArgsConstructor
    public static class Document {

        private String title;
        private String contents;
        private String isbn;
        private String publisher;
        private List<String> authors;
        private String thumbnail;
    }

    @ToString
    @Getter
    @NoArgsConstructor
    private static class Meta {

        @JsonProperty("is_end")
        private boolean isEnd;

        @JsonProperty("pageable_count")
        private int pageableCount;

        @JsonProperty("total_count")
        private int totalCount;
    }
}
