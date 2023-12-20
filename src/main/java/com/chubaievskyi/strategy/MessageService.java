package com.chubaievskyi.strategy;

import java.io.FileWriter;
import java.io.IOException;

import com.chubaievskyi.example.InputReader;
import com.chubaievskyi.example.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageService {

    private  final Logger log = LoggerFactory.getLogger(MessageService.class);
    private final InputReader inputReader = new InputReader();

    private final MessageFormatter readFormatter;
    private final MessageFormatter writeFormatter;

    public MessageService(MessageFormatter readFormatter, MessageFormatter writeFormatter) {
        this.readFormatter = readFormatter;
        this.writeFormatter = writeFormatter;
    }

    public void readAndWriteMessage() {
        String messageText = readMessage();
        String formattedMessage = readFormatter.formatMessage(new Message(messageText));
        writeMessage(formattedMessage);
    }

    protected String readMessage() {
        return inputReader.getMessage();
    }

    protected void writeMessage(String formattedMessage) {
        String filePath = writeFormatter.getFilePath();
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(formattedMessage);
            log.info("Message successfully written to file: {}", filePath);
        } catch (IOException e) {
            log.error("Exception occurred while writing to file", e);
        }
    }
}