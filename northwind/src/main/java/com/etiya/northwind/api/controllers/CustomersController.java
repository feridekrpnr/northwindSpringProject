package com.etiya.northwind.api.controllers;

import com.etiya.northwind.business.abstracts.CustomerService;
import com.etiya.northwind.business.requests.customers.CreateCustomerRequest;
import com.etiya.northwind.business.requests.customers.DeleteCustomerRequest;
import com.etiya.northwind.business.requests.customers.UpdateCustomerRequest;
import com.etiya.northwind.business.responses.customers.GetCustomerResponse;
import com.etiya.northwind.business.responses.customers.ListCustomerResponse;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;
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
    public Result add(@RequestBody CreateCustomerRequest createCustomerRequest) {
        return this.customerService.add(createCustomerRequest);
    }


    @PostMapping("/delete")
    public Result delete(@RequestBody DeleteCustomerRequest deleteCustomerRequest) {
        return this.customerService.delete(deleteCustomerRequest);
    }

    @PostMapping("update")
    public Result update(@RequestBody UpdateCustomerRequest updateCustomerRequest) {
        return this.customerService.update(updateCustomerRequest);
    }

    @GetMapping("/getbycompanyname")
    public DataResult<GetCustomerResponse > getByCompanyName(String companyName) {
        return this.customerService.getByCompanyName(companyName);

    }

    @GetMapping("/getall")
    public DataResult<List<ListCustomerResponse>>getAll() {
        return this.customerService.getAll();
    }




}
