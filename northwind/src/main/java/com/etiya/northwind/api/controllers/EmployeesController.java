package com.etiya.northwind.api.controllers;

import com.etiya.northwind.business.abstracts.EmployeeService;
import com.etiya.northwind.business.requests.employees.CreateEmployeeRequest;
import com.etiya.northwind.business.requests.employees.DeleteEmployeeRequest;
import com.etiya.northwind.business.requests.employees.UpdateEmployeeRequest;
import com.etiya.northwind.business.responses.employees.GetEmployeeResponse;
import com.etiya.northwind.business.responses.employees.ListEmployeeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeesController {


    private EmployeeService employeeService;
    @Autowired
    public EmployeesController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @PostMapping("/add")
    public void add(@RequestBody CreateEmployeeRequest createEmployeeRequest) {
        this.employeeService.add(createEmployeeRequest);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody DeleteEmployeeRequest deleteEmployeeRequest) {
        this.employeeService.delete(deleteEmployeeRequest);
    }

    @PostMapping("/update")
    public void update(@RequestBody UpdateEmployeeRequest updateEmployeeRequest) {
        this.employeeService.update(updateEmployeeRequest);

    }

    @GetMapping("/getById")
    public GetEmployeeResponse getById(@RequestParam int id) {
        return this.employeeService.getById(id);
    }

    @GetMapping("/getAll")
    public List<ListEmployeeResponse> getAll() {
        return this.employeeService.getAll();
    }

}
