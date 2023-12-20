package com.chubaievskyi.adapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JsonMessageReaderTest {

    private JsonMessageReader jsonMessageReader;

    @BeforeEach
    void setUp() {
        ObjectMapper objectMapper = new ObjectMapper();
        jsonMessageReader = new JsonMessageReader(objectMapper);
    }

    @Test
    void testReadMessage() {

        String result = jsonMessageReader.readMessage();

        assertEquals("Hello world!!! -- message from message-list.json file", result);
    }
}
