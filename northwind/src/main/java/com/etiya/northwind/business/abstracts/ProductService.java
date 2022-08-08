package com.etiya.northwind.business.abstracts;

import com.etiya.northwind.business.responses.products.ListProductResponse;

import java.util.List;

public interface ProductService {
    List<ListProductResponse> getAll();
}
