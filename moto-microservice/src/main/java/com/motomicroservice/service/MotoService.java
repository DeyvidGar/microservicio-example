package com.motomicroservice.service;

import com.motomicroservice.models.Moto;
import java.util.List;

/**
 *
 * @author david
 */
public interface MotoService {
    List<Moto> getAllMoto();
    Moto saveMoto(Moto moto);
    Moto getMotoById(long id);
    List<Moto> getListMotoByUserId(long id);
}
