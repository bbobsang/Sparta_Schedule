package com.sparta.spartascheduler.service;

import com.sparta.spartascheduler.exception.WeatherApiException;
import com.sparta.spartascheduler.dto.WeatherResponseDto; // WeatherResponse DTO를 import
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Autowired
    private RestTemplate restTemplate; // RestTemplate 주입

    public WeatherResponseDto getWeather(String location) {
        try {
            String apiUrl = "https://api.weatherapi.com/v1/current.json?key=YOUR_API_KEY&q=" + location;
            return restTemplate.getForObject(apiUrl, WeatherResponseDto.class);
        } catch (RestClientException e) {
            throw new WeatherApiException("날씨 정보를 가져오는 데 실패했습니다.");
        }
    }
}
