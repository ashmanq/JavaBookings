package com.codeclan.example.bookings.components;

import com.codeclan.example.bookings.models.Booking;
import com.codeclan.example.bookings.models.Course;
import com.codeclan.example.bookings.models.Customer;
import com.codeclan.example.bookings.repositories.BookingRepository;
import com.codeclan.example.bookings.repositories.CourseRepository;
import com.codeclan.example.bookings.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CourseRepository courseRepository;

    public DataLoader() {

    }

    public void run(ApplicationArguments args) {
        Customer customer1 = new Customer("Joe Bloggs", "Motherwell", 24);
        customerRepository.save(customer1);
        Customer customer2 = new Customer("Ariana Grande", "Glasgow", 25);
        customerRepository.save(customer2);
        Customer customer3 = new Customer("Son Goku", "London", 35);
        customerRepository.save(customer3);


        Course course1 = new Course("Software Development", "Glasgow", 5);
        courseRepository.save(course1);
        Course course2 = new Course("Big Data", "Glasgow", 3);
        courseRepository.save(course2);
        Course course3 = new Course("UI/UX Design", "Edinburgh", 4);
        courseRepository.save(course3);

        Booking booking1 = new Booking("20-06-20", course1, customer1);
        bookingRepository.save(booking1);
        Booking booking2 = new Booking("20-06-20", course2, customer2);
        bookingRepository.save(booking2);
        Booking booking3 = new Booking("01-07-20", course3, customer3);
        bookingRepository.save(booking3);
        Booking booking4 = new Booking("02-07-20", course3, customer1);
        bookingRepository.save(booking4);
    }
}
