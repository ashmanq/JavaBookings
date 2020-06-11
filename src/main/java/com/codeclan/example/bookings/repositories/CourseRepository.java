package com.codeclan.example.bookings.repositories;

import com.codeclan.example.bookings.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByRating(int rating);
}
