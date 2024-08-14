package com.example.airline_systems.mapper;

import com.example.airline_systems.dto.AirlineDto;
import com.example.airline_systems.model.Airline;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-14T18:31:47+0300",
    comments = "version: 1.6.0.Beta1, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.8.jar, environment: Java 17.0.11 (Amazon.com Inc.)"
)
@Component
public class AirlineMapperImpl implements AirlineMapper {

    @Override
    public AirlineDto mapAirlinetoAirlineDto(Airline airline) {
        if ( airline == null ) {
            return null;
        }

        AirlineDto airlineDto = new AirlineDto();

        airlineDto.setId( airline.getId() );
        airlineDto.setName( airline.getName() );
        airlineDto.setCallsign( airline.getCallsign() );
        airlineDto.setFounded_year( airline.getFounded_year() );
        airlineDto.setBase_airport( airline.getBase_airport() );

        return airlineDto;
    }

    @Override
    public Airline mapAirlineDtotoAirline(AirlineDto airlineDto) {
        if ( airlineDto == null ) {
            return null;
        }

        Airline airline = new Airline();

        airline.setId( airlineDto.getId() );
        airline.setName( airlineDto.getName() );
        airline.setCallsign( airlineDto.getCallsign() );
        airline.setFounded_year( airlineDto.getFounded_year() );
        airline.setBase_airport( airlineDto.getBase_airport() );

        return airline;
    }

    @Override
    public List<AirlineDto> mapAirlinetoAirlineDtoList(List<Airline> airlineList) {
        if ( airlineList == null ) {
            return null;
        }

        List<AirlineDto> list = new ArrayList<AirlineDto>( airlineList.size() );
        for ( Airline airline : airlineList ) {
            list.add( mapAirlinetoAirlineDto( airline ) );
        }

        return list;
    }
}
