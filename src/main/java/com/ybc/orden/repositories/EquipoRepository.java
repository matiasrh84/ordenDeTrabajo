
package com.ybc.orden.repositories;

import com.ybc.orden.entities.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("EquipoRepository")
public interface EquipoRepository extends JpaRepository<Equipo, Integer> {
    
}
