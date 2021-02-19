package com.varitoooo.criteria.project.infrastructure;

import com.varitoooo.criteria.project.application.ProjectResponse;
import com.varitoooo.criteria.project.application.ProjectResponseConverter;
import com.varitoooo.criteria.project.application.find.ProjectCriteriaFinder;
import com.varitoooo.criteria.project.application.find.ProjectFinder;
import com.varitoooo.criteria.project.application.find.ProjectQueryFinder;
import com.varitoooo.criteria.project.domain.*;
import com.varitoooo.criteria.project.domain.criteria.ProjectIdOperator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.OperationsException;
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
    public ResponseEntity<List<ProjectResponse>> find(@RequestParam(value = "id", required = false) String idString,
                                                      @RequestParam(value = "name", required = false) String name,
                                                      @RequestParam(value = "description", required = false) String description) throws OperationsException {
        ProjectCriteriaFinder projectCriteriaFinder = new ProjectCriteriaFinder(projectRepository);


        List<Project> projects = projectCriteriaFinder.find(
                idString == null ? null : new ProjectIdOperation(getOperator(idString), getId(idString)),
                StringUtils.isEmpty(name) ? null : new ProjectName(name),
                StringUtils.isEmpty(description) ? null : new ProjectDescription(description)
        );
        List<ProjectResponse> projectResponses = projects.stream()
                .map(project -> new ProjectResponseConverter().getResponse(project))
                .collect(Collectors.toList());

        return ResponseEntity.ok(projectResponses);
    }

    //TODO this is just a simple version to get id and operation together
    private ProjectIdOperator getOperator(String idString) throws OperationsException {
        int operatorBeginIndex = 0;
        int operatorEndIndex = 1;
        return ProjectIdOperator
                .fromString(idString.substring(operatorBeginIndex, operatorEndIndex))
                .orElseThrow(OperationsException::new);
    }

    private ProjectId getId(String idString) {
        int idBeginIndex = 1;
        int idEndIndex = 2;
        return new ProjectId(Integer.parseInt(idString.substring(idBeginIndex, idEndIndex)));
    }
}
