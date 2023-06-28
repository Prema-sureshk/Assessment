package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.EmployeeModel;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;


@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

  @Autowired  
  EmployeeService employeeService;
  

@PostMapping("/employees")
public ResponseEntity<String> createEmployee(@Validated @RequestBody  EmployeeModel emp){
		//return employeeService.createEmployee(employee);
        if(emp.getName().isEmpty() || emp.getDesignation().isEmpty()){
            return   ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Bad request on validation error\n");
        }
        employeeService.createEmployee(emp);       
        return   ResponseEntity.status(HttpStatus.CREATED).body("HTTP Status will be CREATED (CODE 201)\n EMPLOYEE ID: "+emp.getEmpid());
        
	}
    
}