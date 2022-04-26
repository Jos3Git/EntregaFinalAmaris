package com.example.inbounds.consumerprice;

import com.example.domain.vos.Brand;
import com.example.domain.vos.Price;
import com.example.domain.vos.Product;
import com.example.inbounds.ports.PriceInPort;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ConsumerTest {

  @Mock
  private ObjectMapper mapper;

  @Mock
  private PriceInPort priceInPort;

  @InjectMocks
  private Consumer consumer;

  @Test
  void processConsumer() throws JsonProcessingException {
    ConsumerRecord<String, String> consumerRecord = new ConsumerRecord<String, String>("topic", 1, 1L, "1", "test");

    when(mapper.readValue(consumerRecord.value(), Report.class)).thenReturn(new Report(1L, 1, 100D));

    when(priceInPort.findByProductIdAndPriceListAndUpdate(Mockito.any(), Mockito.any(), Mockito.any()))
        .thenReturn(new Price("1", LocalDateTime.now(), LocalDateTime.now(), 1, 1, 12D, "EUR", new Brand(), new Product()));

    consumer.processConsumer(consumerRecord);

    verify(priceInPort).findByProductIdAndPriceListAndUpdate(Mockito.any(), Mockito.any(), Mockito.any());
    verify(mapper).configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
  }
}