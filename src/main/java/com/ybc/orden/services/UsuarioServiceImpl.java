
package com.ybc.orden.services;

import com.ybc.orden.entities.Usuario;
import com.ybc.orden.repositories.UsuarioRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Override
    @Transactional(readOnly = true)
    public Iterable<Usuario> findAll() {
        
        return usuarioRepository.findAll();
        
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Usuario> findById(Integer id) {
        
        return usuarioRepository.findById(id);
        
    }

    @Override
    @Transactional
    public Usuario save(Usuario usuario) {
        
        return usuarioRepository.save(usuario);
        
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        
        usuarioRepository.deleteById(id);
        
    }
    
}
