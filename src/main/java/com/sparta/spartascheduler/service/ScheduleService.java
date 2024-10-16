package com.sparta.spartascheduler.service;

import com.sparta.spartascheduler.entity.Schedule;
import com.sparta.spartascheduler.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    public Schedule createSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    public Schedule updateSchedule(Long id, Schedule scheduleDetails) {
        Schedule existingSchedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Schedule not found with id: " + id));
        existingSchedule.setTitle(scheduleDetails.getTitle());
        existingSchedule.setContent(scheduleDetails.getContent());

        // 필요한 필드도 업데이트
        return scheduleRepository.save(existingSchedule);
    }

    public void deleteSchedule(Long id) {
        scheduleRepository.deleteById(id);
    }

    public Page<Schedule> getSchedules(int page, int size) {
        return scheduleRepository.findAll(PageRequest.of(page, size));
    }
}