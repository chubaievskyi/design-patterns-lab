package com.chubaievskyi.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger LOG = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        LOG.info("Program start!");

        MessageService messageService = new MessageService();
        messageService.readAndWriteMessage();

        LOG.info("End of program!");
    }
}