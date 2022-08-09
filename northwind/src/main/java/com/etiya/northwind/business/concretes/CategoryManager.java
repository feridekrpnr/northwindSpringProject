package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.CategoryService;
import com.etiya.northwind.business.requests.categories.CreateCategoryRequest;
import com.etiya.northwind.business.requests.categories.DeleteCategoryRequest;
import com.etiya.northwind.business.requests.categories.UpdateCategoryRequest;
import com.etiya.northwind.business.responses.categories.GetCategoryResponse;
import com.etiya.northwind.business.responses.categories.ListCategoryResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.dataAccess.abstracts.CategoryRepository;
import com.etiya.northwind.entities.concretes.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryManager implements CategoryService {

    private CategoryRepository categoryRepository;
    private ModelMapperService modelMapperService;
    @Autowired
    public CategoryManager(CategoryRepository categoryRepository,ModelMapperService modelMapperService ){
        this.categoryRepository = categoryRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public void add(CreateCategoryRequest createCategoryRequest) {
        Category category  = this.modelMapperService.forRequest().map(createCategoryRequest,Category.class);
        this.categoryRepository.save(category);
    }

    @Override
    public void delete(DeleteCategoryRequest deleteCategoryRequest) {
         Category category = this.modelMapperService.forRequest().map(deleteCategoryRequest,Category.class);
         this.categoryRepository.delete(category);
    }

    @Override
    public void update(UpdateCategoryRequest updateCategoryRequest) {
        Category category  = this.modelMapperService.forRequest().map(updateCategoryRequest,Category.class);
        this.categoryRepository.save(category);
    }

    @Override
    public GetCategoryResponse getById(int id) {
         Category category = this.categoryRepository.findById(id);
         GetCategoryResponse response = this.modelMapperService.forResponse().map(category,GetCategoryResponse.class);
         return response;
    }

    @Override
    public List<ListCategoryResponse> getAll() {
        List<Category> result = this.categoryRepository.findAll();
        List<ListCategoryResponse> response = result.stream().map(category -> this.modelMapperService.forResponse()
                .map(category,ListCategoryResponse.class)).collect(Collectors.toList());
        return response;
    }
}
