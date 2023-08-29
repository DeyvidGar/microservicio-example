package com.usermicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

//indicamos con anotacion que este proyecto va a llamar a otros microservicios
@EnableFeignClients
@SpringBootApplication
@EnableEurekaClient
public class UserMicroserviceApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(UserMicroserviceApplication.class, args);
    }
}
