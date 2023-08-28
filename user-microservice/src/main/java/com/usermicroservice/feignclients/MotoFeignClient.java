package com.usermicroservice.feignclients;

import com.usermicroservice.models.Moto;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author david
 */
@FeignClient(value = "moto-microservice", url = "http://localhost:8083", path = "/moto")
public interface MotoFeignClient {
    
    @PostMapping
    public Moto saveMoto( @RequestBody Moto moto );
    
    @GetMapping("/user/{id}")
    public List<Moto> getMotosByUser( @PathVariable long id );
    
}
