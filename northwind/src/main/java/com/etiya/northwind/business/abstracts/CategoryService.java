package com.etiya.northwind.business.abstracts;

import com.etiya.northwind.business.requests.categories.CreateCategoryRequest;
import com.etiya.northwind.business.requests.categories.DeleteCategoryRequest;
import com.etiya.northwind.business.requests.categories.UpdateCategoryRequest;
import com.etiya.northwind.business.responses.categories.GetCategoryResponse;
import com.etiya.northwind.business.responses.categories.ListCategoryResponse;
import com.etiya.northwind.entities.concretes.Category;

import java.util.List;

public interface CategoryService {

    void add(CreateCategoryRequest createCategoryRequest);

    void delete(DeleteCategoryRequest deleteCategoryRequest);

    void update(UpdateCategoryRequest updateCategoryRequest);

    GetCategoryResponse getById(int id);
    List<ListCategoryResponse> getAll();


}
