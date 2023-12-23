package com.chubaievskyi.adapter;

import com.chubaievskyi.example.InputReader;

public class PropertyMessageReader implements MessageReader {

    @Override
    public String readMessage() {
        return new InputReader().getMessage() + " -- message from application.properties file";
    }
}