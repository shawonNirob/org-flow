package com.db.employee.mapper;

import com.db.employee.dto.DepartmentDTO;
import com.db.employee.entity.Department;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    DepartmentDTO toDTO(Department department);
    Department toEntity(DepartmentDTO dto);
}
