package com.chubaievskyi.templatemethod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.io.IOException;

public class TextMessageReader extends MessageService {

    private final Logger log = LoggerFactory.getLogger(TextMessageReader.class);

    @Override
    protected String readMessage() {
        return InputReader.getInstance().getMessage();
    }

    @Override
    protected void writeMessage(String message, String filePath) {

        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(message);
            log.info("Message successfully written to file: {}", filePath);
        } catch (IOException e) {
            log.error("Exception occurred while writing to file", e);
        }
    }

    @Override
    protected String getFilePath() {
        return ".template-method-recorded-files/text_message_output.txt";
    }
}