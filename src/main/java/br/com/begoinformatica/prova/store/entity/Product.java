package br.com.begoinformatica.prova.store.entity;

import java.math.BigDecimal;

public class Product {
	private String name;
	private BigDecimal price;

	public Product() {
		super();
	}

	public Product(String name, BigDecimal price) {
		super();
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String descricao) {
		this.name = descricao;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPice(BigDecimal valor) {
		this.price = valor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
