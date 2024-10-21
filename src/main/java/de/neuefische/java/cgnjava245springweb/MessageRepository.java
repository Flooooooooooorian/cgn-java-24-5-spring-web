package de.neuefische.java.cgnjava245springweb;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MessageRepository extends MongoRepository<Message, String> {

    public List<Message> findAllByName(String name);
}
