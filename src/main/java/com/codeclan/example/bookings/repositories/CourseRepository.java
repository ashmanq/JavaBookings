package com.codeclan.example.bookings.repositories;

import com.codeclan.example.bookings.models.Course;
import com.codeclan.example.bookings.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByRating(int rating);
    List<Course> findByBookingsCustomerNameIgnoreCase(String name);
}
