package com.db.employee.mapper;

import com.db.employee.dto.UserDTO;
import com.db.employee.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDTO(User user);
    User toEntity(UserDTO dto);
}
