package br.com.begoinformatica.prova.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.begoinformatica.prova.store.entity.Product;
import br.com.begoinformatica.prova.store.services.ProductService;

@SpringBootTest
public class ProductServiceTets {

	@Autowired
	private ProductService service;

	@Test
	public void getAllTest() {
		List<?> products = service.products();
		assertFalse(products.isEmpty());
	}

	@Test
	public void deleteFirst() {
		service.delete("Produto 1");
		Product product = service.product("Produto 1");
		assertNull(product);
	}

	@Test
	public void add() {
		final BigDecimal price = new BigDecimal("13.99");
		service.add(new Product("Produto 200", price));
		Product product = service.product("Produto 200");
		assertTrue(product.getPrice().equals(price));
	}

}
