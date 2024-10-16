package com.sparta.spartascheduler.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ScheduleDto {
    @NotBlank
    @Size(max = 10)
    private String userName;

    @NotBlank
    @Size(max = 100)
    private String title;

    @Size(max = 500)
    private String content;

    public ScheduleDto() {}

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

