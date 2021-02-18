package com.varitoooo.criteria.project.domain;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository {
    List<Project> getAll();

    Optional<Project> search(ProjectId projectId);

    List<Project> search(ProjectQuery query);
}
