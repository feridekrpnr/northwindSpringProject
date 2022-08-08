package com.etiya.northwind.business.abstracts;

import com.etiya.northwind.business.responses.suppliers.ListSupplierResponse;

import java.util.List;

public interface SupplierService {
    List<ListSupplierResponse> getAll();
}
