package com.varitoooo.criteria.project.domain.criteria;

public abstract class ProjectStringCriteria {

    public boolean isSatisfiedBy(String value, String projectValue) {
        return projectValue != null && projectValue.contains(value);
    }
}
