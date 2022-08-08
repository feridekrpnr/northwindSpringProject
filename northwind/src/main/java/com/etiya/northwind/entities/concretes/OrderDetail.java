package com.etiya.northwind.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="order_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(OrderDetailId.class)
public class OrderDetail {

    @Column(name="unit_price")
    private double unitPrice;
    @Column(name="quantity")
    private int quantity;
    @Column(name="discount")
    private double discount;

    @Id
    @ManyToOne
    @JoinColumn(name="order_id")
    private Order order;

    @Id
    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;





}
