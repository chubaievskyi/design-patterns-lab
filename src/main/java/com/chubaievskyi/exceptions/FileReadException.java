package com.chubaievskyi.exceptions;

public class FileReadException extends RuntimeException {

    private static final long serialVersionUID = 4034091722409540001L;

    public FileReadException(String message, Throwable cause) {
        super(message, cause);
    }
}