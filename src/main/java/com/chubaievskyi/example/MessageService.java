package com.chubaievskyi.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.io.IOException;

public class MessageService {

    private static final Logger LOG = LoggerFactory.getLogger(MessageService.class);

    public void readAndWriteMessage() {
        String messageText = readMessage();
        writeMessage(messageText);
    }

    protected String readMessage() {
        return InputReader.getInstance().getMessage();
    }

    protected void writeMessage(String messageText) {
        ObjectMapper objectMapper = new XmlMapper();
        String filePath = getFilePath();
        try (FileWriter writer = new FileWriter(filePath)) {
            String message = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(new Message(messageText));
            writer.write(message);
            LOG.info("Message successfully written to file: {}", filePath);
        } catch (IOException e) {
            LOG.error("Exception occurred while writing to file", e);
        }
    }

    protected String getFilePath() {
        return ".example-recorded-files/xml_message_output.xml";
    }
}