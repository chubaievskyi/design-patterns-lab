package com.chubaievskyi.templatemethod;

import com.chubaievskyi.example.InputReader;
import com.chubaievskyi.example.Message;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.io.IOException;

public class XmlMessageService extends TemplateMessageService {

    private final Logger log = LoggerFactory.getLogger(XmlMessageService.class);
    private final InputReader inputReader = new InputReader();

    @Override
    protected String readMessage() {
        return inputReader.getMessage();
    }

    @Override
    protected void writeMessage(String message, String filePath) {

        ObjectMapper objectMapper = new XmlMapper();

        try (FileWriter fileWriter = new FileWriter(filePath)) {
            String xmlMessage = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(new Message(message));
            fileWriter.write(xmlMessage);
            log.info("Message successfully written to file: {}", filePath);
        } catch (IOException e) {
            log.error("Exception occurred while writing to file", e);
        }
    }

    @Override
    protected String getFilePath() {
        return inputReader.getTemplateMethodXmlFilePath();
    }
}