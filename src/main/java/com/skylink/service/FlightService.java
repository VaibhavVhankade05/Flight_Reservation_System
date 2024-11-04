package com.skylink.service;

import java.util.List;
import java.util.Optional;

import com.skylink.entity.Flight;

public interface FlightService 
{
	
	Flight addFlight(Flight flight);
	
    List<Flight> getAllFlights();
    
    Optional<Flight> getFlightById(Long id);
    
    Flight updateFlight(Long id, Flight flightDetails);
    
    void deleteFlight(Long id);

}
