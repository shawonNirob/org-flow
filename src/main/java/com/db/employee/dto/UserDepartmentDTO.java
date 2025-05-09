package com.db.employee.dto;

import lombok.Data;

@Data
public class UserDepartmentDTO {
    private int employeeId;
    private String employeeName;
    private int departmentId;
    private String departmentName;
}
