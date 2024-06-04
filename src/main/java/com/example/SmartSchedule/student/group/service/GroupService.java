package com.example.SmartSchedule.student.group.service;

import com.example.SmartSchedule.student.group.entity.Group;
import com.example.SmartSchedule.student.group.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroupService {

    private final GroupRepository groupRepository;

    @Autowired
    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public List<String> getGroupsByFacultyId(Long facultyId) {
        return groupRepository.findByFacultyId(facultyId).stream()
                .map(Group::getName)
                .collect(Collectors.toList());
    }
}
