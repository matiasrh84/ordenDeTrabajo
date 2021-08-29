package com.ybc.orden.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import javax.swing.JTable;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author matiasrh84
 */
public class Excel {
    
    private static String os = System.getProperty("os.name");
    private static String separator = System.getProperty("file.separator");
    private static Path destino;

    public static boolean exportarTablaExcel(JTable jTable) {
        boolean resultado = false;
        try {
            Workbook wb = new XSSFWorkbook();
            Sheet sheet = wb.createSheet("Órdenes");
            Row rowCol = sheet.createRow(0);
            Calendar fecha = Calendar.getInstance();
            for (int i = 0; i < jTable.getColumnCount()-2; i++) {
                Cell cell = rowCol.createCell(i);
                cell.setCellValue(jTable.getColumnName(i));
            }
            for (int j = 0; j < jTable.getRowCount(); j++) {
                Row row = sheet.createRow(j + 1);
                for (int k = 0; k < jTable.getColumnCount()-2; k++) {
                    Cell cell = row.createCell(k);
                    if (jTable.getValueAt(j, k) != null) {
                        cell.setCellValue(jTable.getValueAt(j, k).toString());
                    }
                }
            }
             if (os.equals("Linux")) {
            destino = Paths.get("/ordenDeTrabajo/Planillas/");
        } else {
            destino = Paths.get("C:" + separator + "Ybgestor" + separator + "Planillas" + separator);
        }
            String nombre = fecha.getTime().toString();
            FileOutputStream out = new FileOutputStream(new File(destino.toString() + separator + nombre + ".xlsx"));
            wb.write(out);
            wb.close();
            out.close();
            resultado = true;
            System.out.println(out);
        } catch (IOException e) {
            System.err.println(e);
            resultado = false;
        }
        return resultado;
    }
}
