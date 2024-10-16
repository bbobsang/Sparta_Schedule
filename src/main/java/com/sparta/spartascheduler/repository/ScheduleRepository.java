package com.sparta.spartascheduler.repository;

import com.sparta.spartascheduler.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> findAllByUserName(String userName); // 특정 유저가 작성한 일정 조회

}
