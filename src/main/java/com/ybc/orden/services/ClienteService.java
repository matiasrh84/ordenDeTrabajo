
package com.ybc.orden.services;

import com.ybc.orden.entities.Cliente;
import java.util.Optional;


public interface ClienteService {
    
    public Iterable<Cliente> findAll();
    public Optional<Cliente> findById(Integer id);
    public Cliente save(Cliente cliente);
    public void deleteById(Integer id);
    
}
