package com.chubaievskyi.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger LOG = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        LOG.info("Program start!");

        MessageFormatter textMessageFormatter = new TextMessageFormatter();
        MessageService textMessageService = new MessageService(textMessageFormatter, textMessageFormatter);
        textMessageService.readAndWriteMessage();

        MessageFormatter jsonMessageFormatter = new JsonMessageFormatter();
        MessageService jsonMessageService = new MessageService(jsonMessageFormatter, jsonMessageFormatter);
        jsonMessageService.readAndWriteMessage();

        MessageFormatter xmlMessageFormatter = new XmlMessageFormatter();
        MessageService xmlMessageService = new MessageService(xmlMessageFormatter, xmlMessageFormatter);
        xmlMessageService.readAndWriteMessage();

        LOG.info("End of program!");
    }
}