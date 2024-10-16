package com.sparta.spartascheduler.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName; // 작성 유저명
    private String title; // 할일 제목
    private String content; // 할일 내용
    @CreatedDate
    private LocalDateTime createdDate; // 작성일
    @LastModifiedDate
    private LocalDateTime modifiedDate; // 수정일
    @OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments; // 댓글 리스트
}