
package com.ybc.orden.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
    private String detalle;
    private String defectosReportados;
    private String condicionDeIngreso;    
    @ManyToOne
    private Cliente cliente;
    @OneToOne
    private Usuario usuario;    
    @OneToOne
    private Equipo equipo;
    
    
    @Override public String toString() {
     
        return detalle;
    } 
    
}
