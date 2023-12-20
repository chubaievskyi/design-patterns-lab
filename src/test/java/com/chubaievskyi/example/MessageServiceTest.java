package com.chubaievskyi.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class MessageServiceTest {

    @Mock
    private FileWriter mockFileWriter;

    @Mock
    private ObjectMapper mockObjectMapper;

    @Mock
    private ObjectWriter mockObjectWriter;

    @InjectMocks
    private MessageService messageService;

    @Test
    void testWriteMessage() throws IOException {

        String messageText = "Test Message";

        when(mockObjectMapper.writerWithDefaultPrettyPrinter()).thenReturn(mockObjectWriter);
        when(mockObjectWriter.writeValueAsString(any(Message.class))).thenReturn(messageText);

        MessageService messageService = new MessageService();

        messageService.writeMessage(messageText, mockFileWriter, mockObjectMapper);

        verify(mockFileWriter, times(1)).write(anyString());

    }

    @Test
    void testReadMessage() {

        String message = messageService.readMessage();
        assertEquals("Hello world!!!", message);
    }

    @Test
    void testGetFilePath() {

        String filePath = messageService.getFilePath();
        assertEquals(".example-recorded-files/xml_message_output.xml!!!", filePath);
    }
}