package com.db.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserProjectDTO {
    private UserDTO user;
    private ProjectDTO project;
    private String role;
}
