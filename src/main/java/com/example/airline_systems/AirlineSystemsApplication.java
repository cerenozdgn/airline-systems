package com.example.airline_systems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"com.example.airline_systems"})
public class AirlineSystemsApplication  {


    public static void main(String[] args) {
        SpringApplication.run(AirlineSystemsApplication.class, args);
    }


}
