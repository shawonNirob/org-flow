package com.db.employee.mapper;

import com.db.employee.dto.UserDTO;
import com.db.employee.dto.UserProjectDTO;
import com.db.employee.entity.UserProject;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UserMapper.class, ProjectMapper.class})
public interface UserProjectMapper {

    @Mapping(source = "user", target = "user")
    @Mapping(source = "project", target = "project")
    @Mapping(source = "role", target = "role")
    UserProjectDTO toDTO(UserProject userProject);
    UserProject toEntity(UserDTO user);
}

