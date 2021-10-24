package com.farinas.market.domain.repository;

import com.farinas.market.domain.dto.Category;
import com.farinas.market.domain.dto.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> getAll();
    Optional<List<Product>> getByCategory(int categoryId);
    Optional<Product> getProduct(int id);
    Product saveProduct(Product product);
    Product updateProduct(Product product);
    void deleteProduct(int id);
}