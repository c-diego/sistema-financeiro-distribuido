package br.edu.utfpr.td.tsi.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

@Component
public class Listener {

	@Autowired
	private Gson gson;
	@Autowired
	private Producer producer;

	@RabbitListener(queues = "transacoes.financeiras")
	public void listen(String in) {
		processarTransacao(in);
	}

	private void processarTransacao(String in) {
		try {
			Thread.sleep(1000);

			Transacao transacao = gson.fromJson(in, Transacao.class);
			System.out.println(transacao);

			if (transacao.getValor() > 40000) {
				producer.enviarTransacaoSuspeita(transacao);
			}
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}

	}

}
