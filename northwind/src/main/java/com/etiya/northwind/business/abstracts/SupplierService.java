package com.etiya.northwind.business.abstracts;

import com.etiya.northwind.business.requests.suppliers.CreateSupplierRequest;
import com.etiya.northwind.business.requests.suppliers.DeleteSupplierRequest;
import com.etiya.northwind.business.requests.suppliers.UpdateSupplierRequest;
import com.etiya.northwind.business.responses.suppliers.GetSupplierResponse;
import com.etiya.northwind.business.responses.suppliers.ListSupplierResponse;

import java.util.List;

public interface SupplierService {

    void add(CreateSupplierRequest createSupplierRequest);

    void delete(DeleteSupplierRequest deleteSupplierRequest);

    void update(UpdateSupplierRequest updateSupplierRequest);

    GetSupplierResponse getById(int id);
    List<ListSupplierResponse> getAll();
}
