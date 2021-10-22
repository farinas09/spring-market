package com.farinas.market.repository;

import com.farinas.market.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

    //Convención sobre convicción
    //CrudRepository permite realizar busquedas por campo según la entidad
    Optional<ProductEntity> findByCategoryIdOrderByNameAsc(int categoryId);

}