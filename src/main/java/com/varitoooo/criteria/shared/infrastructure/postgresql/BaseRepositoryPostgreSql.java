package com.varitoooo.criteria.shared.infrastructure.postgresql;

public abstract class BaseRepositoryPostgreSql {
    protected String WILDCARD = "%";

    public String parseQueryString(String query) {
        if (query == null || query.isEmpty())
            query = WILDCARD;
        return query;
    }
}
