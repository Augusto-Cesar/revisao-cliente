package com.augusto.revisao.cliente;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.augusto.revisao.cliente.entity.Quote;
import com.augusto.revisao.cliente.service.QuoteService;

@SpringBootTest
class RevisaoClienteApplicationTests {
	
	QuoteService quoteService;
	
	@BeforeEach
	public void before() {
		this.quoteService = new QuoteService(); 
	}
	
	@Test
	public void testGetQuote() {
		this.quoteService.addQuote(new Quote("um quote", "Um Autor"));
		assertEquals("um quote", this.quoteService.getQuote().getValue());
	}
	
	@Test
	public void testGetQuoteMutiple() {
		this.quoteService.addQuote(new Quote("um quote", "Um Autor"));
		this.quoteService.addQuote(new Quote("outro quote", "Outro Autor"));
		assertTrue(
				"um quote".equals(this.quoteService.getQuote().getValue()) ||
				"outro quote".equals(this.quoteService.getQuote().getValue()));
	}

}

