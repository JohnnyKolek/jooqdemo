package com.example.jooqdemo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Book {
    private Integer id;
    private String title;
    private Author author;
}
