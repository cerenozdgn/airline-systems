package com.example.airline_systems.dto;

import com.example.airline_systems.model.Airline;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AircraftDto {
    private Long id;

    private String manufacturer_serial_number; //oluşturma ve güncellemede kullanılıyor. uçağın üretici seri numarası
    private String type; //uçak bilgilerini tanımladama kullanılıyor
    private String model; // detaylı gösterim ve güncellemede kullanılıyor
    private String number_of_engines; //Uçaktaki motor sayısı, uçak bilgilerini tanımlamada kullanılıyor.
    private Long operator_airline;

    @JsonIgnore
    private Airline airline;
}
