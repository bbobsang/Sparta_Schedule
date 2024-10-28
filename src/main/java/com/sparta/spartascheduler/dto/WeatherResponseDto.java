package com.sparta.spartascheduler.dto;

import lombok.Getter;

@Getter
public class WeatherResponseDto {

    // Getter 및 Setter
    private Current current;

    public void setCurrent(Current current) {
        this.current = current;
    }

    public static class Current {
        private Condition condition;

        // Getter 및 Setter
        public Condition getCondition() {
            return condition;
        }

        public void setCondition(Condition condition) {
            this.condition = condition;
        }
    }

    public static class Condition {
        private String text; // 날씨 상태

        // Getter 및 Setter
        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }
}
