package com.sparta.spartascheduler.dto;

import jakarta.validation.constraints.NotBlank;

public class CommentDto {
    @NotBlank
    private String content;

    public void setContent(String content) {
        this.content = content;
    }

}
