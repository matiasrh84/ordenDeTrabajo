package com.ybc.orden.views;

import com.ybc.orden.entities.Equipo;
import com.ybc.orden.entities.Orden;
import com.ybc.orden.entities.Usuario;
import com.ybc.orden.services.EstadoOrdenServiceImpl;
import com.ybc.orden.services.EquipoServiceImpl;
import com.ybc.orden.services.OrdenServiceImpl;
import com.ybc.orden.services.UsuarioServiceImpl;
import com.ybc.orden.util.Report;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import javax.annotation.PostConstruct;
import javax.swing.BorderFactory;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AltaOrdenes extends javax.swing.JDialog {
    
    int x;
    int y;
    
    @Autowired
    private OrdenServiceImpl ordenService;
    @Autowired
    private EquipoServiceImpl equipoService;
    @Autowired
    private AltaEquipos abmEquipos;
    @Autowired
    private UsuarioServiceImpl usuarioService;
    @Autowired
    private AltaUsuarios abmUsuarios; 
    @Autowired
    private EstadoOrdenServiceImpl estadoOrdenService;
    
    
    public AltaOrdenes() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        radioTaller.setSelected(true);
        radioFacturar.setSelected(true);

    }

    @PostConstruct
    void cargarEquipos() {
        abmEquipos.setModal(true);
        List<Equipo> datosEquipos = StreamSupport
                .stream(equipoService.findAll().spliterator(), false)
                .collect(Collectors.toList());
        cboEquipo.removeAllItems();
        for (Equipo equipo : datosEquipos) {
            cboEquipo.addItem(equipo);
        }
        AutoCompleteDecorator.decorate(cboEquipo);
        cboEquipo.setSelectedIndex(0);
    }

    @PostConstruct
    void cargarUsuarios() {
        abmUsuarios.setModal(true);
        List<Usuario> datosUsuarios = StreamSupport
                .stream(usuarioService.findAll().spliterator(), false)
                .collect(Collectors.toList());
        cboUsuario.removeAllItems();
        for (Usuario usuario : datosUsuarios) {
            cboUsuario.addItem(usuario);
        }
        AutoCompleteDecorator.decorate(cboUsuario);

    }

    void aplicarCambios() {

        String lugar;
        String condicion;
        Calendar fecha = Calendar.getInstance();

        if (radioTaller.isSelected()) {
            lugar = "Taller";
        } else {
            lugar="Domicilio";
        }
        
        if (radioFacturar.isSelected()) {
            condicion = "Facturar";
        } else {
            condicion="Garantia";
        }

        Orden orden = Orden.builder()
                .entrada(fecha.getTime())
                .lugar(lugar)
                .condicion(condicion)
                .equipo((Equipo) cboEquipo.getSelectedItem())
                .accesoriosRecibidos(txtAccesorios.getText())
                .detalle(txtDetalle.getText())
                .defectosReportados(txtDefectos.getText())
                .usuario((Usuario) cboUsuario.getSelectedItem())
                .configuracionEquipo(txaConfiguracion.getText())
                .diagnostico(txaDiagnostico.getText())
                .solucion(txaSolucion.getText())
                .importe(txtImporte.getText())
                .build();
        
        
        
        cboEquipo.setSelectedIndex(0);
        cboUsuario.setSelectedIndex(0);
        radioTaller.setSelected(true);
        radioFacturar.setSelected(true);
        txtAccesorios.setText(null);
        txtDetalle.setText(null);
        txtDefectos.setText(null);
        txaConfiguracion.setText(null);
        txaDiagnostico.setText(null);
        txaSolucion.setText(null);
        
        ordenService.save(orden);        
        Report report = new Report();
        report.OrdenDeTrabajo(orden);
        report.OrdenDeTrabajoDuplicado(orden);
        dispose();
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoLugarAtencion = new javax.swing.ButtonGroup();
        grupoCondicion = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        rSButtonIconOne1 = new RSMaterialComponent.RSButtonIconOne();
        rSLabelTextIcon1 = new RSMaterialComponent.RSLabelTextIcon();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtAccesorios = new RSMaterialComponent.RSTextFieldMaterial();
        jPanel3 = new javax.swing.JPanel();
        btnAceptar = new RSMaterialComponent.RSButtonMaterialIconTwo();
        btnCancelar = new RSMaterialComponent.RSButtonMaterialIconTwo();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaConfiguracion = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txaDiagnostico = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txaSolucion = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        txtImporte = new RSMaterialComponent.RSTextFieldMaterial();
        radioTaller = new RSMaterialComponent.RSRadioButtonMaterial();
        radioDomicilio = new RSMaterialComponent.RSRadioButtonMaterial();
        cboEquipo = new RSMaterialComponent.RSComboBoxMaterial();
        btnAltaEquipo = new RSMaterialComponent.RSButtonMaterialIconTwo();
        jLabel5 = new javax.swing.JLabel();
        txtDetalle = new RSMaterialComponent.RSTextFieldMaterial();
        jLabel6 = new javax.swing.JLabel();
        txtDefectos = new RSMaterialComponent.RSTextFieldMaterial();
        jLabel10 = new javax.swing.JLabel();
        radioFacturar = new RSMaterialComponent.RSRadioButtonMaterial();
        radioGarantia = new RSMaterialComponent.RSRadioButtonMaterial();
        jLabel11 = new javax.swing.JLabel();
        cboUsuario = new RSMaterialComponent.RSComboBoxMaterial();
        btnAltaUsuario = new RSMaterialComponent.RSButtonMaterialIconTwo();

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
        rSLabelTextIcon1.setText("Alta de órdenes");
        rSLabelTextIcon1.setIcons(null);
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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rSButtonIconOne1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSLabelTextIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel1.setText("Lugar:");

        jLabel2.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel2.setText("Equipo:");

        jLabel4.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel4.setText("Accesorios recibidos:");

        txtAccesorios.setBackground(new java.awt.Color(255, 255, 255));
        txtAccesorios.setForeground(new java.awt.Color(0, 0, 0));
        txtAccesorios.setColorMaterial(new java.awt.Color(51, 153, 255));
        txtAccesorios.setPhColor(new java.awt.Color(51, 153, 255));
        txtAccesorios.setPlaceholder("Ingrese los accesorios");
        txtAccesorios.setSelectionColor(new java.awt.Color(51, 153, 255));

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

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)), "Informe técnico", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog.plain", 0, 11), new java.awt.Color(0, 153, 255))); // NOI18N

        jLabel7.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel7.setText("Configuración de equipo:");

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setBorder(null);

        txaConfiguracion.setBorder(BorderFactory.createCompoundBorder(txaConfiguracion.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        txaConfiguracion.setBackground(new java.awt.Color(255, 255, 255));
        txaConfiguracion.setColumns(20);
        txaConfiguracion.setFont(new java.awt.Font("Dialog.plain", 0, 14)); // NOI18N
        txaConfiguracion.setForeground(new java.awt.Color(0, 0, 0));
        txaConfiguracion.setLineWrap(true);
        txaConfiguracion.setRows(3);
        txaConfiguracion.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2)));
        txaConfiguracion.setMargin(new java.awt.Insets(1, 1, 1, 1));
        txaConfiguracion.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        txaConfiguracion.setSelectionColor(new java.awt.Color(0, 153, 255));
        txaConfiguracion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txaConfiguracionKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(txaConfiguracion);

        jLabel8.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel8.setText("Diagnóstico:");

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setBorder(null);

        txaDiagnostico.setBackground(new java.awt.Color(255, 255, 255));
        txaDiagnostico.setColumns(20);
        txaDiagnostico.setFont(new java.awt.Font("Dialog.plain", 0, 14)); // NOI18N
        txaDiagnostico.setForeground(new java.awt.Color(0, 0, 0));
        txaDiagnostico.setLineWrap(true);
        txaDiagnostico.setRows(3);
        txaDiagnostico.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2)));
        txaDiagnostico.setMargin(new java.awt.Insets(1, 1, 1, 1));
        txaDiagnostico.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        txaDiagnostico.setSelectionColor(new java.awt.Color(0, 153, 255));
        txaDiagnostico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txaDiagnosticoKeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(txaDiagnostico);

        jLabel9.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel9.setText("Solución:");

        jScrollPane4.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane4.setBorder(null);

        txaSolucion.setBackground(new java.awt.Color(255, 255, 255));
        txaSolucion.setColumns(20);
        txaSolucion.setFont(new java.awt.Font("Dialog.plain", 0, 14)); // NOI18N
        txaSolucion.setForeground(new java.awt.Color(0, 0, 0));
        txaSolucion.setLineWrap(true);
        txaSolucion.setRows(3);
        txaSolucion.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2)));
        txaSolucion.setMargin(new java.awt.Insets(1, 1, 1, 1));
        txaSolucion.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        txaSolucion.setSelectionColor(new java.awt.Color(0, 153, 255));
        txaSolucion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txaSolucionKeyPressed(evt);
            }
        });
        jScrollPane4.setViewportView(txaSolucion);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel12.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel12.setText("Importe:");

        txtImporte.setBackground(new java.awt.Color(255, 255, 255));
        txtImporte.setForeground(new java.awt.Color(0, 0, 0));
        txtImporte.setColorMaterial(new java.awt.Color(51, 153, 255));
        txtImporte.setPhColor(new java.awt.Color(51, 153, 255));
        txtImporte.setPlaceholder("Ingrese el importe");
        txtImporte.setSelectionColor(new java.awt.Color(51, 153, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtImporte, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtImporte, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        grupoLugarAtencion.add(radioTaller);
        radioTaller.setForeground(new java.awt.Color(0, 153, 255));
        radioTaller.setText("Taller");
        radioTaller.setColorCheck(new java.awt.Color(0, 153, 255));
        radioTaller.setColorUnCheck(new java.awt.Color(0, 153, 255));
        radioTaller.setRippleColor(new java.awt.Color(0, 153, 255));

        grupoLugarAtencion.add(radioDomicilio);
        radioDomicilio.setForeground(new java.awt.Color(0, 153, 255));
        radioDomicilio.setText("A domicilio");
        radioDomicilio.setColorCheck(new java.awt.Color(0, 153, 255));
        radioDomicilio.setColorUnCheck(new java.awt.Color(0, 153, 255));
        radioDomicilio.setRippleColor(new java.awt.Color(0, 153, 255));

        cboEquipo.setColorMaterial(new java.awt.Color(0, 153, 255));

        btnAltaEquipo.setBackground(new java.awt.Color(0, 153, 51));
        btnAltaEquipo.setText("Alta equipo");
        btnAltaEquipo.setBackgroundHover(new java.awt.Color(0, 102, 0));
        btnAltaEquipo.setFont(new java.awt.Font("Roboto Bold", 1, 12)); // NOI18N
        btnAltaEquipo.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD);
        btnAltaEquipo.setMaximumSize(new java.awt.Dimension(75, 15));
        btnAltaEquipo.setMinimumSize(new java.awt.Dimension(75, 15));
        btnAltaEquipo.setRound(10);
        btnAltaEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAltaEquipoActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel5.setText("Detalle de orden:");

        txtDetalle.setBackground(new java.awt.Color(255, 255, 255));
        txtDetalle.setForeground(new java.awt.Color(0, 0, 0));
        txtDetalle.setColorMaterial(new java.awt.Color(51, 153, 255));
        txtDetalle.setPhColor(new java.awt.Color(51, 153, 255));
        txtDetalle.setPlaceholder("Ingrese el detalle de la orden");
        txtDetalle.setSelectionColor(new java.awt.Color(51, 153, 255));

        jLabel6.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel6.setText("Defectos reportados:");

        txtDefectos.setBackground(new java.awt.Color(255, 255, 255));
        txtDefectos.setForeground(new java.awt.Color(0, 0, 0));
        txtDefectos.setColorMaterial(new java.awt.Color(51, 153, 255));
        txtDefectos.setPhColor(new java.awt.Color(51, 153, 255));
        txtDefectos.setPlaceholder("Ingrese los defectos reportados por el cliente");
        txtDefectos.setSelectionColor(new java.awt.Color(51, 153, 255));

        jLabel10.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel10.setText("Condición:");

        grupoCondicion.add(radioFacturar);
        radioFacturar.setForeground(new java.awt.Color(0, 153, 255));
        radioFacturar.setText("A facturar");
        radioFacturar.setColorCheck(new java.awt.Color(0, 153, 255));
        radioFacturar.setColorUnCheck(new java.awt.Color(0, 153, 255));

        grupoCondicion.add(radioGarantia);
        radioGarantia.setForeground(new java.awt.Color(0, 153, 255));
        radioGarantia.setText("Garantía");
        radioGarantia.setColorCheck(new java.awt.Color(0, 153, 255));
        radioGarantia.setColorUnCheck(new java.awt.Color(0, 153, 255));

        jLabel11.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel11.setText("Técnico:");

        cboUsuario.setColorMaterial(new java.awt.Color(0, 153, 255));

        btnAltaUsuario.setBackground(new java.awt.Color(0, 153, 51));
        btnAltaUsuario.setText("Alta técnico");
        btnAltaUsuario.setBackgroundHover(new java.awt.Color(0, 102, 0));
        btnAltaUsuario.setFont(new java.awt.Font("Roboto Bold", 1, 12)); // NOI18N
        btnAltaUsuario.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD);
        btnAltaUsuario.setMaximumSize(new java.awt.Dimension(75, 15));
        btnAltaUsuario.setMinimumSize(new java.awt.Dimension(75, 15));
        btnAltaUsuario.setRound(10);
        btnAltaUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAltaUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioTaller, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(radioDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioFacturar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(radioGarantia, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(196, 196, 196)
                        .addComponent(cboEquipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(30, 30, 30)
                        .addComponent(btnAltaEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAccesorios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDetalle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(cboUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnAltaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtDefectos, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioTaller, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radioDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(radioFacturar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(radioGarantia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAltaEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel2))
                    .addComponent(cboEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtAccesorios, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtDefectos, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(cboUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAltaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed

        aplicarCambios();

    }//GEN-LAST:event_btnAceptarActionPerformed

    private void rSButtonIconOne1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonIconOne1ActionPerformed

        dispose();

    }//GEN-LAST:event_rSButtonIconOne1ActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

        dispose();

    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAltaEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltaEquipoActionPerformed

        abmEquipos.setVisible(true);
        cargarEquipos();
        cboEquipo.setSelectedIndex(cboEquipo.getItemCount()-1);

    }//GEN-LAST:event_btnAltaEquipoActionPerformed

    private void btnAltaUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltaUsuarioActionPerformed

        abmUsuarios.setVisible(true);
        cargarUsuarios();

    }//GEN-LAST:event_btnAltaUsuarioActionPerformed

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed

        x = evt.getX();
        y = evt.getY();
        
    }//GEN-LAST:event_jPanel2MousePressed

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged

        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
        
    }//GEN-LAST:event_jPanel2MouseDragged

    private void txaConfiguracionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaConfiguracionKeyPressed

        if(evt.getKeyCode() == KeyEvent.VK_TAB) {
            evt.consume();
            txaDiagnostico.requestFocus();
        }
        
    }//GEN-LAST:event_txaConfiguracionKeyPressed

    private void txaDiagnosticoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaDiagnosticoKeyPressed
        
        if(evt.getKeyCode() == KeyEvent.VK_TAB) {
            evt.consume();
            txaSolucion.requestFocus();
        }
        
    }//GEN-LAST:event_txaDiagnosticoKeyPressed

    private void txaSolucionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaSolucionKeyPressed

        if(evt.getKeyCode() == KeyEvent.VK_TAB) {
            evt.consume();
            btnAceptar.requestFocus();
        }
        
    }//GEN-LAST:event_txaSolucionKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSButtonMaterialIconTwo btnAceptar;
    private RSMaterialComponent.RSButtonMaterialIconTwo btnAltaEquipo;
    private RSMaterialComponent.RSButtonMaterialIconTwo btnAltaUsuario;
    private RSMaterialComponent.RSButtonMaterialIconTwo btnCancelar;
    private RSMaterialComponent.RSComboBoxMaterial cboEquipo;
    private RSMaterialComponent.RSComboBoxMaterial cboUsuario;
    private javax.swing.ButtonGroup grupoCondicion;
    private javax.swing.ButtonGroup grupoLugarAtencion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private RSMaterialComponent.RSButtonIconOne rSButtonIconOne1;
    private RSMaterialComponent.RSLabelTextIcon rSLabelTextIcon1;
    private RSMaterialComponent.RSRadioButtonMaterial radioDomicilio;
    private RSMaterialComponent.RSRadioButtonMaterial radioFacturar;
    private RSMaterialComponent.RSRadioButtonMaterial radioGarantia;
    private RSMaterialComponent.RSRadioButtonMaterial radioTaller;
    private javax.swing.JTextArea txaConfiguracion;
    private javax.swing.JTextArea txaDiagnostico;
    private javax.swing.JTextArea txaSolucion;
    private RSMaterialComponent.RSTextFieldMaterial txtAccesorios;
    private RSMaterialComponent.RSTextFieldMaterial txtDefectos;
    private RSMaterialComponent.RSTextFieldMaterial txtDetalle;
    private RSMaterialComponent.RSTextFieldMaterial txtImporte;
    // End of variables declaration//GEN-END:variables
}
