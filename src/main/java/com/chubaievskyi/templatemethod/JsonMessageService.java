package com.chubaievskyi.templatemethod;

import com.chubaievskyi.example.InputReader;
import com.chubaievskyi.example.Message;
import com.chubaievskyi.exceptions.FileWriterException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.io.IOException;

public class JsonMessageService extends TemplateMessageService {

    private final Logger log = LoggerFactory.getLogger(JsonMessageService.class);
    private final InputReader inputReader = new InputReader();
    private final FileWriter fileWriter;

    public JsonMessageService() {
        this.fileWriter = createFileWriter();
    }

    public JsonMessageService(FileWriter fileWriter) {
        this.fileWriter = fileWriter;
    }

    @Override
    protected String readMessage() {
        return inputReader.getMessage();
    }

    @Override
    protected void writeMessage(String message, String filePath) {

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            String xmlMessage = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(new Message(message));
            fileWriter.write(xmlMessage);
            fileWriter.flush();
            log.info("Message successfully written to file: {}", filePath);
        } catch (IOException e) {
            log.error("Exception occurred while writing to file", e);
        }
    }

    @Override
    protected String getFilePath() {
        return inputReader.getTemplateMethodJsonFilePath();
    }

    private FileWriter createFileWriter() {
        try {
            return new FileWriter(getFilePath());
        } catch (IOException e) {
            throw new FileWriterException("Error creating FileWriter", e);
        }
    }
}