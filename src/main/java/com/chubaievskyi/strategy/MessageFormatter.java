package com.chubaievskyi.strategy;

import com.chubaievskyi.example.Message;

public interface MessageFormatter {
    String formatMessage(Message message);
    String getFilePath();
}
