package com.farinas.market.repository;

import com.farinas.market.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    //Convención sobre convicción
    //CrudRepository permite realizar busquedas por campo según la entidad
    Optional<List<Product>> findByCategoryIdOrderByNameAsc(int categoryId);

}