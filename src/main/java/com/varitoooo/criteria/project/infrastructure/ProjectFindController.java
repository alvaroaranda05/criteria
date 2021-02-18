package com.varitoooo.criteria.project.infrastructure;

import com.varitoooo.criteria.project.application.ProjectResponse;
import com.varitoooo.criteria.project.application.ProjectResponseConverter;
import com.varitoooo.criteria.project.application.find.ProjectCriteriaFinder;
import com.varitoooo.criteria.project.application.find.ProjectFinder;
import com.varitoooo.criteria.project.application.find.ProjectQueryFinder;
import com.varitoooo.criteria.project.domain.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping(path = "/query", produces = {"application/json"})
    public ResponseEntity<List<ProjectResponse>> find(@RequestParam(value = "query") String query) {
        ProjectQueryFinder projectQueryFinder = new ProjectQueryFinder(projectRepository);
        List<Project> projects = projectQueryFinder.find(new ProjectQuery(query));
        List<ProjectResponse> projectResponses = projects.stream()
                .map(project -> new ProjectResponseConverter().getResponse(project))
                .collect(Collectors.toList());

        return ResponseEntity.ok(projectResponses);
    }

    @GetMapping(path = "/criteria", produces = {"application/json"})
    public ResponseEntity<List<ProjectResponse>> find(@RequestParam(value = "name", required = false) String name,
                                                      @RequestParam(value = "description", required = false) String description) {
        ProjectCriteriaFinder projectCriteriaFinder = new ProjectCriteriaFinder(projectRepository);
        //TODO add id criteria management
        List<Project> projects = projectCriteriaFinder.find(
                null,
                StringUtils.isEmpty(name) ? null : new ProjectName(name),
                StringUtils.isEmpty(description) ? null : new ProjectDescription(description)
        );
        List<ProjectResponse> projectResponses = projects.stream()
                .map(project -> new ProjectResponseConverter().getResponse(project))
                .collect(Collectors.toList());

        return ResponseEntity.ok(projectResponses);
    }
}
