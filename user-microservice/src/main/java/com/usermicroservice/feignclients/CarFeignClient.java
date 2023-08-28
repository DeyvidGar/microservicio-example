/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usermicroservice.feignclients;

//indicamos el nombre del servicio y la url del microservicio

import com.usermicroservice.models.Car;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "car-microservice", url = "http://localhost:8082", path = "/car")
//@RequestMapping("/car")
public interface CarFeignClient {
    
    //creamos el metodo del cliente:
    @PostMapping
    Car saveCar(@RequestBody Car car);
    
    @GetMapping("/user/{id}")
    public List<Car> getCarsByUser( @PathVariable long id );
    
}
