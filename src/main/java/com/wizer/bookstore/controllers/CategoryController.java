package com.wizer.bookstore.controllers;

import com.wizer.bookstore.Models.Category;
import com.wizer.bookstore.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping()
    public List<Category> index(){
        return this.categoryService.getAll();
    }

    @PostMapping()
    public Category create(@RequestBody Category category){
        return this.categoryService.save(category);
    }

    @GetMapping("/{id}")
    public Category getcategory(@PathVariable Long id){
        return this.categoryService.getCategoryById(id);
    }

    @PutMapping("/{id}")
    public Category updateCategory(@RequestBody Category category, @PathVariable Long id){
        Category category1 = this.categoryService.getCategoryById(id);
        if(category1 != null){
            category1.setDescription(category.getDescription());
            category1.setTitle(category.getTitle());
            this.categoryService.save(category1);
        }
        return category1;
    }

    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable Long id){
        Category category = this.categoryService.getCategoryById(id);
        if(category != null) return this.categoryService.deleteCategoryById(id);
        return "Category Could not be deleted";
    }
}
