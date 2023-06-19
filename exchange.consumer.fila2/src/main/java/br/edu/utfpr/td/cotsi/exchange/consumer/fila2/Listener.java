package br.edu.utfpr.td.cotsi.exchange.consumer.fila2;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Listener {

	@RabbitListener(queues = "exemplo.exchange.fila2")
	public void listen(String in) {
		System.out.println(in);
	}
}

