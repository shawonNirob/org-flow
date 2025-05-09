package com.db.employee.controller;

import com.db.employee.dto.UserProjectCreateRequest;
import com.db.employee.dto.UserProjectDTO;
import com.db.employee.dto.UserProjectUpdateRequest;
import com.db.employee.service.UserProjectService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-project")
public class UserProjectController {
    @Autowired
    private UserProjectService userProjectService;

    @GetMapping
    public List<UserProjectDTO> getAllUserProjectRoles() {return userProjectService.getAllUserProjectRoles();}

    @GetMapping("/user/{empId}")
    public ResponseEntity<List<UserProjectDTO>> getProjectsByUserId(@PathVariable int empId) {
        List<UserProjectDTO> userProject =  userProjectService.getProjectsByUserId(empId);
        return userProject != null ? ResponseEntity.ok(userProject) : ResponseEntity.notFound().build();
    }

    @GetMapping("/project/{projectId}")
    public ResponseEntity<List<UserProjectDTO>> getUserByProjectId(@PathVariable int projectId) {
        List<UserProjectDTO> userProject = userProjectService.getUserByProjectId(projectId);
        return userProject != null ? ResponseEntity.ok(userProject) : ResponseEntity.notFound().build();
    }

    @GetMapping("/task/{empId}/{projectId}")
    public ResponseEntity<UserProjectDTO> getPosition(@PathVariable int empId, @PathVariable int projectId) {
        UserProjectDTO userProject = userProjectService.getPosition(empId, projectId);
        return userProject != null ? ResponseEntity.ok(userProject) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public UserProjectDTO createUserProjectRole(@RequestBody UserProjectCreateRequest request) {
        return userProjectService.createUserProjectRole(request);
    }

    @PutMapping("/update/{empId}/{projectId}")
    public ResponseEntity<UserProjectDTO> updateUserProjectRole(@PathVariable int empId, @PathVariable int projectId, @RequestBody UserProjectUpdateRequest request) {
        UserProjectDTO updatedUser = userProjectService.updateUserProjectRole(empId, projectId, request);
        return updatedUser != null ? ResponseEntity.ok(updatedUser) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{empId}/{projectId}")
    public ResponseEntity<String> deleteUserProjectRole(@PathVariable int empId, @PathVariable int projectId) {
        try{
            userProjectService.deleteTask(empId, projectId);
            return ResponseEntity.ok("Task deleted");
        }catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
