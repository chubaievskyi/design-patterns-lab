package com.chubaievskyi.adapter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JsonMessageReaderTest {

    @Test
    void testReadMessage() {

        JsonMessageReader jsonMessageReader = new JsonMessageReader();

        String result = jsonMessageReader.readMessage();

        assertEquals("Hello world!!! -- message from message-list.json file", result);
    }
}
