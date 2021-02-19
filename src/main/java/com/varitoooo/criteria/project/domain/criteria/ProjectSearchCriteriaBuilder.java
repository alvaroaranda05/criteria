package com.varitoooo.criteria.project.domain.criteria;

import com.varitoooo.criteria.project.domain.ProjectDescription;
import com.varitoooo.criteria.project.domain.ProjectIdOperation;
import com.varitoooo.criteria.project.domain.ProjectName;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public final class ProjectSearchCriteriaBuilder {
    protected List<ProjectSearchCriteria> criteria = new ArrayList<>();

    public ProjectSearchCriteriaBuilder withName(ProjectName name)   {
        if (name != null && !StringUtils.isEmpty(name.getValue())) criteria.add(new ProjectNameCriteria(name.getValue()));
        return this;
    }

    public ProjectSearchCriteriaBuilder withDescription(ProjectDescription description)   {
        if (description != null && !StringUtils.isEmpty(description.getValue())) criteria.add(new ProjectDescriptionCriteria(description.getValue()));
        return this;
    }

    public ProjectSearchCriteriaBuilder withId(ProjectIdOperation idOperation)   {
        if (idOperation != null) criteria.add(new ProjectIdCriteria(idOperation.getOperator(), idOperation.getId().getValue()));
        return this;
    }

    public List<ProjectSearchCriteria> build() {
        return criteria;
    }
}
