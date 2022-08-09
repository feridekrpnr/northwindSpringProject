package com.etiya.northwind.business.abstracts;

import com.etiya.northwind.business.requests.customers.CreateCustomerRequest;
import com.etiya.northwind.business.requests.customers.DeleteCustomerRequest;
import com.etiya.northwind.business.requests.customers.UpdateCustomerRequest;
import com.etiya.northwind.business.responses.customers.GetCustomerResponse;
import com.etiya.northwind.business.responses.customers.ListCustomerResponse;

import java.util.List;

public interface CustomerService {

    void add(CreateCustomerRequest createCustomerRequest);

    void delete(DeleteCustomerRequest deleteCustomerRequest);

    void update(UpdateCustomerRequest updateCustomerRequest);

    GetCustomerResponse getByCompanyName(String companyName);
    List<ListCustomerResponse> getAll();
}
