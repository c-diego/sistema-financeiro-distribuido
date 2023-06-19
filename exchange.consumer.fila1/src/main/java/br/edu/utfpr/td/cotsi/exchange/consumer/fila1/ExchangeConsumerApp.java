package br.edu.utfpr.td.cotsi.exchange.consumer.fila1;

import javax.annotation.PostConstruct;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("br.edu.utfpr.td.cotsi.exchange")
public class ExchangeConsumerApp {

	@Autowired
	private AmqpAdmin amqpAdmin;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ExchangeConsumerApp.class, args);
	}

	@PostConstruct
	public void configurarCanais() {
		Queue fila1 = new Queue("exemplo.exchange.fila1", true);
		amqpAdmin.declareQueue(fila1);		
	}
}
