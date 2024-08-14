package com.example.airline_systems.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Airline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String callsign; // Havayolunun çağrı işareti APIda kullanılıyor
    private int founded_year; // güncelleme ve göstermede kullanılacak

    private String base_airport; // listeleme ve detay göstermede kullanılacak

    @OneToMany(mappedBy = "airline",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Aircraft> aircraftSet = new ArrayList<>();

    //An airline can have many planes, so the Airline class has a List<Aircraft> and is associated with the operatorAirline in the Aircraft class with the mappedBy property



}
