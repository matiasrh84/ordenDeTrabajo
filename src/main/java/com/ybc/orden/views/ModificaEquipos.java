package com.ybc.orden.views;

import com.ybc.orden.entities.Cliente;
import com.ybc.orden.entities.Equipo;
import com.ybc.orden.services.ClienteServiceImpl;
import com.ybc.orden.services.EquipoServiceImpl;
import static com.ybc.orden.views.MainFrame.idEquipos;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import javax.annotation.PostConstruct;
import javax.swing.JOptionPane;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ModificaEquipos extends javax.swing.JDialog {

    @Autowired
    private ClienteServiceImpl clienteService;
    @Autowired
    private EquipoServiceImpl equipoService;
    @Autowired
    private AltaClientes abmClientes;

    public ModificaEquipos() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        txtTipo.setEnabled(false);
    }

    @PostConstruct
    void cargarClientes() {
        abmClientes.setModal(true);
        List<Cliente> datosClientes = StreamSupport
                .stream(clienteService.findAll().spliterator(), false)
                .collect(Collectors.toList());
        cboCliente.removeAllItems();
        for (Cliente cliente : datosClientes) {
            cboCliente.addItem(cliente);
        }
        AutoCompleteDecorator.decorate(cboCliente);
        
    }
    
    void cargarDatos() {
        if(idEquipos !=0) {
            Equipo equipo = equipoService.findById(idEquipos).get();
            cboCliente.setSelectedItem(equipo.getCliente());
            cboTipo.setSelectedItem(equipo.getTipo());
            if(cboTipo.getSelectedItem().toString().equals("Otros")) {
                txtTipo.setEnabled(true);
                txtTipo.setText(equipo.getTipo());
            }
            txtMarca.setText(equipo.getMarca());
            txtModelo.setText(equipo.getModelo());
            txtSerie.setText(equipo.getNumeroSerie());
        }
    }
    
    void aplicarCambios() {
        String tipo;
        if (cboTipo.getSelectedItem().equals("Otros")) {
            tipo = txtTipo.getText();
        } else {
            tipo = cboTipo.getSelectedItem().toString();
        }
        Equipo equipo = Equipo.builder()
                .id(idEquipos)
                .cliente((Cliente) cboCliente.getSelectedItem())
                .tipo(tipo)
                .marca(txtMarca.getText())
                .modelo(txtModelo.getText())
                .numeroSerie(txtSerie.getText())
                .estado(true)
                .build();

        cboCliente.setSelectedIndex(0);
        cboTipo.setSelectedIndex(0);
        txtMarca.setText(null);
        txtModelo.setText(null);
        txtSerie.setText(null);
        txtTipo.setText(null);
        txtTipo.setEnabled(false);

        equipoService.save(equipo);
        dispose();
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtTipo = new RSMaterialComponent.RSTextFieldMaterial();
        jPanel2 = new javax.swing.JPanel();
        rSButtonIconOne1 = new RSMaterialComponent.RSButtonIconOne();
        rSLabelTextIcon1 = new RSMaterialComponent.RSLabelTextIcon();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMarca = new RSMaterialComponent.RSTextFieldMaterial();
        jLabel4 = new javax.swing.JLabel();
        txtModelo = new RSMaterialComponent.RSTextFieldMaterial();
        jLabel5 = new javax.swing.JLabel();
        txtSerie = new RSMaterialComponent.RSTextFieldMaterial();
        jPanel3 = new javax.swing.JPanel();
        btnAceptar = new RSMaterialComponent.RSButtonMaterialIconTwo();
        btnCancelar = new RSMaterialComponent.RSButtonMaterialIconTwo();
        cboTipo = new RSMaterialComponent.RSComboBoxMaterial();
        jLabel3 = new javax.swing.JLabel();
        cboCliente = new RSMaterialComponent.RSComboBoxMaterial();
        btnAltaCliente = new RSMaterialComponent.RSButtonMaterialIconTwo();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 2));

        txtTipo.setBackground(new java.awt.Color(255, 255, 255));
        txtTipo.setForeground(new java.awt.Color(0, 0, 0));
        txtTipo.setColorMaterial(new java.awt.Color(51, 153, 255));
        txtTipo.setPhColor(new java.awt.Color(51, 153, 255));
        txtTipo.setPlaceholder("Ingrese otro tipo");
        txtTipo.setSelectionColor(new java.awt.Color(51, 153, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

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
        rSLabelTextIcon1.setText("Modifica equipo");
        rSLabelTextIcon1.setIcons(null);
        rSLabelTextIcon1.setMaximumSize(new java.awt.Dimension(104, 17));
        rSLabelTextIcon1.setMinimumSize(new java.awt.Dimension(104, 17));
        rSLabelTextIcon1.setSizeIcon(1.0F);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rSLabelTextIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rSButtonIconOne1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(rSButtonIconOne1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSLabelTextIcon1, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel1.setText("Cliente:");

        jLabel2.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel2.setText("Marca:");

        txtMarca.setBackground(new java.awt.Color(255, 255, 255));
        txtMarca.setForeground(new java.awt.Color(0, 0, 0));
        txtMarca.setColorMaterial(new java.awt.Color(51, 153, 255));
        txtMarca.setPhColor(new java.awt.Color(51, 153, 255));
        txtMarca.setPlaceholder("Ingrese la marca");
        txtMarca.setSelectionColor(new java.awt.Color(51, 153, 255));

        jLabel4.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel4.setText("Modelo:");

        txtModelo.setBackground(new java.awt.Color(255, 255, 255));
        txtModelo.setForeground(new java.awt.Color(0, 0, 0));
        txtModelo.setColorMaterial(new java.awt.Color(51, 153, 255));
        txtModelo.setPhColor(new java.awt.Color(51, 153, 255));
        txtModelo.setPlaceholder("Ingrese el modelo");
        txtModelo.setSelectionColor(new java.awt.Color(51, 153, 255));

        jLabel5.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel5.setText("Nº de serie:");

        txtSerie.setBackground(new java.awt.Color(255, 255, 255));
        txtSerie.setForeground(new java.awt.Color(0, 0, 0));
        txtSerie.setColorMaterial(new java.awt.Color(51, 153, 255));
        txtSerie.setPhColor(new java.awt.Color(51, 153, 255));
        txtSerie.setPlaceholder("Ingrese el nº de serie");
        txtSerie.setSelectionColor(new java.awt.Color(51, 153, 255));

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cboTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CPU", "Impresora", "Monitor", "Notebook", "Otros" }));
        cboTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTipoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel3.setText("Tipo:");

        cboCliente.setColorMaterial(new java.awt.Color(0, 153, 255));

        btnAltaCliente.setBackground(new java.awt.Color(0, 153, 51));
        btnAltaCliente.setText("Alta cliente");
        btnAltaCliente.setBackgroundHover(new java.awt.Color(0, 102, 0));
        btnAltaCliente.setFont(new java.awt.Font("Roboto Bold", 1, 12)); // NOI18N
        btnAltaCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAltaCliente.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD);
        btnAltaCliente.setRound(10);
        btnAltaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAltaClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(jLabel3))
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtModelo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtMarca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, 0)
                                        .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnAltaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(11, 11, 11)
                        .addComponent(txtSerie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cboCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAltaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
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

        if(!txtMarca.getText().equals("") && !txtModelo.getText().equals("")) {
            aplicarCambios();
        } else {
            JOptionPane.showMessageDialog(null, "Debe completar los campos obligatorios");
        }

    }//GEN-LAST:event_btnAceptarActionPerformed

    private void rSButtonIconOne1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonIconOne1ActionPerformed

        dispose();

    }//GEN-LAST:event_rSButtonIconOne1ActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

        dispose();

    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cboTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTipoActionPerformed

        if (cboTipo.getSelectedItem().equals("Otros")) {
            txtTipo.setEnabled(true);
            txtTipo.requestFocus();
        } else {
            txtTipo.setEnabled(false);
            txtMarca.requestFocus();
        }

    }//GEN-LAST:event_cboTipoActionPerformed

    private void btnAltaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltaClienteActionPerformed

        abmClientes.setVisible(true);
        cargarClientes();
        
    }//GEN-LAST:event_btnAltaClienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSButtonMaterialIconTwo btnAceptar;
    private RSMaterialComponent.RSButtonMaterialIconTwo btnAltaCliente;
    private RSMaterialComponent.RSButtonMaterialIconTwo btnCancelar;
    private RSMaterialComponent.RSComboBoxMaterial cboCliente;
    private RSMaterialComponent.RSComboBoxMaterial cboTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private RSMaterialComponent.RSButtonIconOne rSButtonIconOne1;
    private RSMaterialComponent.RSLabelTextIcon rSLabelTextIcon1;
    private RSMaterialComponent.RSTextFieldMaterial txtMarca;
    private RSMaterialComponent.RSTextFieldMaterial txtModelo;
    private RSMaterialComponent.RSTextFieldMaterial txtSerie;
    private RSMaterialComponent.RSTextFieldMaterial txtTipo;
    // End of variables declaration//GEN-END:variables
}
