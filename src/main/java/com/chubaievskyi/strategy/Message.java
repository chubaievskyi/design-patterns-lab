package com.chubaievskyi.strategy;

import lombok.Data;

@Data
public class Message {

    private String messageText;

    public Message(String messageText) {
        this.messageText = messageText;
    }
}