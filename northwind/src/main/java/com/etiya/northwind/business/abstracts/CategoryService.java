package com.etiya.northwind.business.abstracts;

import com.etiya.northwind.business.responses.categories.ListCategoryResponse;

import java.util.List;

public interface CategoryService {

    List<ListCategoryResponse> getAll();
}
