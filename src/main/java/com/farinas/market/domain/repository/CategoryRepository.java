package com.farinas.market.domain.repository;

import com.farinas.market.domain.dto.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {
    List<Category> getAll();
    Optional<Category> getCategory(int id);
    Category saveCategory(Category product);
    void deleteCategory(int id);
}
