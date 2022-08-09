package com.etiya.northwind.business.requests.orderDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderDetailRequest {
    private double unitPrice;

    private int quantity;

    private double discount;

    private String contactName;

    private int orderId;

    private int productId;
}
