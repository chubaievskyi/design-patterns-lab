package com.chubaievskyi.strategy;

import java.io.FileWriter;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageService {

    private static final Logger LOG = LoggerFactory.getLogger(MessageService.class);

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
        return InputReader.getInstance().getMessage();
    }

    protected void writeMessage(String formattedMessage) {
        String filePath = writeFormatter.getFilePath();
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(formattedMessage);
            LOG.info("Message successfully written to file: {}", filePath);
        } catch (IOException e) {
            LOG.error("Exception occurred while writing to file", e);
        }
    }
}