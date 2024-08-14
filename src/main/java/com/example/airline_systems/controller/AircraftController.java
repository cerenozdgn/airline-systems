package com.example.airline_systems.controller;

import com.example.airline_systems.dto.AircraftDto;
import com.example.airline_systems.service.AircraftService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/aircraft")
public class AircraftController {
    private final AircraftService aircraftService;

    @PreAuthorize("hasAnyAuthority('USER')")
    @PostMapping("/")
    public ResponseEntity <AircraftDto> createAircraft(@RequestBody AircraftDto aircraft){
        return new ResponseEntity<>(aircraftService.createAircraft(aircraft), HttpStatus.CREATED);
    }

    @PreAuthorize("hasAnyAuthority('USER')")
    @PatchMapping("/{id}")
    public ResponseEntity<AircraftDto> updateAircraft(@PathVariable Long id,@RequestBody String manufacturerSerialNumber){
        return ResponseEntity.ok( aircraftService.updateAircraft(id,manufacturerSerialNumber));
    }

    @PreAuthorize("hasAnyAuthority('USER')")
    @GetMapping("/{id}")
    public ResponseEntity<AircraftDto> getAircraft(@PathVariable Long id){
        return ResponseEntity.ok(aircraftService.getAircraft(id));
    }

    @PreAuthorize("hasAnyAuthority('USER')")
    @PostMapping("/{id}")
    public ResponseEntity <Void> deleteAircraft(@PathVariable Long id){
        aircraftService.deleteAircraft(id);
        return null;
    }
}
