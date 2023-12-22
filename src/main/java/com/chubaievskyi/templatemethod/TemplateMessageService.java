package com.chubaievskyi.templatemethod;

import com.chubaievskyi.example.InputReader;

public abstract class TemplateMessageService {

    private final InputReader inputReader = new InputReader();

    protected String readMessage() {
        return inputReader.getMessage();
    }

    protected abstract void writeMessage(String message, String filePath);

    protected abstract String getFilePath();

    public final void readAndWriteMessage() {
        String message = readMessage();
        String filePath = getFilePath();
        writeMessage(message, filePath);
    }
}