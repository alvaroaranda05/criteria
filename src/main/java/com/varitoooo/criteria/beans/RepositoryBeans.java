package com.varitoooo.criteria.beans;

import com.varitoooo.criteria.project.domain.ProjectRepository;
import com.varitoooo.criteria.project.infrastructure.postgresql.ProjectRepositoryPostgreSql;
import com.varitoooo.criteria.project.infrastructure.postgresql.ProjectRepositoryPostgreSqlJpa;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

public class RepositoryBeans {
    @Bean
    @Primary
    public ProjectRepository projectRepositoryComponent(ProjectRepositoryPostgreSqlJpa projectRepositoryPostgreSqlJpa) {
        return new ProjectRepositoryPostgreSql(projectRepositoryPostgreSqlJpa);
    }
}
