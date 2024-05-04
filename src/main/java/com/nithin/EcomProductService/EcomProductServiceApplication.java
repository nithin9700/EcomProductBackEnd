package com.nithin.EcomProductService;

import jakarta.persistence.EntityManagerFactory;
import jdk.jfr.Enabled;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;




@SpringBootApplication
//@EnableSwagger2
public class EcomProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcomProductServiceApplication.class, args);
	}

}
