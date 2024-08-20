package com.jackdodev.newCo.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping("/{id}")
    public Project getProjectById(@RequestHeader(value="user-id") Long userId, @PathVariable Long projectId) {
        return projectService.getProjectById(userId, projectId);
    }

    @GetMapping
    public List<Project> getAllProject(@RequestHeader(value = "user-id") Long userId) {
        return projectService.getAllProjectsByUser(userId);
    }

    @PostMapping
    public Project createProject(@RequestBody Project project) {
        return projectService.createProject(project);
    }

    @DeleteMapping("/{id}")
    public void deleteProject(@RequestHeader(value = "user-id") Long userId, @PathVariable Long projectId) {
        projectService.deleteProject(userId, projectId);
    }
}
