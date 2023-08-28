package com.usermicroservice.service.impl;

import com.usermicroservice.entity.User;
import com.usermicroservice.feignclients.CarFeignClient;
import com.usermicroservice.feignclients.MotoFeignClient;
import com.usermicroservice.models.Car;
import com.usermicroservice.models.Moto;
import com.usermicroservice.repositories.UserRepository;
import com.usermicroservice.service.UserService;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserRepository userRepository;
    
    //inject las clase de microservicio
    @Autowired
    private CarFeignClient carFeignClient;
    
    @Autowired
    private MotoFeignClient motoFeignClient;
    
    @Override
    public User saveUser(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return this.userRepository.findAll();
    }

    @Override
    public User findUserById(long id) {
        return this.userRepository.findById(id).orElse(null);
    }
    
    //Rest template
    @Override
    public List<Car> listAllCar(long id) {
        String url = "http://localhost:8082/car/user/"+id;
        return this.restTemplate.getForObject(url, List.class);
    }
    
    @Override
    public List<Moto> listAllMoto(long id) {
        String url = "http://localhost:8083/car/user/"+id;
        return this.restTemplate.getForObject(url, List.class);
    }
    
    //metodo que utiliza el servicio
    @Override
    public Car saveCar(long userId, Car car) {
        car.setUserId(userId);
        return this.carFeignClient.saveCar(car);
    }

    @Override
    public Moto saveMoto(long userId, Moto moto) {
        moto.setUserId(userId);
        return this.motoFeignClient.saveMoto(moto);
    }

    @Override
    public Map<String, Object> getByUserAllVehicles(long userId) {
        Map<String, Object> result = new HashMap<>();
        User user = this.userRepository.findById(userId).orElse(null);
        
        if( user == null ) {
            result.put("Message", "This user not exist.");
            return result;
        }
        
        List<Car> cars = this.carFeignClient.getCarsByUser(userId);
        
        if ( cars.isEmpty() ) {
            result.put("Cars", "This user not have cars yet.");
        } else {
            result.put("Cars", cars);
        }
        
        List<Moto> motos = this.motoFeignClient.getMotosByUser(userId);
        
        if ( motos.isEmpty() ) {
            result.put("Motos", "This user not have motos yet.");
        } else {
            result.put("Motos", motos);
        }
        
        return result;
    }
        
}
