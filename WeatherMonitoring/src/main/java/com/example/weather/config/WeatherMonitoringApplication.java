package com.example.weather.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WeatherMonitoringApplication {
    public static void main(String[] args) {
        SpringApplication.run(WeatherMonitoringApplication.class, args);
        System.out.println("Weather Monitoring Application Started!");
    }
}
