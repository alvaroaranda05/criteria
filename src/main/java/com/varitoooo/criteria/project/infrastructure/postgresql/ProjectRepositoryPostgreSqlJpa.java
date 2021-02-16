package com.varitoooo.criteria.project.infrastructure.postgresql;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepositoryPostgreSqlJpa extends CrudRepository<ProjectEntity, Integer>, JpaSpecificationExecutor<ProjectEntity> {

}
