package org.acme.cs_c6_e1.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.acme.cs_c6_e1.model.entities.Invoice;
import org.acme.cs_c6_e1.service.InvoiceService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/invoice")
@Validated
public class InvoiceController {

    private final InvoiceService invoiceService;

    @GetMapping("/{number}")
    public @Valid Invoice getInvoice(@PathVariable final String number) {
        return invoiceService.findInvoiceByNumber(number);
    }

    @PostMapping("/")
    public Invoice createInvoice(@RequestBody @Valid final Invoice invoice) {
        return invoiceService.createInvoice(invoice);
    }
}
