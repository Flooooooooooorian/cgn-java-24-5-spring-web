package de.neuefische.java.cgnjava245springweb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.Instant;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MessageControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    MessageRepository messageRepository;

    @Test
    void getAllMessagesTest() throws Exception {
        //GIVEN

        Instant now = Instant.parse("2024-10-23T08:21:44.082Z");
        Message testMessage = new Message("1", "Florian", "Test-Message", now, "test-ip");

        messageRepository.save(testMessage);

        //WHEN
//        mockMvc.perform(MockMvcRequestBuilders.get())

        mockMvc.perform(get("/api/messages"))

                //THEN
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        [
                          {
                            "id": "1",
                            "name": "Florian",
                            "message": "Test-Message",
                            "sentAt": "2024-10-23T08:21:44.082Z",
                            "ip": "test-ip"
                          }
                        ]
                        """));

    }

    @Test
    void postMessagesTest() throws Exception {
        //GIVEN

        //WHEN

        mockMvc.perform(post("/api/messages")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                    "name": "Martin",
                                    "message": "Test-Message",
                                    "ip": "123"
                                }
                                """))

                //THEN
                .andExpect(status().isOk())
                .andExpect(content().json("""
                          {
                            "name": "Martin",
                            "message": "Test-Message",
                            "ip": "123"
                          }
                        """));

    }

}
