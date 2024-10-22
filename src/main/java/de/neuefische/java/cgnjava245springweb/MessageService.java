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
    private final IdService idService;

    public MessageService(MessageRepository messageRepository, IdService idService) {
        this.messageRepository = messageRepository;
        this.idService = idService;
    }

    public Message createMessage(Message message) {

        Message messageToSave = message
                .withId(idService.randomId())
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
