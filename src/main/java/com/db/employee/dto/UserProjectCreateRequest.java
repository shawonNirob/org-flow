package com.db.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserProjectCreateRequest {
    private int userId;
    private int projectId;
    private String role;
}
