package com.db.employee.controller;

import com.db.employee.dto.UserAuditDTO;
import com.db.employee.service.UserAuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user-audit")
public class UserAuditController {
    private final UserAuditService userAuditService;

    @Autowired
    public UserAuditController(UserAuditService userAuditService) {
        this.userAuditService = userAuditService;
    }

    @GetMapping("/details")
    public List<UserAuditDTO> getUserDetails() {
        return userAuditService.getAllUsers();
    }

    //use Pagination
    //use Total Count

    @GetMapping("/details/{id}")
    public List<UserAuditDTO> getUserAditHistory(@PathVariable int id) {
        return userAuditService.getUserAditHistory(id);
    }
}
