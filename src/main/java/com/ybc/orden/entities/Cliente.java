package com.ybc.orden.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String apellido;
    private String nombre;
    private String cuit;
    private long telefono;
    private String direccion;
    private String email;
    private String condicionIva;
    private String contacto;
    private boolean estado;
    

    @Override
    public String toString() {

        return apellido + ", " + nombre;
    }
    
    public String getEstado() {
        if(estado)
            return "Activo";
        else
            return "Inactivo";
    }
}
