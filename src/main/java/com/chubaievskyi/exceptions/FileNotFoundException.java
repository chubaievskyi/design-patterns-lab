package com.chubaievskyi.exceptions;

public class FileNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 8314191646687056056L;

    public FileNotFoundException(String message) {
        super(message);
    }
}