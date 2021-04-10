package com.ybc.orden.services;

import com.ybc.orden.entities.Usuario;
import com.ybc.orden.repositories.UsuarioRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UsuarioServiceImpl{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional(readOnly = true)
    public Iterable<Usuario> findAll() {

        return usuarioRepository.findAll();

    }

    @Transactional(readOnly = true)
    public Optional<Usuario> findById(Integer id) {

        return usuarioRepository.findById(id);

    }

    @Transactional
    public Usuario save(Usuario usuario) {

        return usuarioRepository.save(usuario);

    }

    @Transactional
    public void deleteById(Integer id) {

        usuarioRepository.deleteById(id);

    }

}
