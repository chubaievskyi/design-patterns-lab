package com.chubaievskyi.templatemethod;

import com.chubaievskyi.example.InputReader;
import com.chubaievskyi.example.Message;
import com.chubaievskyi.exceptions.FileWriterException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.io.IOException;

public class XmlMessageService extends TemplateMessageService {

    private final Logger log = LoggerFactory.getLogger(XmlMessageService.class);
    private final FileWriter fileWriter;

    public XmlMessageService() {
        this.fileWriter = createFileWriter();
    }

    public XmlMessageService(FileWriter fileWriter) {
        this.fileWriter = fileWriter;
    }

    @Override
    protected void writeMessage(String message, String filePath) {

        ObjectMapper objectMapper = new XmlMapper();

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
        return new InputReader().getTemplateMethodXmlFilePath();
    }

    private FileWriter createFileWriter() {
        try {
            return new FileWriter(getFilePath());
        } catch (IOException e) {
            throw new FileWriterException("Error creating FileWriter", e);
        }
    }
}