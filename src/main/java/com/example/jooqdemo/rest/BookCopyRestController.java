package com.example.jooqdemo.rest;

import com.example.jooqdemo.model.BookCopy;
import com.example.jooqdemo.repositories.BookCopyRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/library")
@AllArgsConstructor
public class BookCopyRestController {

    private BookCopyRepository bookCopyRepository;

    @GetMapping("/bookCopies")
    public List<BookCopy> findAll(){
        return  bookCopyRepository.findAll();
    }

    @GetMapping("/bookCopies/{bookTitle}")
    public List<BookCopy> findBookCopyByTitle(@PathVariable String bookTitle){
        return bookCopyRepository.findBookCopyByTitle(bookTitle);
    }
}
