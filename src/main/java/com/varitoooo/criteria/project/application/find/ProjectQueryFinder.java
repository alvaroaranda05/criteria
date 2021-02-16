package com.varitoooo.criteria.project.application.find;

import com.varitoooo.criteria.project.domain.Project;
import com.varitoooo.criteria.project.domain.ProjectQuery;
import com.varitoooo.criteria.project.domain.ProjectRepository;

import java.util.List;


public final class ProjectQueryFinder {

    private final ProjectRepository projectRepository;

    public ProjectQueryFinder(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> find(ProjectQuery query) {
        return projectRepository.search(query);
    }
}
