package org.acme.cs_c4_e1.service.exceptions;

public class AlreadyExistingInvoiceException extends RuntimeException {

    public AlreadyExistingInvoiceException() {
        super("This invoice already exists");
    }
}
