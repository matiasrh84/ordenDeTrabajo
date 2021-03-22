
package com.ybc.orden.controllers;

import com.ybc.orden.entities.Cliente;
import com.ybc.orden.entities.Equipo;
import com.ybc.orden.entities.Orden;
import com.ybc.orden.entities.Usuario;
import com.ybc.orden.services.ClienteService;
import com.ybc.orden.services.OrdenService;
import static com.ybc.orden.views.Main.tablaOrdenes;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class OrdenController {
    
    DefaultTableModel model = new DefaultTableModel();
    
    @Autowired
    private ClienteService clienteService;
    
    
   
    
    public void cargarTablaOrdenes() {
        
        ArrayList<String> cabeceras = new ArrayList<String>();
        Orden orden = new Orden();
        cabeceras.add("Fecha");
        cabeceras.add("Equipo");
        cabeceras.add("Cliente");
        
        for(String cab : cabeceras) {
            model.addColumn(cab);
        }
        
        tablaOrdenes.setModel(model);
        
        ArrayList<Object[]> datos = new ArrayList<>();
        Cliente cliente = new Cliente(4, "roberto", "guzman", "dni", 31098324);
        Equipo equipo = new Equipo(4, "Asus", "esta es una computadora chota", cliente);
        Usuario usuario = new Usuario(2, "ramon", "santamarina", 23456789, "rsantamarina", "1234", true);
        orden.setCliente(cliente);
        orden.setEntrada(new Date(20210303));
        orden.setEquipo(equipo);
        orden.setUsuario(usuario);
        
        clienteService.save(cliente);
        
        
        
        for(Object[] registros: datos) {
            model.addRow(registros);
        }
        tablaOrdenes.setModel(model);
    }
    
}
