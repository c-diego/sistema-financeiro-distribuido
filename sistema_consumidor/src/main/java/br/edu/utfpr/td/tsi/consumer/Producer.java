package br.edu.utfpr.td.tsi.consumer;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

@Component
public class Producer {

	@Autowired
	private RabbitTemplate rabbitTemplate;

    @Autowired
    private FanoutExchange fanout;

    @Autowired
    private Gson gson;

    public void enviarTransacaoSuspeita(Transacao transacao) {
        String transacaoJson = gson.toJson(transacao);
        rabbitTemplate.convertAndSend(fanout.getName(), "", transacaoJson);
    }
    
}
