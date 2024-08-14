package com.example.airline_systems.repository;

import com.example.airline_systems.model.Aircraft;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AircraftRepository extends JpaRepository<Aircraft,Long> {
}
