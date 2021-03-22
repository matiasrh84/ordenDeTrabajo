
package com.ybc.orden.services;

import com.ybc.orden.entities.Equipo;
import java.util.Optional;


public interface EquipoService {

    public Iterable<Equipo> findAll();
    public Optional<Equipo> findById(Integer id);
    public Equipo save(Equipo equipo);
    public void deleteById(Integer id);
    
}
