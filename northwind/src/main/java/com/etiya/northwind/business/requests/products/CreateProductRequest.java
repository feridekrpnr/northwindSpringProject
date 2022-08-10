package com.etiya.northwind.business.requests.products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductRequest {

    private int productId;
    @NotBlank
    @NotNull
    @Size(min=1,max=10)
    private String productName;
    @Positive
    private double unitPrice;
    @PositiveOrZero
    private int unitsInStock;
    @Positive
    private int categoryId;
    @Min(0)
    private int supplierId;
    @Positive
    private int discontinued;


}
