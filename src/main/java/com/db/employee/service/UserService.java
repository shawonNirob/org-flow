package com.db.employee.service;

import com.db.employee.dto.UserDTO;
import com.db.employee.entity.Department;
import com.db.employee.entity.User;
import com.db.employee.mapper.UserMapper;
import com.db.employee.repository.DepartmentReposity;
import com.db.employee.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final DepartmentReposity departmentRepository;

    public UserService(UserRepository userRepository, UserMapper userMapper, DepartmentReposity departmentRepository) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.departmentRepository = departmentRepository;
    }

    public UserDTO createUser(UserDTO dto) {
        User savedUser = userRepository.save(userMapper.toEntity(dto));
        return userMapper.toDTO(savedUser);
    }

    public UserDTO getUserById(int id) {
        return userRepository.findById(id).map(userMapper::toDTO).orElse(null);
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(userMapper::toDTO).collect(Collectors.toList());
    }

    public UserDTO updateUser(int id, UserDTO userDetails) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) return null;

        user.setName(userDetails.getName());
        user.setSalary(userDetails.getSalary());
        user.setHireDate(userDetails.getHireDate());

        Department department = departmentRepository.findById(userDetails.getDepartment().getDepartmentId())
                .orElseThrow(()->new RuntimeException("Department not found"));

        user.setDepartment(department);

        User updatedUser = userRepository.save(user);
        return userMapper.toDTO(updatedUser);
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}
