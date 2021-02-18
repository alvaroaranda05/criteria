package com.varitoooo.criteria.project;

public final class ProjectEntry {
    private final Integer id;
    private final String name;
    private final String description;

    public ProjectEntry(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
