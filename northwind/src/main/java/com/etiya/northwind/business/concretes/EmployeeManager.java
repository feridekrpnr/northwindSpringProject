package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.EmployeeService;
import com.etiya.northwind.business.responses.employees.ListEmployeeResponse;
import com.etiya.northwind.dataAccess.abstracts.EmployeeRepository;
import com.etiya.northwind.entities.concretes.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmployeeManager implements EmployeeService {


    EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeManager(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<ListEmployeeResponse> getAll() {
        List<Employee> result = this.employeeRepository.findAll();
        List<ListEmployeeResponse> response = new ArrayList<ListEmployeeResponse>();
        for(Employee employee : result) {
            ListEmployeeResponse listEmployeeResponse = new ListEmployeeResponse();
            listEmployeeResponse.setId(employee.getEmployeeId());
            listEmployeeResponse.setFirstName(employee.getFirstName());
            listEmployeeResponse.setLastName(employee.getLastName());
            listEmployeeResponse.setBirthDate(employee.getBirthDate());
            response.add(listEmployeeResponse);

        }
        return response;
    }
}
