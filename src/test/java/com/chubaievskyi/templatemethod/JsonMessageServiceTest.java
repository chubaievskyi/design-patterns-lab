package com.chubaievskyi.templatemethod;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class JsonMessageServiceTest {

    @Mock
    private FileWriter mockFileWriter;

    @InjectMocks
    private JsonMessageService jsonMessageService;

    @Test
    void readMessage() {

        String message = jsonMessageService.readMessage();
        assertEquals("Hello world!!!", message);
    }

    @Test
    void writeMessage() throws IOException {

        JsonMessageService jsonMessageService = new JsonMessageService(mockFileWriter);

        jsonMessageService.writeMessage("test", "testFilePath");

        verify(mockFileWriter).write(anyString());
        verify(mockFileWriter).flush();
    }

    @Test
    void getFilePath() {

        String filePath = jsonMessageService.getFilePath();
        assertEquals(".template-method-recorded-files/json_message_output.json!!!", filePath);
    }
}