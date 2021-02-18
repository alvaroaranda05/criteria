package com.varitoooo.criteria.project.domain.criteria;

import com.varitoooo.criteria.project.domain.Project;

public interface ProjectSearchCriteria {
    boolean isSatisfiedBy(Project project);
}
