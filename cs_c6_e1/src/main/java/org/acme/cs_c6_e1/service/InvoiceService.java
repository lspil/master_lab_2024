package org.acme.cs_c6_e1.service;

import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.acme.cs_c6_e1.model.entities.Invoice;
import org.acme.cs_c6_e1.repositories.InvoiceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@AllArgsConstructor
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;

    public Invoice findInvoiceByNumber(final String number) {
        return invoiceRepository.findInvoiceByNumber(number)
                .orElseThrow();
    }

    public Invoice createInvoice(final Invoice invoice) {
        return invoiceRepository.save(invoice);
    }
}
