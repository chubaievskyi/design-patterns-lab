package com.chubaievskyi.adapter;

import com.chubaievskyi.example.Message;
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
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AdaptorMessageServiceTest {

    @Mock
    private FileWriter mockFileWriter;

    @Mock
    private ObjectMapper mockObjectMapper;

    @Mock
    private ObjectWriter mockObjectWriter;

    @InjectMocks
    private AdaptorMessageService adaptorMessageService;

    @Test
    void testWriteMessage() throws IOException {

        String messageText = "Test Message";

        when(mockObjectMapper.writerWithDefaultPrettyPrinter()).thenReturn(mockObjectWriter);
        when(mockObjectWriter.writeValueAsString(any(Message.class))).thenReturn(messageText);

        adaptorMessageService.writeMessage(messageText, mockFileWriter, mockObjectMapper);

        verify(mockFileWriter, times(1)).write(anyString());
    }

    @Test
    void testGetFilePath() {

        String filePath = adaptorMessageService.getFilePath();
        assertEquals(".adaptor-recorded-files/xml_message_output.xml!!!", filePath);
    }
}