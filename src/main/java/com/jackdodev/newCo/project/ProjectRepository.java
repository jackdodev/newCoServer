package com.jackdodev.newCo.project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findByUserId(Long userId);

    @Query("Select p from projects p WHERE p.id = :projectId AND p.arthur.id = :userId")
    Project findProjectById(@Param("userId") Long userId, @Param("projectId") Long projectId);

    @Query("DELETE FROM projects p where id = :projectId AND p.arthur.id = :projectId")
    void deleteById(@Param("userId") Long userId, @Param("projectId") Long projectId);
}
