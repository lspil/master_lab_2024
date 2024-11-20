package org.acme.cs_c6_e1.repositories;

import org.acme.cs_c6_e1.model.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

    @Query(value = """
        SELECT i FROM Invoice i WHERE i.number = :number
    """)
    Optional<Invoice> findInvoiceByNumber(String number);
}