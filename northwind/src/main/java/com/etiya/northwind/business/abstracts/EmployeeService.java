package com.etiya.northwind.business.abstracts;

import com.etiya.northwind.business.requests.employees.CreateEmployeeRequest;
import com.etiya.northwind.business.requests.employees.DeleteEmployeeRequest;
import com.etiya.northwind.business.requests.employees.UpdateEmployeeRequest;
import com.etiya.northwind.business.responses.employees.GetEmployeeResponse;
import com.etiya.northwind.business.responses.employees.ListEmployeeResponse;

import java.util.List;

public interface EmployeeService {

    void add(CreateEmployeeRequest createEmployeeRequest);

    void delete(DeleteEmployeeRequest deleteEmployeeRequest);

    void update(UpdateEmployeeRequest updateEmployeeRequest);

    GetEmployeeResponse getById(int id);
    List<ListEmployeeResponse> getAll();
}
