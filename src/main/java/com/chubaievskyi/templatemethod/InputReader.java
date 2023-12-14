package com.chubaievskyi.templatemethod;

import com.chubaievskyi.templatemethod.exceptions.FileNotFoundException;
import com.chubaievskyi.templatemethod.exceptions.FileReadException;
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

    private static InputReader instance;

    private String message;

    private InputReader() {
        loadProperties();
        readPropertyValue();
    }

    public static synchronized InputReader getInstance() {
        if (instance == null) {
            instance = new InputReader();
        }
        return instance;
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