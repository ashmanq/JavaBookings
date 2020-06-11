package com.codeclan.example.bookings.components;

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
    }
}
