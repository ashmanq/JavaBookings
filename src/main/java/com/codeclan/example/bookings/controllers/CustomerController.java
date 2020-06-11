package com.codeclan.example.bookings.controllers;

import com.codeclan.example.bookings.models.Customer;
import com.codeclan.example.bookings.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping(value = "")
    public ResponseEntity<List<Customer>> findCustomers(
            ) {
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }
}
