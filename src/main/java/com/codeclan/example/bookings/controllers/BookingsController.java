package com.codeclan.example.bookings.controllers;

import com.codeclan.example.bookings.models.Booking;
import com.codeclan.example.bookings.models.Course;
import com.codeclan.example.bookings.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/bookings")
public class BookingsController {

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Booking> findOneBooking(@PathVariable Long id) {
        return new ResponseEntity<>(bookingRepository.findById(id).get(), HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<Booking>> findBookings(
            @RequestParam(name = "date", required = false) String date
    ) {
        if(date != null) {
            return new ResponseEntity<>(bookingRepository.findByDate(date), HttpStatus.OK);
        }
        return new ResponseEntity<>(bookingRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Booking> postBooking(@RequestBody Booking booking) {
        bookingRepository.save(booking);
        return new ResponseEntity<>(booking, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Booking> putCourse(@RequestBody Booking booking, @PathVariable Long id) {
        bookingRepository.save(booking);
        return new ResponseEntity<>(booking, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity <?> deleteCourse(@PathVariable Long id) {
        bookingRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    };

}
