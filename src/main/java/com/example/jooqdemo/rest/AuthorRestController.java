package com.example.jooqdemo.rest;

import com.example.jooqdemo.model.Author;
import com.example.jooqdemo.repositories.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/library")
@AllArgsConstructor
public class AuthorRestController {
    private AuthorRepository authorRepository;

    @GetMapping("/authors")
    public List<Author> getAuthors(){
        return  authorRepository.findAll();
    }
}
