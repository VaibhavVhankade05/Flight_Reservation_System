package com.skylink.serviceimplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skylink.entity.Flight;
import com.skylink.repository.FlightRepository;
import com.skylink.service.FlightService;



@Service
public class FlightImplementation implements FlightService
{

	@Autowired
    private FlightRepository flightRepository;

	
//	Add Flight
    @Override
    public Flight addFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    
    
//  Flight List
    @Override
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }
    
    
    
//	Flight By Id
    @Override
    public Optional<Flight> getFlightById(Long id) {
        return flightRepository.findById(id);
    }
    
    
    
    
//	Update
    @Override
    public Flight updateFlight(Long id, Flight flightDetails) {
        return flightRepository.findById(id).map(flight -> {
            flight.setFlightNumber(flightDetails.getFlightNumber());
            flight.setOrigin(flightDetails.getOrigin());
            flight.setDestination(flightDetails.getDestination());
            flight.setDepartureTime(flightDetails.getDepartureTime());
            flight.setArrivalTime(flightDetails.getArrivalTime());
            flight.setPrice(flightDetails.getPrice());
            return flightRepository.save(flight);
        }).orElseThrow(() -> new RuntimeException("Flight Not Found with ID " + id));
    }
    
    

    
//	Delete
    @Override
    public void deleteFlight(Long id) {
        if (!flightRepository.existsById(id)) {
            throw new RuntimeException("Flight Not Found with ID " + id);
        }
        flightRepository.deleteById(id);
    }

}
