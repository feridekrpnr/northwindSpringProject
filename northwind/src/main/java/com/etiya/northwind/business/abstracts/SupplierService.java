package com.etiya.northwind.business.abstracts;

import com.etiya.northwind.business.requests.suppliers.CreateSupplierRequest;
import com.etiya.northwind.business.requests.suppliers.DeleteSupplierRequest;
import com.etiya.northwind.business.requests.suppliers.UpdateSupplierRequest;
import com.etiya.northwind.business.responses.suppliers.GetSupplierResponse;
import com.etiya.northwind.business.responses.suppliers.ListSupplierResponse;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;

import java.util.List;

public interface SupplierService {

    Result add(CreateSupplierRequest createSupplierRequest);

    Result delete(DeleteSupplierRequest deleteSupplierRequest);

    Result update(UpdateSupplierRequest updateSupplierRequest);

    DataResult<GetSupplierResponse> getById(int id);
    DataResult<List<ListSupplierResponse>> getAll();
}
