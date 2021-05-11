
package com.ybc.orden.services;

import com.ybc.orden.entities.EstadoOrden;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.ybc.orden.repositories.EstadoOrdenRepository;

@Component
public class EstadoOrdenServiceImpl {
    
    @Autowired
    private EstadoOrdenRepository detalleOrdenRepository;
    
    @Transactional(readOnly = true)
    public Iterable<EstadoOrden> findAll() {

        return detalleOrdenRepository.findAll();

    }

    @Transactional(readOnly = true)
    public Optional<EstadoOrden> findById(Integer id) {
        
        return detalleOrdenRepository.findById(id);
                
    }

    @Transactional
    public EstadoOrden save(EstadoOrden detalleOrden) {
        
        return detalleOrdenRepository.save(detalleOrden);
        
    }

    @Transactional
    public void deleteById(Integer id) {
        
        detalleOrdenRepository.deleteById(id);
        
    }
}