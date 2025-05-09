package com.db.employee.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee_projects", schema = "db")
public class UserProject {
    @EmbeddedId
    private UserProjectId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("empId")
    @JoinColumn(name = "emp_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("projectId")
    @JoinColumn(name = "project_id")
    private Project project;

    @Column(name = "role", length = 50)
    private String role;
}
