package com.example.SmartSchedule.student.schedule.controller;

import com.example.SmartSchedule.student.schedule.dto.ScheduleDTO;
import com.example.SmartSchedule.student.schedule.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/student")
public class ScheduleController {
    private final ScheduleService scheduleService;

    @Autowired
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping("/getScheduleForDay")
    public List<ScheduleDTO> getScheduleForDay(@RequestParam Long groupId, @RequestParam String date) {
        LocalDate localDate = LocalDate.parse(date);
        return scheduleService.getScheduleForDay(groupId, localDate);
    }

    @GetMapping("/getScheduleForWeek")
    public List<ScheduleDTO> getScheduleForWeek(@RequestParam Long groupId, @RequestParam String startDate) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = start.plusDays(6);
        return scheduleService.getScheduleForPeriod(groupId, start, end);
    }

    @GetMapping("/getScheduleForMonth")
    public List<ScheduleDTO> getScheduleForMonth(@RequestParam Long groupId, @RequestParam String startDate) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = start.plusMonths(1).minusDays(1);
        return scheduleService.getScheduleForPeriod(groupId, start, end);
    }
}
