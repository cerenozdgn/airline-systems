package com.example.airline_systems.mapper;

import com.example.airline_systems.dto.AircraftDto;
import com.example.airline_systems.model.Aircraft;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AircraftMapper {
    AircraftMapper INSTANCE = Mappers.getMapper(AircraftMapper.class);

    @Mapping(target = "operator_airline", source = "airline.id")
    AircraftDto mapAircrafttoAircraftDto(Aircraft aircraft);

    @Mapping(target = "airline.id", source = "operator_airline")
    Aircraft mapAircraftDtotoAircraft(AircraftDto aircraftDto);

}

