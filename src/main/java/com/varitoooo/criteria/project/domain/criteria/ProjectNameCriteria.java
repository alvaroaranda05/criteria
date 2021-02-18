package com.varitoooo.criteria.project.domain.criteria;

import com.varitoooo.criteria.project.domain.Project;

public final class ProjectNameCriteria extends ProjectStringCriteria implements ProjectSearchCriteria {
    private final String name;

    public ProjectNameCriteria(String name) {
        this.name = name;
    }

    @Override
    public boolean isSatisfiedBy(Project project) {
        return isSatisfiedBy(name, project.getName().getValue());
    }
}
