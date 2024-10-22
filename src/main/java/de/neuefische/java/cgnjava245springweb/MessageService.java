package de.neuefische.java.cgnjava245springweb;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Component
public class MessageService {

    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Message createMessage(Message message) {

        Message messageToSave = message
                .withId(UUID.randomUUID().toString())
                .withSentAt(Instant.now());

        return messageRepository.save(messageToSave);
    }

    public List<Message> findAll() {

        return messageRepository.findAll();
    }

    public void deleteById(String id) {
        messageRepository.deleteById(id);
    }
}
