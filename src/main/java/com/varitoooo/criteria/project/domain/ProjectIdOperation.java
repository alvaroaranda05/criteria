package com.varitoooo.criteria.project.domain;

import com.varitoooo.criteria.project.domain.criteria.ProjectIdOperator;

public final class ProjectIdOperation {
    private final ProjectIdOperator operator;
    private final ProjectId id;

    public ProjectIdOperation(ProjectIdOperator operator, ProjectId id) {
        this.operator = operator;
        this.id = id;
    }

    public ProjectIdOperator getOperator() {
        return operator;
    }

    public ProjectId getId() {
        return id;
    }
}
