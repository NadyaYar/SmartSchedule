package com.example.SmartSchedule.student.group.repository;

import com.example.SmartSchedule.student.group.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
    List<Group> findByFacultyId(Long facultyId);
}
