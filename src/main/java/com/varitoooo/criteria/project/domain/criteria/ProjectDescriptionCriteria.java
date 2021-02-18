package com.varitoooo.criteria.project.domain.criteria;

import com.varitoooo.criteria.project.domain.Project;

public final class ProjectDescriptionCriteria extends ProjectStringCriteria implements ProjectSearchCriteria {
    private final String description;

    public ProjectDescriptionCriteria(String description) {
        this.description = description;
    }

    @Override
    public boolean isSatisfiedBy(Project project) {
        return isSatisfiedBy(description, project.getDescription().getValue());
    }
}
