package com.etiya.northwind.business.responses.orderDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetOrderDetailResponse {
    private double unitPrice;

    private int quantity;

    private double discount;

    private String contactName;

    private int orderId;

    private int productId;
}
