package com.app.jeyz9.booksservice.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookControllerTest {
    @Autowired
    private MockMvc mockMvc;

    private static Long createdBookId;

    @Test
    @Order(1)
    void testAddBook() throws Exception {
        String newBook = """
                {
                    "title": "Jey Test",
                    "type": "test",
                    "img": "test.jpg"
                }
                """;

        MvcResult result = mockMvc.perform(post("/api/v1/books")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(newBook))
                .andExpect(status().isCreated())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.title").value("Jey Test"))
                .andReturn();
        String responseBody = result.getResponse().getContentAsString();
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(responseBody);
        createdBookId = jsonNode.get("id").asLong();
    }
    
    @Test
    @Order(2)
    void testGetBookById() throws Exception {
        mockMvc.perform(get("/api/v1/books/" + createdBookId))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.title").isString());
    }

    @Test
    @Order(3)
    void testEditBook() throws Exception {
        String newBook = """
                {
                    "title": "Jey Test Update",
                    "type": "update",
                    "img": "test.jpg"
                }
                """;

        mockMvc.perform(put("/api/v1/books/" + createdBookId)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(newBook))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$").value("Updated book success!"));
    }

    @Test
    @Order(4)
    void testDeleteBookById() throws Exception {
        mockMvc.perform(delete("/api/v1/books/" + createdBookId)
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isNoContent());
    }

    @Test
    @Order(5)
    void testGetAllBooks() throws Exception {
        mockMvc.perform(get("/api/v1/books"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$").isArray());
    }
}
