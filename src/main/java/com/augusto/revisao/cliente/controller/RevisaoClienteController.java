package com.augusto.revisao.cliente.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RevisaoClienteController {
	private RestTemplate template;

	public RevisaoClienteController(RestTemplate template) {
		this.template = template;
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
}
