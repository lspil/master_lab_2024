package org.acme.cs_c6_e1.contract;

import org.acme.cs_c6_e1.model.entities.Invoice;
import org.acme.cs_c6_e1.repositories.InvoiceRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class InvoiceServiceContractTests {

    @MockBean
    private InvoiceRepository invoiceRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("""
            WHEN ...
            AND ...
            THEN ...
            """)
    public void test1() throws Exception {
        final String number = "12345";

        final Invoice invoice = new Invoice();
        invoice.setId(10);
        invoice.setNumber(number);

        when(invoiceRepository.findInvoiceByNumber(number))
                .thenReturn(Optional.of(invoice));

        mockMvc.perform(get("/api/v1/invoice/12345")) // execute call

                .andExpect(status().isOk()); // assertions
    }

}
