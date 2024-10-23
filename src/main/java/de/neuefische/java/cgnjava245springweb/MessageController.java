package de.neuefische.java.cgnjava245springweb;

import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/messages")
//@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping
    public Message addMessage(@RequestBody NewMessageDto message) {

        Message messageToSave = Message.builder()
                .name(message.name())
                .message(message.message())
                .ip(message.ip())
                .build();

        return messageService.createMessage(messageToSave);
//        messages.add(message);
    }

    @GetMapping()
    public List<Message> getMessages() {
        return messageService.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteMessage(@PathVariable String id) {
        messageService.deleteById(id);
    }
}
