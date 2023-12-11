package edu.co.sena.secretario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@SpringBootApplication
public class SecretarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecretarioApplication.class, args);
	}

}
