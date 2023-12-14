package com.chubaievskyi.strategy;

public interface MessageFormatter {
    String formatMessage(Message message);
    String getFilePath();
}
