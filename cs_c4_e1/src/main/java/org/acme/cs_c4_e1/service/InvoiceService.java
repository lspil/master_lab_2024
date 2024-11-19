package org.acme.cs_c4_e1.service;

import lombok.AllArgsConstructor;
import org.acme.cs_c4_e1.model.Invoice;
import org.acme.cs_c4_e1.repository.InvoiceRepository;
import org.acme.cs_c4_e1.service.exceptions.AlreadyExistingInvoiceException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;

    public void saveInvoice(final Invoice invoice) {
        final var existingInvoice = this.invoiceRepository.getInvoiceById(invoice.id());

        if (existingInvoice.isPresent()) {
            throw new AlreadyExistingInvoiceException();
        } else {
            this.invoiceRepository.saveInvoice(invoice);
        }
    }

    public void deleteInvoice(final String id) {
        this.invoiceRepository.deleteById(id);
    }

    public List<Invoice> getInvoices() {
        return this.invoiceRepository.getInvoices();
    }

    public Invoice getInvoiceById(final String id) {
        return this.invoiceRepository.getInvoiceById(id).orElseThrow();
    }
}
