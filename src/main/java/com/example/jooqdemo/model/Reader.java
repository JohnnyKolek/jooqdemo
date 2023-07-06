package com.example.jooqdemo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Reader {
    private Integer id;
    private String name;
    private String surname;
    private String street;
    private String postalCode;
    private String city;
    private String phoneNumber;

}
