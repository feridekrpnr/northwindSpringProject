package com.etiya.northwind.dataAccess.abstracts;

import com.etiya.northwind.entities.concretes.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {
    Order findById(int id);
}
