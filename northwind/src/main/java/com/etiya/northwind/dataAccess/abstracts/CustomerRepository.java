package com.etiya.northwind.dataAccess.abstracts;

import com.etiya.northwind.entities.concretes.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,String> {
    Customer findByCompanyName(String companyName);
}
