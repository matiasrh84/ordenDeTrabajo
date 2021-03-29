
package com.ybc.orden.services;

import com.ybc.orden.entities.Equipo;
import com.ybc.orden.repositories.EquipoRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("EquipoService")
public class EquipoServiceImpl implements EquipoService{

    @Autowired
    private EquipoRepository equiporepository;
    
    @Override
    @Transactional(readOnly = true)
    public Iterable<Equipo> findAll() {
        
        return equiporepository.findAll();
        
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Equipo> findById(Integer id) {
        
        return equiporepository.findById(id);
        
    }

    @Override
    @Transactional
    public Equipo save(Equipo equipo) {
        
        return equiporepository.save(equipo);
        
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        
        equiporepository.deleteById(id);
        
    }
    
}
