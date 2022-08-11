package com.etiya.northwind.api.controllers;

import com.etiya.northwind.business.abstracts.ProductService;
import com.etiya.northwind.business.requests.products.CreateProductRequest;
import com.etiya.northwind.business.requests.products.DeleteProductRequest;
import com.etiya.northwind.business.requests.products.UpdateProductRequest;
import com.etiya.northwind.business.responses.products.GetProductResponse;
import com.etiya.northwind.business.responses.products.ListProductResponse;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public Result add(@RequestBody @Valid CreateProductRequest createProductRequest) {
        return this.productService.add(createProductRequest);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody DeleteProductRequest deleteProductRequest) {
        return this.productService.delete(deleteProductRequest);
    }


    @PostMapping("/update")
    public Result update(@RequestBody UpdateProductRequest updateProductRequest) {
        return this.productService.update(updateProductRequest);
    }

    @GetMapping("/getbyid")
    public DataResult<GetProductResponse >getById(@RequestParam int id) {
        return this.productService.getById(id);
    }

    @GetMapping("/getall")
    public DataResult<List<ListProductResponse>>getAll() {
        return this.productService.getAll();
    }

    @GetMapping("/getallbypage")
    public DataResult<List<ListProductResponse>> getAllByPage(int pageNo,int pageSize) {
        return this.productService.getAll(pageNo,pageSize);
    }

    @GetMapping("getallasc")
    public DataResult<List<ListProductResponse>> getAllSorted(int type, String data) {
        return this.productService.getAllSorted(type, data);
    }
}
