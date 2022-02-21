package de.hsm.exam.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductManager {
	private List<Product> products;

	public ProductManager() {
		products = new ArrayList<>();
		products.add(new Product("iphone 12", "Apple", 162));
		products.add(new Product("Galaxy S20 FE", "Samsung", 190));
		products.add(new Product("Xperia 1E", "Sony", 181));
		products.add(new Product("Moto G9", "Motorola", 200));
	}
	
	public List<Product> findProducts(String text){
		return products.stream().filter((product -> product.getName().contains(text)))
				.collect(Collectors.toList());
	}
	
}
