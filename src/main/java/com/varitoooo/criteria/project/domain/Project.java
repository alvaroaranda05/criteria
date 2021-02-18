package com.varitoooo.criteria.project.domain;

import com.varitoooo.criteria.project.domain.criteria.ProjectSearchCriteria;

import java.util.Objects;

public final class Project {
    private final ProjectId id;
    private final ProjectName name;
    private final ProjectDescription description;

    public Project(ProjectId id, ProjectName name, ProjectDescription description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public ProjectId getId() {
        return id;
    }

    public ProjectName getName() {
        return name;
    }

    public ProjectDescription getDescription() {
        return description;
    }

    public boolean satisfies(ProjectSearchCriteria criteria) {
        return criteria.isSatisfiedBy(this);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;

        if (!(other instanceof Project)) return false;

        Project otherProject = (Project) other;
        return Objects.equals(id, otherProject.id)
                && Objects.equals(name, otherProject.name)
                && Objects.equals(description, otherProject.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }
}
