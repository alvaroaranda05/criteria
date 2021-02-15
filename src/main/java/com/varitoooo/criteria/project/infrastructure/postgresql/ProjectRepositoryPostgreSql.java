package com.varitoooo.criteria.project.infrastructure.postgresql;

import com.varitoooo.criteria.project.domain.Project;
import com.varitoooo.criteria.project.domain.ProjectId;
import com.varitoooo.criteria.project.domain.ProjectRepository;

import java.util.Optional;

public final class ProjectRepositoryPostgreSql implements ProjectRepository {

    private final ProjectRepositoryPostgreSqlJpa projectRepositoryPostgreSqlJpa;

    public ProjectRepositoryPostgreSql(ProjectRepositoryPostgreSqlJpa projectRepositoryPostgreSqlJpa) {
        this.projectRepositoryPostgreSqlJpa = projectRepositoryPostgreSqlJpa;
    }

    @Override
    public void save(Project project) {
        ProjectEntity projectEntity = new ProjectEntityConverter().getEntity(project);
        projectRepositoryPostgreSqlJpa.save(projectEntity);
    }

    @Override
    public Optional<Project> search(ProjectId projectId) {
        Optional<ProjectEntity> projectEntity = projectRepositoryPostgreSqlJpa.findById(projectId.getValue());
        return projectEntity.map(entity -> new ProjectEntityConverter().getProject(entity));
    }
}
