package com.example.airline_systems.service;

import com.example.airline_systems.dto.AirlineDto;

import java.util.List;

public interface AirlineService {
    public AirlineDto createAirline(AirlineDto airline);
    public AirlineDto updateAirline(Long id, int foundedYear);
    public AirlineDto getAirline(Long id);
    public List<AirlineDto> getAllAirlines();
    public void deleteAirline(Long id);
}
