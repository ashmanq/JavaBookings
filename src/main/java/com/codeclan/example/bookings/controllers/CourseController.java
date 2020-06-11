package com.codeclan.example.bookings.controllers;

import com.codeclan.example.bookings.models.Course;
import com.codeclan.example.bookings.models.Customer;
import com.codeclan.example.bookings.repositories.CourseRepository;
import com.codeclan.example.bookings.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Course> findOneCourse(@PathVariable Long id) {
        return new ResponseEntity<>(courseRepository.findById(id).get(), HttpStatus.OK);
    };


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

    @PostMapping
    public ResponseEntity<Course> postCourse(@RequestBody Course course) {
        courseRepository.save(course);
        return new ResponseEntity<>(course, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Course> putCourse(@RequestBody Course course, @PathVariable Long id) {
//        if(courseRepository.findById(id).isPresent()) {
//            Course found = courseRepository.findById(id).get();
//            found.setName(course.getName());
//            found.setRating(course.getRating());
//            found.setTown(course.getTown());
//            found.setBookings(course.getBookings());
//            courseRepository.save(found);
//            return new ResponseEntity<>(found, HttpStatus.CREATED);
//        }
//        course = null;
        courseRepository.save(course);
        return new ResponseEntity<>(course, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity <?> deleteCourse(@PathVariable Long id) {
        courseRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    };

}
