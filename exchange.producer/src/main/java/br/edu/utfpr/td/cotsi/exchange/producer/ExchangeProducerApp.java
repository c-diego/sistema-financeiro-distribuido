package br.edu.utfpr.td.cotsi.exchange.producer;

import javax.annotation.PostConstruct;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("br.edu.utfpr.td.cotsi.exchange")
public class ExchangeProducerApp {

	@Autowired
	private AmqpAdmin amqpAdmin;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ExchangeProducerApp.class, args);
	}

	@PostConstruct
	public void configurarCanais() {
		Queue fila1 = new Queue("exemplo.exchange.fila1", true);
		amqpAdmin.declareQueue(fila1);
		Queue fila2 = new Queue("exemplo.exchange.fila2", true);
		amqpAdmin.declareQueue(fila2);

		FanoutExchange fanout = new FanoutExchange("exemplo.exchange.fanout", true, false);
		amqpAdmin.declareExchange(fanout);
		Binding binding = BindingBuilder.bind(fila1).to(fanout);
		amqpAdmin.declareBinding(binding);
		binding = BindingBuilder.bind(fila2).to(fanout);
		amqpAdmin.declareBinding(binding);
	}
}
