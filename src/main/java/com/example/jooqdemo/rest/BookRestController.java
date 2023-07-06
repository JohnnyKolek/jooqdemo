package com.example.jooqdemo.rest;

import com.example.jooqdemo.model.Book;
import com.example.jooqdemo.repositories.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/library")
@AllArgsConstructor
public class BookRestController {

    private BookRepository bookRepository;

    @GetMapping("/books")
    public List<Book> getBooks(){
        return  bookRepository.findAll();
    }
}
