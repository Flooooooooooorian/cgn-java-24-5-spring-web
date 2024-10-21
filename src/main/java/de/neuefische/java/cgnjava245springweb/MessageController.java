package de.neuefische.java.cgnjava245springweb;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/messages")
//@RequiredArgsConstructor
public class MessageController {

    private final MessageRepository repository;

    public MessageController(MessageRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public void addMessage(@RequestBody Message message) {
        repository.save(message);
//        messages.add(message);
    }

    @GetMapping("{name}")
    public List<Message> getMessages(@PathVariable String name) {
        return repository.findAllByName(name);
    }

    @DeleteMapping("/{id}")
    public void deleteMessage(@PathVariable String id) {
        repository.deleteById(id);
    }
}
