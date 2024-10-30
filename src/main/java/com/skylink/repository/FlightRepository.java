package com.skylink.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skylink.entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long>
{

}
