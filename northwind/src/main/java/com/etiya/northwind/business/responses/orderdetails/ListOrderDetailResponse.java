package com.etiya.northwind.business.responses.orderdetails;

import com.etiya.northwind.entities.concretes.Order;
import com.etiya.northwind.entities.concretes.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListOrderDetailResponse {

    private double unitPrice;

    private int quantity;

    private double discount;

    private int orderId;

    private int productId;

}
