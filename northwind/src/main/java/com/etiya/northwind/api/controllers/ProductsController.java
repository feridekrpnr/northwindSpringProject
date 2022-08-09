package com.etiya.northwind.api.controllers;

import com.etiya.northwind.business.abstracts.ProductService;
import com.etiya.northwind.business.requests.products.CreateProductRequest;
import com.etiya.northwind.business.requests.products.DeleteProductRequest;
import com.etiya.northwind.business.requests.products.UpdateProductRequest;
import com.etiya.northwind.business.responses.products.GetProductResponse;
import com.etiya.northwind.business.responses.products.ListProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //restful controller http protokolünü kullanarak farklı uygulamaların sistemimize erişimini saglar
@RequestMapping("api/products")
public class ProductsController {

    private ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/add")
    public void add(@RequestBody CreateProductRequest createProductRequest) {
        this.productService.add(createProductRequest);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody DeleteProductRequest deleteProductRequest) {
        this.productService.delete(deleteProductRequest);
    }


    @PostMapping("/update")
    public void update(@RequestBody UpdateProductRequest updateProductRequest) {
        this.productService.update(updateProductRequest);
    }

    @GetMapping("/getById")
    public GetProductResponse getById(@RequestParam int id) {
        return this.productService.getById(id);
    }

    @GetMapping("/getAll")
    public List<ListProductResponse> getAll() {
        return this.productService.getAll();
    }

    @GetMapping("/getAllByPage")
    public List<ListProductResponse> getAllByPage(int pageNo,int pageSize) {
        return this.productService.getAll(pageNo,pageSize);
    }

    @GetMapping("getAllAsc")
    public List<ListProductResponse> getAllSorted(int type, String data) {
        return this.productService.getAllSorted(type, data);
    }
}
