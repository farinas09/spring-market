package com.farinas.market.service;

import com.farinas.market.entity.Category;
import com.farinas.market.entity.Product;
import com.farinas.market.repository.CategoryRepository;
import com.farinas.market.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    public Category getCategory(int id) {
        return categoryRepository.getById(id);
    }

    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    public boolean deleteCategory(int id) {
        Category category = getCategory(id);
        if( category != null ) {
            categoryRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}