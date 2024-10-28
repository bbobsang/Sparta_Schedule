package com.sparta.spartascheduler.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
public class ScheduleDto {
    @NotBlank
    @Size(max = 10)
    private String userName;

    @NotBlank
    @Size(max = 100)
    private String title;

    @Size(max = 500)
    private String content;


    private LocalDate date; // 날짜
    private String location; // 위치

}

