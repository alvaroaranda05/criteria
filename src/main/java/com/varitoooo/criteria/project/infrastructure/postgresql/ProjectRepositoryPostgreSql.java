package com.varitoooo.criteria.project.infrastructure.postgresql;

import com.varitoooo.criteria.project.domain.Project;
import com.varitoooo.criteria.project.domain.ProjectId;
import com.varitoooo.criteria.project.domain.ProjectQuery;
import com.varitoooo.criteria.project.domain.ProjectRepository;
import com.varitoooo.criteria.shared.infrastructure.postgresql.BaseRepositoryPostgreSql;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public final class ProjectRepositoryPostgreSql extends BaseRepositoryPostgreSql implements ProjectRepository {

    private final ProjectRepositoryPostgreSqlJpa projectRepositoryPostgreSqlJpa;

    public ProjectRepositoryPostgreSql(ProjectRepositoryPostgreSqlJpa projectRepositoryPostgreSqlJpa) {
        this.projectRepositoryPostgreSqlJpa = projectRepositoryPostgreSqlJpa;
    }

    @Override
    public List<Project> getAll() {
        return StreamSupport.stream(projectRepositoryPostgreSqlJpa.findAll().spliterator(), false)
                .map(entity -> new ProjectEntityConverter().getProject(entity))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Project> search(ProjectId projectId) {
        Optional<ProjectEntity> projectEntity = projectRepositoryPostgreSqlJpa.findById(projectId.getValue());
        return projectEntity.map(entity -> new ProjectEntityConverter().getProject(entity));
    }

    @Override
    public List<Project> search(ProjectQuery query) {
        String queryString = parseQueryString(query.getValue());
        
        Specification<ProjectEntity> specification = (root, criteriaQuery, criteriaBuilder) ->
            criteriaBuilder.or(
                    criteriaBuilder.like(criteriaBuilder.upper(root.get(ProjectEntity.COLUMN_NAME)), WILDCARD + queryString.toUpperCase() + WILDCARD),
                    criteriaBuilder.like(criteriaBuilder.upper(root.get(ProjectEntity.COLUMN_DESCRIPTION)), WILDCARD + queryString.toUpperCase() + WILDCARD)
            );

        List<ProjectEntity> entities = projectRepositoryPostgreSqlJpa.findAll(specification);
        return entities.stream()
                .map(entity -> new ProjectEntityConverter().getProject(entity))
                .collect(Collectors.toList());
    }
}
