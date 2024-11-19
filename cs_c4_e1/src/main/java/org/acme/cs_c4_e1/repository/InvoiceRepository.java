package org.acme.cs_c4_e1.repository;

import org.acme.cs_c4_e1.model.Invoice;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class InvoiceRepository {

    private final List<Invoice> invoices = new ArrayList<>();

    public void saveInvoice(final Invoice invoice) {
        this.invoices.add(invoice);
    }

    public List<Invoice> getInvoices() {
        return this.invoices;
    }

    public Optional<Invoice> getInvoiceById(final String id) {
        return this.invoices.stream()
                .filter(invoice -> invoice.id().equals(id))
                .findFirst();
    }

    public void deleteById(final String id) {
        this.invoices.removeIf(invoice -> invoice.id().equals(id));
    }
}
