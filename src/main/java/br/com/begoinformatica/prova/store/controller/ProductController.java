package br.com.begoinformatica.prova.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.begoinformatica.prova.store.entity.Product;
import br.com.begoinformatica.prova.store.services.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService service;

	@GetMapping("/products")
	public List<?> all() {
		return service.products();
	}

	@GetMapping("/product/{name}")
	public Product product(@PathVariable String name) {
		return service.product(name);
	}

	@PostMapping("/product")
	public HttpStatus add(@RequestBody Product product) {
		service.add(product);
		return HttpStatus.OK;
	}

	@DeleteMapping("/remove/{name}")
	public HttpStatus remove(@PathVariable String name) {
		service.delete(name);
		return HttpStatus.OK;
	}

}
