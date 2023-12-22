package com.chubaievskyi.strategy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class StrategyMessageServiceTest {

    @Mock
    private FileWriter mockFileWriter;

    @InjectMocks
    private StrategyMessageService strategyMessageService;

    @Test
    void readMessage() {

        String message = strategyMessageService.readMessage();
        assertEquals("Hello world!!!", message);
    }

    @Test
    void writeMessage() throws IOException {

        String messageText = "Test Message";

        strategyMessageService.writeMessage(messageText, mockFileWriter);

        verify(mockFileWriter, times(1)).write(anyString());

    }
}