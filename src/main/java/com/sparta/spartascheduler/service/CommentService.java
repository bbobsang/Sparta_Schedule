package com.sparta.spartascheduler.service;

import com.sparta.spartascheduler.entity.Comment;
import com.sparta.spartascheduler.entity.Schedule;
import com.sparta.spartascheduler.exception.CommentNotFoundException;
import com.sparta.spartascheduler.repository.CommentRepository;
import com.sparta.spartascheduler.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class CommentService {
    private static final Logger logger = LoggerFactory.getLogger(CommentService.class);

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;

    public Comment addComment(Long scheduleId, Comment comment) {
        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new CommentNotFoundException("Schedule not found with id: " + scheduleId));
        comment.setSchedule(schedule);
        logger.info("Comment added to schedule ID: {}", scheduleId);
        return commentRepository.save(comment);
    }

    public List<Comment> getComments(Long scheduleId) {
        return commentRepository.findByScheduleId(scheduleId);
    }

    public void deleteComment(Long scheduleId, Long commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new CommentNotFoundException("Comment not found with id: " + commentId));
        commentRepository.delete(comment);
        logger.info("Comment deleted with ID: {}", commentId);
    }
}
