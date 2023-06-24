package br.edu.utfpr.td.cotsi.exchange.consumer.receitaFederal;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

@Component
public class Listener {

	@Autowired
	private Gson gson;

	@RabbitListener(queues = "receita.federal")
	public void listen(String in) {
		processarTransacao(in);
	}

	private void processarTransacao(String in) {

		Transacao transacao = gson.fromJson(in, Transacao.class);
		System.out.println(transacao);

	}
}
