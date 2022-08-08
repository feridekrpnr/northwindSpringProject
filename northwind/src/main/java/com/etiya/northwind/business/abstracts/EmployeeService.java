package com.etiya.northwind.business.abstracts;

import com.etiya.northwind.business.responses.employees.ListEmployeeResponse;

import java.util.List;

public interface EmployeeService {

    List<ListEmployeeResponse> getAll();
}
