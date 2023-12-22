package com.chubaievskyi.strategy;

import java.io.FileWriter;
import java.io.IOException;

import com.chubaievskyi.example.InputReader;
import com.chubaievskyi.example.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StrategyMessageService {

    private  final Logger log = LoggerFactory.getLogger(StrategyMessageService.class);
    private final InputReader inputReader = new InputReader();

    private final MessageFormatter messageFormatter;

    public StrategyMessageService(MessageFormatter messageFormatter) {
        this.messageFormatter = messageFormatter;
    }

    public void readAndWriteMessage() {
        String filePath = messageFormatter.getFilePath();
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            String messageText = readMessage();
            String formattedMessage = messageFormatter.formatMessage(new Message(messageText));
            writeMessage(formattedMessage, fileWriter);
        } catch (IOException e) {
            log.error("Error creating FileWriter", e);
        }

    }

    protected String readMessage() {
        return inputReader.getMessage();
    }

    protected void writeMessage(String formattedMessage, FileWriter fileWriter) {
        try {
            fileWriter.write(formattedMessage);
            log.info("Message successfully written to file");
        } catch (IOException e) {
            log.error("Exception occurred while writing to file", e);
        }
    }
}