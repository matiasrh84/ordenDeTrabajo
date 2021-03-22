package com.ybc.orden.services;

import com.ybc.orden.entities.Cliente;
import com.ybc.orden.repositories.ClienteRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Cliente> findAll() {

        return clienteRepository.findAll();

    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Cliente> findById(Integer id) {
        
        return clienteRepository.findById(id);
                
    }

    @Override
    @Transactional
    public Cliente save(Cliente cliente) {
        
        return clienteRepository.save(cliente);
        
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        
        clienteRepository.deleteById(id);
        
    }

}
