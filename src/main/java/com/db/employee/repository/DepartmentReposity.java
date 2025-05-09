package com.db.employee.repository;

import com.db.employee.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentReposity extends JpaRepository<Department, Integer> {
}
