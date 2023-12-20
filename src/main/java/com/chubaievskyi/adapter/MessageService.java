package com.chubaievskyi.adapter;

import com.chubaievskyi.example.InputReader;
import com.chubaievskyi.example.Message;
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

            MessageReader propertyReader = new PropertyMessageReader(inputReader);
            String propertyMessageText = propertyReader.readMessage();
            writeMessage(propertyMessageText, writer, objectMapper);

            MessageReader jsonReader = new JsonMessageReader();
            String jsonMessageText = jsonReader.readMessage();
            writeMessage(jsonMessageText, writer, objectMapper);

        } catch (IOException e) {
            log.error("Exception occurred while writing to file", e);
        }
    }

    private void writeMessage(String messageText, FileWriter writer, ObjectMapper objectMapper) {

        try {
            String message = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(new Message(messageText));
            writer.write(message);
            log.info("Message successfully written to file");
        } catch (IOException e) {
            log.error("Exception occurred while writing to file", e);
        }
    }

    protected String getFilePath() {
        return inputReader.getAdaptorFilePath();
    }
}