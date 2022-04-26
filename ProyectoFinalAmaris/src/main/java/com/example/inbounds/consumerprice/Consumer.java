package com.example.inbounds.consumerprice;

import com.example.inbounds.ports.PriceInPort;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Consumer {

  private ObjectMapper mapper;

  private PriceInPort priceInPort;

  @KafkaListener(topics = { "proyectoFinalAmaris-topic-first" }) // Te obliga a poner el topic
  public void processConsumer(final ConsumerRecord<String, String> consumerRecord) throws JsonProcessingException {
    mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
    Report report = mapper.readValue(consumerRecord.value(), Report.class);
    priceInPort.findByProductIdAndPriceListAndUpdate(report.getProductid().toString(), report.getPricelistid(), report.getPrice());
  }
}