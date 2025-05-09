package com.db.employee.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "departments", schema = "db")
public class Department {
    @Id
    @Column(name = "department_id", nullable = false)
    private int departmentId;

    @Column(name = "department_name", length = 100)
    private String departmentName;
}
