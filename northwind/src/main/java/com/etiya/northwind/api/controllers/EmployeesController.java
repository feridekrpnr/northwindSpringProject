package com.etiya.northwind.api.controllers;

import com.etiya.northwind.business.abstracts.EmployeeService;
import com.etiya.northwind.business.requests.employees.CreateEmployeeRequest;
import com.etiya.northwind.business.requests.employees.DeleteEmployeeRequest;
import com.etiya.northwind.business.requests.employees.UpdateEmployeeRequest;
import com.etiya.northwind.business.responses.employees.GetEmployeeResponse;
import com.etiya.northwind.business.responses.employees.ListEmployeeResponse;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public Result add(@RequestBody @Valid CreateEmployeeRequest createEmployeeRequest) {
        return this.employeeService.add(createEmployeeRequest);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody DeleteEmployeeRequest deleteEmployeeRequest) {
        return this.employeeService.delete(deleteEmployeeRequest);
    }

    @PostMapping("/update")
    public Result update(@RequestBody UpdateEmployeeRequest updateEmployeeRequest) {
        return this.employeeService.update(updateEmployeeRequest);

    }

    @GetMapping("/getbyid")
    public DataResult<GetEmployeeResponse> getById(@RequestParam int id) {
        return this.employeeService.getById(id);
    }

    @GetMapping("/getall")
    public DataResult<List<ListEmployeeResponse>> getAll() {
        return this.employeeService.getAll();
    }

}
