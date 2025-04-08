package com.example.weather.service;

import com.example.weather.kafka.WeatherProducer;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    private final WeatherProducer weatherProducer;
    private final RestTemplate restTemplate = new RestTemplate();

    public WeatherService(WeatherProducer weatherProducer) {
        this.weatherProducer = weatherProducer;
    }

    public void fetchAndSendWeather(String city) {
        String apiKey = "6e1a202fdcb54fcb42c67944d7fa6671"; // Use your OpenWeather API Key
        String url = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey + "&units=metric";
        String weatherJson = restTemplate.getForObject(url, String.class);

        // Send weather data to Kafka
        weatherProducer.sendWeatherData(city, weatherJson);
    }
}
