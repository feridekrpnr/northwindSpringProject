package com.etiya.northwind.business.abstracts;

import com.etiya.northwind.business.responses.customers.ListCustomerResponse;

import java.util.List;

public interface CustomerService {

    List<ListCustomerResponse> getAll();
}
