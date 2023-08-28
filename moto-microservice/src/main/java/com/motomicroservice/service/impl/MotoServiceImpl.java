package com.motomicroservice.service.impl;

import com.motomicroservice.models.Moto;
import com.motomicroservice.repository.MotoRepository;
import com.motomicroservice.service.MotoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author david
 */
@Service
public class MotoServiceImpl implements MotoService {

    @Autowired
    private MotoRepository motoRepository;

    @Override
    public List<Moto> getAllMoto() {
        return this.motoRepository.findAll();
    }

    @Override
    public Moto saveMoto(Moto moto) {
        return this.motoRepository.save(moto);

    }

    @Override
    public Moto getMotoById(long id) {
        return this.motoRepository.findById(id).get();

    }

    @Override
    public List<Moto> getListMotoByUserId(long id) {
        return this.motoRepository.findByUserId(id);
    }

}
