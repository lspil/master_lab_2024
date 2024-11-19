package org.acme.repositories;

import org.acme.model.jpa.entities.JPAEntityProduct;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {

    public void createProduct(JPAEntityProduct product) {
        System.out.println("Creating product");
    }

    public List<JPAEntityProduct> searchProducts() {
        return List.of();
    }
}
