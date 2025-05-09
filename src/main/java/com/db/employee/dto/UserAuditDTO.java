package com.db.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAuditDTO {
    private int empId;
    private String userName;
    private Integer departmentId;
    private BigDecimal salary;
    private LocalDateTime hiredate;
    private int version;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime auditTime;
}
