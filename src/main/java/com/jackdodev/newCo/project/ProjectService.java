package com.jackdodev.newCo.project;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    @Transactional
    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    @Transactional
    public Project getProjectById(UUID authorId, UUID projectId) {
        return projectRepository.findByIdAndAuthorId(authorId, projectId);
    }

    public List<Project> getAllProjectsByAuthor(UUID authorId) {
        return projectRepository.findByAuthorId(authorId);
    }

    public void deleteProject(UUID authorId, UUID projectId) {
        projectRepository.deleteByAuthorIdAndId(authorId, projectId);
    }
}
