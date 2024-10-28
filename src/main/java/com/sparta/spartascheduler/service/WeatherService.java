package com.sparta.spartascheduler.service;

import com.sparta.spartascheduler.dto.WeatherResponseDto;
import com.sparta.spartascheduler.exception.WeatherApiException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    private final RestTemplate restTemplate;

    @Value("${weather.api.key}")
    private String apiKey;

    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public WeatherResponseDto getWeather(String location) {
        try {
            String apiUrl = "https://api.weatherapi.com/v1/current.json?key=" + apiKey + "&q=" + location;
            return restTemplate.getForObject(apiUrl, WeatherResponseDto.class);
        } catch (RestClientException e) {
            throw new WeatherApiException("날씨 정보를 가져오는 데 실패했습니다.");
        }
    }
}
