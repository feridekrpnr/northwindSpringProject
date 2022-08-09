package com.etiya.northwind.business.responses.orders;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetOrderResponse {
    private int orderId;

    private Date orderDate;

    private String shipName;

    private String fullName;
}
