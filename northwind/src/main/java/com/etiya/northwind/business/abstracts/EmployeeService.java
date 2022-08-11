package com.etiya.northwind.business.abstracts;

import com.etiya.northwind.business.requests.employees.CreateEmployeeRequest;
import com.etiya.northwind.business.requests.employees.DeleteEmployeeRequest;
import com.etiya.northwind.business.requests.employees.UpdateEmployeeRequest;
import com.etiya.northwind.business.responses.employees.GetEmployeeResponse;
import com.etiya.northwind.business.responses.employees.ListEmployeeResponse;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;

import java.util.List;

public interface EmployeeService {

    Result add(CreateEmployeeRequest createEmployeeRequest);

    Result delete(DeleteEmployeeRequest deleteEmployeeRequest);

    Result update(UpdateEmployeeRequest updateEmployeeRequest);

    DataResult <GetEmployeeResponse >getById(int id);
    DataResult<List<ListEmployeeResponse>> getAll();
}
