package br.edu.utfpr.td.cotsi.exchange.consumer.policiaFederal;

import javax.annotation.PostConstruct;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Autowired
    private AmqpAdmin amqpAdmin;

    @PostConstruct
    public void configurarCanais() {
        Queue fila = new Queue("policia.federal", true);
        amqpAdmin.declareQueue(fila);
    }

}
