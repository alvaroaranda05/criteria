package com.varitoooo.criteria.project.domain;

public final class ProjectQuery {
    private final String value;

    public ProjectQuery(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        ProjectQuery that = (ProjectQuery) obj;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
