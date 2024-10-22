package de.neuefische.java.cgnjava245springweb;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class MessageServiceTest {

    IdService idService = mock(IdService.class);
    MessageRepository messageRepository = mock(MessageRepository.class);
    MessageService messageService = new MessageService(messageRepository, idService);

    @Test
    void findAllTest() {
        //GIVEN
        Message m1 = new Message("1", "Florian", "Test", Instant.now(), "test-ip");
        Message m2 = new Message("2", "Martin", "Test-2", Instant.now(), "test-ip-2");
        List<Message> messages = List.of(m1, m2);

        when(messageRepository.findAll()).thenReturn(messages);

        //WHEN
        List<Message> actual = messageService.findAll();

        //THEN
        assertEquals(messages, actual);

    }

    @Test
    void createMessageTest() {
        //GIVEN
        Message messageToSave = new Message(null, "Test-name", "Test-Message", null, "test-ip");
        Message savedMessage = new Message("23ABC", "Test-name", "Test-Message", Instant.now(), "test-ip");

        when(messageRepository.save(savedMessage)).thenReturn(savedMessage);
        when(idService.randomId()).thenReturn("23ABC");

        //WHEN
        Message actual = messageService.createMessage(messageToSave);

        //THEN
        verify(messageRepository).save(savedMessage);
        verify(idService).randomId();
        assertEquals(savedMessage, actual);
    }

}
