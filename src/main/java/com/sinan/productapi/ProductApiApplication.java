package com.sinan.productapi;

import com.sinan.productapi.models.Product;
import com.sinan.productapi.repositories.ProductRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProductApiApplication {

	@Autowired
	private transient ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProductApiApplication.class, args);
	}

	@Bean
	InitializingBean sendDatabase() {
		return () -> {
			productRepository.save(new Product(1, "IPHONE X", 15));
			productRepository.save(new Product(2, "SAMSUNG 10", 10));
			productRepository.save(new Product(3, "ONEPLUS 9T PRO", 25));
		};
	}
}
