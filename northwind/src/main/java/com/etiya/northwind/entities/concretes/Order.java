package com.etiya.northwind.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "order_id")
    private int orderId;
    @Column(name="order_date")
    private Date orderDate;
    @Column(name = "ship_name")
    private String shipName;

    @ManyToOne
    @JoinColumn(name="employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name= "customer_id")
    private Customer customer;


    @OneToMany(mappedBy = "order" )
    private List<OrderDetail> orderDetails;



}
