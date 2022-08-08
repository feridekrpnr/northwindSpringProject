package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.CustomerService;
import com.etiya.northwind.business.responses.customers.ListCustomerResponse;
import com.etiya.northwind.dataAccess.abstracts.CustomerRepository;
import com.etiya.northwind.entities.concretes.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
@Service
public class CustomerManager implements CustomerService {

    CustomerRepository customerRepository;
    @Autowired
    public CustomerManager(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<ListCustomerResponse> getAll() {
        List<Customer> result = this.customerRepository.findAll();
        List<ListCustomerResponse> response = new ArrayList<ListCustomerResponse>();
        for (Customer customer : result) {
            ListCustomerResponse customerListResponse = new ListCustomerResponse();
            customerListResponse.setCustomerId(customer.getCustomerId());
            customerListResponse.setCompanyName(customer.getCompanyName());
            customerListResponse.setContactName(customer.getContactName());
            customerListResponse.setCity(customer.getCity());
            response.add(customerListResponse);
        }
        return response;


    }
}
