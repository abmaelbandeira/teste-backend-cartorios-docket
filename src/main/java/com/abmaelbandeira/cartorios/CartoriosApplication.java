package com.abmaelbandeira.cartorios;

import com.abmaelbandeira.cartorios.model.Cartorio;
import com.abmaelbandeira.cartorios.repository.CartorioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CartoriosApplication {

	public static void main(String[] args) {
		SpringApplication.run(CartoriosApplication.class, args);
	}


	@Bean
	CommandLineRunner runner(CartorioRepository cartorioRepository){
		return args -> {
			cartorioRepository.save(new Cartorio("Cartório 1", "Rua projetada"));
		};
	}


}
