package com.chubaievskyi.templatemethod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TemplateMethodClient {

    private static final Logger LOG = LoggerFactory.getLogger(TemplateMethodClient.class);

    public static void main(String[] args) {

        LOG.info("Program start!");

        TemplateMessageService textMessageService = new TextMessageService();
        textMessageService.readAndWriteMessage();

        TemplateMessageService jsonMessageService = new JsonMessageService();
        jsonMessageService.readAndWriteMessage();

        TemplateMessageService xmlMessageService = new XmlMessageService();
        xmlMessageService.readAndWriteMessage();

        LOG.info("End of program!");
    }
}