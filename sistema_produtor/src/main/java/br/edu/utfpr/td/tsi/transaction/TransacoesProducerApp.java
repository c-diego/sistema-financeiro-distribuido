package br.edu.utfpr.td.tsi.transaction;

import java.util.List;


import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
@ComponentScan("br.edu.utfpr.td.tsi.transaction")
public class TransacoesProducerApp {

	@Autowired
	private AmqpAdmin amqpAdmin;

	@Autowired
	private RabbitTemplate rabbitTemplate;

	private Queue filaTransacoes;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(TransacoesProducerApp.class, args);
	}

	@PostConstruct
	public void criarFila() {
		filaTransacoes = new Queue("transacoes.financeiras", true);
		amqpAdmin.declareQueue(filaTransacoes);
		processarArquivotransacoes();
	}

	public void processarArquivotransacoes() {
		List<Transacao> transacoes = new LeitorArquivo().lerArquivo();
		for (Transacao transacao : transacoes) {
			rabbitTemplate.convertAndSend(this.filaTransacoes.getName(), transacao.toString());
		}
	}
}
