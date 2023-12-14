package com.chubaievskyi.adapter;

import com.chubaievskyi.adapter.exceptions.FileReadException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonMessageReader implements MessageReader {

    @Override
    public String readMessage() {
        try {
//            InputStream input = getClass().getClassLoader().getResourceAsStream("messageslist.json");
            ObjectMapper objectMapper = new ObjectMapper();
//            return objectMapper.readTree(input).toString();

            JsonNode jsonNode = objectMapper.readTree(new File("messageslist.json"));
            return jsonNode.get("messageText").asText() + " -- message from messageslist.json file";

        } catch (IOException e) {
            throw new FileReadException("Failed to read message from file.", e);
        }
    }
}
