package com.example.airline_systems.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Aircraft {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String manufacturer_serial_number; //oluşturma ve güncellemede kullanılıyor. uçağın üretici seri numarası
    private String type; //uçak bilgilerini tanımladama kullanılıyor
    private String model; // detaylı gösterim ve güncellemede kullanılıyor
    private String number_of_engines; //Uçaktaki motor sayısı, uçak bilgilerini tanımlamada kullanılıyor.

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Airline airline; // Uçağın ait olduğu havayolu, ilişkilendirme ve filtreleme işlemlerinde kullanılacak
    //Each aircraft can belong to only one airline, so the Aircraft class contains a reference to an Airline object.


}
