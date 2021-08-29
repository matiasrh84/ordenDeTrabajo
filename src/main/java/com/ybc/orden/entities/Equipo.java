
package com.ybc.orden.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Equipo implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tipo;
    private String marca;
    private String numeroSerie;
    private String modelo;
    private boolean estado;
    
    @OneToOne    
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    
    @Override public String toString() {
     
        return marca + " - " + modelo;
    }
    
    public String getEstado() {
        if(estado)
            return "Activo";
        else
            return "Inactivo";
    }
    
}
