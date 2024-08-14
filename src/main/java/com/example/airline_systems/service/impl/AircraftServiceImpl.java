package com.example.airline_systems.service.impl;

import com.example.airline_systems.dto.AircraftDto;
import com.example.airline_systems.exception.ResourceNotFoundException;
import com.example.airline_systems.mapper.AircraftMapper;
import com.example.airline_systems.model.Aircraft;
import com.example.airline_systems.repository.AircraftRepository;
import com.example.airline_systems.repository.AirlineRepository;
import com.example.airline_systems.service.AircraftService;
import org.springframework.stereotype.Service;

@Service
public class AircraftServiceImpl implements AircraftService {

    private final AircraftRepository aircraftRepository;
    private final AirlineRepository airlineRepository;
    private final AircraftMapper aircraftMapper;

    public AircraftServiceImpl(AircraftRepository aircraftRepository, AirlineRepository airlineRepository, AircraftMapper aircraftMapper) {
        this.aircraftRepository = aircraftRepository;
        this.airlineRepository = airlineRepository;
        this.aircraftMapper = aircraftMapper;
    }

    public AircraftDto createAircraft(AircraftDto aircraftDto){
        Aircraft aircraft = aircraftMapper.mapAircraftDtotoAircraft(aircraftDto);

        aircraftRepository.save(aircraft);

        return aircraftMapper.INSTANCE.mapAircrafttoAircraftDto(aircraft);
    }
    public AircraftDto updateAircraft(Long id,String manufacturerSerialNumber){
        Aircraft aircraft = aircraftRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Aircraft not found"));
        aircraft.setManufacturer_serial_number(manufacturerSerialNumber);
        aircraftRepository.save(aircraft);
        return aircraftMapper.INSTANCE.mapAircrafttoAircraftDto(aircraft);
    }
    public AircraftDto getAircraft(Long id){
        Aircraft aircraft =  aircraftRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Aircraft not found"));
        return aircraftMapper.INSTANCE.mapAircrafttoAircraftDto(aircraft);
    }
    public void deleteAircraft(Long id){
        aircraftRepository.deleteById(id);
    }

}
