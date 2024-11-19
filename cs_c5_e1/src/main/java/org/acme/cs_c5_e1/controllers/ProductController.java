package org.acme.cs_c5_e1.controllers;

import lombok.AllArgsConstructor;
import org.acme.cs_c5_e1.model.Product;
import org.acme.cs_c5_e1.services.ProductService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/")
    @PreAuthorize("isAuthenticated()")
    public void createProduct(@RequestBody final Product product) {
        productService.createProduct(product);
    }

}
