package com.kafka.Springbootkafkatutorial.controller;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.Springbootkafkatutorial.kafka.kafkaProducer;

@RestController
@RequestMapping("/api/v1/kafka")
public class messageController {
	
	private kafkaProducer kafkaProducer;
	
	public messageController(kafkaProducer kafkaProducer) {
		this.kafkaProducer = kafkaProducer;
	}
	
	@GetMapping("/publish")
	public ResponseEntity<String> publish(@RequestParam("message") String message){
		kafkaProducer.sendMessage(message);
		return ResponseEntity.ok("message sent to the topic");
	}

}
