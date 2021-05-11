package com.ybc.orden.repositories;

import com.ybc.orden.entities.EstadoOrden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("DetalleOrdenRepository")
public interface EstadoOrdenRepository extends JpaRepository<EstadoOrden, Integer>{
    
}
