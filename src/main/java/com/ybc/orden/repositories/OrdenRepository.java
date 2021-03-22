
package com.ybc.orden.repositories;

import com.ybc.orden.entities.Orden;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrdenRepository extends JpaRepository<Orden, Integer> {
    
}
