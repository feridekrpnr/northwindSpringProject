package com.etiya.northwind.business.responses.suppliers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetSupplierResponse {
    private int supplierId;

    private String companyName;

    private String address;

    private String city;
}
