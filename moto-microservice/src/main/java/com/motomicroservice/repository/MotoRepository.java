/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.motomicroservice.repository;

import com.motomicroservice.models.Moto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author david
 */
@Repository
public interface MotoRepository extends JpaRepository<Moto, Long>{
    List<Moto> findByUserId(long id);
}
