package com.example.controller;

import com.example.producer.Producer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RestConsoleTest {
    String MESSAGE = "desde test";

    @Mock
    Producer producer;

    @InjectMocks
    RestConsole console;

    @Test
    void sendReport() {
        doNothing().when(producer).generateTiles(Mockito.any());

        console.sendReport(MESSAGE);

        verify(producer).generateTiles(Mockito.any());
    }
}