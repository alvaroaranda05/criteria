package com.varitoooo.criteria.project.application.find;

import com.varitoooo.criteria.project.domain.*;
import com.varitoooo.criteria.project.domain.criteria.ProjectSearchCriteria;
import com.varitoooo.criteria.project.domain.criteria.ProjectSearchCriteriaBuilder;

import java.util.List;
import java.util.stream.Collectors;

public final class ProjectCriteriaFinder {
    private final ProjectRepository projectRepository;

    public ProjectCriteriaFinder(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> find(ProjectId id, ProjectName name, ProjectDescription description) {
        List<Project> projects = projectRepository.getAll();
        List<ProjectSearchCriteria> criteria = getCriteria(name, description);
        DomainProjectCriteriaFinder domainProjectCriteriaFinder = new DomainProjectCriteriaFinder(criteria);

        return projects.stream()
                .filter(domainProjectCriteriaFinder::isSatisfiedBy)
                .collect(Collectors.toList());
    }

    private List<ProjectSearchCriteria> getCriteria(ProjectName name, ProjectDescription description) {
        return new ProjectSearchCriteriaBuilder()
                .withName(name)
                .withDescription(description)
                .build();
    }
}
