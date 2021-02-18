package com.varitoooo.criteria.project.domain;

import com.varitoooo.criteria.project.domain.criteria.ProjectSearchCriteria;

import java.util.List;

public final class DomainProjectCriteriaFinder {
    private List<ProjectSearchCriteria> criteria;

    public DomainProjectCriteriaFinder(List<ProjectSearchCriteria> criteria) {
        this.criteria = criteria;
    }

    public boolean isSatisfiedBy(Project project) {
        return criteria.stream()
                .allMatch(searchCriteria -> searchCriteria.isSatisfiedBy(project));
    }
}
