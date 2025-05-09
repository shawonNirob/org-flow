package com.db.employee.repository;

import com.db.employee.entity.UserAudit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAuditRepository extends JpaRepository<UserAudit, Integer> {

    @Query(value = "select e.emp_id, e.name, d.department_name, p.project_id, p.project_name, e.salary, e.hire_date, ep.role, ae.salary as prev_salary, ae.version, ae.audit_time " +
            "from db.employees e " +
            "left join db.departments d on e.department_id = d.department_id " +
            "left join db.employee_projects ep on e.emp_id = ep.emp_id " +
            "left join db.projects p on ep.project_id = p.project_id " +
            "left left join db.audit_employees ae on e.emp_id = ae.emp_id " +
            "left order by e.emp_id, p.project_id, ae.audit_time", nativeQuery = true)
    List<UserAudit> fetchUserProjectAuditDetails();

    List<UserAudit> findByEmpIdOrderByAuditTimeDesc(int id);
}
