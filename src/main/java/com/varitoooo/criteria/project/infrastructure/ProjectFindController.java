package com.varitoooo.criteria.project.infrastructure;

import com.varitoooo.criteria.project.application.find.ProjectFinder;
import com.varitoooo.criteria.project.application.ProjectResponse;
import com.varitoooo.criteria.project.application.ProjectResponseConverter;
import com.varitoooo.criteria.project.domain.Project;
import com.varitoooo.criteria.project.domain.ProjectId;
import com.varitoooo.criteria.project.domain.ProjectRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/projects")
public final class ProjectFindController {

    private final ProjectRepository projectRepository;

    public ProjectFindController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @GetMapping(path = "/{id}", produces = {"application/json"})
    public ResponseEntity<ProjectResponse> find(@PathVariable(value = "id") Integer id) {
        ProjectFinder projectFinder = new ProjectFinder(projectRepository);
        Project project = projectFinder.find(new ProjectId(id));
        ProjectResponse projectResponse = new ProjectResponseConverter().getResponse(project);

        return ResponseEntity.ok(projectResponse);
    }
}
