package com.varitoooo.criteria.project.infrastructure;

import com.varitoooo.criteria.project.application.create.ProjectCreator;
import com.varitoooo.criteria.project.application.ProjectEntry;
import com.varitoooo.criteria.project.application.ProjectResponse;
import com.varitoooo.criteria.project.application.ProjectResponseConverter;
import com.varitoooo.criteria.project.domain.Project;
import com.varitoooo.criteria.project.domain.ProjectId;
import com.varitoooo.criteria.project.domain.ProjectName;
import com.varitoooo.criteria.project.domain.ProjectRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/projects")
public final class ProjectCreateController {

    private final ProjectRepository projectRepository;

    public ProjectCreateController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @PostMapping(produces = {"application/json"})
    public ResponseEntity<ProjectResponse> create(@RequestBody ProjectEntry projectEntry) {
        ProjectCreator projectCreator = new ProjectCreator(projectRepository);
        Project project = projectCreator.create(
                new ProjectId(projectEntry.getId()),
                new ProjectName(projectEntry.getName())
        );
        ProjectResponse projectResponse = new ProjectResponseConverter().getResponse(project);
        return ResponseEntity.ok().body(projectResponse);
    }
}
