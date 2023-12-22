package com.chubaievskyi.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StrategyClient {

    private static final Logger LOG = LoggerFactory.getLogger(StrategyClient.class);

    public static void main(String[] args) {

        LOG.info("Program start!");

        MessageFormatter textMessageFormatter = new TextMessageFormatter();
        StrategyMessageService textService = new StrategyMessageService(textMessageFormatter);
        textService.readAndWriteMessage();

        MessageFormatter jsonMessageFormatter = new JsonMessageFormatter();
        StrategyMessageService jsonService = new StrategyMessageService(jsonMessageFormatter);
        jsonService.readAndWriteMessage();

        MessageFormatter xmlMessageFormatter = new XmlMessageFormatter();
        StrategyMessageService xmlService = new StrategyMessageService(xmlMessageFormatter);
        xmlService.readAndWriteMessage();

        LOG.info("End of program!");
    }
}