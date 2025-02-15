package com.yashcore.ecommerce.controller;

import com.yashcore.ecommerce.model.Product;
import com.yashcore.ecommerce.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
@CrossOrigin(origins = "http://localhost:5174")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/category/{categoryId}")
    public List<Product> getProductByCategory(@PathVariable Long categoryId) {
        return productService.getProductByCategory(categoryId);
    }
}
