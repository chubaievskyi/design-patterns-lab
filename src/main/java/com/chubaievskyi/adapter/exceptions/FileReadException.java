package com.chubaievskyi.adapter.exceptions;

public class FileReadException extends RuntimeException {

    private static final long serialVersionUID = -3510083190579319481L;

    public FileReadException(String message, Throwable cause) {
        super(message, cause);
    }
}