package com.etiya.northwind.api.controllers;

import com.etiya.northwind.business.abstracts.CategoryService;
import com.etiya.northwind.business.requests.categories.CreateCategoryRequest;
import com.etiya.northwind.business.requests.categories.DeleteCategoryRequest;
import com.etiya.northwind.business.requests.categories.UpdateCategoryRequest;
import com.etiya.northwind.business.responses.categories.GetCategoryResponse;
import com.etiya.northwind.business.responses.categories.ListCategoryResponse;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;
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
    public Result add(@RequestBody CreateCategoryRequest createCategoryRequest) {
        return this.categoryService.add(createCategoryRequest);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody DeleteCategoryRequest deleteCategoryRequest) {
        return this.categoryService.delete(deleteCategoryRequest);
    }

    @PostMapping("/update")
    public Result update(@RequestBody UpdateCategoryRequest updateCategoryRequest) {
        return this.categoryService.update(updateCategoryRequest);
    }

    @GetMapping("/getbyid")
    public DataResult< GetCategoryResponse> getById(@RequestParam int id) {
        return this.categoryService.getById(id);
    }

    @GetMapping("/getall")
    public DataResult<List<ListCategoryResponse>> getAll() {
        return this.categoryService.getAll();

    }
}
