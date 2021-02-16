package com.varitoooo.criteria.project.application;

import com.varitoooo.criteria.project.domain.Project;

public final class ProjectResponseConverter {
    public ProjectResponse getResponse(Project project) {
        return new ProjectResponse(
                project.getId().getValue(),
                project.getName().getValue(),
                project.getDescription().getValue());
    }
}
