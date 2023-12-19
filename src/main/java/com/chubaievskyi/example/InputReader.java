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
    }
}