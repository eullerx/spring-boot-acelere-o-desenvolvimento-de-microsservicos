package br.com.eullerx.springbootproperties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SpringbootpropertiesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootpropertiesApplication.class, args);
	}

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringbootpropertiesApplication.class);
	}
	
}
