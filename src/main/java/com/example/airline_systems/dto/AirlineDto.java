package com.example.airline_systems.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AirlineDto {
    private Long id;

    private String name;
    private String callsign; // Havayolunun çağrı işareti APIda kullanılıyor
    private int founded_year; // güncelleme ve göstermede kullanılacak

    private String base_airport; // listeleme ve detay göstermede kullanılacak
}
