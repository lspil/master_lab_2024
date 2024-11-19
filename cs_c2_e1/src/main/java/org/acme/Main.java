package org.acme;

import org.acme.config.ProjectConfig;
import org.acme.controllers.ProductController;
import org.acme.model.http.dto.HttpProduct;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var controller = context.getBean(ProductController.class);

        controller.createProduct(new HttpProduct(1L, "Product 1"));
    }
}