package com.example.producer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class ProducerImplTest {

    String MESSAGE = "desde test";

    @Mock
    KafkaTemplate<String,String> kafkaTemplate;

    @InjectMocks
    ProducerImpl producer;

    @Test
    void generateTiles() {
        producer.generateTiles(MESSAGE);

        Assertions.assertNotNull(kafkaTemplate);
    }
}