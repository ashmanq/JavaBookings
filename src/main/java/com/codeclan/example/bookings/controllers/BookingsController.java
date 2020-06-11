package com.codeclan.example.bookings.controllers;

import com.codeclan.example.bookings.models.Booking;
import com.codeclan.example.bookings.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/bookings")
public class BookingsController {

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping
    public ResponseEntity<List<Booking>> getBookings() {
        return new ResponseEntity<>(bookingRepository.findAll(), HttpStatus.OK);
    }

}
