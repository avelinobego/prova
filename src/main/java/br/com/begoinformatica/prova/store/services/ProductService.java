package br.com.begoinformatica.prova.store.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.begoinformatica.prova.store.entity.Product;
import br.com.begoinformatica.prova.store.gateway.ProductGateway;

@Service
public class ProductService {
	@Autowired
	private ProductGateway productGateway;

	public List<?> products() {
		return productGateway.products();
	}

	public Product product(String name) {
		Optional<Product> product = productGateway.product(name);
		if (product.isPresent()) {
			return product.get();
		} else {
			return null;
		}
	}

	public void add(Product product) {
		productGateway.add(product);
	}

	public void delete(String name) {
		productGateway.delete(name);
	}

}
