package com.ybc.orden.views;

import com.ybc.orden.controllers.OrdenController;


public class Main extends javax.swing.JFrame {

    
    private OrdenController ordenController;
   
    public Main() {
        this.ordenController = new OrdenController();
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        ordenController.cargarTablaOrdenes();
        
    }
       
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        panelLateral = new javax.swing.JPanel();
        rSLabelIcon1 = new RSMaterialComponent.RSLabelIcon();
        panelBotones = new javax.swing.JPanel();
        btnOrdenes = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnClientes = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnUsuarios = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnEquipos = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnSalir = new RSMaterialComponent.RSButtonMaterialIconOne();
        panelContenedor = new javax.swing.JPanel();
        panelOrdenes = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaOrdenes = new RSMaterialComponent.RSTableMetro();
        btnNuevaOrden = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnUsuarios3 = new RSMaterialComponent.RSButtonMaterialIconOne();
        panelClientes = new javax.swing.JPanel();
        panelEquipos = new javax.swing.JPanel();
        panelUsuarios = new javax.swing.JPanel();
        panelBotonCerrar = new javax.swing.JPanel();
        rSButtonIconOne1 = new RSMaterialComponent.RSButtonIconOne();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelPrincipal.setBackground(new java.awt.Color(51, 153, 255));
        panelPrincipal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        panelLateral.setBackground(new java.awt.Color(255, 255, 255));
        panelLateral.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255)));

        rSLabelIcon1.setForeground(new java.awt.Color(51, 153, 255));
        rSLabelIcon1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.TOUCH_APP);
        rSLabelIcon1.setSizeIcon(150.0F);

        panelBotones.setBackground(new java.awt.Color(255, 255, 255));

        btnOrdenes.setBackground(new java.awt.Color(51, 153, 255));
        btnOrdenes.setText("Ordenes");
        btnOrdenes.setBackgroundHover(new java.awt.Color(0, 102, 255));
        btnOrdenes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnOrdenes.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.OFFLINE_PIN);
        btnOrdenes.setRound(20);
        btnOrdenes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenesActionPerformed(evt);
            }
        });

        btnClientes.setBackground(new java.awt.Color(51, 153, 255));
        btnClientes.setText("Clientes");
        btnClientes.setBackgroundHover(new java.awt.Color(0, 102, 255));
        btnClientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnClientes.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.WORK);
        btnClientes.setRound(20);
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });

        btnUsuarios.setBackground(new java.awt.Color(51, 153, 255));
        btnUsuarios.setText("Usuarios");
        btnUsuarios.setBackgroundHover(new java.awt.Color(0, 102, 255));
        btnUsuarios.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnUsuarios.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ACCOUNT_CIRCLE);
        btnUsuarios.setRound(20);
        btnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuariosActionPerformed(evt);
            }
        });

        btnEquipos.setBackground(new java.awt.Color(51, 153, 255));
        btnEquipos.setText("Equipos");
        btnEquipos.setBackgroundHover(new java.awt.Color(0, 102, 255));
        btnEquipos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnEquipos.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.COMPUTER);
        btnEquipos.setRound(20);
        btnEquipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEquiposActionPerformed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(51, 153, 255));
        btnSalir.setText("Salir");
        btnSalir.setBackgroundHover(new java.awt.Color(0, 102, 255));
        btnSalir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSalir.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXIT_TO_APP);
        btnSalir.setRound(20);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBotonesLayout = new javax.swing.GroupLayout(panelBotones);
        panelBotones.setLayout(panelBotonesLayout);
        panelBotonesLayout.setHorizontalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnOrdenes, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnEquipos, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelBotonesLayout.setVerticalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnOrdenes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEquipos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelLateralLayout = new javax.swing.GroupLayout(panelLateral);
        panelLateral.setLayout(panelLateralLayout);
        panelLateralLayout.setHorizontalGroup(
            panelLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLateralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLateralLayout.createSequentialGroup()
                        .addComponent(rSLabelIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(panelBotones, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelLateralLayout.setVerticalGroup(
            panelLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLateralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rSLabelIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        panelContenedor.setBackground(new java.awt.Color(51, 153, 255));
        panelContenedor.setLayout(new javax.swing.OverlayLayout(panelContenedor));

        panelOrdenes.setBackground(new java.awt.Color(51, 153, 255));

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));

        tablaOrdenes.setForeground(new java.awt.Color(255, 255, 255));
        tablaOrdenes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaOrdenes.setBackgoundHead(new java.awt.Color(0, 0, 0));
        tablaOrdenes.setBackgoundHover(new java.awt.Color(0, 102, 255));
        tablaOrdenes.setColorBorderHead(new java.awt.Color(204, 204, 204));
        tablaOrdenes.setColorBorderRows(new java.awt.Color(255, 255, 255));
        tablaOrdenes.setColorPrimaryText(new java.awt.Color(0, 102, 255));
        tablaOrdenes.setColorSecundaryText(new java.awt.Color(0, 102, 255));
        tablaOrdenes.setGridColor(new java.awt.Color(255, 255, 255));
        tablaOrdenes.setSelectionBackground(new java.awt.Color(0, 102, 255));
        jScrollPane1.setViewportView(tablaOrdenes);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnNuevaOrden.setBackground(new java.awt.Color(255, 255, 255));
        btnNuevaOrden.setText("Nueva orden");
        btnNuevaOrden.setBackgroundHover(new java.awt.Color(0, 102, 255));
        btnNuevaOrden.setForegroundText(new java.awt.Color(51, 153, 255));
        btnNuevaOrden.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnNuevaOrden.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD);
        btnNuevaOrden.setRound(20);
        btnNuevaOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaOrdenActionPerformed(evt);
            }
        });

        btnUsuarios3.setBackground(new java.awt.Color(255, 255, 255));
        btnUsuarios3.setText("Usuarios");
        btnUsuarios3.setBackgroundHover(new java.awt.Color(0, 102, 255));
        btnUsuarios3.setForegroundText(new java.awt.Color(51, 153, 255));
        btnUsuarios3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnUsuarios3.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ACCOUNT_CIRCLE);
        btnUsuarios3.setRound(20);
        btnUsuarios3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuarios3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelOrdenesLayout = new javax.swing.GroupLayout(panelOrdenes);
        panelOrdenes.setLayout(panelOrdenesLayout);
        panelOrdenesLayout.setHorizontalGroup(
            panelOrdenesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelOrdenesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevaOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addComponent(btnUsuarios3, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelOrdenesLayout.setVerticalGroup(
            panelOrdenesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOrdenesLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelOrdenesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUsuarios3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevaOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panelContenedor.add(panelOrdenes);

        panelClientes.setBackground(new java.awt.Color(51, 153, 255));

        javax.swing.GroupLayout panelClientesLayout = new javax.swing.GroupLayout(panelClientes);
        panelClientes.setLayout(panelClientesLayout);
        panelClientesLayout.setHorizontalGroup(
            panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 569, Short.MAX_VALUE)
        );
        panelClientesLayout.setVerticalGroup(
            panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 548, Short.MAX_VALUE)
        );

        panelContenedor.add(panelClientes);

        panelEquipos.setBackground(new java.awt.Color(51, 153, 255));

        javax.swing.GroupLayout panelEquiposLayout = new javax.swing.GroupLayout(panelEquipos);
        panelEquipos.setLayout(panelEquiposLayout);
        panelEquiposLayout.setHorizontalGroup(
            panelEquiposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 569, Short.MAX_VALUE)
        );
        panelEquiposLayout.setVerticalGroup(
            panelEquiposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 548, Short.MAX_VALUE)
        );

        panelContenedor.add(panelEquipos);

        panelUsuarios.setBackground(new java.awt.Color(51, 153, 255));

        javax.swing.GroupLayout panelUsuariosLayout = new javax.swing.GroupLayout(panelUsuarios);
        panelUsuarios.setLayout(panelUsuariosLayout);
        panelUsuariosLayout.setHorizontalGroup(
            panelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 569, Short.MAX_VALUE)
        );
        panelUsuariosLayout.setVerticalGroup(
            panelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 548, Short.MAX_VALUE)
        );

        panelContenedor.add(panelUsuarios);

        panelBotonCerrar.setBackground(new java.awt.Color(51, 153, 255));

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

        javax.swing.GroupLayout panelBotonCerrarLayout = new javax.swing.GroupLayout(panelBotonCerrar);
        panelBotonCerrar.setLayout(panelBotonCerrarLayout);
        panelBotonCerrarLayout.setHorizontalGroup(
            panelBotonCerrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBotonCerrarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rSButtonIconOne1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelBotonCerrarLayout.setVerticalGroup(
            panelBotonCerrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonCerrarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rSButtonIconOne1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addComponent(panelLateral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelBotonCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelLateral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addComponent(panelBotonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOrdenesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenesActionPerformed

        panelOrdenes.setVisible(true);
        panelClientes.setVisible(false);
        panelEquipos.setVisible(false);
        panelUsuarios.setVisible(false);
        
    }//GEN-LAST:event_btnOrdenesActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed

        System.exit(0);
        
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed

        panelOrdenes.setVisible(false);
        panelClientes.setVisible(true);
        panelEquipos.setVisible(false);
        panelUsuarios.setVisible(false);
        
    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnEquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEquiposActionPerformed

        panelOrdenes.setVisible(false);
        panelClientes.setVisible(false);
        panelEquipos.setVisible(true);
        panelUsuarios.setVisible(false);
        
    }//GEN-LAST:event_btnEquiposActionPerformed

    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosActionPerformed

        panelOrdenes.setVisible(false);
        panelClientes.setVisible(false);
        panelEquipos.setVisible(false);
        panelUsuarios.setVisible(true);
        
    }//GEN-LAST:event_btnUsuariosActionPerformed

    private void btnNuevaOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaOrdenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNuevaOrdenActionPerformed

    private void rSButtonIconOne1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonIconOne1ActionPerformed

        System.exit(0);
        
    }//GEN-LAST:event_rSButtonIconOne1ActionPerformed

    private void btnUsuarios3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuarios3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUsuarios3ActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSButtonMaterialIconOne btnClientes;
    private RSMaterialComponent.RSButtonMaterialIconOne btnEquipos;
    private RSMaterialComponent.RSButtonMaterialIconOne btnNuevaOrden;
    private RSMaterialComponent.RSButtonMaterialIconOne btnOrdenes;
    private RSMaterialComponent.RSButtonMaterialIconOne btnSalir;
    private RSMaterialComponent.RSButtonMaterialIconOne btnUsuarios;
    private RSMaterialComponent.RSButtonMaterialIconOne btnUsuarios3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelBotonCerrar;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelClientes;
    private javax.swing.JPanel panelContenedor;
    private javax.swing.JPanel panelEquipos;
    private javax.swing.JPanel panelLateral;
    private javax.swing.JPanel panelOrdenes;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelUsuarios;
    private RSMaterialComponent.RSButtonIconOne rSButtonIconOne1;
    private RSMaterialComponent.RSLabelIcon rSLabelIcon1;
    public static RSMaterialComponent.RSTableMetro tablaOrdenes;
    // End of variables declaration//GEN-END:variables
}
