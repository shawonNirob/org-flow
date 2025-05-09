package com.db.employee.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ProjectDTO {
    private int projectId;
    private String projectName;
    private Date startDate;
    private Date endDate;
}
