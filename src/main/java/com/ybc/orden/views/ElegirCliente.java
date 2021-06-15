package com.ybc.orden.views;

import com.ybc.orden.entities.Cliente;
import com.ybc.orden.repositories.ClienteRepository;
import com.ybc.orden.services.ClienteServiceImpl;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import javax.annotation.PostConstruct;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ElegirCliente extends javax.swing.JDialog {

    int x;
    int y;
    DefaultTableModel modelClientes;

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ClienteServiceImpl clienteService;

    public ElegirCliente() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
    }

    @PostConstruct
    public void cargarTablaClientes() {

        modelClientes = (DefaultTableModel) tablaClientes.getModel();
        List<Cliente> datosClientes = StreamSupport
                .stream(clienteRepository.findByEstado(true).spliterator(), false)
                .collect(Collectors.toList());
        modelClientes.setNumRows(0);

        for (Cliente datos : datosClientes) {
            Object[] fila = {datos.getId(), datos.getApellido(), datos.getNombre(), datos.getCuit(), datos.getContacto()};
            modelClientes.addRow(fila);
        }

        tablaClientes.getColumnModel().getColumn(0).setMaxWidth(0);
        tablaClientes.getColumnModel().getColumn(0).setMinWidth(0);
        tablaClientes.getColumnModel().getColumn(0).setPreferredWidth(0);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        rSButtonIconOne1 = new RSMaterialComponent.RSButtonIconOne();
        rSLabelTextIcon1 = new RSMaterialComponent.RSLabelTextIcon();
        jPanel3 = new javax.swing.JPanel();
        btnAceptar = new RSMaterialComponent.RSButtonMaterialIconTwo();
        btnCancelar = new RSMaterialComponent.RSButtonMaterialIconTwo();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaClientes = new RSMaterialComponent.RSTableMetro();
        rSLabelIcon2 = new RSMaterialComponent.RSLabelIcon();
        txtBuscar = new RSMaterialComponent.RSTextFieldMaterial();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 2));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });

        rSButtonIconOne1.setBackground(new java.awt.Color(255, 255, 255));
        rSButtonIconOne1.setForeground(new java.awt.Color(255, 51, 51));
        rSButtonIconOne1.setBackgroundHover(new java.awt.Color(153, 0, 0));
        rSButtonIconOne1.setForegroundText(new java.awt.Color(255, 51, 51));
        rSButtonIconOne1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CLOSE);
        rSButtonIconOne1.setSizeIcon(20.0F);
        rSButtonIconOne1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonIconOne1ActionPerformed(evt);
            }
        });

        rSLabelTextIcon1.setForeground(new java.awt.Color(0, 153, 255));
        rSLabelTextIcon1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        rSLabelTextIcon1.setText("Elegir clientes");
        rSLabelTextIcon1.setIcons(null);
        rSLabelTextIcon1.setSizeIcon(1.0F);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rSLabelTextIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 199, Short.MAX_VALUE)
                .addComponent(rSButtonIconOne1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rSButtonIconOne1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSLabelTextIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        btnAceptar.setBackground(new java.awt.Color(0, 153, 51));
        btnAceptar.setText("Aceptar");
        btnAceptar.setBackgroundHover(new java.awt.Color(0, 102, 0));
        btnAceptar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAceptar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CHECK);
        btnAceptar.setRound(30);
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(255, 51, 51));
        btnCancelar.setText("Cancelar");
        btnCancelar.setBackgroundHover(new java.awt.Color(153, 0, 0));
        btnCancelar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCancelar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CANCEL);
        btnCancelar.setRound(30);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel4MouseDragged(evt);
            }
        });
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel4MousePressed(evt);
            }
        });

        tablaClientes.setForeground(new java.awt.Color(255, 255, 255));
        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Apellido", "Nombre", "CUIT", "Contacto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaClientes.setBackgoundHead(new java.awt.Color(0, 0, 0));
        tablaClientes.setBackgoundHover(new java.awt.Color(0, 102, 255));
        tablaClientes.setColorBorderHead(new java.awt.Color(204, 204, 204));
        tablaClientes.setColorBorderRows(new java.awt.Color(255, 255, 255));
        tablaClientes.setColorPrimaryText(new java.awt.Color(0, 102, 255));
        tablaClientes.setColorSecundaryText(new java.awt.Color(0, 102, 255));
        tablaClientes.setSelectionBackground(new java.awt.Color(0, 102, 255));
        tablaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaClientes);

        rSLabelIcon2.setForeground(new java.awt.Color(0, 153, 255));
        rSLabelIcon2.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SEARCH);

        txtBuscar.setBackground(new java.awt.Color(255, 255, 255));
        txtBuscar.setForeground(new java.awt.Color(0, 0, 0));
        txtBuscar.setColorMaterial(new java.awt.Color(51, 153, 255));
        txtBuscar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtBuscar.setPhColor(new java.awt.Color(0, 0, 0));
        txtBuscar.setPlaceholder("Buscar");
        txtBuscar.setSelectionColor(new java.awt.Color(51, 153, 255));
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(rSLabelIcon2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSLabelIcon2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed

        if (tablaClientes.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un cliente");
        } else {
            Optional<Cliente> cliente = clienteService.findById(Integer.valueOf(tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 0).toString()));
            AltaOrdenes.idCliente = cliente.get().getId();
            ModificaOrdenes.idCliente = cliente.get().getId();
            dispose();
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void rSButtonIconOne1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonIconOne1ActionPerformed

        dispose();

    }//GEN-LAST:event_rSButtonIconOne1ActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

        dispose();

    }//GEN-LAST:event_btnCancelarActionPerformed

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed

        x = evt.getX();
        y = evt.getY();

    }//GEN-LAST:event_jPanel2MousePressed

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged

        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);

    }//GEN-LAST:event_jPanel2MouseDragged

    private void jPanel4MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel4MouseDragged

    private void jPanel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel4MousePressed

    private void tablaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaClientesMouseClicked

        if (evt.getClickCount() == 2) {
            Optional<Cliente> cliente = clienteService.findById(Integer.valueOf(tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 0).toString()));
            AltaOrdenes.idCliente = cliente.get().getId();
            ModificaOrdenes.idCliente = cliente.get().getId();
            dispose();
        }

    }//GEN-LAST:event_tablaClientesMouseClicked

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased

        TableRowSorter sorter = new TableRowSorter(modelClientes);
        sorter.setRowFilter(RowFilter.regexFilter(".*" + txtBuscar.getText() + ".*"));
        tablaClientes.setRowSorter(sorter);
    }//GEN-LAST:event_txtBuscarKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSButtonMaterialIconTwo btnAceptar;
    private RSMaterialComponent.RSButtonMaterialIconTwo btnCancelar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private RSMaterialComponent.RSButtonIconOne rSButtonIconOne1;
    private RSMaterialComponent.RSLabelIcon rSLabelIcon2;
    private RSMaterialComponent.RSLabelTextIcon rSLabelTextIcon1;
    public static RSMaterialComponent.RSTableMetro tablaClientes;
    private RSMaterialComponent.RSTextFieldMaterial txtBuscar;
    // End of variables declaration//GEN-END:variables
}
