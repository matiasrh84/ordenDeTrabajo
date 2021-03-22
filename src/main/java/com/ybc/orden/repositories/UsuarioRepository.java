
package com.ybc.orden.repositories;

import com.ybc.orden.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    
}
