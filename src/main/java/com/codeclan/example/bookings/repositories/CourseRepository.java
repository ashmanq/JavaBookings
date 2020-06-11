package com.codeclan.example.bookings.repositories;

import com.codeclan.example.bookings.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
