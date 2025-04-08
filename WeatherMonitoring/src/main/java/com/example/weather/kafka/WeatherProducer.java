package com.example.weather.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class WeatherProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public WeatherProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendWeatherData(String city, String weatherJson) {
        kafkaTemplate.send("weather_topic", city, weatherJson);
        System.out.println("Sent weather data for: " + city);
    }
}
