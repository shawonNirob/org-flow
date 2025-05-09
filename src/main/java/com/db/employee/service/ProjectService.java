package com.db.employee.service;

import com.db.employee.dto.ProjectDTO;
import com.db.employee.entity.Project;
import com.db.employee.mapper.ProjectMapper;
import com.db.employee.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    public ProjectService(ProjectRepository projectRepository, ProjectMapper projectMapper) {
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
    }

    public ProjectDTO createProject(ProjectDTO dto) {
        Project savedUser = projectRepository.save(projectMapper.toEntity(dto));
        return projectMapper.toDTO(savedUser);
    }

    public ProjectDTO getProjectById(int id) {
        return projectRepository.findById(id).map(projectMapper::toDTO).orElse(null);
    }

    public List<ProjectDTO> getAllProjects() {
        return projectRepository.findAll()
                .stream()
                .map(projectMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ProjectDTO updateProject(int id, ProjectDTO projectDetails) {
        Project project = projectRepository.findById(id).orElse(null);
        if (project == null) return null;

        project.setProjectName(projectDetails.getProjectName());
        project.setStartingDate(projectDetails.getStartDate());
        project.setEndingDate(projectDetails.getEndDate());

        Project updatedProject = projectRepository.save(project);
        return projectMapper.toDTO(updatedProject);
    }

    public void deleteProject(int id) {
        projectRepository.deleteById(id);
    }
}
