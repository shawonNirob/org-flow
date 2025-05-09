package com.db.employee.controller;

import com.db.employee.dto.DepartmentDTO;
import com.db.employee.dto.ProjectDTO;
import com.db.employee.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping
    public List<ProjectDTO> getAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDTO> getProjectById(@PathVariable int id) {
        ProjectDTO project = projectService.getProjectById(id);
        return project != null ? ResponseEntity.ok(project) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ProjectDTO createProject(@RequestBody ProjectDTO project) {
        return projectService.createProject(project);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectDTO> updateProject(@PathVariable int id, @RequestBody ProjectDTO project) {
        ProjectDTO updatedProject = projectService.updateProject(id, project);
        return updatedProject != null ? ResponseEntity.ok(updatedProject) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable int id) {
        projectService.deleteProject(id);
        return ResponseEntity.ok("Project deleted successfully");
    }
}
