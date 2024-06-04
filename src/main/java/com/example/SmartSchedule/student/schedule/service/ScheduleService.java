package com.example.SmartSchedule.student.schedule.service;

import com.example.SmartSchedule.student.schedule.dto.ScheduleDTO;
import com.example.SmartSchedule.student.schedule.entity.Schedule;
import com.example.SmartSchedule.student.schedule.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    @Autowired
    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }


    public List<ScheduleDTO> getScheduleForDay(Long groupId, LocalDate date) {
        List<Schedule> schedules = scheduleRepository.findByGroupIdAndDate(groupId, date);
        return schedules.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<ScheduleDTO> getScheduleForPeriod(Long groupId, LocalDate startDate, LocalDate endDate) {
        List<Schedule> schedules = scheduleRepository.findByGroupIdAndDateBetween(groupId, startDate, endDate);
        return schedules.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private ScheduleDTO convertToDTO(Schedule schedule) {
        ScheduleDTO dto = new ScheduleDTO();
        dto.setId(schedule.getId());
        dto.setSubject(schedule.getSubject());
        dto.setTeacher(schedule.getTeacher());
        dto.setRoom(schedule.getRoom());
        dto.setStartTime(schedule.getStartTime());
        dto.setEndTime(schedule.getEndTime());
        dto.setDate(schedule.getDate());
        dto.setGroupId(schedule.getGroup().getId());
        return dto;
    }
}
