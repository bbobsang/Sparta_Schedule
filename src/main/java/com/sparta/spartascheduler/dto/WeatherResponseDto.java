package com.sparta.spartascheduler.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
public class WeatherResponseDto {

    private Current current;

    @Setter
    @Getter
    public static class Current {
        // Getter 및 Setter
        private Condition condition;

    }

    @Setter
    @Getter
    public static class Condition {
        // Getter 및 Setter
        private String text; // 날씨 상태

    }

}
