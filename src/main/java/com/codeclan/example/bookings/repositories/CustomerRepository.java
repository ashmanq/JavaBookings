package com.codeclan.example.bookings.repositories;

import com.codeclan.example.bookings.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
