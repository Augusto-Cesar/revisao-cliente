package com.augusto.revisao.cliente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.augusto.revisao.cliente.service.QuoteService;

@SpringBootApplication
public class RevisaoClienteApplication {

	public static void main(String[] args) {
		SpringApplication.run(RevisaoClienteApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	@Bean
	public QuoteService getQuoteService() {
		return new QuoteService();
	}
}
