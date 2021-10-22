package com.farinas.market.persistence.crud;

import com.farinas.market.persistence.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductEntityCrudRepository extends CrudRepository<ProductEntity, Integer> {

    List<ProductEntity> findByCategoryIdOrderByNameAsc(int categoryId);

}