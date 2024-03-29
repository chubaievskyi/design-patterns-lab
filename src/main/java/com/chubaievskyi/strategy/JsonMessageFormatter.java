package com.chubaievskyi.strategy;

import com.chubaievskyi.example.InputReader;
import com.chubaievskyi.example.Message;
import com.chubaievskyi.exceptions.MessageFormatException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonMessageFormatter implements MessageFormatter {

    @Override
    public String formatMessage(Message message) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(message);
        } catch (JsonProcessingException e) {
            throw new MessageFormatException("Error formatting JSON message", e);
        }
    }

    @Override
    public String getFilePath() {
        return new InputReader().getStrategyJsonFilePath();
    }
}