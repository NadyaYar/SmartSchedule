package com.example.SmartSchedule.student.schedule.repository;

import com.example.SmartSchedule.student.schedule.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> findByGroupIdAndDate(Long groupId, LocalDate date);

    List<Schedule> findByGroupIdAndDateBetween(Long groupId, LocalDate startDate, LocalDate endDate);
}
