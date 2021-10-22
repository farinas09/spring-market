package com.farinas.market.persistence.mapper;

import com.farinas.market.domain.dto.Product;
import com.farinas.market.persistence.entity.ProductEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {
    @Mappings({
            @Mapping(source = "id", target = "productId"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "categoryId", target = "categoryId"),
            @Mapping(source = "cost", target = "cost"),
            @Mapping(source = "salePrice", target = "price"),
            @Mapping(source = "status", target = "active"),
            @Mapping(source = "categoryEntity", target = "category"),
            @Mapping(source = "createdAt", target = "createdAt"),
            @Mapping(source = "modifiedAt", target = "modifiedAt")
    }
    )
    Product toProduct(ProductEntity product);
    List<Product> toProducts(List<ProductEntity> products);

    @InheritInverseConfiguration
    @Mapping(target = "categoryEntity", ignore = true)
    ProductEntity toProductEntity(Product product);
}
