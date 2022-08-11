package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.ProductService;
import com.etiya.northwind.business.requests.products.CreateProductRequest;
import com.etiya.northwind.business.requests.products.DeleteProductRequest;
import com.etiya.northwind.business.requests.products.UpdateProductRequest;
import com.etiya.northwind.business.responses.products.GetProductResponse;
import com.etiya.northwind.business.responses.products.ListProductResponse;
import com.etiya.northwind.core.exceptions.BusinessException;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;
import com.etiya.northwind.core.utilities.results.SuccessDataResult;
import com.etiya.northwind.core.utilities.results.SuccessResult;
import com.etiya.northwind.dataAccess.abstracts.ProductRepository;
import com.etiya.northwind.entities.concretes.Category;
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
    public Result add(CreateProductRequest createProductRequest) {
            checkIfProductNameExist(createProductRequest.getProductName());
            checkIfCategoryLimitExceeds(createProductRequest.getCategoryId());


            Product product = this.modelMapperService.forRequest().map(createProductRequest, Product.class);
            this.productRepository.save(product);
            return new SuccessResult("PRODUCT.ADDED");

    }

    @Override
    public Result delete(DeleteProductRequest deleteProductRequest) {
        Product product = this.modelMapperService.forRequest().map(deleteProductRequest, Product.class);
        this.productRepository.delete(product);
        return new SuccessResult("PRODUCT.DELETED");
    }

    @Override
    public Result update(UpdateProductRequest updateProductRequest) {
        Product product = this.modelMapperService.forRequest().map(updateProductRequest, Product.class);
        this.productRepository.save(product);
        return new SuccessResult("PRODUCT.UPDATED");
    }

    @Override
    public DataResult<GetProductResponse> getById(int id) {
        Product product = this.productRepository.findById(id);
        GetProductResponse response = this.modelMapperService.forResponse().map(product, GetProductResponse.class);
        return new SuccessDataResult<>(response);
    }


    @Override
    public DataResult<List<ListProductResponse>> getAll() {
        List<Product> result = this.productRepository.findAll();
        List<ListProductResponse> response = result.stream().map(product -> this.modelMapperService.forResponse()
                .map(product, ListProductResponse.class)).collect(Collectors.toList()); //array bazlı yapıyı dolaşmak için kullnılır,map ne yapayım, ilki stream mapi her biri için bunu yap

        return new SuccessDataResult<List<ListProductResponse>>(response);
    }

    @Override
    public DataResult <List<ListProductResponse>> getAll(int pageNo, int pageSize) {
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
        return new SuccessDataResult<>(response);
    }

    @Override
    public DataResult<List<ListProductResponse>> getAllSorted(int type, String data) {
        Sort sort;
        if (type == 0) {
            sort = Sort.by(Sort.Direction.ASC, data);
        } else {
            sort = Sort.by(Sort.Direction.DESC, data);
        }
        List<Product> products = this.productRepository.findAll(sort);
        List<ListProductResponse> response = products.stream().map(product -> this.modelMapperService.forResponse()
                .map(product, ListProductResponse.class)).collect(Collectors.toList());

    return new SuccessDataResult<>(response);

    }
    private void checkIfCategoryLimitExceeds(int categoryId) {
        List <Product> products = this.productRepository.findByCategoryCategoryId(categoryId);
        if(products.size()>=15) {
            throw new BusinessException("Category limit exceedded");
        }
    }

    private void checkIfProductNameExist(String productName) {
        Product tempProduct = productRepository.findByProductName(productName);
        if(tempProduct!=null)
            throw new BusinessException("Product already exists");
    }


}
