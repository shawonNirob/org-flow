package com.db.employee.service;

import com.db.employee.dto.DepartmentDTO;
import com.db.employee.entity.Department;
import com.db.employee.mapper.DepartmentMapper;
import com.db.employee.repository.DepartmentReposity;
import com.db.employee.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private final DepartmentReposity departmentReposity;
    private final DepartmentMapper departmentMapper;

    public DepartmentService(DepartmentReposity departmentReposity, DepartmentMapper departmentMapper, UserRepository userRepository) {
        this.departmentReposity = departmentReposity;
        this.departmentMapper = departmentMapper;
    }

    public List<DepartmentDTO> getAllDepartments() {
        return departmentReposity.findAll().stream().map(departmentMapper::toDTO).collect(Collectors.toList());
    }

    public DepartmentDTO getDepartmentById(int id) {
        return departmentReposity.findById(id).map(departmentMapper::toDTO).orElse(null);
    }

    public DepartmentDTO createDepartment(DepartmentDTO departmentDTO){
        Department savedDepartment = departmentReposity.save(departmentMapper.toEntity(departmentDTO));
        return departmentMapper.toDTO(savedDepartment);
    }

    public DepartmentDTO updateDepartment(int id, DepartmentDTO departmentDTO){
        Department department = departmentReposity.findById(id).orElse(null);
        if(department == null) return null;

        department.setDepartmentName(departmentDTO.getDepartmentName());

        Department updatedDepartment = departmentReposity.save(department);
        return departmentMapper.toDTO(updatedDepartment);
    }

    public void deleteDepartment(int id){
        departmentReposity.deleteById(id);
    }
}
