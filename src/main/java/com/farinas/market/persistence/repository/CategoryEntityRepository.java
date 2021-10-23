package com.farinas.market.persistence.repository;

import com.farinas.market.domain.dto.Category;
import com.farinas.market.domain.repository.CategoryRepository;
import com.farinas.market.persistence.crud.CategoryEntityCrudRepository;
import com.farinas.market.persistence.entity.CategoryEntity;
import com.farinas.market.persistence.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class CategoryEntityRepository implements CategoryRepository {
    @Autowired
    private CategoryEntityCrudRepository categoryEntityCrudRepository;
    @Autowired
    private CategoryMapper mapper;

    @Override
    public List<Category> getAll() {
        List<CategoryEntity> categoriesEntities =  (List<CategoryEntity>) categoryEntityCrudRepository.findAll();
        return mapper.toCategories(categoriesEntities);
    }

    @Override
    public Optional<Category> getCategory(int id) {
        return categoryEntityCrudRepository.findById(id).map(category -> mapper.toCategory(category));
    }

    @Override
    public Category saveCategory(Category category) {
        return mapper.toCategory(categoryEntityCrudRepository.save(mapper.toCategoryEntity(category)));
    }

    @Override
    public Category updateCategory(Category category) {
        CategoryEntity response = categoryEntityCrudRepository.findById(category.getCategoryId()).map(categoryEntity -> {
                    categoryEntity.setDescription(category.getDescription());
                    categoryEntity.setModifiedAt(LocalDateTime.now());
                    return categoryEntityCrudRepository.save(categoryEntity);
                }).get();
            return mapper.toCategory(response);
    }

    @Override
    public void deleteCategory(int id) {
        categoryEntityCrudRepository.findById(id).map(category -> {
            category.setStatus(false);
            return categoryEntityCrudRepository.save(category);
        });
        //categoryEntityCrudRepository.deleteById(id);
    }
}
