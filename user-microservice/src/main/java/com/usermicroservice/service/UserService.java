package com.usermicroservice.service;

import com.usermicroservice.entity.User;
import com.usermicroservice.models.Car;
import com.usermicroservice.models.Moto;

import java.util.List;
import java.util.Map;

public interface UserService {
    User saveUser(User user);
    List<User> getAllUser();
    User findUserById(long id);
    
    List<Car> listAllCar(long id);
    List<Moto> listAllMoto(long id);
    
    Car saveCar(long userId, Car car);
    Moto saveMoto(long userId, Moto moto);
    
    Map<String, Object> getByUserAllVehicles(long userId);
    
}
