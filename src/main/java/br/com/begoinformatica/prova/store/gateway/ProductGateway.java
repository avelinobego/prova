package br.com.begoinformatica.prova.store.gateway;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import br.com.begoinformatica.prova.store.entity.Product;

@Component
public class ProductGateway {

	private final List<Product> data = new ArrayList<>();

	@PostConstruct
	public void init() {
		for (int i = 1; i < 101; i++) {
			data.add(new Product("Produto " + i, new BigDecimal(i)));
		}
	}

	public List<?> products() {
		return data;
	}

	public Optional<Product> product(String name) {
		Optional<Product> any = data.stream().filter(e -> e.getName().equals(name)).findAny();
		return any;
	}

	public void add(Product product) {
		data.add(product);
	}

	public void delete(String name) {
		data.removeIf(p -> p.getName().equals(name));
	}

}
