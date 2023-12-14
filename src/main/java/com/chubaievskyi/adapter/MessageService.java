package com.chubaievskyi.adapter;

import com.chubaievskyi.example.Message;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.io.IOException;

public class MessageService {

    private final Logger log = LoggerFactory.getLogger(MessageService.class);
    public void readAndWriteMessage() {

        MessageReader propertyReader = new PropertyMessageReader(InputReader.getInstance());
        String propertyMessageText = propertyReader.readMessage();
        writeMessage(propertyMessageText);

        MessageReader jsonReader = new JsonMessageReader();
        String jsonMessageText = jsonReader.readMessage();
        writeMessage(jsonMessageText);
    }

    private void writeMessage(String messageText) {
        ObjectMapper objectMapper = new XmlMapper();
        String filePath = ".adaptor-recorded-files/xml_message_output.xml";
        try (FileWriter writer = new FileWriter(filePath, true)) {
            String message = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(new Message(messageText));
            writer.write(message);
            log.info("Message successfully written to file: {}", filePath);
        } catch (IOException e) {
            log.error("Exception occurred while writing to file", e);
        }
    }
}
