package com.example.jooqdemo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Author {
    private Integer id;
    private String name;
    private String surname;

}
