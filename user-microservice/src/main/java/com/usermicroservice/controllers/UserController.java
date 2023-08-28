package com.usermicroservice.controllers;

import com.usermicroservice.entity.User;
import com.usermicroservice.models.Car;
import com.usermicroservice.models.Moto;
import com.usermicroservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> listAllUser() {
        List<User> list = this.userService.getAllUser();
        if(list == null) return ResponseEntity.noContent().build();
        else return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findUserById(@PathVariable long id) {
        User user = this.userService.findUserById(id);
        if(user == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> saveUser( @RequestBody User user) {
        return ResponseEntity.ok( this.userService.saveUser(user) );
    }
    
    @GetMapping("/car/{userId}")
    public ResponseEntity<List<Car>> listAllCarOfUser(@PathVariable long userId) {
        User user = this.userService.findUserById(userId);
        if ( user == null ) return ResponseEntity.notFound().build();
        return ResponseEntity.ok( this.userService.listAllCar(userId));
    }
    
    @GetMapping("/moto/{userId}")
    public ResponseEntity<List<Moto>> listAllMotoOfUser(@PathVariable long userId) {
        User user = this.userService.findUserById(userId);
        if ( user == null ) return ResponseEntity.notFound().build();
        return ResponseEntity.ok( this.userService.listAllMoto(userId));
    }
    
    @PostMapping("/car/{userId}")
    public ResponseEntity<Car> saveCar(@PathVariable long userId, @RequestBody Car car) {
        return ResponseEntity.ok( this.userService.saveCar(userId, car));
    }
    
    @PostMapping("/moto/{userId}")
    public ResponseEntity<Moto> saveCar(@PathVariable long userId, @RequestBody Moto moto) {
        return ResponseEntity.ok( this.userService.saveMoto(userId, moto) );
    }
    
    @GetMapping("/{id}/vehicles")
    public ResponseEntity<Map<String, Object>> getAllVehiclesByUser(@PathVariable long id) {
        return ResponseEntity.ok( this.userService.getByUserAllVehicles(id));
    }
}
