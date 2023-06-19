package br.edu.utfpr.td.cotsi.exchange.consumer.fila1;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Listener {

	@RabbitListener(queues = "exemplo.exchange.fila1")
	public void listen(String in) {
		System.out.println(in);
	}
}

