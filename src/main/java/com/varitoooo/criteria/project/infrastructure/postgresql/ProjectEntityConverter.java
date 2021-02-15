package com.varitoooo.criteria.project.infrastructure.postgresql;

import com.varitoooo.criteria.project.domain.Project;
import com.varitoooo.criteria.project.domain.ProjectDescription;
import com.varitoooo.criteria.project.domain.ProjectId;
import com.varitoooo.criteria.project.domain.ProjectName;

public final class ProjectEntityConverter {
    public ProjectEntity getEntity(Project project) {
        return new ProjectEntity(
            project.getId().getValue(),
            project.getName().getValue(),
            project.getDescription().getValue()
        );
    }

    public Project getProject(ProjectEntity projectEntity) {
        return new Project(
                new ProjectId(projectEntity.getId()),
                new ProjectName(projectEntity.getName()),
                new ProjectDescription(projectEntity.getDescription()));
    }
}
