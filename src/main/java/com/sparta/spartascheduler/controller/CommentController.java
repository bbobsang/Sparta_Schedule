package com.sparta.spartascheduler.controller;

import com.sparta.spartascheduler.entity.Comment;
import com.sparta.spartascheduler.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules/{scheduleId}/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping
    public ResponseEntity<Comment> addComment(@PathVariable Long scheduleId, @RequestBody Comment comment) {
        Comment createdComment = commentService.addComment(scheduleId, comment);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdComment);
    }

    @GetMapping
    public List<Comment> getComments(@PathVariable Long scheduleId) {
        return commentService.getComments(scheduleId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long scheduleId, @PathVariable Long id) {
        commentService.deleteComment(scheduleId, id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }
}