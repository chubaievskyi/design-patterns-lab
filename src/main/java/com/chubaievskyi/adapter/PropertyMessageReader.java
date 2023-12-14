package com.chubaievskyi.adapter;

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
