package com.codeclan.example.bookings.repositories;

import com.codeclan.example.bookings.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
