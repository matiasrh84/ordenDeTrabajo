
package com.ybc.orden.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
public class Usuario implements Serializable {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String apellido;
    private int dni;
    private String usuario;
    private String clave;
    private boolean tecnico;
    private int permisos;
    private boolean estado;
    
    
    @Override public String toString() {
     
        return apellido+", "+nombre;
    } 
    
}
