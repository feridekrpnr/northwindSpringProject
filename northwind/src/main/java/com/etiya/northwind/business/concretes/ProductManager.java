package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.ProductService;
import com.etiya.northwind.business.responses.products.ListProductResponse;
import com.etiya.northwind.dataAccess.abstracts.ProductRepository;
import com.etiya.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductManager implements ProductService {

    private ProductRepository productRepository;

    @Autowired //git bunların somutunu bul enjekte et
    public ProductManager(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ListProductResponse> getAll() {
        List<Product> result = this.productRepository.findAll();
        List <ListProductResponse>response = new ArrayList<ListProductResponse>();
        for (Product product : result) {
            ListProductResponse responseProduct = new ListProductResponse();
            responseProduct.setCategoryId(product.getCategory().getCategoryId());
            responseProduct.setCategoryName(product.getCategory().getCategoryName());
            responseProduct.setProductId(product.getProductId());
            responseProduct.setProductName(product.getProductName());
            responseProduct.setUnitPrice(product.getUnitPrice());
            responseProduct.setUnitsInStock(product.getUnitsInStock());
            response.add(responseProduct);
        }
        return response;
    }
}
