package com.ybc.orden.util;

import com.ybc.orden.entities.Orden;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.beans.factory.annotation.Autowired;


public class Report {       
    
    @Autowired
    JasperReport reporte;

    public void OrdenDeTrabajo(Orden orden) {
       Map parametro = new HashMap();
        
        try {
            
            Path destino = Paths.get("ordenDeTrabajo/Reportes/");
            
            reporte = (JasperReport) JRLoader.loadObject(getClass().getResource("/reportes/OrdenDeTrabajo.jasper"));
            parametro.put("idOrden", orden.getId());
            parametro.put("fecha", orden.getEntrada());
            parametro.put("nombreCliente", orden.getEquipo().getCliente().getNombre()+" "+orden.getEquipo().getCliente().getApellido());
            parametro.put("direccion", orden.getEquipo().getCliente().getDireccion());
            parametro.put("telefono", orden.getEquipo().getCliente().getTelefono());
            parametro.put("email", orden.getEquipo().getCliente().getEmail());
            parametro.put("tipoEquipo", orden.getEquipo().getTipo());
            parametro.put("marca", orden.getEquipo().getMarca());
            parametro.put("modelo", orden.getEquipo().getModelo());
            parametro.put("serie", orden.getEquipo().getNumeroSerie());
            parametro.put("accesorios", orden.getAccesoriosRecibidos());
            parametro.put("detalle", orden.getDetalle());
            parametro.put("defectos", orden.getDefectosReportados());
            parametro.put("importe", orden.getImporte());
            parametro.put("condicion", orden.getCondicion());
            parametro.put("tecnico", orden.getUsuario().getNombre()+" "+orden.getUsuario().getApellido());
            parametro.put("contacto", orden.getEquipo().getCliente().getContacto());
            
            System.out.println(parametro);
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametro, new JREmptyDataSource());
            JasperExportManager.exportReportToPdfFile(jasperPrint, destino.toString()+"/"+orden.getId()+"-original.pdf");
            
            
            
           // JasperPrintManager.printReport(jasperPrint,false);
        } catch (JRException ex) {
            Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void OrdenDeTrabajoDuplicado(Orden orden) {
       Map parametro = new HashMap();
        
        try {
            
            Path destino = Paths.get("ordenDeTrabajo/Reportes/");
            
            reporte = (JasperReport) JRLoader.loadObject(getClass().getResource("/reportes/OrdenDeTrabajoDuplicado.jasper"));
            parametro.put("idOrden", orden.getId());
            parametro.put("fecha", orden.getEntrada());
            parametro.put("nombreCliente", orden.getEquipo().getCliente().getNombre()+" "+orden.getEquipo().getCliente().getApellido());
            parametro.put("direccion", orden.getEquipo().getCliente().getDireccion());
            parametro.put("telefono", orden.getEquipo().getCliente().getTelefono());
            parametro.put("email", orden.getEquipo().getCliente().getEmail());
            parametro.put("tipoEquipo", orden.getEquipo().getTipo());
            parametro.put("marca", orden.getEquipo().getMarca());
            parametro.put("modelo", orden.getEquipo().getModelo());
            parametro.put("serie", orden.getEquipo().getNumeroSerie());
            parametro.put("accesorios", orden.getAccesoriosRecibidos());
            parametro.put("detalle", orden.getDetalle());
            parametro.put("defectos", orden.getDefectosReportados());
            parametro.put("importe", orden.getImporte());
            parametro.put("condicion", orden.getCondicion());
            parametro.put("tecnico", orden.getUsuario().getNombre()+" "+orden.getUsuario().getApellido());
            parametro.put("contacto", orden.getEquipo().getCliente().getContacto());
            parametro.put("configuracion",orden.getConfiguracionEquipo());
            parametro.put("diagnostico", orden.getDiagnostico());
            parametro.put("solucion", orden.getSolucion());
            
            System.out.println(parametro);
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametro, new JREmptyDataSource());
            JasperExportManager.exportReportToPdfFile(jasperPrint, destino.toString()+"/"+orden.getId()+"-duplicado.pdf");
            
            
            
           // JasperPrintManager.printReport(jasperPrint,false);
        } catch (JRException ex) {
            Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
