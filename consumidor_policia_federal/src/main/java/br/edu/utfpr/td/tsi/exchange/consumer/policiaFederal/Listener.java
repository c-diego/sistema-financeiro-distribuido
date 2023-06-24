package br.edu.utfpr.td.tsi.exchange.consumer.policiaFederal;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

@Component
public class Listener {
	@Autowired
	Gson gson;

	@RabbitListener(queues = "policia.federal")
	public void listen(String in) {
		processarTransacao(in);
	}

	private void processarTransacao(String in) {

		Transacao transacao = gson.fromJson(in, Transacao.class);
		System.out.println(transacao);

	}
}
