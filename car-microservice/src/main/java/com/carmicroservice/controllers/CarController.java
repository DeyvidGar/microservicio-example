package com.carmicroservice.controllers;

import com.carmicroservice.models.Car;
import com.carmicroservice.service.CarService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author david
 */
@RestController
@RequestMapping("/car")
public class CarController {
    
    @Autowired
    private CarService carService;
    
    @GetMapping
    public ResponseEntity<List<Car>> listAllCar() {
        return ResponseEntity.ok(this.carService.getAllCar() );
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Car> findCarById(@PathVariable long id) {
        return ResponseEntity.ok( this.carService.findCarById(id) );
    }
    
    @PostMapping
    public ResponseEntity<Car> saveCar(@RequestBody Car car) {
        return ResponseEntity.ok( this.carService.saveCar(car) );
    }
    
    @GetMapping("/user/{id}")
    public ResponseEntity<List<Car>> listAllCarByUserId(@PathVariable long id) {
        return ResponseEntity.ok( this.carService.findbyUserId(id) );
    }
    
}
