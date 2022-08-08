package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.CategoryService;
import com.etiya.northwind.business.responses.categories.ListCategoryResponse;
import com.etiya.northwind.dataAccess.abstracts.CategoryRepository;
import com.etiya.northwind.entities.concretes.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CategoryManager implements CategoryService {


    private CategoryRepository categoryRepository;
    @Autowired
    public CategoryManager(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<ListCategoryResponse> getAll() {
        List<Category> result = this.categoryRepository.findAll();
        List<ListCategoryResponse> response = new ArrayList<ListCategoryResponse>();
        for(Category category : result) {
            ListCategoryResponse categoryResponse = new ListCategoryResponse();
            categoryResponse.setCategoryId(category.getCategoryId());
            categoryResponse.setCategoryName(category.getCategoryName());
            response.add(categoryResponse);
        }
        return response;
    }
}
