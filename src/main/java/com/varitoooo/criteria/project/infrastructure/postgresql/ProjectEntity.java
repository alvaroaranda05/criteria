package com.varitoooo.criteria.project.infrastructure.postgresql;

import javax.persistence.*;

@Entity
@Table(name = "project")
public final class ProjectEntity {
    @Id
    @Column(name = "id", nullable = false, updatable = false, unique = true)
    private int id;

    @Basic
    @Column(name = "name", nullable = false, length = 250)
    private String name;

    @Basic
    @Column(name = "description", length = 250)
    private String description;

    public ProjectEntity() {
    }

    public ProjectEntity(int id, String name, String description) {
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
