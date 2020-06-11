package com.codeclan.example.bookings;

import com.codeclan.example.bookings.models.Booking;
import com.codeclan.example.bookings.models.Course;
import com.codeclan.example.bookings.models.Customer;
import com.codeclan.example.bookings.repositories.BookingRepository;
import com.codeclan.example.bookings.repositories.CourseRepository;
import com.codeclan.example.bookings.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BookingsApplicationTests {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private BookingRepository bookingRepository;

	@Autowired
	private CourseRepository courseRepository;

	@Test
	void contextLoads() {

	}

	@Test
	void canSaveCustomer() {
		Optional<Customer> found = customerRepository.findById(1L);
		assertEquals("Joe Bloggs", found.get().getName());
	}

	@Test
	void canSaveCourse() {
		Optional<Course> found = courseRepository.findById(1L);
		assertEquals("Software Development", found.get().getName());
	}

	@Test
	void canSaveBooking() {
		Optional<Booking> found = bookingRepository.findById(1L);
		assertEquals("20-06-20", found.get().getDate());
	}
}
