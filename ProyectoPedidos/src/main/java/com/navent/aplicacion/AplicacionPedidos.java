package com.navent.aplicacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.navent.*")
@EnableJpaRepositories("com.navent.*")
@EntityScan("com.navent.*")
public class AplicacionPedidos extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(AplicacionPedidos.class, args);
	}
}
