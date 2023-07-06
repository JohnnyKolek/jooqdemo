package com.example.jooqdemo.rest;

import com.example.jooqdemo.model.Reader;
import com.example.jooqdemo.repositories.ReaderRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/library")
@AllArgsConstructor
public class ReaderRestController {

    private ReaderRepository readerRepository;

    @GetMapping("/readers")
    public List<Reader> getReaders(){
        return  readerRepository.findAll();
    }

    @GetMapping("/readers/{readerId}")
    public Reader getReader(@PathVariable int readerId){
        return  readerRepository.findReaderById(readerId);
    }


}
