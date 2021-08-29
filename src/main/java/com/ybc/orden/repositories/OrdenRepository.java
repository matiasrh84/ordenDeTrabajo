
package com.ybc.orden.repositories;

import com.ybc.orden.entities.Orden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("OrdenRepository")
public interface OrdenRepository extends JpaRepository<Orden, Integer> {    
}
