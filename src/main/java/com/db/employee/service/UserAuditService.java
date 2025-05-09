package com.db.employee.service;

import com.db.employee.dto.UserAuditDTO;
import com.db.employee.mapper.UserAuditMapper;
import com.db.employee.repository.UserAuditRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserAuditService {
    private final UserAuditRepository userAuditRepository;
    private final UserAuditMapper userAuditMapper;

    public UserAuditService(UserAuditRepository userAuditRepository, UserAuditMapper userAuditMapper) {
        this.userAuditRepository = userAuditRepository;
        this.userAuditMapper = userAuditMapper;
    }

    public List<UserAuditDTO> getAllUsers() {
        return userAuditRepository.findAll().stream().map(userAuditMapper::toDTO).collect(Collectors.toList());
    }

    public List<UserAuditDTO> getUserAditHistory(int id) {
        return userAuditRepository.findByEmpIdOrderByAuditTimeDesc(id).stream().map(userAuditMapper::toDTO).collect(Collectors.toList());
    }
}
