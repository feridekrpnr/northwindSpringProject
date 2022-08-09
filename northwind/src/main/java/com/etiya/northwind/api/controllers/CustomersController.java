package com.etiya.northwind.api.controllers;

import com.etiya.northwind.business.abstracts.CustomerService;
import com.etiya.northwind.business.requests.customers.CreateCustomerRequest;
import com.etiya.northwind.business.requests.customers.DeleteCustomerRequest;
import com.etiya.northwind.business.requests.customers.UpdateCustomerRequest;
import com.etiya.northwind.business.responses.customers.GetCustomerResponse;
import com.etiya.northwind.business.responses.customers.ListCustomerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomersController {

    private CustomerService customerService;
    @Autowired
    public CustomersController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/add")
    public void add(@RequestBody CreateCustomerRequest createCustomerRequest) {
        this.customerService.add(createCustomerRequest);
    }


    @PostMapping("/delete")
    public void delete(@RequestBody DeleteCustomerRequest deleteCustomerRequest) {
        this.customerService.delete(deleteCustomerRequest);
    }

    @PostMapping("update")
    public void update(@RequestBody UpdateCustomerRequest updateCustomerRequest) {
        this.customerService.update(updateCustomerRequest);
    }

    @GetMapping("/getByCompanyName")
    public GetCustomerResponse getByCompanyName(String companyName) {
        return this.customerService.getByCompanyName(companyName);
    }

    @GetMapping("/getAll")
    public List<ListCustomerResponse> getAll() {
        return this.customerService.getAll();
    }




}
