package br.edu.utfpr.td.tsi.transaction;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
	@Autowired
	private AmqpAdmin amqpAdmin;
    
    @Bean
    public Queue filaTransacoes() {
        Queue filaTransacoes = new Queue("transacoes.financeiras", true);
		amqpAdmin.declareQueue(filaTransacoes);
        return filaTransacoes;
    }
}
