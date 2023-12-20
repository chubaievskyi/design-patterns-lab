package com.chubaievskyi.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.io.IOException;

public class MessageService {

    private final Logger log = LoggerFactory.getLogger(MessageService.class);
    private final InputReader inputReader = new InputReader();

    public void readAndWriteMessage() {
        ObjectMapper objectMapper = new XmlMapper();
        try (FileWriter writer = new FileWriter(getFilePath())) {
            String messageText = readMessage();
            writeMessage(messageText, writer, objectMapper);
        } catch (IOException e) {
            log.error("Exception occurred while writing to file", e);
        }
    }

    protected String readMessage() {
        return inputReader.getMessage();
    }

    protected void writeMessage(String messageText, FileWriter writer, ObjectMapper objectMapper) {

        try {
            String message = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(new Message(messageText));
            writer.write(message);
            log.info("Message successfully written to file");
        } catch (IOException e) {
            log.error("Exception occurred while writing to file", e);
        }
    }

    protected String getFilePath() {
        return inputReader.getExampleFilePath();
    }
}