
package com.ybc.orden.repositories;

import com.ybc.orden.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("ClienteRepository")
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
    
}
