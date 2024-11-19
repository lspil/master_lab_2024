package org.acme.controllers.mapper;

import org.acme.model.http.dto.HttpProduct;
import org.acme.model.jpa.entities.JPAEntityProduct;

public class ProductMapper {

    public static JPAEntityProduct toJPAEntityProduct(HttpProduct product) {
        JPAEntityProduct jpaEntityProduct = new JPAEntityProduct();
        jpaEntityProduct.setId(product.id());
        jpaEntityProduct.setName(product.name());
        return jpaEntityProduct;
    }
}
