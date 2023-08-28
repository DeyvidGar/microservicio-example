package com.carmicroservice.service.impl;

import com.carmicroservice.CarRepository.CarRepository;
import com.carmicroservice.models.Car;
import com.carmicroservice.service.CarService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author david
 */
@Service
public class CarServiceImpl implements CarService{
    
    @Autowired
    private CarRepository carRepository;

    @Override
    public List<Car> getAllCar() {
        return this.carRepository.findAll();
    }

    @Override
    public Car findCarById(long id) {
        return this.carRepository.findById(id).get();
    }

    @Override
    public Car saveCar(Car car) {
        return this.carRepository.save(car);
    }

    @Override
    public List<Car> findbyUserId(long id) {
        return this.carRepository.findByUserId(id);
    }
    
}
