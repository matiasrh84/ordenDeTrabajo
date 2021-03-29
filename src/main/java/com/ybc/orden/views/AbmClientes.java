package com.ybc.orden.views;

import org.springframework.stereotype.Component;

@Component
public class AbmClientes extends javax.swing.JDialog {

    public AbmClientes() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        rSTextFieldMaterial1 = new RSMaterialComponent.RSTextFieldMaterial();
        jPanel2 = new javax.swing.JPanel();
        rSButtonIconOne1 = new RSMaterialComponent.RSButtonIconOne();
        rSLabelTextIcon1 = new RSMaterialComponent.RSLabelTextIcon();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        rSTextFieldMaterial5 = new RSMaterialComponent.RSTextFieldMaterial();
        jLabel4 = new javax.swing.JLabel();
        rSTextFieldMaterial6 = new RSMaterialComponent.RSTextFieldMaterial();
        jLabel5 = new javax.swing.JLabel();
        rSTextFieldMaterial7 = new RSMaterialComponent.RSTextFieldMaterial();
        jLabel6 = new javax.swing.JLabel();
        rSTextFieldMaterial8 = new RSMaterialComponent.RSTextFieldMaterial();
        rSTextFieldMaterial9 = new RSMaterialComponent.RSTextFieldMaterial();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnAceptar = new RSMaterialComponent.RSButtonMaterialIconTwo();
        btnCancelar = new RSMaterialComponent.RSButtonMaterialIconTwo();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 2));

        rSTextFieldMaterial1.setBackground(new java.awt.Color(255, 255, 255));
        rSTextFieldMaterial1.setForeground(new java.awt.Color(0, 0, 0));
        rSTextFieldMaterial1.setColorMaterial(new java.awt.Color(51, 153, 255));
        rSTextFieldMaterial1.setPhColor(new java.awt.Color(51, 153, 255));
        rSTextFieldMaterial1.setPlaceholder("Ingrese los apellidos");
        rSTextFieldMaterial1.setSelectionColor(new java.awt.Color(51, 153, 255));

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
        rSLabelTextIcon1.setText("Alta de usuarios");
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

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel1.setText("Apellidos:");

        jLabel2.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel2.setText("Nombres:");

        rSTextFieldMaterial5.setBackground(new java.awt.Color(255, 255, 255));
        rSTextFieldMaterial5.setForeground(new java.awt.Color(0, 0, 0));
        rSTextFieldMaterial5.setColorMaterial(new java.awt.Color(51, 153, 255));
        rSTextFieldMaterial5.setPhColor(new java.awt.Color(51, 153, 255));
        rSTextFieldMaterial5.setPlaceholder("Ingrese los nombres");
        rSTextFieldMaterial5.setSelectionColor(new java.awt.Color(51, 153, 255));

        jLabel4.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel4.setText("CUIT:");

        rSTextFieldMaterial6.setBackground(new java.awt.Color(255, 255, 255));
        rSTextFieldMaterial6.setForeground(new java.awt.Color(0, 0, 0));
        rSTextFieldMaterial6.setColorMaterial(new java.awt.Color(51, 153, 255));
        rSTextFieldMaterial6.setPhColor(new java.awt.Color(51, 153, 255));
        rSTextFieldMaterial6.setPlaceholder("Ingrese el CUIT");
        rSTextFieldMaterial6.setSelectionColor(new java.awt.Color(51, 153, 255));

        jLabel5.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel5.setText("Teléfono:");

        rSTextFieldMaterial7.setBackground(new java.awt.Color(255, 255, 255));
        rSTextFieldMaterial7.setForeground(new java.awt.Color(0, 0, 0));
        rSTextFieldMaterial7.setColorMaterial(new java.awt.Color(51, 153, 255));
        rSTextFieldMaterial7.setPhColor(new java.awt.Color(51, 153, 255));
        rSTextFieldMaterial7.setPlaceholder("Ingrese el teléfono");
        rSTextFieldMaterial7.setSelectionColor(new java.awt.Color(51, 153, 255));

        jLabel6.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel6.setText("Domicilio:");

        rSTextFieldMaterial8.setBackground(new java.awt.Color(255, 255, 255));
        rSTextFieldMaterial8.setForeground(new java.awt.Color(0, 0, 0));
        rSTextFieldMaterial8.setColorMaterial(new java.awt.Color(51, 153, 255));
        rSTextFieldMaterial8.setPhColor(new java.awt.Color(51, 153, 255));
        rSTextFieldMaterial8.setPlaceholder("Ingrese el domicilio");
        rSTextFieldMaterial8.setSelectionColor(new java.awt.Color(51, 153, 255));

        rSTextFieldMaterial9.setBackground(new java.awt.Color(255, 255, 255));
        rSTextFieldMaterial9.setForeground(new java.awt.Color(0, 0, 0));
        rSTextFieldMaterial9.setColorMaterial(new java.awt.Color(51, 153, 255));
        rSTextFieldMaterial9.setPhColor(new java.awt.Color(51, 153, 255));
        rSTextFieldMaterial9.setPlaceholder("Ingrese condición IVA");
        rSTextFieldMaterial9.setSelectionColor(new java.awt.Color(51, 153, 255));

        jLabel7.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel7.setText("IVA:");

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rSTextFieldMaterial1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rSTextFieldMaterial6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rSTextFieldMaterial5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rSTextFieldMaterial7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rSTextFieldMaterial8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rSTextFieldMaterial9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(rSTextFieldMaterial1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(rSTextFieldMaterial5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(rSTextFieldMaterial6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(rSTextFieldMaterial7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(rSTextFieldMaterial8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(rSTextFieldMaterial9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void rSButtonIconOne1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonIconOne1ActionPerformed

        dispose();

    }//GEN-LAST:event_rSButtonIconOne1ActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        
        dispose();
        
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSButtonMaterialIconTwo btnAceptar;
    private RSMaterialComponent.RSButtonMaterialIconTwo btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private RSMaterialComponent.RSButtonIconOne rSButtonIconOne1;
    private RSMaterialComponent.RSLabelTextIcon rSLabelTextIcon1;
    private RSMaterialComponent.RSTextFieldMaterial rSTextFieldMaterial1;
    private RSMaterialComponent.RSTextFieldMaterial rSTextFieldMaterial5;
    private RSMaterialComponent.RSTextFieldMaterial rSTextFieldMaterial6;
    private RSMaterialComponent.RSTextFieldMaterial rSTextFieldMaterial7;
    private RSMaterialComponent.RSTextFieldMaterial rSTextFieldMaterial8;
    private RSMaterialComponent.RSTextFieldMaterial rSTextFieldMaterial9;
    // End of variables declaration//GEN-END:variables
}
