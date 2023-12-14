package com.chubaievskyi.templatemethod;

public abstract class MessageService {

    protected abstract String readMessage();

    protected abstract void writeMessage(String message, String filePath);

    protected abstract String getFilePath();

    public final void readAndWriteMessage() {
        String message = readMessage();
        String filePath = getFilePath();
        writeMessage(message, filePath);
    }
}