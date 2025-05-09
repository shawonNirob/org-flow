package com.db.employee.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProjectId implements Serializable {
    @Column(name = "emp_id")
    private int empId;

    @Column(name = "project_id")
    private int projectId;
}
