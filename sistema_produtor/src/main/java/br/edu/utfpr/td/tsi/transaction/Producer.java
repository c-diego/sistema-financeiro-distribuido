package br.edu.utfpr.td.tsi.transaction;

import java.util.List;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import jakarta.annotation.PostConstruct;

@Component
public class Producer {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    
    @Autowired
    private Queue filaTransacoes;

    @Autowired
    private Gson gson;

    @PostConstruct
    public void processarArquivotransacoes() {
        List<Transacao> transacoes = new LeitorArquivo().lerArquivo();

        for (Transacao transacao : transacoes) {
            String transacaoJson = gson.toJson(transacao);

            rabbitTemplate.convertAndSend(this.filaTransacoes.getName(), transacaoJson);
        }
    }
}
