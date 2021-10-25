package com.farinas.market.web.controller;

import com.farinas.market.domain.dto.Category;
import com.farinas.market.domain.dto.Message;
import com.farinas.market.domain.service.CategoryService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Api(tags = { "Categories" })
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    private final static Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @GetMapping()
    @ApiOperation("Get all categories")
    @ApiResponse(code = 200, message = "Ok")
    public ResponseEntity<List<Category>> getAll() {
        logger.info("Categories: Get all");
        return new ResponseEntity<>(categoryService.getAll(), HttpStatus.OK);
    }

    @ApiOperation("Get category by Id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 404, message = "Category not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategory(@ApiParam(value = "The category id", required = true, example = "1") @PathVariable("id") int id) {
        logger.info("Categories: Get category by id: " + id);
        return categoryService.getCategory(id)
                .map(category -> new ResponseEntity<>(category, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public ResponseEntity<?> saveCategory(@Valid @RequestBody Category category, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            logger.error("Category: (Post) incorrect fields.");
            return new ResponseEntity<>(new Message("Incorrect fields"), HttpStatus.BAD_REQUEST);
        }

        Category cat = categoryService.saveCategory(category);
        cat = categoryService.getCategory(cat.getCategoryId()).get();
        logger.info("Category: (Post) " + cat.getDescription() + " created.");
        return new ResponseEntity<>(cat, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateCategory(@Valid @RequestBody Category category, @PathVariable("id") int id, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            logger.error("Category: (PUT) incorrect fields.");
            return new ResponseEntity<>(new Message("Incorrect fields"), HttpStatus.BAD_REQUEST);
        }

        category.setCategoryId(id);
         return categoryService.getCategory(category.getCategoryId()).map(cat -> {
            Category response = categoryService.updateCategory(category);
             logger.info("Category: (PUT) " + cat.getDescription() + " updated.");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable("id") int id) {
        if(categoryService.deleteCategory(id)) {
            logger.info("Category: (DELETE) Category id:" + id + " updated.");
            return new ResponseEntity<>(new Message("Deleted Successfully"), HttpStatus.OK);
        } else {
            logger.error("Category: (DELETE) Category id:" + id + " not found.");
            return new ResponseEntity<>(new Message("Category not found"), HttpStatus.NOT_FOUND);
        }
    }
}
