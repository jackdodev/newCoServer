package com.jackdodev.newCo.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping("/{id}")
    public Project getProjectByProjectIdAndAuthorId(@RequestHeader(value="authorId") String authorId, @PathVariable String projectId) {
        return projectService.getProjectById(UUID.fromString(authorId), UUID.fromString(projectId));
    }

    @GetMapping
    public List<Project> getAllProject(@RequestHeader(value = "authorId") String authorId) {
        return projectService.getAllProjectsByAuthor(UUID.fromString(authorId));
    }

    @PostMapping
    public Project createProject(@RequestBody ProjectDTO projectDto) {
        Project project = Project.convertProjectFromProjectDTO(projectDto);
        return projectService.createProject(project);
    }

    @DeleteMapping("/{id}")
    public void deleteProject(@RequestHeader(value = "authorId") String authorId, @PathVariable String projectId) {
        projectService.deleteProject(UUID.fromString(authorId), UUID.fromString(projectId));
    }
}
