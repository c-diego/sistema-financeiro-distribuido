package br.edu.utfpr.td.cotsi.exchange.producer;

import javax.annotation.PostConstruct;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Producer {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	private FanoutExchange fanout = new FanoutExchange("exemplo.exchange.fanout", true, false);

	@PostConstruct
	public void enviarEventosTeste() {
		for (int i = 0; i < 20; i++) {
			String msg = String.format("Evento codigo: %s", i);
			System.out.println(msg);
			rabbitTemplate.convertAndSend(fanout.getName(), "", msg);
		}
	}
}
