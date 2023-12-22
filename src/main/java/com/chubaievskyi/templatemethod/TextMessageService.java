package com.chubaievskyi.templatemethod;

import com.chubaievskyi.example.InputReader;
import com.chubaievskyi.exceptions.FileWriterException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.io.IOException;

public class TextMessageService extends TemplateMessageService {

    private final Logger log = LoggerFactory.getLogger(TextMessageService.class);
    private final InputReader inputReader = new InputReader();
    private final FileWriter fileWriter;

    public TextMessageService() {
        this.fileWriter = createFileWriter();
    }

    public TextMessageService(FileWriter fileWriter) {
        this.fileWriter = fileWriter;
    }

    @Override
    protected String readMessage() {
        return inputReader.getMessage();
    }

    @Override
    protected void writeMessage(String message, String filePath) {

        try {
            fileWriter.write(message);
            fileWriter.flush();
            log.info("Message successfully written to file: {}", filePath);
        } catch (IOException e) {
            log.error("Exception occurred while writing to file", e);
        }
    }

    @Override
    protected String getFilePath() {
        return inputReader.getTemplateMethodTxtFilePath();
    }

    private FileWriter createFileWriter() {
        try {
            return new FileWriter(getFilePath());
        } catch (IOException e) {
            throw new FileWriterException("Error creating FileWriter", e);
        }
    }
}