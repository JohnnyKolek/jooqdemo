package com.example.jooqdemo.rest;

import com.example.jooqdemo.model.Rental;
import com.example.jooqdemo.repositories.RentalRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/library")
@AllArgsConstructor
public class RentalRestController {

    private RentalRepository rentalRepository;

    @GetMapping("/rentals")
    public List<Rental> getRentals() {
        return rentalRepository.findAll();
    }
}
