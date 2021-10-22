package com.farinas.market.service;

import com.farinas.market.entity.Product;
import com.farinas.market.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Optional<List<Product>> getByCategory(int categoryId) {
        return productRepository.findByCategoryIdOrderByNameAsc(categoryId);
    }

    public Product getProduct(int id) {
        return productRepository.getById(id);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public boolean deleteProduct(int id) {
        Product product = getProduct(id);
        if( product != null ) {
            productRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
