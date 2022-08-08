package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.SupplierService;
import com.etiya.northwind.business.responses.suppliers.ListSupplierResponse;
import com.etiya.northwind.dataAccess.abstracts.SupplierRepository;
import com.etiya.northwind.entities.concretes.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class SupplierManager implements SupplierService {


    private SupplierRepository supplierRepository;
    @Autowired
    public SupplierManager(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public List<ListSupplierResponse> getAll() {
        List<Supplier> result = this.supplierRepository.findAll();
        List<ListSupplierResponse> response = new ArrayList<ListSupplierResponse>();
        for(Supplier suplier: result){
            ListSupplierResponse listSupplierResponse = new ListSupplierResponse();
            listSupplierResponse.setSupplierId(suplier.getSupplierId());
            listSupplierResponse.setCompanyName(suplier.getCompanyName());
            listSupplierResponse.setAddress(suplier.getAddress());
            listSupplierResponse.setCity(suplier.getCity());
            response.add(listSupplierResponse);
            }
        return response;
        }
}

