package com.varitoooo.criteria.project.domain.criteria;

import java.util.Arrays;
import java.util.Optional;

public enum ProjectIdOperator {
    LESS_THAN("<"),
    EQUAL("="),
    MORE_THAN(">");

    private final String operation;

    ProjectIdOperator(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }

    public static Optional<ProjectIdOperator> fromString(String operationString) {
        return Arrays.stream(ProjectIdOperator.values())
                .filter(operation -> operation.getOperation().equals(operationString))
                .findFirst();
    }
}
