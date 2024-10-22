package de.neuefische.java.cgnjava245springweb;

import lombok.Builder;
import lombok.With;



public record NewMessageDto(
        String name,
        String message
) {
}
