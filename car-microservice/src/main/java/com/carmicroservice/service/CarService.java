package com.carmicroservice.service;

import com.carmicroservice.models.Car;
import java.util.List;

/**
 *
 * @author david
 */
public interface CarService {
    List<Car> getAllCar();
    Car findCarById(long id);
    Car saveCar(Car car);
    List<Car> findbyUserId(long id);
}
