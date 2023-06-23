package br.edu.utfpr.td.tsi.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.google.gson.Gson;

@SpringBootApplication
@ComponentScan("br.edu.utfpr.td.tsi.consumer")
public class TransacoesConsumerApp {

	@Bean
	public Gson gson() {
		return new Gson();
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(TransacoesConsumerApp.class, args);
	}
	
}
