package com.sparta.spartascheduler.service;

import com.sparta.spartascheduler.dto.ScheduleDto;
import com.sparta.spartascheduler.dto.WeatherResponseDto;
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

    @Autowired
    private WeatherService weatherService; // 날씨 서비스 주입

    // 스케줄 생성 메서드
    public Schedule createSchedule(ScheduleDto scheduleDto) {
        // 날씨 정보를 가져오기
        WeatherResponseDto weatherResponse = weatherService.getWeather(scheduleDto.getLocation());

        // 스케줄 객체 생성
        Schedule schedule = new Schedule();

        // 날씨 상태 설정
        String weatherCondition = weatherResponse.getCurrent().getCondition().getText();
        schedule.setWeather(weatherCondition);

        // 기타 필드 설정
        schedule.setTitle(scheduleDto.getTitle()); // 스케줄 제목 설정
        schedule.setContent(scheduleDto.getContent()); // 스케줄 DTO 에서 내용을 가져와 스케줄 객체의 content 필드에 설정
        schedule.setDate(scheduleDto.getDate()); // 스케줄 날짜 설정
        schedule.setLocation(scheduleDto.getLocation()); // 위치 정보 설정


        return scheduleRepository.save(schedule); // 스케줄 저장
    }

}