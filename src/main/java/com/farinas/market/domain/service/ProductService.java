package com.farinas.market.domain.service;

import com.farinas.market.domain.dto.Category;
import com.farinas.market.domain.dto.Product;
import com.farinas.market.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.getAll();
    }

    public Optional<List<Product>> getByCategory(int categoryId) {
        return productRepository.getByCategory(categoryId);
    }

    public Optional<Product> getProduct(int id) {
        return productRepository.getProduct(id);
    }

    public Product saveProduct(Product product) {
        return productRepository.saveProduct(product);
    }

    public Product updateProduct(Product product) {
        return productRepository.updateProduct(product);
    }

    public boolean deleteProduct(int id) {
        return getProduct(id).map(product -> {
            productRepository.deleteProduct(id);
            return true;
        }).orElse(false);
    }
}

