package com.example.jooqdemo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
public class Rental {
    private Integer id;
    private BookCopy bookCopy;
    private Reader reader;
    private LocalDate rentalDate;
}
