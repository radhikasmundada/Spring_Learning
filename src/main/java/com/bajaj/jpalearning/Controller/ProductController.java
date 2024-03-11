package com.bajaj.jpalearning.Controller;

import com.bajaj.jpalearning.Services.CustomerService;
import com.bajaj.jpalearning.Services.ProductService;
import com.bajaj.jpalearning.beans.ResponseHandler;
import com.bajaj.jpalearning.entities.Customer;
import com.bajaj.jpalearning.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public ResponseEntity<Object> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseHandler.createResponse("", HttpStatus.OK, products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        return ResponseHandler.createResponse("Product found", HttpStatus.OK,  product);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createProduct(@RequestBody Product product) {
        Object createdProduct = productService.createProduct(product);
        return ResponseHandler.createResponse("New Product is created", HttpStatus.CREATED, createdProduct);
    }

}
