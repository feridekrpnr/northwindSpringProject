package com.etiya.northwind.business.abstracts;

import com.etiya.northwind.business.requests.categories.CreateCategoryRequest;
import com.etiya.northwind.business.requests.categories.DeleteCategoryRequest;
import com.etiya.northwind.business.requests.categories.UpdateCategoryRequest;
import com.etiya.northwind.business.responses.categories.GetCategoryResponse;
import com.etiya.northwind.business.responses.categories.ListCategoryResponse;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;
import com.etiya.northwind.entities.concretes.Category;

import java.util.List;

public interface CategoryService {

    Result add(CreateCategoryRequest createCategoryRequest);

    Result delete(DeleteCategoryRequest deleteCategoryRequest);

    Result update(UpdateCategoryRequest updateCategoryRequest);

    DataResult<GetCategoryResponse> getById(int id);
    DataResult<List<ListCategoryResponse>>getAll();


}
