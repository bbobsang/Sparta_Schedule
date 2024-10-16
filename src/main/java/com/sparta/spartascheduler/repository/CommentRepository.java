package com.sparta.spartascheduler.repository;

import com.sparta.spartascheduler.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByScheduleId(Long scheduleId); // 특정 일정의 댓글 조회
}
