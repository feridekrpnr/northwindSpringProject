package com.etiya.northwind.business.abstracts;

import com.etiya.northwind.business.requests.customers.CreateCustomerRequest;
import com.etiya.northwind.business.requests.customers.DeleteCustomerRequest;
import com.etiya.northwind.business.requests.customers.UpdateCustomerRequest;
import com.etiya.northwind.business.responses.customers.GetCustomerResponse;
import com.etiya.northwind.business.responses.customers.ListCustomerResponse;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;

import java.util.List;

public interface CustomerService {

    Result add(CreateCustomerRequest createCustomerRequest);

    Result delete(DeleteCustomerRequest deleteCustomerRequest);

    Result update(UpdateCustomerRequest updateCustomerRequest);

    DataResult<GetCustomerResponse > getByCompanyName(String companyName);
    DataResult<List<ListCustomerResponse>> getAll();
}
