package com.chubaievskyi.templatemethod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger LOG = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        LOG.info("Program start!");

        MessageService textMessageService = new TextMessageReader();
        textMessageService.readAndWriteMessage();

        MessageService jsonMessageService = new JsonMessageService();
        jsonMessageService.readAndWriteMessage();

        MessageService xmlMessageService = new XmlMessageService();
        xmlMessageService.readAndWriteMessage();

        LOG.info("End of program!");
    }
}