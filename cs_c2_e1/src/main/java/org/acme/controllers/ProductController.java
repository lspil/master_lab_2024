package org.acme.controllers;

import org.acme.model.http.dto.HttpProduct;
import org.acme.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ProductController {

    private final ProductService productService;

//    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    public void createProduct(HttpProduct product) {
        productService.createProduct(product);
    }

    public List<HttpProduct> searchProducts() {
        return productService.searchProducts();
    }
}
