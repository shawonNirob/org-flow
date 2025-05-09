package com.db.employee.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "projects", schema = "db")
public class Project {
    @Id
    @Column(name = "project_id", nullable = false)
    private int projectId;

    @Column(name = "project_name", length = 100)
    private String projectName;

    @Column(name = "starting_date")
    private Date startingDate;

    @Column(name = "end_date")
    private Date endingDate;
}
