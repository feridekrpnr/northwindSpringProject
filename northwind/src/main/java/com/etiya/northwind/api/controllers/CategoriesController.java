package com.etiya.northwind.api.controllers;

import com.etiya.northwind.business.abstracts.CategoryService;
import com.etiya.northwind.business.requests.categories.CreateCategoryRequest;
import com.etiya.northwind.business.requests.categories.DeleteCategoryRequest;
import com.etiya.northwind.business.requests.categories.UpdateCategoryRequest;
import com.etiya.northwind.business.responses.categories.GetCategoryResponse;
import com.etiya.northwind.business.responses.categories.ListCategoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {


    private CategoryService categoryService;
    @Autowired
    public CategoriesController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/add")
    public void add(@RequestBody CreateCategoryRequest createCategoryRequest) {
        this.categoryService.add(createCategoryRequest);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody DeleteCategoryRequest deleteCategoryRequest) {
        this.categoryService.delete(deleteCategoryRequest);
    }

    @PostMapping("/update")
    public void update(@RequestBody UpdateCategoryRequest updateCategoryRequest) {
        this.categoryService.update(updateCategoryRequest);
    }

    @GetMapping("/getById")
    public GetCategoryResponse getById(@RequestParam int id) {
        return this.categoryService.getById(id);
    }

    @GetMapping("/getAll")
    public List<ListCategoryResponse> getAll() {
        return this.categoryService.getAll();

    }
}
