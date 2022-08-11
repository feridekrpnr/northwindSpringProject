package com.etiya.northwind.api.controllers;

import com.etiya.northwind.business.abstracts.SupplierService;
import com.etiya.northwind.business.requests.suppliers.CreateSupplierRequest;
import com.etiya.northwind.business.requests.suppliers.DeleteSupplierRequest;
import com.etiya.northwind.business.requests.suppliers.UpdateSupplierRequest;
import com.etiya.northwind.business.responses.suppliers.GetSupplierResponse;
import com.etiya.northwind.business.responses.suppliers.ListSupplierResponse;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
public class SuppliersController {

    private SupplierService supplierService;

    @Autowired
    public SuppliersController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }


    @PostMapping("/add")
    public Result add(@RequestBody CreateSupplierRequest createSupplierRequest) {
        return this.supplierService.add(createSupplierRequest);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody DeleteSupplierRequest deleteSupplierRequest) {
        return this.supplierService.delete(deleteSupplierRequest);
    }


    @PostMapping("/update")
    public Result update(@RequestBody UpdateSupplierRequest updateSupplierRequest) {
        return this.supplierService.update(updateSupplierRequest);
    }

    @GetMapping("/getById")
    public DataResult<GetSupplierResponse >getById(@RequestParam int id) {
        return this.supplierService.getById(id);
    }
    @GetMapping("/getAll")
    public DataResult<List<ListSupplierResponse>> getAll() {
        return this.supplierService.getAll();

    }
}
