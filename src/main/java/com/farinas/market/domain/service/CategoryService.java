package com.farinas.market.domain.service;

import com.farinas.market.domain.dto.Category;
import com.farinas.market.domain.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll() {
        return categoryRepository.getAll();
    }

    public Optional<Category> getCategory(int id) {
        return categoryRepository.getCategory(id);
    }

    public Category saveCategory(Category category) {
        return categoryRepository.saveCategory(category);
    }

    public Category updateCategory(Category category) {
        return categoryRepository.updateCategory(category);
    }

    public boolean deleteCategory(int id) {
        return getCategory(id).map(category -> {
            categoryRepository.deleteCategory(id);
            return true;
        }).orElse(false);
    }
}
