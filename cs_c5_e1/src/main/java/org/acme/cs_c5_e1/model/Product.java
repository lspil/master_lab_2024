package org.acme.cs_c5_e1.model;

import org.springframework.data.annotation.Id;

public record Product(
        @Id  String id,
        String name
) {
}
