package com.etiya.northwind.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailId implements Serializable {

    private static final long serialVERSIONUID= 1L;

    private int orderId;
    private int productId;


}
