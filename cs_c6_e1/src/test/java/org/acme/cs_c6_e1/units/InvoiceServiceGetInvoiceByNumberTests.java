package org.acme.cs_c6_e1.units;

import org.acme.cs_c6_e1.model.entities.Invoice;
import org.acme.cs_c6_e1.repositories.InvoiceRepository;
import org.acme.cs_c6_e1.service.InvoiceService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class InvoiceServiceGetInvoiceByNumberTests {

    @Test
    @DisplayName("""
            Given there is an invoice for the given number in the database
            Then the invoice details are returned
            """)
    void test1() {
        // Test setup
        final String number = "12345";

        final Invoice invoice = new Invoice();
        invoice.setId(10);
        invoice.setNumber(number);

        final InvoiceRepository invoiceRepository = mock(InvoiceRepository.class);

        when(invoiceRepository.findInvoiceByNumber(number))
                .thenReturn(Optional.of(invoice));

        final InvoiceService invoiceService = new InvoiceService(invoiceRepository);

        // Call
        final Invoice resultedInvoice = invoiceService.findInvoiceByNumber(number);

        // Assert
        assertNotNull(resultedInvoice);
        assertNotNull(resultedInvoice.getId());
        assertEquals(number, resultedInvoice.getNumber());

        verify(invoiceRepository, times(1)).findInvoiceByNumber(any());
    }

    @Test
    @DisplayName("""
            Given there is no invoice for the given number in the database
            Then the an exception is thrown.
            """)
    void test2() {
        // Test setup
        final String number = "12345";

        final InvoiceRepository invoiceRepository = mock(InvoiceRepository.class);

        when(invoiceRepository.findInvoiceByNumber(number))
                .thenReturn(Optional.empty());

        final InvoiceService invoiceService = new InvoiceService(invoiceRepository);

        // Call
        assertThrows(
                RuntimeException.class,
                () -> invoiceService.findInvoiceByNumber(number)
                );

        // Asserts

        verify(invoiceRepository, times(1)).findInvoiceByNumber(any());
    }

}
