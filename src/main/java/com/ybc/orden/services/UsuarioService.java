
package com.ybc.orden.services;

import com.ybc.orden.entities.Usuario;
import java.util.Optional;


public interface UsuarioService {
    
    public Iterable<Usuario> findAll();
    public Optional<Usuario> findById(Integer id);
    public Usuario save(Usuario usuario);
    public void deleteById(Integer id);
    
}
