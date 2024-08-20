package com.jackdodev.newCo.project;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    @Transactional
    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    @Transactional
    public Project getProjectById(Long userId, Long projectId) {
        return projectRepository.findProjectById(userId, projectId);
    }

    public List<Project> getAllProjectsByUser(Long userId) {
        return new ArrayList<>(projectRepository.findByUserId(userId));
    }

    public void deleteProject(Long userId, Long projectId) {
        projectRepository.deleteById(userId, projectId);
    }
}
