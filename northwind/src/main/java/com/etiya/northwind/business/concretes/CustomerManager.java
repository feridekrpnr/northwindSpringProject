package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.CustomerService;
import com.etiya.northwind.business.requests.customers.CreateCustomerRequest;
import com.etiya.northwind.business.requests.customers.DeleteCustomerRequest;
import com.etiya.northwind.business.requests.customers.UpdateCustomerRequest;
import com.etiya.northwind.business.responses.customers.GetCustomerResponse;
import com.etiya.northwind.business.responses.customers.ListCustomerResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;
import com.etiya.northwind.core.utilities.results.SuccessDataResult;
import com.etiya.northwind.core.utilities.results.SuccessResult;
import com.etiya.northwind.dataAccess.abstracts.CustomerRepository;
import com.etiya.northwind.entities.concretes.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerManager implements CustomerService {

    private CustomerRepository customerRepository;
    private ModelMapperService modelMapperService;

    @Autowired
    public CustomerManager(CustomerRepository customerRepository,ModelMapperService modelMapperService) {
        this.customerRepository = customerRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public Result add(CreateCustomerRequest createCustomerRequest) {
        Customer customer = this.modelMapperService.forRequest().map(createCustomerRequest,Customer.class);
        this.customerRepository.save(customer);
        return new SuccessResult("CUSTOMER.ADDED");
    }

    @Override
    public Result delete(DeleteCustomerRequest deleteCustomerRequest) {
        Customer customer = this.modelMapperService.forRequest().map(deleteCustomerRequest,Customer.class);
        this.customerRepository.delete(customer);
        return new SuccessResult("CUSTOMER.DELETED");
    }

    @Override
    public Result update(UpdateCustomerRequest updateCustomerRequest) {
        Customer customer = this.modelMapperService.forRequest().map(updateCustomerRequest,Customer.class);
        this.customerRepository.save(customer);
        return new SuccessResult("CUSTOMER.UPDATED");
    }

    @Override
    public DataResult <GetCustomerResponse >getByCompanyName(String companyName) {
        Customer customer = this.customerRepository.findByCompanyName(companyName);
        GetCustomerResponse response = this.modelMapperService.forResponse().map(customer,GetCustomerResponse.class);
        return new SuccessDataResult<>(response);
    }

    @Override
    public DataResult <List<ListCustomerResponse>> getAll() {
        List<Customer> result = this.customerRepository.findAll();
        List<ListCustomerResponse> response = result.stream().map(customer -> this.modelMapperService.forResponse()
                .map(customer,ListCustomerResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(response);


    }
}
