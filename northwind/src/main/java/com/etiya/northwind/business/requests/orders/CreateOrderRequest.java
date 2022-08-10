package com.etiya.northwind.business.requests.orders;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderRequest {

    private int orderId;

    private Date orderDate;

    private String shipName;

    private int employeeId;

    private String customerId;


}
