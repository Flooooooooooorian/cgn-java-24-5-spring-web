package de.neuefische.java.cgnjava245springweb;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MessageRepository extends MongoRepository<Message, String> {

    public List<Message> findAllByName(String name);
}
