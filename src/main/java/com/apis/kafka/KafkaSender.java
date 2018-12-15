package com.apis.kafka;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Component
public class KafkaSender {
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	public void send(String topic, String payload) {
        kafkaTemplate.send(topic, payload);
        System.out.println("Message: "+payload+" sent to topic: "+topic);
}
}