package com.example.outbounds.productproducer;

import com.example.commons.constans.Constants;
import com.example.outbounds.ports.ProductCrudProducerOutPort;
import lombok.AllArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
@AllArgsConstructor
public class ProductCrudProducer implements ProductCrudProducerOutPort {

  private KafkaTemplate<String, String> kafkaTemplate;

  @Override
  public void generateTiles(final String tile) {
    this.kafkaTemplate.send(new ProducerRecord<String, String>(Constants.TOPIC1, LocalTime.now().toString(), tile));

  }

}
