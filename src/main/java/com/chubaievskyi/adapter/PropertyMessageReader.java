package com.chubaievskyi.adapter;

import com.chubaievskyi.example.InputReader;

public class PropertyMessageReader implements MessageReader {
    private final InputReader inputReader;

    public PropertyMessageReader(InputReader inputReader) {
        this.inputReader = inputReader;
    }

    @Override
    public String readMessage() {
        return inputReader.getMessage() + " -- message from application.properties file";
    }
}
