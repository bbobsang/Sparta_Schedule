package com.sparta.spartascheduler.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id; // 스케쥴 ID

    private String userName;
    private String userId; // 작성 유저명
    private String title; // 할일 제목
    private String content; // 할일 내용
    private String weather; // 날씨 정보를 저장할 필드 추가
    private String location; // 위치 정보
    private LocalDate date; // 날짜 (LocalDate 타입으로 설정)

    @CreatedDate
    private LocalDateTime createdDate; // 작성일
    @LastModifiedDate
    private LocalDateTime modifiedDate; // 수정일
    @OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments; // 댓글 리스트
}