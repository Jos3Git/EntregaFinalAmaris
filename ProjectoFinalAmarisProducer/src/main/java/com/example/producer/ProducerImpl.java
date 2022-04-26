package com.example.producer;

import com.example.constants.Constants;
import lombok.AllArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
@AllArgsConstructor
public class ProducerImpl implements Producer{

    static Logger log = LoggerFactory.getLogger(ProducerImpl.class);

    KafkaTemplate<String,String> kafkaTemplate;

    public  void generateTiles(String tile){

        kafkaTemplate.send(new ProducerRecord<String,String>(Constants.topic1, LocalTime.now().toString(),tile));

    }
}
