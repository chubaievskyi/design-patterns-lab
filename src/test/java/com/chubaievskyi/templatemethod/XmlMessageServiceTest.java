package com.chubaievskyi.templatemethod;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class XmlMessageServiceTest {

    @Mock
    private FileWriter mockFileWriter;

    @InjectMocks
    private XmlMessageService xmlMessageService;

    @Test
    void readMessage() {

        String message = xmlMessageService.readMessage();
        assertEquals("Hello world!!!", message);
    }

    @Test
    void writeMessage() throws IOException {

        XmlMessageService xmlMessageService = new XmlMessageService(mockFileWriter);

        xmlMessageService.writeMessage("test", "testFilePath");

        verify(mockFileWriter).write(anyString());
        verify(mockFileWriter).flush();
    }

    @Test
    void getFilePath() {

        String filePath = xmlMessageService.getFilePath();
        assertEquals(".template-method-recorded-files/xml_message_output.xml!!!", filePath);
    }
}