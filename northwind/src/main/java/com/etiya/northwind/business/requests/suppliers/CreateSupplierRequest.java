package com.etiya.northwind.business.requests.suppliers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateSupplierRequest {

    private int supplierId;
    @Size(min=1,max=10)
    private String companyName;

    private String address;

    private String city;
}
