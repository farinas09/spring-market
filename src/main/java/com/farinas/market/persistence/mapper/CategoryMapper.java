package com.farinas.market.persistence.mapper;

import com.farinas.market.domain.dto.Category;
import com.farinas.market.domain.dto.Product;
import com.farinas.market.persistence.entity.CategoryEntity;
import com.farinas.market.persistence.entity.ProductEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
            @Mapping(source = "id", target = "categoryId"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "status", target = "active"),
            @Mapping(source = "createdAt", target = "createdAt"),
            @Mapping(source = "modifiedAt", target = "modifiedAt")
    }
    )
    Category toCategory(CategoryEntity category);
    List<Category> toCategories(List<CategoryEntity> categories);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "productEntities", ignore = true),
            @Mapping(target = "status", constant = "true")
    }
    )

    CategoryEntity toCategoryEntity(Category category);
}