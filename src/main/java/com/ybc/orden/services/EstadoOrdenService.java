
package com.ybc.orden.services;

import com.ybc.orden.entities.EstadoOrden;
import java.util.Optional;


public interface EstadoOrdenService {
    
    public Iterable<EstadoOrden> findAll();
    public Optional<EstadoOrden> findById(Integer id);
    public EstadoOrden save(EstadoOrden detalleOrden);
    public void deleteById(Integer id);
}
