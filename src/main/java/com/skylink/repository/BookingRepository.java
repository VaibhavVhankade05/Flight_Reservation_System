package com.skylink.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skylink.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long>
{

}
