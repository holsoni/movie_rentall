package com.example.movie_rentall.controller;
/*
    @author   soniakk
    @class  Main
    @version  1.0
    @project   reingeneering-lab3
*/

import com.example.movie_rentall.dto.CreateRentalRequestDTO;
import com.example.movie_rentall.model.Rental;
import com.example.movie_rentall.service.CustomerService;
import com.example.movie_rentall.service.RentalService;
import org.springframework.web.bind.annotation.*;

@RestController
public class RentalController {
    private final RentalService rentalService;
    private final CustomerService customerService;

    public RentalController(RentalService rentalService, CustomerService customerService) {
        this.rentalService = rentalService;
        this.customerService = customerService;
    }

    @PostMapping("rental/create")
    public Rental createRental(@RequestBody CreateRentalRequestDTO rentalRequest) {
        return rentalService.createRental(rentalRequest);
    }

    @GetMapping("rental/customer/statement/{id}")
    public String getStatement(@PathVariable String id) {
        return customerService.getStatement(id);
    }



}
