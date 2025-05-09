package com.db.employee.repository;

import com.db.employee.dto.UserProjectDTO;
import com.db.employee.entity.UserProject;
import com.db.employee.entity.UserProjectId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserProjectRepository extends JpaRepository<UserProject, UserProjectId> {
    List<UserProject> findByUser_EmpId(int empId);
    List<UserProject> findByProject_ProjectId(int projectId);
}
