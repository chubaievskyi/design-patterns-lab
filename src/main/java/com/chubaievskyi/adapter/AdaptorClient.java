package com.chubaievskyi.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AdaptorClient {

    private static final Logger LOG = LoggerFactory.getLogger(AdaptorClient.class);

    public static void main(String[] args) {

        LOG.info("Program start!");

        AdaptorMessageService adaptorMessageService = new AdaptorMessageService();
        adaptorMessageService.readAndWriteMessage();

        LOG.info("End of program!");
    }
}