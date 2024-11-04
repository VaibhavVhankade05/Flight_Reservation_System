package com.skylink.serviceimplementation;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skylink.entity.Booking;
import com.skylink.repository.BookingRepository;
import com.skylink.repository.FlightRepository;
import com.skylink.repository.UserRepository;
import com.skylink.service.BookingService;


@Service
public class BookingImplementation implements BookingService
{
	
	@Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FlightRepository flightRepository;
	

    
//  Book Ticket
    @Override
    public Booking createBooking(Booking booking) {
        // Set the booking date and default status
    	booking.setBookingDate(new Date(new java.util.Date().getTime())); // Converts to java.sql.Date
        booking.setStatus("BOOKED");
        return bookingRepository.save(booking);
    }
    
    
    
//	Booking Details
    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
    
    
    
    
//	Booking By Id 
    @Override
    public Optional<Booking> getBookingById(Long id) {
        return bookingRepository.findById(id);
    }
    
    
    
//  Update 
    @Override
    public Booking updateBooking(Long id, Booking bookingDetails) {
        return bookingRepository.findById(id).map(booking -> {
            booking.setStatus(bookingDetails.getStatus());
            booking.setFlight(bookingDetails.getFlight());
            return bookingRepository.save(booking);
        }).orElseThrow(() -> new RuntimeException("Booking Not Found with ID: " + id));
    }

    
    
//  Delete
    @Override
    public void deleteBooking(Long id) {
        if (!bookingRepository.existsById(id)) {
            throw new RuntimeException("Booking not found with ID: " + id);
        }
        bookingRepository.deleteById(id);
    }
}
