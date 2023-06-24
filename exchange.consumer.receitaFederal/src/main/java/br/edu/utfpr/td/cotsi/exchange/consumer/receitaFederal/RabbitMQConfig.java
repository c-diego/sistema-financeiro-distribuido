package br.edu.utfpr.td.cotsi.exchange.consumer.receitaFederal;

import javax.annotation.PostConstruct;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;

public class RabbitMQConfig {

    @Autowired
    private AmqpAdmin amqpAdmin;

    @PostConstruct
    public void configurarCanais() {
        Queue fila = new Queue("receita.federal", true);
        amqpAdmin.declareQueue(fila);
    }

}
