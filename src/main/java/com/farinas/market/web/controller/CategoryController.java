package com.farinas.market.web.controller;

import com.farinas.market.domain.dto.Category;
import com.farinas.market.domain.dto.Message;
import com.farinas.market.domain.dto.Product;
import com.farinas.market.domain.repository.CategoryRepository;
import com.farinas.market.domain.service.CategoryService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping()
    @ApiOperation("Get all categories")
    @ApiResponse(code = 200, message = "Ok")
    public ResponseEntity<List<Category>> getAll() {
        return new ResponseEntity<>(categoryService.getAll(), HttpStatus.OK);
    }

    @ApiOperation("Get category by Id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 404, message = "Category not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategory(@ApiParam(value = "The category id", required = true, example = "1") @PathVariable("id") int id) {
        return categoryService.getCategory(id)
                .map(category -> new ResponseEntity<>(category, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public ResponseEntity<Category> saveCategory(@RequestBody Category category) {
        Category cat = categoryService.saveCategory(category);
        cat = categoryService.getCategory(cat.getCategoryId()).get();
        return new ResponseEntity<>(cat, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable("id") int id) {
        if(categoryService.deleteCategory(id)) {
            return new ResponseEntity<>(new Message("Deleted Successfully"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new Message("Category not found"), HttpStatus.NOT_FOUND);
        }
    }
}
