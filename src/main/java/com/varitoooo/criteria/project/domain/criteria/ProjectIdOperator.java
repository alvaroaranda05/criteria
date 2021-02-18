package com.varitoooo.criteria.project.domain.criteria;

public enum ProjectIdOperator {
    LESS_THAN("less_than"),
    EQUAL("equal"),
    MORE_THAN("more_than");

    private final String operation;

    ProjectIdOperator(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }
}
