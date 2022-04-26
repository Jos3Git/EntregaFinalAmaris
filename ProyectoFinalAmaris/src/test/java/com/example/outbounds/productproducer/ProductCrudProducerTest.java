package com.example.outbounds.productproducer;

import com.example.commons.constans.Constants;
import lombok.AllArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;

import java.time.LocalTime;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class ProductCrudProducerTest {

  String MESSAGE = "desde test";

  @Mock
  KafkaTemplate<String, String> kafkaTemplate;

  @InjectMocks
  ProductCrudProducer productCrudProducer;

  @Test
  void generateTiles() {

    productCrudProducer.generateTiles(MESSAGE);

    Assertions.assertNotNull(kafkaTemplate);
  }

}