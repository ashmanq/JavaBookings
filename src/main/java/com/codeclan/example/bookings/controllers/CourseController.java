package com.codeclan.example.bookings.controllers;

import com.codeclan.example.bookings.models.Course;
import com.codeclan.example.bookings.models.Customer;
import com.codeclan.example.bookings.repositories.CourseRepository;
import com.codeclan.example.bookings.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping(value = "")
    public ResponseEntity<List<Course>> findCourses(
            @RequestParam(name="rating", required = false) Integer rating,
            @RequestParam(name="coursename", required = false) String courseName,
            @RequestParam(name="customer", required = false) String customerName
    ) {
        if(rating != null) {
            return new ResponseEntity<>(courseRepository.findByRating(rating), HttpStatus.OK);
        }
        if(customerName != null) {
            return new ResponseEntity<>(courseRepository.findByBookingsCustomerNameIgnoreCase(customerName), HttpStatus.OK);
        }

        return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);
    }
}
