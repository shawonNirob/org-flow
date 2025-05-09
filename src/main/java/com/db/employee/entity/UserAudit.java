package com.db.employee.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "audit_employees", schema = "db")
public class UserAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "log_id", nullable = false)
    private int id;

    @Column(name = "emp_id")
    private int empId;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "department_id")
    private Integer departmentId;

    @Column(name = "salary", precision = 10, scale = 2)
    private BigDecimal salary;

    @Column(name = "hire_date")
    private LocalDate hireDate;

    @Column(name = "version")
    private int version;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "audit_time", insertable = false, updatable = false)
    private LocalDateTime auditTime;
}
