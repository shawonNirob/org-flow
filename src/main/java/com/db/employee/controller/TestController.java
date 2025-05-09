package com.db.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/db")
    public String testDatabaseConnection() {
        try {
            Integer count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM db.employees", Integer.class);
            return "Connected! Employee Count: " + count;
        } catch (Exception e) {
            System.out.println("Password: " + System.getenv("DB_PASSWORD"));
            return "Database connection failed: " + e.getMessage();
        }
    }
}

