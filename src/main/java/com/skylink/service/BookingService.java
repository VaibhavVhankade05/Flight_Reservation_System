package com.skylink.service;

import java.util.List;
import java.util.Optional;

import com.skylink.entity.Booking;

public interface BookingService 
{
	
	Booking createBooking(Booking booking);

    List<Booking> getAllBookings();

    Optional<Booking> getBookingById(Long id);

    Booking updateBooking(Long id, Booking bookingDetails);

    void deleteBooking(Long id);
}
