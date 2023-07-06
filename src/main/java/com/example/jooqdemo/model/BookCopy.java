package com.example.jooqdemo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class BookCopy {
    private Integer id;
    private Book book;
    private String isbn;

}
