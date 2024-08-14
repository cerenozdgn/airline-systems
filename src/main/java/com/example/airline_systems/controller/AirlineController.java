package com.example.airline_systems.controller;

import com.example.airline_systems.dto.AirlineDto;
import com.example.airline_systems.service.AirlineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/airline")
public class AirlineController {
    private final AirlineService airlineService;

    @PreAuthorize("hasAnyAuthority('USER')")
    @PostMapping("/")
    public ResponseEntity<AirlineDto> createAirline(@RequestBody AirlineDto airline){
        AirlineDto createdAirline = airlineService.createAirline(airline);
        return new ResponseEntity<>(createdAirline, HttpStatus.CREATED);

    }


    @PreAuthorize("hasAnyAuthority('USER')")
    @PatchMapping("/{id}")
    public ResponseEntity <AirlineDto> updateAirline(@RequestBody AirlineDto airlineDto, @PathVariable Long id){
        return ResponseEntity.ok(airlineService.updateAirline(id,airlineDto.getFounded_year()));

    }

    @PreAuthorize("hasAnyAuthority('USER')")
    @GetMapping("/{id}")
    public ResponseEntity<AirlineDto> getAirline(@PathVariable Long id){
        return ResponseEntity.ok(airlineService.getAirline(id));
    }

    @PreAuthorize("hasAnyAuthority('USER')")
    @GetMapping("/")
    public ResponseEntity<List<AirlineDto>> getAllAirlines(){
        return ResponseEntity.ok(airlineService.getAllAirlines());
    }

    @PreAuthorize("hasAnyAuthority('USER')")
    @PostMapping("/{id}")
    public ResponseEntity<Void> deleteAirline(@PathVariable Long id){ //herhangi bir veri döndürmediği içimn void yaptım
        airlineService.deleteAirline(id);
        return null;
    }


}
