package com.chubaievskyi.strategy;

import com.chubaievskyi.example.InputReader;
import com.chubaievskyi.example.Message;

public class TextMessageFormatter implements MessageFormatter {

    @Override
    public String formatMessage(Message message) {
        return message.getMessageText();
    }

    @Override
    public String getFilePath() {
        return new InputReader().getStrategyTxtFilePath();
    }
}