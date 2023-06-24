package br.edu.utfpr.td.tsi.consumer;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
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

    @Bean
    public FanoutExchange fanout() {
        FanoutExchange fanout = new FanoutExchange(
                "transacoes.suspeitas",
                true,
                false);

        amqpAdmin.declareExchange(fanout);

        return fanout;
    }

    @Bean
    public Queue filaPF() {
        Queue filaPF = new Queue("policia.federal");
        amqpAdmin.declareQueue(filaPF);
        return filaPF;
    }

    @Bean
    public Queue filaRF() {
        Queue filaRF = new Queue("receita.federal");
        amqpAdmin.declareQueue(filaRF);
        return filaRF;
    }

    @Bean
    public Binding bindingPF(FanoutExchange fanout, Queue filaPF) {
        Binding bindingPF = BindingBuilder.bind(filaPF).to(fanout);
        amqpAdmin.declareBinding(bindingPF);
        return bindingPF;
    }

    @Bean
    public Binding bindingRF(FanoutExchange fanout, Queue filaRF) {
        Binding bindingRF = BindingBuilder.bind(filaRF).to(fanout);
        amqpAdmin.declareBinding(bindingRF);
        return bindingRF;
    }
}
