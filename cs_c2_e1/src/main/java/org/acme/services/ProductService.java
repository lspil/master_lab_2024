package org.acme.services;

import org.acme.aspects.Observe;
import org.acme.controllers.mapper.ProductMapper;
import org.acme.model.http.dto.HttpProduct;
import org.acme.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Observe
    public void createProduct(final HttpProduct product) {
        final var jpaEntityProduct = ProductMapper.toJPAEntityProduct(product);
        productRepository.createProduct(jpaEntityProduct);
    }

    public List<HttpProduct> searchProducts() {
        return null;
    }
}
