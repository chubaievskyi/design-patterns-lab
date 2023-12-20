package com.chubaievskyi.adapter;

import com.chubaievskyi.example.InputReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PropertyMessageReaderTest {

    private PropertyMessageReader propertyMessageReader;

    @BeforeEach
    void setUp() {
        InputReader inputReader = new InputReader();
        propertyMessageReader = new PropertyMessageReader(inputReader);
    }

    @Test
    void testReadMessage() {

        String result = propertyMessageReader.readMessage();

        assertEquals("Hello world!!! -- message from application.properties file", result);
    }
}