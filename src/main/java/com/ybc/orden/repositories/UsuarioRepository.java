
package com.ybc.orden.repositories;

import com.ybc.orden.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("UsuarioRepository")
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    
}
