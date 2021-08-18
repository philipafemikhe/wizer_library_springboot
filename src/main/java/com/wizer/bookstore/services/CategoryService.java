package com.wizer.bookstore.services;

import com.wizer.bookstore.Models.Category;
import com.wizer.bookstore.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll() {
        return this.categoryRepository.findAll();
    }

    public Category save(Category category) {
        return this.categoryRepository.save(category);
    }

    public Category getCategoryById(Long id) {
        return this.categoryRepository.findById(id).get();
    }

    public String deleteCategoryById(Long id) {
        try{
            this.categoryRepository.deleteById(id);
            return "Category Deleted";
        }catch(Exception err){
            return "Category Not Found";
        }
    }
}
