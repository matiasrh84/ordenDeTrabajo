
package com.ybc.orden.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Orden implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date entrada;
    private String lugar;
    private String condicion;
    private String accesoriosRecibidos;
    private String detalle;
    private String defectosReportados;
    private String configuracionEquipo;
    private String diagnostico;
    private String solucion;
    
    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;    
    @OneToOne
    @JoinColumn(name = "equipo_id")
    private Equipo equipo; 
    
    
    @Override public String toString() {
     
        return detalle;
    } 
    
}
