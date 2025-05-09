package com.db.employee.mapper;

import com.db.employee.dto.ProjectDTO;
import com.db.employee.entity.Project;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProjectMapper {
    ProjectDTO toDTO(Project project);
    Project toEntity(ProjectDTO dto);
}
