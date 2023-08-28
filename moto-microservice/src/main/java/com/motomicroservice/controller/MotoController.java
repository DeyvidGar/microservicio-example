package com.motomicroservice.controller;

import com.motomicroservice.models.Moto;
import com.motomicroservice.service.MotoService;
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
@RequestMapping("/moto")
public class MotoController {
    @Autowired
    private MotoService motoService;
    
    @GetMapping
    public ResponseEntity<List<Moto>> listAllMoto() {
        return ResponseEntity.ok(this.motoService.getAllMoto() );
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Moto> findMotoById(@PathVariable long id) {
        return ResponseEntity.ok( this.motoService.getMotoById(id) );
    }
    
    @PostMapping
    public ResponseEntity<Moto> saveMoto(@RequestBody Moto Moto) {
        return ResponseEntity.ok( this.motoService.saveMoto(Moto) );
    }
    
    @GetMapping("/user/{id}")
    public ResponseEntity<List<Moto>> listAllMotoByUserId(@PathVariable long id) {
        return ResponseEntity.ok( this.motoService.getListMotoByUserId(id) );
    }
}
