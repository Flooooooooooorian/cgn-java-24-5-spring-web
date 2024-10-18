package de.neuefische.java.cgnjava245springweb;

import lombok.With;

@With
public record Product(
        String id,
        String name,
        double price
) {
}
