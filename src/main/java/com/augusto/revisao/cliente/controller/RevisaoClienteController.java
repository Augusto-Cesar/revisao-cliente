package com.augusto.revisao.cliente.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.augusto.revisao.cliente.entity.Quote;
import com.augusto.revisao.cliente.service.QuoteService;

@RestController
public class RevisaoClienteController {
	private RestTemplate template;
	private QuoteService quoteService;

	public RevisaoClienteController(RestTemplate template, QuoteService quoteService) {
		this.template = template;
		this.quoteService = quoteService;
	}
	
	@RequestMapping("/template")
	public String hello() {
		String message = this.template.getForObject("http://localhost:8080/revisao/", String.class);
		if (message.equalsIgnoreCase("teste")) {
			return "Teste ok!!!";
		} else {
			return "Erro no retorno!";
		}
	}
	
	@RequestMapping("/quote")
	public Quote getQuote() {
		return this.quoteService.getQuote();
	}
	
	@RequestMapping(value="/quote", method=RequestMethod.POST)
	public void addQuote(@RequestBody Quote quote) {
		this.quoteService.addQuote(quote);
	}
	
	
}
