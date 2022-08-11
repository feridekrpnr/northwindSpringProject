package com.etiya.northwind.dataAccess.abstracts;

import com.etiya.northwind.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    Product findById(int id);
    Product findByProductName(String productName);

    List<Product>  findByCategoryCategoryId(int categoryId);
}