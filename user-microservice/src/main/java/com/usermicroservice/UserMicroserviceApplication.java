package com.usermicroservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

//indicamos con anotacion que este proyecto va a llamar a otros microservicios
@EnableFeignClients
@SpringBootApplication
public class UserMicroserviceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(UserMicroserviceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("UserMicroserviceApplication.run");
	}
}
