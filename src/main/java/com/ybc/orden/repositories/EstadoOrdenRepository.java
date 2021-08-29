package com.ybc.orden.repositories;

import com.ybc.orden.entities.EstadoOrden;
import com.ybc.orden.entities.Orden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("DetalleOrdenRepository")
public interface EstadoOrdenRepository extends JpaRepository<EstadoOrden, Integer>{
    Iterable<EstadoOrden> findByEstado(String estado);
    Iterable<EstadoOrden> findByOrden(Orden orden);
    Iterable<EstadoOrden> findByEstadoActual(boolean estado);
    
}
