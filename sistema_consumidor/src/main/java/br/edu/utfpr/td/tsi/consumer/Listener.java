package br.edu.utfpr.td.tsi.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Listener {
	
	@RabbitListener(queues = "transacoes.financeiras")
	public void listen(String in) {
	    processarTransacao(in);
	}
	
	public void processarTransacao(String in) {
		try
		{
		    Thread.sleep(1000);
		    System.out.println(in);
		}
		catch(InterruptedException ex)
		{
		    Thread.currentThread().interrupt();
		}
		
	}
	
}


