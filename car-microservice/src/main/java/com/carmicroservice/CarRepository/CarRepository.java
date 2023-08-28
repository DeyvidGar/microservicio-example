package com.carmicroservice.CarRepository;

import com.carmicroservice.models.Car;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author david
 */
@Repository
public interface CarRepository extends JpaRepository<Car, Long>{
    List<Car> findByUserId(long id);
}
