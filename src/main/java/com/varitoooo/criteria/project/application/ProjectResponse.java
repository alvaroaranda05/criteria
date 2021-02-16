package com.varitoooo.criteria.project.application;

public final class ProjectResponse {
    private final int id;
    private final String name;
    private final String description;

    public ProjectResponse(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
