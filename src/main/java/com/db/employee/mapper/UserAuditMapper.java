package com.db.employee.mapper;

import com.db.employee.dto.UserAuditDTO;
import com.db.employee.entity.UserAudit;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserAuditMapper {
    UserAuditDTO toDTO(UserAudit userAudit);
    UserAudit toEntity(UserAuditDTO dto);
}
