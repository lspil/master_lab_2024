package org.acme.cs_c6_e1.service;

import lombok.AllArgsConstructor;
import org.acme.cs_c6_e1.model.entities.Invoice;
import org.acme.cs_c6_e1.repositories.InvoiceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@AllArgsConstructor
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Invoice findInvoiceByNumber(final String number) {
        final var invoice = invoiceRepository.findInvoiceByNumber(number);

        if (invoice.isPresent()) {
            return invoice.get();
        } else {
            throw new RuntimeException();
        }
    }

    public Invoice createInvoice(final Invoice invoice) {
        return invoiceRepository.save(invoice);
    }
}
