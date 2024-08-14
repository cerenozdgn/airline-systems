package com.example.airline_systems.service;

import com.example.airline_systems.dto.AircraftDto;

public interface AircraftService {
    public AircraftDto createAircraft(AircraftDto aircraft);
    public AircraftDto updateAircraft(Long id,String manufacturerSerialNumber);

    public AircraftDto getAircraft(Long id);
    public void deleteAircraft(Long id);
}
