package com.ybc.orden.views;

import com.ybc.orden.entities.Cliente;
import com.ybc.orden.entities.Equipo;
import com.ybc.orden.entities.Orden;
import com.ybc.orden.entities.Usuario;
import com.ybc.orden.services.ClienteServiceImpl;
import com.ybc.orden.services.EquipoServiceImpl;
import com.ybc.orden.services.OrdenServiceImpl;
import com.ybc.orden.services.UsuarioServiceImpl;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import javax.annotation.PostConstruct;
import javax.swing.table.DefaultTableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MainFrame extends javax.swing.JFrame {

    int x;
    int y;
    int z;
    int w;
    static int idClientes;
    static int idEquipos;
    static int idUsuarios;
    static int idOrdenes;
    
    @Autowired
    private ClienteServiceImpl clienteService;
    @Autowired
    private OrdenServiceImpl ordenService;
    @Autowired
    private UsuarioServiceImpl usuarioService;
    @Autowired
    private EquipoServiceImpl equipoService;
    @Autowired
    private AltaClientes altaClientes;
    @Autowired
    private AltaEquipos altaEquipos;
    @Autowired
    private AltaUsuarios altaUsuarios;
    @Autowired
    private AltaOrdenes altaOrdenes;
    @Autowired
    private ModificaClientes modificaClientes;
    @Autowired
    private ModificaEquipos modificaEquipos;
    @Autowired
    private ModificaUsuarios modificaUsuarios;
    @Autowired
    private ModificaOrdenes modificaOrdenes;
    

    public MainFrame() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        panelOrdenes.setVisible(true);
        panelClientes.setVisible(false);
        panelEquipos.setVisible(false);
        panelUsuarios.setVisible(false);

    }

    @PostConstruct
    private void setModal() {
        altaClientes.setModal(true);
        altaUsuarios.setModal(true);
        altaEquipos.setModal(true);
        altaOrdenes.setModal(true);
        modificaClientes.setModal(true);
        modificaEquipos.setModal(true);
        modificaUsuarios.setModal(true);
    }

    @PostConstruct
    public void cargarTablaOrdenes() {
        SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
        DefaultTableModel modelOrdenes = (DefaultTableModel) tablaOrdenes.getModel();
        List<Orden> datosOrdenes = StreamSupport
                .stream(ordenService.findAll().spliterator(), false)
                .collect(Collectors.toList());
        modelOrdenes.setNumRows(0);

        for (Orden datos : datosOrdenes) {
            Object[] fila = {datos.getId(), sd.format(datos.getEntrada()), datos.getEquipo().getMarca(), datos.getEquipo().getCliente().getApellido() + ", " + datos.getEquipo().getCliente().getNombre()};
            modelOrdenes.addRow(fila);
        }
        tablaOrdenes.getColumnModel().getColumn(0).setMaxWidth(0);
        tablaOrdenes.getColumnModel().getColumn(0).setMinWidth(0);
        tablaOrdenes.getColumnModel().getColumn(0).setPreferredWidth(0);

    }

    public void cargarTablaClientes() {

        DefaultTableModel modelClientes = (DefaultTableModel) tablaClientes.getModel();
        List<Cliente> datosClientes = StreamSupport
                .stream(clienteService.findAll().spliterator(), false)
                .collect(Collectors.toList());
        modelClientes.setNumRows(0);

        for (Cliente datos : datosClientes) {
            Object[] fila = {datos.getId(), datos.getApellido(), datos.getNombre(), datos.getCuit()};
            modelClientes.addRow(fila);
        }

        tablaClientes.getColumnModel().getColumn(0).setMaxWidth(0);
        tablaClientes.getColumnModel().getColumn(0).setMinWidth(0);
        tablaClientes.getColumnModel().getColumn(0).setPreferredWidth(0);

    }

    public void cargarTablaEquipos() {

        DefaultTableModel modelEquipos = (DefaultTableModel) tablaEquipos.getModel();
        List<Equipo> datosEquipos = StreamSupport
                .stream(equipoService.findAll().spliterator(), false)
                .collect(Collectors.toList());
        modelEquipos.setNumRows(0);

        for (Equipo datos : datosEquipos) {
            Object[] fila = {datos.getId(), datos.getMarca(), datos.getModelo(), datos.getCliente().getApellido() + ", " + datos.getCliente().getNombre()};
            modelEquipos.addRow(fila);
        }
        
        tablaEquipos.getColumnModel().getColumn(0).setMaxWidth(0);
        tablaEquipos.getColumnModel().getColumn(0).setMinWidth(0);
        tablaEquipos.getColumnModel().getColumn(0).setPreferredWidth(0);

    }

    public void cargarTablaUsuarios() {

        DefaultTableModel modelUsuarios = (DefaultTableModel) tablaUsuarios.getModel();
        List<Usuario> datosUsuarios = StreamSupport
                .stream(usuarioService.findAll().spliterator(), false)
                .collect(Collectors.toList());
        modelUsuarios.setNumRows(0);

        for (Usuario datos : datosUsuarios) {
            Object[] fila = {datos.getId(), datos.getApellido(), datos.getNombre(), datos.getDni(), datos.getUsuario()};
            modelUsuarios.addRow(fila);
        }
        
        tablaUsuarios.getColumnModel().getColumn(0).setMaxWidth(0);
        tablaUsuarios.getColumnModel().getColumn(0).setMinWidth(0);
        tablaUsuarios.getColumnModel().getColumn(0).setPreferredWidth(0);

    }
    
    void modificarCliente() {
        modificaClientes.cargarDatos();
        modificaClientes.setVisible(true);
        cargarTablaClientes();
    }
    
    void modificarEquipo() {
        modificaEquipos.cargarDatos();
        modificaEquipos.setVisible(true);
        cargarTablaEquipos();
    }
    
    void modificarUsuario() {
        modificaUsuarios.cargarDatos();
        modificaUsuarios.setVisible(true);
        cargarTablaUsuarios();
    }
    void modificarOrden() {
        modificaOrdenes.cargarDatos();
        modificaOrdenes.setVisible(true);
        cargarTablaOrdenes();
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
        panelTablaOrdenes = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaOrdenes = new RSMaterialComponent.RSTableMetro();
        btnModificarOrden = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnNuevaOrden = new RSMaterialComponent.RSButtonMaterialIconOne();
        panelClientes = new javax.swing.JPanel();
        panelTablaClientes = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaClientes = new RSMaterialComponent.RSTableMetro();
        btnModificarCliente = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnNuevoCliente = new RSMaterialComponent.RSButtonMaterialIconOne();
        panelEquipos = new javax.swing.JPanel();
        panelTablaEquipos = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaEquipos = new RSMaterialComponent.RSTableMetro();
        btnNuevoEquipo = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnModificarEquipo = new RSMaterialComponent.RSButtonMaterialIconOne();
        panelUsuarios = new javax.swing.JPanel();
        panelTablaUsuarios = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaUsuarios = new RSMaterialComponent.RSTableMetro();
        btnNuevoUsuario = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnModificarUsuario = new RSMaterialComponent.RSButtonMaterialIconOne();
        panelBotonCerrar = new javax.swing.JPanel();
        btnCerrar = new RSMaterialComponent.RSButtonIconOne();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelPrincipal.setBackground(new java.awt.Color(51, 153, 255));
        panelPrincipal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        panelLateral.setBackground(new java.awt.Color(255, 255, 255));
        panelLateral.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255)));
        panelLateral.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panelLateralMouseDragged(evt);
            }
        });
        panelLateral.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelLateralMousePressed(evt);
            }
        });

        rSLabelIcon1.setForeground(new java.awt.Color(51, 153, 255));
        rSLabelIcon1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.TOUCH_APP);
        rSLabelIcon1.setSizeIcon(150.0F);

        panelBotones.setBackground(new java.awt.Color(255, 255, 255));

        btnOrdenes.setBackground(new java.awt.Color(255, 153, 51));
        btnOrdenes.setText("Ordenes");
        btnOrdenes.setBackgroundHover(new java.awt.Color(204, 102, 0));
        btnOrdenes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnOrdenes.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.OFFLINE_PIN);
        btnOrdenes.setRound(20);
        btnOrdenes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenesActionPerformed(evt);
            }
        });

        btnClientes.setBackground(new java.awt.Color(255, 153, 51));
        btnClientes.setText("Clientes");
        btnClientes.setBackgroundHover(new java.awt.Color(204, 102, 0));
        btnClientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnClientes.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.WORK);
        btnClientes.setRound(20);
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });

        btnUsuarios.setBackground(new java.awt.Color(255, 153, 51));
        btnUsuarios.setText("Usuarios");
        btnUsuarios.setBackgroundHover(new java.awt.Color(204, 102, 0));
        btnUsuarios.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnUsuarios.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ACCOUNT_CIRCLE);
        btnUsuarios.setRound(20);
        btnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuariosActionPerformed(evt);
            }
        });

        btnEquipos.setBackground(new java.awt.Color(255, 153, 51));
        btnEquipos.setText("Equipos");
        btnEquipos.setBackgroundHover(new java.awt.Color(204, 102, 0));
        btnEquipos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnEquipos.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.COMPUTER);
        btnEquipos.setRound(20);
        btnEquipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEquiposActionPerformed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(255, 51, 51));
        btnSalir.setText("Salir");
        btnSalir.setBackgroundHover(new java.awt.Color(153, 0, 0));
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
                .addContainerGap())
        );

        panelContenedor.setBackground(new java.awt.Color(51, 153, 255));
        panelContenedor.setLayout(new javax.swing.OverlayLayout(panelContenedor));

        panelOrdenes.setBackground(new java.awt.Color(51, 153, 255));

        panelTablaOrdenes.setBackground(new java.awt.Color(51, 153, 255));

        tablaOrdenes.setForeground(new java.awt.Color(255, 255, 255));
        tablaOrdenes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Fecha", "Equipo", "Cliente"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaOrdenes.setBackgoundHead(new java.awt.Color(0, 0, 0));
        tablaOrdenes.setBackgoundHover(new java.awt.Color(0, 102, 255));
        tablaOrdenes.setColorBorderHead(new java.awt.Color(204, 204, 204));
        tablaOrdenes.setColorBorderRows(new java.awt.Color(255, 255, 255));
        tablaOrdenes.setColorPrimaryText(new java.awt.Color(0, 102, 255));
        tablaOrdenes.setColorSecundaryText(new java.awt.Color(0, 102, 255));
        tablaOrdenes.setSelectionBackground(new java.awt.Color(0, 102, 255));
        tablaOrdenes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaOrdenesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaOrdenes);

        javax.swing.GroupLayout panelTablaOrdenesLayout = new javax.swing.GroupLayout(panelTablaOrdenes);
        panelTablaOrdenes.setLayout(panelTablaOrdenesLayout);
        panelTablaOrdenesLayout.setHorizontalGroup(
            panelTablaOrdenesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaOrdenesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 784, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelTablaOrdenesLayout.setVerticalGroup(
            panelTablaOrdenesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTablaOrdenesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnModificarOrden.setBackground(new java.awt.Color(255, 255, 255));
        btnModificarOrden.setText("Modificar orden");
        btnModificarOrden.setBackgroundHover(new java.awt.Color(102, 102, 102));
        btnModificarOrden.setForegroundText(new java.awt.Color(51, 153, 255));
        btnModificarOrden.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnModificarOrden.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.MOUSE);
        btnModificarOrden.setRound(20);
        btnModificarOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarOrdenActionPerformed(evt);
            }
        });

        btnNuevaOrden.setBackground(new java.awt.Color(0, 153, 51));
        btnNuevaOrden.setText("Nueva orden");
        btnNuevaOrden.setBackgroundHover(new java.awt.Color(0, 102, 0));
        btnNuevaOrden.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnNuevaOrden.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD);
        btnNuevaOrden.setRound(20);
        btnNuevaOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaOrdenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelOrdenesLayout = new javax.swing.GroupLayout(panelOrdenes);
        panelOrdenes.setLayout(panelOrdenesLayout);
        panelOrdenesLayout.setHorizontalGroup(
            panelOrdenesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTablaOrdenes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelOrdenesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevaOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnModificarOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelOrdenesLayout.setVerticalGroup(
            panelOrdenesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOrdenesLayout.createSequentialGroup()
                .addComponent(panelTablaOrdenes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelOrdenesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificarOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevaOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panelContenedor.add(panelOrdenes);

        panelClientes.setBackground(new java.awt.Color(51, 153, 255));

        panelTablaClientes.setBackground(new java.awt.Color(51, 153, 255));

        tablaClientes.setForeground(new java.awt.Color(255, 255, 255));
        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Apellido", "Nombre", "CUIT"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

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
        jScrollPane3.setViewportView(tablaClientes);

        javax.swing.GroupLayout panelTablaClientesLayout = new javax.swing.GroupLayout(panelTablaClientes);
        panelTablaClientes.setLayout(panelTablaClientesLayout);
        panelTablaClientesLayout.setHorizontalGroup(
            panelTablaClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        panelTablaClientesLayout.setVerticalGroup(
            panelTablaClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnModificarCliente.setBackground(new java.awt.Color(255, 255, 255));
        btnModificarCliente.setText("Modificar cliente");
        btnModificarCliente.setBackgroundHover(new java.awt.Color(102, 102, 102));
        btnModificarCliente.setForegroundText(new java.awt.Color(51, 153, 255));
        btnModificarCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnModificarCliente.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.MOUSE);
        btnModificarCliente.setRound(20);
        btnModificarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarClienteActionPerformed(evt);
            }
        });

        btnNuevoCliente.setBackground(new java.awt.Color(0, 153, 51));
        btnNuevoCliente.setText("Nuevo cliente");
        btnNuevoCliente.setBackgroundHover(new java.awt.Color(0, 102, 0));
        btnNuevoCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnNuevoCliente.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD);
        btnNuevoCliente.setRound(20);
        btnNuevoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelClientesLayout = new javax.swing.GroupLayout(panelClientes);
        panelClientes.setLayout(panelClientesLayout);
        panelClientesLayout.setHorizontalGroup(
            panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 324, Short.MAX_VALUE)
                .addComponent(btnModificarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(panelTablaClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelClientesLayout.setVerticalGroup(
            panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelClientesLayout.createSequentialGroup()
                .addComponent(panelTablaClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        panelContenedor.add(panelClientes);

        panelEquipos.setBackground(new java.awt.Color(51, 153, 255));

        panelTablaEquipos.setBackground(new java.awt.Color(51, 153, 255));

        tablaEquipos.setForeground(new java.awt.Color(255, 255, 255));
        tablaEquipos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Marca", "Modelo", "Cliente"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaEquipos.setBackgoundHead(new java.awt.Color(0, 0, 0));
        tablaEquipos.setBackgoundHover(new java.awt.Color(0, 102, 255));
        tablaEquipos.setColorBorderHead(new java.awt.Color(204, 204, 204));
        tablaEquipos.setColorBorderRows(new java.awt.Color(255, 255, 255));
        tablaEquipos.setColorPrimaryText(new java.awt.Color(0, 102, 255));
        tablaEquipos.setColorSecundaryText(new java.awt.Color(0, 102, 255));
        tablaEquipos.setSelectionBackground(new java.awt.Color(0, 102, 255));
        tablaEquipos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaEquiposMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaEquipos);

        javax.swing.GroupLayout panelTablaEquiposLayout = new javax.swing.GroupLayout(panelTablaEquipos);
        panelTablaEquipos.setLayout(panelTablaEquiposLayout);
        panelTablaEquiposLayout.setHorizontalGroup(
            panelTablaEquiposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaEquiposLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        panelTablaEquiposLayout.setVerticalGroup(
            panelTablaEquiposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaEquiposLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnNuevoEquipo.setBackground(new java.awt.Color(0, 153, 51));
        btnNuevoEquipo.setText("Nuevo equipo");
        btnNuevoEquipo.setBackgroundHover(new java.awt.Color(0, 102, 0));
        btnNuevoEquipo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnNuevoEquipo.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD);
        btnNuevoEquipo.setRound(20);
        btnNuevoEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoEquipoActionPerformed(evt);
            }
        });

        btnModificarEquipo.setBackground(new java.awt.Color(255, 255, 255));
        btnModificarEquipo.setText("Modificar equipo");
        btnModificarEquipo.setBackgroundHover(new java.awt.Color(102, 102, 102));
        btnModificarEquipo.setForegroundText(new java.awt.Color(51, 153, 255));
        btnModificarEquipo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnModificarEquipo.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.MOUSE);
        btnModificarEquipo.setRound(20);
        btnModificarEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarEquipoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelEquiposLayout = new javax.swing.GroupLayout(panelEquipos);
        panelEquipos.setLayout(panelEquiposLayout);
        panelEquiposLayout.setHorizontalGroup(
            panelEquiposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEquiposLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevoEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 324, Short.MAX_VALUE)
                .addComponent(btnModificarEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(panelTablaEquipos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelEquiposLayout.setVerticalGroup(
            panelEquiposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEquiposLayout.createSequentialGroup()
                .addComponent(panelTablaEquipos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelEquiposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificarEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevoEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panelContenedor.add(panelEquipos);

        panelUsuarios.setBackground(new java.awt.Color(51, 153, 255));

        panelTablaUsuarios.setBackground(new java.awt.Color(51, 153, 255));

        tablaUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        tablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Apellido", "Nombre", "DNI", "Usuario"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaUsuarios.setBackgoundHead(new java.awt.Color(0, 0, 0));
        tablaUsuarios.setBackgoundHover(new java.awt.Color(0, 102, 255));
        tablaUsuarios.setColorBorderHead(new java.awt.Color(204, 204, 204));
        tablaUsuarios.setColorBorderRows(new java.awt.Color(204, 204, 204));
        tablaUsuarios.setColorPrimaryText(new java.awt.Color(0, 102, 255));
        tablaUsuarios.setColorSecundaryText(new java.awt.Color(0, 102, 255));
        tablaUsuarios.setSelectionBackground(new java.awt.Color(0, 102, 255));
        tablaUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaUsuariosMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tablaUsuarios);

        javax.swing.GroupLayout panelTablaUsuariosLayout = new javax.swing.GroupLayout(panelTablaUsuarios);
        panelTablaUsuarios.setLayout(panelTablaUsuariosLayout);
        panelTablaUsuariosLayout.setHorizontalGroup(
            panelTablaUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaUsuariosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addContainerGap())
        );
        panelTablaUsuariosLayout.setVerticalGroup(
            panelTablaUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaUsuariosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnNuevoUsuario.setBackground(new java.awt.Color(0, 153, 51));
        btnNuevoUsuario.setText("Nuevo usuario");
        btnNuevoUsuario.setBackgroundHover(new java.awt.Color(0, 102, 0));
        btnNuevoUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnNuevoUsuario.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD);
        btnNuevoUsuario.setRound(20);
        btnNuevoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoUsuarioActionPerformed(evt);
            }
        });

        btnModificarUsuario.setBackground(new java.awt.Color(255, 255, 255));
        btnModificarUsuario.setForeground(new java.awt.Color(51, 153, 255));
        btnModificarUsuario.setText("Modificar usuario");
        btnModificarUsuario.setBackgroundHover(new java.awt.Color(102, 102, 102));
        btnModificarUsuario.setForegroundText(new java.awt.Color(51, 153, 255));
        btnModificarUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnModificarUsuario.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.MOUSE);
        btnModificarUsuario.setRound(20);
        btnModificarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelUsuariosLayout = new javax.swing.GroupLayout(panelUsuarios);
        panelUsuarios.setLayout(panelUsuariosLayout);
        panelUsuariosLayout.setHorizontalGroup(
            panelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUsuariosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 324, Short.MAX_VALUE)
                .addComponent(btnModificarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(panelTablaUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelUsuariosLayout.setVerticalGroup(
            panelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelUsuariosLayout.createSequentialGroup()
                .addComponent(panelTablaUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panelContenedor.add(panelUsuarios);

        panelBotonCerrar.setBackground(new java.awt.Color(51, 153, 255));
        panelBotonCerrar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panelBotonCerrarMouseDragged(evt);
            }
        });
        panelBotonCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelBotonCerrarMousePressed(evt);
            }
        });

        btnCerrar.setBackground(new java.awt.Color(255, 255, 255));
        btnCerrar.setForeground(new java.awt.Color(255, 51, 51));
        btnCerrar.setBackgroundHover(new java.awt.Color(153, 0, 0));
        btnCerrar.setForegroundText(new java.awt.Color(255, 51, 51));
        btnCerrar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CLOSE);
        btnCerrar.setSizeIcon(20.0F);
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBotonCerrarLayout = new javax.swing.GroupLayout(panelBotonCerrar);
        panelBotonCerrar.setLayout(panelBotonCerrarLayout);
        panelBotonCerrarLayout.setHorizontalGroup(
            panelBotonCerrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBotonCerrarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelBotonCerrarLayout.setVerticalGroup(
            panelBotonCerrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonCerrarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText(" Usuario: ");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel2.setFont(new java.awt.Font("Dialog.plain", 0, 14)); // NOI18N
        jLabel2.setText("Usuario prueba");

        jLabel3.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        jLabel3.setText("ybcomputacion.com");

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addComponent(panelLateral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelBotonCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addContainerGap())))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelLateral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addComponent(panelBotonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addContainerGap())
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
        cargarTablaOrdenes();

    }//GEN-LAST:event_btnOrdenesActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed

        System.exit(0);

    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed

        panelOrdenes.setVisible(false);
        panelClientes.setVisible(true);
        panelEquipos.setVisible(false);
        panelUsuarios.setVisible(false);
        cargarTablaClientes();

    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnEquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEquiposActionPerformed

        panelOrdenes.setVisible(false);
        panelClientes.setVisible(false);
        panelEquipos.setVisible(true);
        panelUsuarios.setVisible(false);
        cargarTablaEquipos();

    }//GEN-LAST:event_btnEquiposActionPerformed

    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosActionPerformed

        panelOrdenes.setVisible(false);
        panelClientes.setVisible(false);
        panelEquipos.setVisible(false);
        panelUsuarios.setVisible(true);
        cargarTablaUsuarios();

    }//GEN-LAST:event_btnUsuariosActionPerformed

    private void btnNuevoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoClienteActionPerformed

        idClientes = 0;
        altaClientes.setVisible(true);
        cargarTablaClientes();

    }//GEN-LAST:event_btnNuevoClienteActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed

        System.exit(0);

    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnModificarOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarOrdenActionPerformed

        altaOrdenes.setVisible(true);
        cargarTablaOrdenes();

    }//GEN-LAST:event_btnModificarOrdenActionPerformed

    private void btnNuevaOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaOrdenActionPerformed

        altaOrdenes.setVisible(true);
        cargarTablaOrdenes();
        


    }//GEN-LAST:event_btnNuevaOrdenActionPerformed

    private void btnModificarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarClienteActionPerformed

        altaClientes.setVisible(true);
        cargarTablaClientes();

    }//GEN-LAST:event_btnModificarClienteActionPerformed

    private void btnNuevoEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoEquipoActionPerformed

        altaEquipos.setVisible(true);
        cargarTablaEquipos();

    }//GEN-LAST:event_btnNuevoEquipoActionPerformed

    private void btnModificarEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarEquipoActionPerformed

        altaEquipos.setVisible(true);
        cargarTablaEquipos();

    }//GEN-LAST:event_btnModificarEquipoActionPerformed

    private void btnNuevoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoUsuarioActionPerformed

        altaUsuarios.setVisible(true);
        cargarTablaUsuarios();

    }//GEN-LAST:event_btnNuevoUsuarioActionPerformed

    private void btnModificarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarUsuarioActionPerformed

        altaUsuarios.setVisible(true);
        cargarTablaUsuarios();

    }//GEN-LAST:event_btnModificarUsuarioActionPerformed

    private void panelBotonCerrarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBotonCerrarMousePressed

        x = evt.getX();
        y = evt.getY();

    }//GEN-LAST:event_panelBotonCerrarMousePressed

    private void panelBotonCerrarMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBotonCerrarMouseDragged

        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);

    }//GEN-LAST:event_panelBotonCerrarMouseDragged

    private void panelLateralMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelLateralMousePressed

        z = evt.getX();
        w = evt.getY();

    }//GEN-LAST:event_panelLateralMousePressed

    private void panelLateralMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelLateralMouseDragged

        this.setLocation(this.getLocation().x + evt.getX() - z, this.getLocation().y + evt.getY() - w);

    }//GEN-LAST:event_panelLateralMouseDragged

    private void tablaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaClientesMouseClicked

        if (evt.getClickCount() == 2) {
            Optional<Cliente> cliente = clienteService.findById(Integer.valueOf(tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 0).toString()));
            idClientes = cliente.get().getId();            
            modificarCliente();
            
        }

    }//GEN-LAST:event_tablaClientesMouseClicked

    private void tablaEquiposMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEquiposMouseClicked
      
        if (evt.getClickCount() == 2) {
            Optional<Equipo> equipo = equipoService.findById(Integer.valueOf(tablaEquipos.getValueAt(tablaEquipos.getSelectedRow(), 0).toString()));
            idEquipos = equipo.get().getId();            
            modificarEquipo();
            
        }
        
    }//GEN-LAST:event_tablaEquiposMouseClicked

    private void tablaUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaUsuariosMouseClicked
        
        if (evt.getClickCount() == 2) {
            Optional<Usuario> usuario = usuarioService.findById(Integer.valueOf(tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 0).toString()));
            idUsuarios = usuario.get().getId();            
            modificarUsuario();
            
        }
        
    }//GEN-LAST:event_tablaUsuariosMouseClicked

    private void tablaOrdenesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaOrdenesMouseClicked

        if (evt.getClickCount() == 2) {
            Optional<Orden> orden = ordenService.findById(Integer.valueOf(tablaOrdenes.getValueAt(tablaOrdenes.getSelectedRow(), 0).toString()));
            idOrdenes = orden.get().getId();            
            modificarOrden();
            
        }
        
    }//GEN-LAST:event_tablaOrdenesMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSButtonIconOne btnCerrar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnClientes;
    private RSMaterialComponent.RSButtonMaterialIconOne btnEquipos;
    private RSMaterialComponent.RSButtonMaterialIconOne btnModificarCliente;
    private RSMaterialComponent.RSButtonMaterialIconOne btnModificarEquipo;
    private RSMaterialComponent.RSButtonMaterialIconOne btnModificarOrden;
    private RSMaterialComponent.RSButtonMaterialIconOne btnModificarUsuario;
    private RSMaterialComponent.RSButtonMaterialIconOne btnNuevaOrden;
    private RSMaterialComponent.RSButtonMaterialIconOne btnNuevoCliente;
    private RSMaterialComponent.RSButtonMaterialIconOne btnNuevoEquipo;
    private RSMaterialComponent.RSButtonMaterialIconOne btnNuevoUsuario;
    private RSMaterialComponent.RSButtonMaterialIconOne btnOrdenes;
    private RSMaterialComponent.RSButtonMaterialIconOne btnSalir;
    private RSMaterialComponent.RSButtonMaterialIconOne btnUsuarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel panelBotonCerrar;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelClientes;
    private javax.swing.JPanel panelContenedor;
    private javax.swing.JPanel panelEquipos;
    private javax.swing.JPanel panelLateral;
    private javax.swing.JPanel panelOrdenes;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelTablaClientes;
    private javax.swing.JPanel panelTablaEquipos;
    private javax.swing.JPanel panelTablaOrdenes;
    private javax.swing.JPanel panelTablaUsuarios;
    private javax.swing.JPanel panelUsuarios;
    private RSMaterialComponent.RSLabelIcon rSLabelIcon1;
    private RSMaterialComponent.RSTableMetro tablaClientes;
    private RSMaterialComponent.RSTableMetro tablaEquipos;
    public static RSMaterialComponent.RSTableMetro tablaOrdenes;
    private RSMaterialComponent.RSTableMetro tablaUsuarios;
    // End of variables declaration//GEN-END:variables

}
