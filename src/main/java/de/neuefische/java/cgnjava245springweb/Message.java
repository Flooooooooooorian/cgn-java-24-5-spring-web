package de.neuefische.java.cgnjava245springweb;

import lombok.Builder;
import lombok.With;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document("messages")
@With
@Builder
public record Message(
        @Id
        String id,
        String name,
        String message,
        Instant sentAt,
        String ip
) {
}
