package org.acme.cs_c6_e1.repositories;

import org.acme.cs_c6_e1.model.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(propagation = Propagation.MANDATORY)
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Query(value = """
        SELECT i FROM Invoice i WHERE i.number = :number
    """)
    Optional<Invoice> findInvoiceByNumber(String number);

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    Invoice save(Invoice entity);
}
