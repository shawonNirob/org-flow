package com.db.employee.dto;

import lombok.*;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserAuditClientResponse {
    private UserDTO user;
    private List<UserAuditDTO> data;
}
