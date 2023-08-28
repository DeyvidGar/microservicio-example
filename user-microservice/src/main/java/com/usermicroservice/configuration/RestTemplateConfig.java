package com.usermicroservice.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * clase que genera bean de confiracion para comunicar los microservicios 'hijos' ya qeu user se relacion con los otros microservicios
 * @author david
 */
@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    
}
