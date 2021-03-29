
package com.ybc.orden.services;

import com.ybc.orden.entities.Orden;
import com.ybc.orden.repositories.OrdenRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("OrdenService")
public class OrdenServiceImpl implements OrdenService{

    @Autowired
    private OrdenRepository ordenRepository;
    
    @Override
    @Transactional(readOnly = true)
    public Iterable<Orden> findAll() {
        
        return ordenRepository.findAll();
        
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Orden> findById(Integer id) {
        
        return ordenRepository.findById(id);
        
    }

    @Override
    @Transactional
    public Orden save(Orden orden) {
        
        return ordenRepository.save(orden);
        
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        
        ordenRepository.deleteById(id);
        
    }
    
}
