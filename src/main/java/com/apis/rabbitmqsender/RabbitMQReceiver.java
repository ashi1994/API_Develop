package com.apis.rabbitmqsender;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.apis.model.UserDBMapping;


@Service
public class RabbitMQReceiver {
	
	@Component
	public class Consumer {
	 
		@RabbitListener(queues="${javainuse.rabbitmq.queue}")
	    public void recievedMessage(UserDBMapping us) {
			System.out.println("Received msg = " + us);
	    }
	}
}
