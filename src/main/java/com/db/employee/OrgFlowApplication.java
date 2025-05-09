package com.db.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//@EnableSwagger2
//@EnableWebMvc
public class OrgFlowApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrgFlowApplication.class, args);
		System.out.println("org-flow application started");
	}
}
