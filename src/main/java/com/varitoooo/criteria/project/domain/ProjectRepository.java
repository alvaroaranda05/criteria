package com.varitoooo.criteria.project.domain;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository {
    void save(Project project);

    Optional<Project> search(ProjectId projectId);

    List<Project> search(ProjectQuery query);
}
