package com.db.employee.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class UserDTO {
    private int empId;
    private String name;
    private DepartmentDTO department;
    private BigDecimal salary;
    private LocalDate hireDate;
}
