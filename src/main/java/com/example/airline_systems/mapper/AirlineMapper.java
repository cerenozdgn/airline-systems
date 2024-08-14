package com.example.airline_systems.mapper;

import com.example.airline_systems.dto.AirlineDto;
import com.example.airline_systems.model.Airline;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AirlineMapper {
    AirlineMapper INSTANCE = Mappers.getMapper(AirlineMapper.class);

    AirlineDto mapAirlinetoAirlineDto(Airline airline);

    Airline mapAirlineDtotoAirline(AirlineDto airlineDto);

    List<AirlineDto> mapAirlinetoAirlineDtoList(List<Airline> airlineList);
}
