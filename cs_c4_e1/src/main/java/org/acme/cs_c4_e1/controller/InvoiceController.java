package org.acme.cs_c4_e1.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.acme.cs_c4_e1.model.Invoice;
import org.acme.cs_c4_e1.service.InvoiceService;
import org.acme.cs_c4_e1.service.exceptions.AlreadyExistingInvoiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/invoices")
@AllArgsConstructor
@Slf4j
public class InvoiceController {

    private final InvoiceService invoiceService;

    @PostMapping("/invoice")
    public ResponseEntity<Invoice> createInvoice(
            @RequestBody final Invoice invoice) {
        try {
            this.invoiceService.saveInvoice(invoice);
            return ResponseEntity.ok(invoice);
        } catch (final AlreadyExistingInvoiceException e) {
            log.error("Error creating invoice", e);
        }

        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }
}
