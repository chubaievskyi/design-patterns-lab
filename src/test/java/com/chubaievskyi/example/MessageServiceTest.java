package com.chubaievskyi.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.FileWriter;
import java.io.IOException;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MessageServiceTest {

    private InputReader inputReader;

    @Mock
    private ObjectMapper objectMapper;

    @Mock
    private ObjectWriter objectWriter;

    @Mock
    private FileWriter fileWriter;

    @InjectMocks
    private MessageService messageService;

    private String message;

    @BeforeEach
    void setUp() {
        message = inputReader.getMessage();
    }

    @Test
    void testReadAndWriteMessage() throws IOException {

        when(objectMapper.writerWithDefaultPrettyPrinter()).thenReturn(objectWriter);
        when(objectWriter.writeValueAsString(new Message(message))).thenReturn("<Message><messageText>" + message + "</messageText></Message>");
        doNothing().when(fileWriter).write(anyString());
        doNothing().when(fileWriter).close();

        messageService.readAndWriteMessage();

        verify(inputReader, times(1)).getMessage();
        verify(fileWriter, times(1)).write("<Message><messageText>" + message + "</messageText></Message>");
    }
}