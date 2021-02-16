package com.varitoooo.criteria.project.infrastructure.postgresql;

import javax.persistence.*;

@Entity
@Table(name = "project")
public final class ProjectEntity {
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_DESCRIPTION = "description";


    @Id
    @Column(name = COLUMN_ID, nullable = false, updatable = false, unique = true)
    private int id;

    @Basic
    @Column(name = COLUMN_NAME, nullable = false, length = 250)
    private String name;

    @Basic
    @Column(name = COLUMN_DESCRIPTION, length = 250)
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
