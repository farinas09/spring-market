package com.farinas.market.persistence.repository;

import com.farinas.market.domain.dto.Product;
import com.farinas.market.domain.repository.ProductRepository;
import com.farinas.market.persistence.crud.ProductEntityCrudRepository;
import com.farinas.market.persistence.entity.ProductEntity;
import com.farinas.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductEntityRepository implements ProductRepository {
    @Autowired
    private ProductEntityCrudRepository productEntityCrudRepository;
    @Autowired
    private ProductMapper mapper;

    @Override
    public List<Product> getAll() {
        List<ProductEntity> productEntities =  (List<ProductEntity>) productEntityCrudRepository.findAll();
        return mapper.toProducts(productEntities);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<ProductEntity> productEntities = productEntityCrudRepository.findByCategoryIdOrderByNameAsc(categoryId);
        return Optional.of(mapper.toProducts(productEntities));
    }

    @Override
    public Optional<Product> getProduct(int id) {
        return productEntityCrudRepository.findById(id).map(prod -> mapper.toProduct(prod));
    }

    @Override
    public Product saveProduct(Product product) {
        return mapper.toProduct(productEntityCrudRepository.save(mapper.toProductEntity(product)));
    }

    @Override
    public void deleteProduct(int id) {
        productEntityCrudRepository.deleteById(id);
    }
}
