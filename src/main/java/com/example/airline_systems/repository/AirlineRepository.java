package com.example.airline_systems.repository;

import com.example.airline_systems.model.Airline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirlineRepository extends JpaRepository<Airline,Long> {
}
