package com.varitoooo.criteria.project.application.find;

import com.varitoooo.criteria.shared.domain.exception.NotFoundException;
import com.varitoooo.criteria.project.domain.DomainProjectFinder;
import com.varitoooo.criteria.project.domain.Project;
import com.varitoooo.criteria.project.domain.ProjectId;
import com.varitoooo.criteria.project.domain.ProjectRepository;

import java.util.Optional;


public final class ProjectFinder {

    private final ProjectRepository projectRepository;

    public ProjectFinder(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project find(ProjectId id) {
        DomainProjectFinder domainProjectFinder = new DomainProjectFinder(projectRepository);
        Optional<Project> project = domainProjectFinder.find(id);

        return project.orElseThrow(() -> new NotFoundException("The project with id " + id.getValue() + " does not exist"));
    }
}
