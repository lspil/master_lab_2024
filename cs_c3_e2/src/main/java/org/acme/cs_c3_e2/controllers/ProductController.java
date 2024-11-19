package org.acme.cs_c3_e2.controllers;

import org.acme.cs_c3_e2.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @GetMapping("/products")
    public List<Product> getProducts() {
        return List.of(
                new Product("1", "Product 1"),
                new Product("2", "Product 2"),
                new Product("3", "Product 3")
        );
    }
}
