package com.chubaievskyi.adapter;

import com.chubaievskyi.exceptions.FileReadException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonMessageReader implements MessageReader {

    private final ObjectMapper objectMapper;

    public JsonMessageReader(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public String readMessage() {
        try {
            JsonNode jsonNode = objectMapper.readTree(new File("message-list.json"));
            return jsonNode.get("messageText").asText() + " -- message from message-list.json file";

        } catch (IOException e) {
            throw new FileReadException("Failed to read message from file.", e);
        }
    }
}