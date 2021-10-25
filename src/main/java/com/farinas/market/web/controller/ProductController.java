package com.farinas.market.web.controller;

import com.farinas.market.domain.dto.Message;
import com.farinas.market.domain.dto.Product;
import com.farinas.market.domain.service.ProductService;
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
@Api(tags = { "Products" })
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    private final static Logger logger = LoggerFactory.getLogger(ProductController.class);

    @GetMapping()
    @ApiOperation("Get all products")
    @ApiResponse(code = 200, message = "Ok")
    public ResponseEntity<List<Product>> getAll() {
        logger.info("Products: Get all");
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

    @ApiOperation("Get product by Id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 404, message = "Product not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@ApiParam(value = "The product id", required = true, example = "1") @PathVariable("id") int id) {
        logger.info("Products: Get products by id: " + id);
        return productService.getProduct(id)
                .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<Product>> getByCategory(@PathVariable("id") int categoryId) {
        logger.info("Products: Get products by category id: " + categoryId);
        return productService.getByCategory(categoryId)
                .map(products -> new ResponseEntity<>(products, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public ResponseEntity<?> saveProduct(@Valid  @RequestBody Product product, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            logger.error("Product: (Post) incorrect fields.");
            return new ResponseEntity<>(new Message("Incorrect fields"), HttpStatus.BAD_REQUEST);
        }
        logger.info("Product: (Post) " + product.getName() + " created.");
        return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@Valid @RequestBody Product product, @PathVariable("id") int id, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            logger.error("Product: (PUT) incorrect fields.");
            return new ResponseEntity<>(new Message("Incorrect fields"), HttpStatus.BAD_REQUEST);
        }

        product.setProductId(id);
        return productService.getProduct(product.getProductId()).map(prod -> {
            Product response = productService.updateProduct(product);
            logger.info("Product: (PUT) " + product.getName() + " updated.");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") int id) {
        if(productService.deleteProduct(id)) {
            return new ResponseEntity<>(new Message("Product deleted successfully"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new Message("Product not found"),HttpStatus.NOT_FOUND);
        }
    }
}