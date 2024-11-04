package com.skylink.entity;

import java.util.*;
import java.sql.Date;

import jakarta.persistence.*;

@Entity
@Table(name="Booking")
public class Booking 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "userId", nullable = false)
    private User user;
	
    @ManyToOne
    @JoinColumn(name = "flightId", nullable = false)
    private Flight flight;
    
    
    private Date bookingDate;
    
    private String status; // e.g., BOOKED, CANCELED
    
    
    
//    Setter Getter
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
    
}
