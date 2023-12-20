package com.chubaievskyi.strategy;

import com.chubaievskyi.example.InputReader;
import com.chubaievskyi.example.Message;
import com.chubaievskyi.exceptions.MessageFormatException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XmlMessageFormatter implements MessageFormatter {

    @Override
    public String formatMessage(Message message) {
        XmlMapper xmlMapper = new XmlMapper();
        try {
            return xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(message);
        } catch (JsonProcessingException e) {
            throw new MessageFormatException("Error formatting JSON message", e);
        }
    }

    @Override
    public String getFilePath() {
        return new InputReader().getStrategyXmlFilPath();
    }
}