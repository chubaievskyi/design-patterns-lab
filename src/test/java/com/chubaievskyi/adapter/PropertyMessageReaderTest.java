package com.chubaievskyi.adapter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PropertyMessageReaderTest {

    @Test
    void testReadMessage() {

        PropertyMessageReader propertyMessageReader = new PropertyMessageReader();

        String result = propertyMessageReader.readMessage();

        assertEquals("Hello world!!! -- message from application.properties file", result);
    }
}