
package com.ybc.orden.services;

import com.ybc.orden.entities.Orden;
import java.util.Optional;


public interface OrdenService {

    public Iterable<Orden> findAll();
    public Optional<Orden> findById(Integer id);
    public Orden save(Orden orden);
    public void deleteById(Integer id);
    
}
