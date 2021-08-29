
package com.ybc.orden.repositories;

import com.ybc.orden.entities.Cliente;
import com.ybc.orden.entities.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("EquipoRepository")
public interface EquipoRepository extends JpaRepository<Equipo, Integer> {
    public Iterable<Equipo> findByEstado(boolean estado);
    public Iterable<Equipo> findByEstadoAndCliente(boolean estado, Cliente cliente);
}
