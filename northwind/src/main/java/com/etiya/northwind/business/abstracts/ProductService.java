package com.etiya.northwind.business.abstracts;

import com.etiya.northwind.business.requests.products.CreateProductRequest;
import com.etiya.northwind.business.requests.products.DeleteProductRequest;
import com.etiya.northwind.business.requests.products.UpdateProductRequest;
import com.etiya.northwind.business.responses.products.GetProductResponse;
import com.etiya.northwind.business.responses.products.ListProductResponse;

import java.util.List;

public interface ProductService {

    void add(CreateProductRequest createProductRequest);
    void delete(DeleteProductRequest deleteProductRequest);
    void update(UpdateProductRequest updateProductRequest);
    GetProductResponse getById(int id);
    List<ListProductResponse> getAll();
    List<ListProductResponse> getAll(int pageNo,int pageSize);
    List<ListProductResponse> getAllSorted(int type, String data);

}
