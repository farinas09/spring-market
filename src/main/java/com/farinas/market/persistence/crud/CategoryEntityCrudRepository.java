package com.farinas.market.persistence.crud;

import com.farinas.market.persistence.entity.CategoryEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryEntityCrudRepository extends CrudRepository<CategoryEntity, Integer> {

}
