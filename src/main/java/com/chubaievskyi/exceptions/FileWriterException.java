package com.chubaievskyi.exceptions;

public class FileWriterException extends RuntimeException{

    private static final long serialVersionUID = -4039738872248282474L;

    public FileWriterException(String message, Throwable cause) {
        super(message, cause);
    }
}