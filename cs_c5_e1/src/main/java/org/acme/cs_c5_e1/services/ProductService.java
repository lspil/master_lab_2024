package org.acme.cs_c5_e1.services;

import lombok.AllArgsConstructor;
import org.acme.cs_c5_e1.model.Product;
import org.acme.cs_c5_e1.repositories.ProductRepository;
import org.acme.cs_c5_e1.services.exceptions.AlreadyExistingProductException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public Optional<Product> findProductById(final String id) {
        return productRepository.findById(id);
    }

    public List<Product> findProductsByName(final String name) {
        return productRepository.findProductByName(name);
    }

    public void createProduct(final Product product) {
        final var p = productRepository.findById(product.id());

        if (p.isPresent()) {
            throw new AlreadyExistingProductException();
        } else {
            productRepository.save(product);
        }
    }
}
