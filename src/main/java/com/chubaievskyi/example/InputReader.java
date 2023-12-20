package com.chubaievskyi.example;

import com.chubaievskyi.exceptions.FileNotFoundException;
import com.chubaievskyi.exceptions.FileReadException;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

@Getter
public class InputReader {

    private final Logger log = LoggerFactory.getLogger(InputReader.class);
    private final Properties properties = new Properties();

    private String message;
    private String adaptorFilePath;
    private String exampleFilePath;
    private String strategyJsonFilePath;
    private String strategyTxtFilePath;
    private String strategyXmlFilPath;
    private String templateMethodJsonFilePath;
    private String templateMethodTxtFilePath;
    private String templateMethodXmlFilePath;

    public InputReader() {
        loadProperties();
        readPropertyValue();
    }

    private void loadProperties() {

        try {
            InputStream input = getClass().getClassLoader().getResourceAsStream("application.properties");

            if (input != null) {
                properties.load(new InputStreamReader(input, StandardCharsets.UTF_8));
                log.info("Loaded properties from application.properties in classpath");
            } else {
                throw new FileNotFoundException("Application.properties not found in classpath, " +
                        "please check the classpath and file .properties");
            }
        } catch (IOException e) {
            throw new FileReadException("Failed to read properties from file.", e);
        }
    }

    private void readPropertyValue() {
        log.info("Read the values of properties.");
        message = properties.getProperty("message");
        adaptorFilePath = properties.getProperty("adaptor.file.path");
        exampleFilePath = properties.getProperty("example.file.path");
        strategyJsonFilePath = properties.getProperty("strategy.json.file.path");
        strategyTxtFilePath = properties.getProperty("strategy.txt.file.path");
        strategyXmlFilPath = properties.getProperty("strategy.xml.file.path");
        templateMethodJsonFilePath = properties.getProperty("template.method.json.file.path");
        templateMethodTxtFilePath = properties.getProperty("template.method.txt.file.path");
        templateMethodXmlFilePath = properties.getProperty("template.method.xml.file.path");
    }
}