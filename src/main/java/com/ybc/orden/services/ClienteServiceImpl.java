package com.ybc.orden.services;

import com.ybc.orden.entities.Cliente;
import com.ybc.orden.repositories.ClienteRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional(readOnly = true)
    public Iterable<Cliente> findAll() {

        return clienteRepository.findAll();

    }

    @Transactional(readOnly = true)
    public Optional<Cliente> findById(Integer id) {
        
        return clienteRepository.findById(id);
                
    }

    @Transactional
    public Cliente save(Cliente cliente) {
        
        return clienteRepository.save(cliente);
        
    }

    @Transactional
    public void deleteById(Integer id) {
        
        clienteRepository.deleteById(id);
        
    }

}
