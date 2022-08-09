package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.ProductService;
import com.etiya.northwind.business.requests.products.CreateProductRequest;
import com.etiya.northwind.business.requests.products.DeleteProductRequest;
import com.etiya.northwind.business.requests.products.UpdateProductRequest;
import com.etiya.northwind.business.responses.products.GetProductResponse;
import com.etiya.northwind.business.responses.products.ListProductResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.dataAccess.abstracts.ProductRepository;
import com.etiya.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductManager implements ProductService {

    private ProductRepository productRepository;
    private ModelMapperService modelMapperService;

    @Autowired //git bunların somutunu bul enjekte et
    public ProductManager(ProductRepository productRepository, ModelMapperService modelMapperService) {
        this.productRepository = productRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public void add(CreateProductRequest createProductRequest) {
        Product product = this.modelMapperService.forRequest().map(createProductRequest, Product.class);
        this.productRepository.save(product);
    }

    @Override
    public void delete(DeleteProductRequest deleteProductRequest) {
        Product product = this.modelMapperService.forRequest().map(deleteProductRequest, Product.class);
        this.productRepository.delete(product);
    }

    @Override
    public void update(UpdateProductRequest updateProductRequest) {
        Product product = this.modelMapperService.forRequest().map(updateProductRequest, Product.class);
        this.productRepository.save(product);
    }

    @Override
    public GetProductResponse getById(int id) {
        Product product = this.productRepository.findById(id);
        GetProductResponse response = this.modelMapperService.forResponse().map(product, GetProductResponse.class);
        return response;
    }


    @Override
    public List<ListProductResponse> getAll() {
        List<Product> result = this.productRepository.findAll();
        List<ListProductResponse> response = result.stream().map(product -> this.modelMapperService.forResponse()
                .map(product, ListProductResponse.class)).collect(Collectors.toList()); //array bazlı yapıyı dolaşmak için kullnılır,map ne yapayım, ilki stream mapi her biri için bunu yap

        return response;
    }

    @Override
    public List<ListProductResponse> getAll(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);  // pageNo  0dan başlamaz

        List<Product> products = this.productRepository.findAll(pageable).getContent();
        List<ListProductResponse> response = products.stream().map(product -> this.modelMapperService.forResponse()
                .map(product, ListProductResponse.class)).collect(Collectors.toList());

        for (ListProductResponse listProductResponse : response) {
            listProductResponse.setPageNo(pageNo);
            listProductResponse.setPageSize(pageSize);
            listProductResponse.setTotalData(this.productRepository.findAll().size());
            listProductResponse.setTotalPage((this.productRepository.findAll().size() / pageSize)+1);

        }


        return response;
    }

    @Override
    public List<ListProductResponse> getAllSorted(int type, String data) {
        Sort sort;
        if (type == 0) {
            sort = Sort.by(Sort.Direction.ASC, data);
        } else {
            sort = Sort.by(Sort.Direction.DESC, data);
        }
        List<Product> products = this.productRepository.findAll(sort);
        List<ListProductResponse> response = products.stream().map(product -> this.modelMapperService.forResponse()
                .map(product, ListProductResponse.class)).collect(Collectors.toList());

    return response;

    }

}
