package de.neuefische.java.cgnjava245springweb;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("messages")
public record Message(
        @Id
        String id,
        String name,
        String message
) {
}
