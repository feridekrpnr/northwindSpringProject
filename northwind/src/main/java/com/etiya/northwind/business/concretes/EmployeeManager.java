package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.EmployeeService;
import com.etiya.northwind.business.requests.employees.CreateEmployeeRequest;
import com.etiya.northwind.business.requests.employees.DeleteEmployeeRequest;
import com.etiya.northwind.business.requests.employees.UpdateEmployeeRequest;
import com.etiya.northwind.business.responses.employees.GetEmployeeResponse;
import com.etiya.northwind.business.responses.employees.ListEmployeeResponse;
import com.etiya.northwind.core.exceptions.BusinessException;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;
import com.etiya.northwind.core.utilities.results.SuccessDataResult;
import com.etiya.northwind.core.utilities.results.SuccessResult;
import com.etiya.northwind.dataAccess.abstracts.EmployeeRepository;
import com.etiya.northwind.entities.concretes.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeManager implements EmployeeService {


    private EmployeeRepository employeeRepository;
    private ModelMapperService modelMapperService;

    @Autowired
    public EmployeeManager(EmployeeRepository employeeRepository,ModelMapperService modelMapperService) {
        this.employeeRepository = employeeRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public Result add(CreateEmployeeRequest createEmployeeRequest) {
        checkIfReportsLimitExceeds(createEmployeeRequest.getReportsTo());
        Employee employee = this.modelMapperService.forRequest().map(createEmployeeRequest,Employee.class);
        this.employeeRepository.save(employee);
        return new SuccessResult("EMPLOYEE.ADDED");
    }

    @Override
    public Result delete(DeleteEmployeeRequest deleteEmployeeRequest) {
        Employee employee = this.modelMapperService.forRequest().map(deleteEmployeeRequest,Employee.class);
        this.employeeRepository.delete(employee);
        return new SuccessResult("EMPLOYEE.DELETED");
    }

    @Override
    public Result update(UpdateEmployeeRequest updateEmployeeRequest) {
         Employee employee = this.modelMapperService.forRequest().map(updateEmployeeRequest,Employee.class);
         this.employeeRepository.save(employee);
         return new SuccessResult("EMPLOYEE.UPDATED");
    }

    @Override
    public DataResult<GetEmployeeResponse > getById(int id) {
        Employee employee = this.employeeRepository.findById(id);
        GetEmployeeResponse response =  this.modelMapperService.forResponse().map(employee,GetEmployeeResponse.class);
        return new SuccessDataResult<>(response);
    }

    @Override
    public DataResult<List<ListEmployeeResponse>>getAll() {
        List<Employee> result = this.employeeRepository.findAll();
        List<ListEmployeeResponse> response =result.stream().map(employee -> this.modelMapperService.forResponse()
                .map(employee,ListEmployeeResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(response);
    }
    private void checkIfReportsLimitExceeds(int reportsTo) {
        List<Employee> employees = this.employeeRepository.findByReportsTo(reportsTo);
        if(employees.size()> 9) {
            throw new BusinessException("Employees reportsTo limit exceedded");
        }
    }
}
