package com.etiya.northwind.api.controllers;

import com.etiya.northwind.business.abstracts.EmployeeService;
import com.etiya.northwind.business.responses.employees.ListEmployeeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeesController {


    private EmployeeService employeeService;
    @Autowired
    public EmployeesController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/getAll")
    public List<ListEmployeeResponse> getAll() {
        return this.employeeService.getAll();
    }

}