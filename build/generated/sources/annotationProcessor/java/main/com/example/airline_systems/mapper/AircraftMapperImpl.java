package com.example.airline_systems.mapper;

import com.example.airline_systems.dto.AircraftDto;
import com.example.airline_systems.model.Aircraft;
import com.example.airline_systems.model.Airline;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-14T18:31:47+0300",
    comments = "version: 1.6.0.Beta1, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.8.jar, environment: Java 17.0.11 (Amazon.com Inc.)"
)
@Component
public class AircraftMapperImpl implements AircraftMapper {

    @Override
    public AircraftDto mapAircrafttoAircraftDto(Aircraft aircraft) {
        if ( aircraft == null ) {
            return null;
        }

        AircraftDto aircraftDto = new AircraftDto();

        aircraftDto.setOperator_airline( aircraftAirlineId( aircraft ) );
        aircraftDto.setId( aircraft.getId() );
        aircraftDto.setManufacturer_serial_number( aircraft.getManufacturer_serial_number() );
        aircraftDto.setType( aircraft.getType() );
        aircraftDto.setModel( aircraft.getModel() );
        aircraftDto.setNumber_of_engines( aircraft.getNumber_of_engines() );
        aircraftDto.setAirline( aircraft.getAirline() );

        return aircraftDto;
    }

    @Override
    public Aircraft mapAircraftDtotoAircraft(AircraftDto aircraftDto) {
        if ( aircraftDto == null ) {
            return null;
        }

        Aircraft aircraft = new Aircraft();

        aircraft.setAirline( aircraftDtoToAirline( aircraftDto ) );
        aircraft.setId( aircraftDto.getId() );
        aircraft.setManufacturer_serial_number( aircraftDto.getManufacturer_serial_number() );
        aircraft.setType( aircraftDto.getType() );
        aircraft.setModel( aircraftDto.getModel() );
        aircraft.setNumber_of_engines( aircraftDto.getNumber_of_engines() );

        return aircraft;
    }

    private Long aircraftAirlineId(Aircraft aircraft) {
        Airline airline = aircraft.getAirline();
        if ( airline == null ) {
            return null;
        }
        return airline.getId();
    }

    protected Airline aircraftDtoToAirline(AircraftDto aircraftDto) {
        if ( aircraftDto == null ) {
            return null;
        }

        Airline airline = new Airline();

        airline.setId( aircraftDto.getOperator_airline() );

        return airline;
    }
}
