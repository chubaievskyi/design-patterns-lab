package com.chubaievskyi.exceptions;

public class MessageFormatException extends RuntimeException {

    private static final long serialVersionUID = 6018793052675973535L;

    public MessageFormatException(String message, Throwable cause) {
        super(message, cause);
    }
}