package com.db.employee.service;

import com.db.employee.dto.UserProjectDTO;
import com.db.employee.dto.UserProjectCreateRequest;
import com.db.employee.dto.UserProjectUpdateRequest;
import com.db.employee.entity.Project;
import com.db.employee.entity.User;
import com.db.employee.entity.UserProject;
import com.db.employee.entity.UserProjectId;
import com.db.employee.mapper.UserProjectMapper;
import com.db.employee.repository.ProjectRepository;
import com.db.employee.repository.UserProjectRepository;
import com.db.employee.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserProjectService {
    private final UserProjectRepository userProjectRepository;
    private final UserProjectMapper userProjectMapper;
    private final UserRepository userRepository;
    private final ProjectRepository projectRepository;

    public UserProjectService(UserProjectRepository userProjectRepository, UserProjectMapper userProjectMapper, UserRepository userRepository, ProjectRepository projectRepository) {
        this.userProjectRepository = userProjectRepository;
        this.userProjectMapper = userProjectMapper;
        this.userRepository = userRepository;
        this.projectRepository = projectRepository;
    }

    public List<UserProjectDTO> getAllUserProjectRoles() {
        return userProjectRepository.findAll().stream().map(userProjectMapper::toDTO).collect(Collectors.toList());
    }

    public List<UserProjectDTO> getProjectsByUserId(int empId) {
        List<UserProject> userProjects = userProjectRepository.findByUser_EmpId(empId);
        return userProjects.stream().map(userProjectMapper::toDTO).collect(Collectors.toList());
    }

    public List<UserProjectDTO> getUserByProjectId(int projectId) {
        List<UserProject> userProjects = userProjectRepository.findByProject_ProjectId(projectId);
        return userProjects.stream().map(userProjectMapper::toDTO).collect(Collectors.toList());
    }

    public UserProjectDTO getPosition(int empId, int projectId) {
        return userProjectRepository.findById(new UserProjectId(empId, projectId)).map(userProjectMapper::toDTO).orElse(null);
    }

    public UserProjectDTO createUserProjectRole(UserProjectCreateRequest request) {
        User user = userRepository.findById(request.getUserId()).orElseThrow(()-> new RuntimeException("User Not Found"));
        Project project = projectRepository.findById(request.getProjectId()).orElseThrow(()-> new RuntimeException("Project Not Found"));

        UserProject userProject = new UserProject();
        userProject.setId(new UserProjectId(request.getUserId(), request.getProjectId()));
        userProject.setUser(user);
        userProject.setProject(project);
        userProject.setRole(request.getRole());

        UserProject savedUserProject = userProjectRepository.save(userProject);

        return userProjectMapper.toDTO(savedUserProject);
    }

    public UserProjectDTO updateUserProjectRole(int empId, int projectId, UserProjectUpdateRequest request) {
        UserProject userProject = userProjectRepository.findById(new UserProjectId(empId, projectId))
                .orElseThrow(()-> new RuntimeException("User Not Found"));

        userProject.setRole(request.getRole());
        UserProject savedUserProject = userProjectRepository.save(userProject);

        return userProjectMapper.toDTO(savedUserProject);
    }

    public void deleteTask(int empId, int projectId) {
        UserProjectId userProjectId = new UserProjectId(empId, projectId);
        if(!userProjectRepository.existsById(userProjectId)) {throw new EntityNotFoundException("User Project Role Not Found");}
        userProjectRepository.deleteById(userProjectId);
    }
}
