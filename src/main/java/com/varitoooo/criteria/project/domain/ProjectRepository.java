package com.varitoooo.criteria.project.domain;

import java.util.Optional;

public interface ProjectRepository {
    void save(Project project);

    Optional<Project> search(ProjectId projectId);
}
