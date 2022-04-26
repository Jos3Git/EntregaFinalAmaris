package com.example.controller;

import com.example.producer.Producer;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class RestConsole {

    Producer producer;

    @GetMapping("/producer")
    public void sendReport(@RequestBody String tile){
        producer.generateTiles(tile);
    }


}
