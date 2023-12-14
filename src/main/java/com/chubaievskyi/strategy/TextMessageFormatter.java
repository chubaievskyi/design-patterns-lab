package com.chubaievskyi.strategy;

public class TextMessageFormatter implements MessageFormatter {

    @Override
    public String formatMessage(Message message) {
        return message.getMessageText();
    }

    @Override
    public String getFilePath() {
        return ".strategy-recorded-files/text_message_output.txt";
    }
}