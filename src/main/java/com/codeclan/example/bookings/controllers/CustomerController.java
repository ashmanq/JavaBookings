package com.codeclan.example.bookings.controllers;

import com.codeclan.example.bookings.models.Customer;
import com.codeclan.example.bookings.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Customer> findOneCustomer(@PathVariable Long id) {
      return new ResponseEntity<>(customerRepository.findById(id).get(), HttpStatus.OK);
    };

    @GetMapping(value = "")
    public ResponseEntity<List<Customer>> findCustomers(
            @RequestParam(name = "course", required = false) String courseName,
            @RequestParam(name = "town", required = false) String town,
            @RequestParam(name = "age", required = false) Integer age
            ) {

        if(courseName != null) {
            if(town != null) {
                if(age != null) {
                    return new ResponseEntity<>(customerRepository.findByAgeGreaterThanAndTownIgnoreCaseAndBookingsCourseNameIgnoreCase(age, town, courseName), HttpStatus.OK);
                }
                return new ResponseEntity<>(customerRepository.findByTownIgnoreCaseAndBookingsCourseNameIgnoreCase(town, courseName), HttpStatus.OK);
            }
            return new ResponseEntity<>(customerRepository.findByBookingsCourseNameIgnoreCase(courseName), HttpStatus.OK);

        }
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Customer> postCustomer(@RequestBody Customer customer) {
        customerRepository.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Customer> putCustomer(@RequestBody Customer customer, @PathVariable Long id) {
        customerRepository.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity <Long> deleteCustomer(@PathVariable Long id) {
        customerRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    };


}
