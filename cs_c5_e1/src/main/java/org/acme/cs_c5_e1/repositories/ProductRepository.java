package org.acme.cs_c5_e1.repositories;


import org.acme.cs_c5_e1.model.Product;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, String> {

    @Query("""
        SELECT * FROM product WHERE name = :name
    """)
    List<Product> findProductByName(String name);
}