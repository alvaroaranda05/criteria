package com.varitoooo.criteria.project.domain.criteria;

import com.varitoooo.criteria.project.domain.Project;

public final class ProjectIdCriteria implements ProjectSearchCriteria {

    private final ProjectIdOperator operator;
    private final Integer id;

    public ProjectIdCriteria(ProjectIdOperator operator, Integer id) {
        this.operator = operator;
        this.id = id;
    }

    @Override
    public boolean isSatisfiedBy(Project project) {
        int projectId = project.getId().getValue();

        if (operator.equals(ProjectIdOperator.EQUAL)) return equalsOperation(projectId);
        if (operator.equals(ProjectIdOperator.MORE_THAN)) return moreThanOperation(projectId);
        if (operator.equals(ProjectIdOperator.LESS_THAN)) return lessThanOperation(projectId);
        return false;
    }

    private boolean equalsOperation(Integer projectId) {
        return projectId != null && projectId.equals(id);
    }

    private boolean moreThanOperation(Integer projectId) {
        return projectId != null && id > projectId;
    }

    private boolean lessThanOperation(Integer projectId) {
        return projectId != null && id < projectId;
    }
}
