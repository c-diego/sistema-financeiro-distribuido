package br.edu.utfpr.td.tsi.transaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.google.gson.Gson;

@SpringBootApplication
@ComponentScan("br.edu.utfpr.td.tsi.transaction")
public class TransacoesProducerApp {

	@Bean
	public Gson gson() {
		return new Gson();
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(TransacoesProducerApp.class, args);
	}
}
