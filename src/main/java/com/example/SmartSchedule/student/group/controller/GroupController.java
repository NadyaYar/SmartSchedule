package com.example.SmartSchedule.student.group.controller;

import com.example.SmartSchedule.student.group.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class GroupController {

    private final GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping("/getGroups")
    public List<String> getGroups(@RequestParam Long facultyId) {
        return groupService.getGroupsByFacultyId(facultyId);
    }
}
