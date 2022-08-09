package com.etiya.northwind.api.controllers;

import com.etiya.northwind.business.abstracts.SupplierService;
import com.etiya.northwind.business.requests.suppliers.CreateSupplierRequest;
import com.etiya.northwind.business.requests.suppliers.DeleteSupplierRequest;
import com.etiya.northwind.business.requests.suppliers.UpdateSupplierRequest;
import com.etiya.northwind.business.responses.suppliers.GetSupplierResponse;
import com.etiya.northwind.business.responses.suppliers.ListSupplierResponse;
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
    public void add(@RequestBody CreateSupplierRequest createSupplierRequest) {
        this.supplierService.add(createSupplierRequest);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody DeleteSupplierRequest deleteSupplierRequest) {
        this.supplierService.delete(deleteSupplierRequest);
    }


    @PostMapping("/update")
    public void update(@RequestBody UpdateSupplierRequest updateSupplierRequest) {
        this.supplierService.update(updateSupplierRequest);
    }

    @GetMapping("/getById")
    public GetSupplierResponse getById(@RequestParam int id) {
        return this.supplierService.getById(id);
    }
    @GetMapping("/getAll")
    public List<ListSupplierResponse> getAll() {
        return this.supplierService.getAll();

    }
}
