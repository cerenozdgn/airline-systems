package com.example.airline_systems.service.impl;

import com.example.airline_systems.dto.AirlineDto;
import com.example.airline_systems.exception.ResourceNotFoundException;
import com.example.airline_systems.mapper.AirlineMapper;
import com.example.airline_systems.model.Airline;
import com.example.airline_systems.repository.AirlineRepository;
import com.example.airline_systems.service.AirlineService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AirlineServiceImpl implements AirlineService {
    private final AirlineRepository airlineRepository;
    private final AirlineMapper airlineMapper;

    public AirlineServiceImpl(AirlineRepository airlineRepository, AirlineMapper airlineMapper) {
        this.airlineRepository = airlineRepository;
        this.airlineMapper = airlineMapper;
    }

    public AirlineDto createAirline(AirlineDto airlineDto){
        Airline airline = airlineMapper.mapAirlineDtotoAirline(airlineDto);

        airlineRepository.save(airline);

        return airlineMapper.INSTANCE.mapAirlinetoAirlineDto(airline);

    }
    public AirlineDto updateAirline(Long id, int foundedYear) {
       Airline airline = airlineRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Airline not found"));
       airline.setFounded_year(foundedYear);
       airlineRepository.save(airline);
        return airlineMapper.INSTANCE.mapAirlinetoAirlineDto(airline);
    }
    public AirlineDto getAirline(Long id){
       Airline airline = airlineRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Airline not found"));
        return airlineMapper.INSTANCE.mapAirlinetoAirlineDto(airline);
    }
    public List<AirlineDto> getAllAirlines(){
        List<Airline> airlineList = airlineRepository.findAll();
        return airlineMapper.INSTANCE.mapAirlinetoAirlineDtoList(airlineList);
    }
    public void deleteAirline(Long id){
        airlineRepository.deleteById(id);
    }
    
}
