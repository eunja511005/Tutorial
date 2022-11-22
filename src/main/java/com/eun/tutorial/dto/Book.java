package com.eun.tutorial.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Book {
    private String isbn;
    private String name;
    private String author;
}
