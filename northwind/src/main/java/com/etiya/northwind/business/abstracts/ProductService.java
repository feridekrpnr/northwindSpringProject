package com.etiya.northwind.business.abstracts;

import com.etiya.northwind.business.requests.products.CreateProductRequest;
import com.etiya.northwind.business.requests.products.DeleteProductRequest;
import com.etiya.northwind.business.requests.products.UpdateProductRequest;
import com.etiya.northwind.business.responses.products.GetProductResponse;
import com.etiya.northwind.business.responses.products.ListProductResponse;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;

import java.util.List;

public interface ProductService {

    Result add(CreateProductRequest createProductRequest);
    Result delete(DeleteProductRequest deleteProductRequest);
    Result update(UpdateProductRequest updateProductRequest);
    DataResult< GetProductResponse> getById(int id);
    DataResult<List<ListProductResponse>> getAll();
    DataResult<List<ListProductResponse>>getAll(int pageNo,int pageSize);
    DataResult<List<ListProductResponse>> getAllSorted(int type, String data);

}
