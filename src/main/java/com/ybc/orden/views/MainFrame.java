package com.ybc.orden.views;

import com.ybc.orden.entities.Cliente;
import com.ybc.orden.entities.Equipo;
import com.ybc.orden.entities.EstadoOrden;
import com.ybc.orden.entities.Orden;
import com.ybc.orden.entities.Usuario;
import com.ybc.orden.services.ClienteServiceImpl;
import com.ybc.orden.services.EquipoServiceImpl;
import com.ybc.orden.services.EstadoOrdenServiceImpl;
import com.ybc.orden.services.OrdenServiceImpl;
import com.ybc.orden.services.UsuarioServiceImpl;
import com.ybc.orden.util.Report;
import java.awt.Color;
import static java.awt.Frame.ICONIFIED;
import java.text.SimpleDateFormat;
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
public class MainFrame extends javax.swing.JFrame {

    int x;
    int y;
    int z;
    int w;
    static int idClientes;
    static int idEquipos;
    static int idUsuarios;
    static int idOrdenes;
    static int idEstado;
    public String usuario;
    public static int idUsuario;
    DefaultTableModel modelOrdenes;
    DefaultTableModel modelClientes;
    DefaultTableModel modelEquipos;
    DefaultTableModel modelUsuarios;
    SimpleDateFormat dateFormat;

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
    @Autowired
    private Estado estado;
    @Autowired
    private EstadoOrdenServiceImpl estadoOrdenService;
    

    public MainFrame() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        panelOrdenes.setVisible(true);
        panelClientes.setVisible(false);
        panelEquipos.setVisible(false);
        panelUsuarios.setVisible(false);
        txtBuscar.requestFocus();
        dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    }

    @PostConstruct
    private void setModal() {
        btnOrdenes.setBackground(Color.decode("#cc6600"));
        altaClientes.setModal(true);
        altaUsuarios.setModal(true);
        altaEquipos.setModal(true);
        altaOrdenes.setModal(true);
        estado.setModal(true);
        modificaClientes.setModal(true);
        modificaEquipos.setModal(true);
        modificaUsuarios.setModal(true);        
    }

    @PostConstruct
    public void cargarTablaOrdenes() {
        modelOrdenes = (DefaultTableModel) tablaOrdenes.getModel();
        List<EstadoOrden> datosOrdenes = StreamSupport
                .stream(estadoOrdenService.findAll().spliterator(), false)
                .collect(Collectors.toList());
        modelOrdenes.setNumRows(0);

        for (EstadoOrden datos : datosOrdenes) {
            Object[] fila = {datos.getOrden().getId(), dateFormat.format(datos.getFecha()), datos.getOrden().getEquipo(), datos.getOrden().getEquipo().getCliente().toString(), datos.getOrden().getUsuario().toString(), datos.getEstado(), datos.getId(), datos.getOrden().getUsuario().getId()};
            modelOrdenes.addRow(fila);
        }

        tablaOrdenes.getColumnModel().getColumn(0).setMaxWidth(70);
        tablaOrdenes.getColumnModel().getColumn(0).setMinWidth(70);
        tablaOrdenes.getColumnModel().getColumn(0).setPreferredWidth(70);

        tablaOrdenes.getColumnModel().getColumn(1).setMaxWidth(90);
        tablaOrdenes.getColumnModel().getColumn(1).setMinWidth(90);
        tablaOrdenes.getColumnModel().getColumn(1).setPreferredWidth(90);

        tablaOrdenes.getColumnModel().getColumn(3).setMaxWidth(140);
        tablaOrdenes.getColumnModel().getColumn(3).setMinWidth(140);
        tablaOrdenes.getColumnModel().getColumn(3).setPreferredWidth(140);

        tablaOrdenes.getColumnModel().getColumn(4).setMaxWidth(140);
        tablaOrdenes.getColumnModel().getColumn(4).setMinWidth(140);
        tablaOrdenes.getColumnModel().getColumn(4).setPreferredWidth(140);

        tablaOrdenes.getColumnModel().getColumn(5).setMaxWidth(80);
        tablaOrdenes.getColumnModel().getColumn(5).setMinWidth(80);
        tablaOrdenes.getColumnModel().getColumn(5).setPreferredWidth(80);

        tablaOrdenes.getColumnModel().getColumn(6).setMaxWidth(0);
        tablaOrdenes.getColumnModel().getColumn(6).setMinWidth(0);
        tablaOrdenes.getColumnModel().getColumn(6).setPreferredWidth(0);
        tablaOrdenes.getColumnModel().getColumn(7).setMaxWidth(0);
        tablaOrdenes.getColumnModel().getColumn(7).setMinWidth(0);
        tablaOrdenes.getColumnModel().getColumn(7).setPreferredWidth(0);
    }

    public void cargarTablaClientes() {

        modelClientes = (DefaultTableModel) tablaClientes.getModel();
        List<Cliente> datosClientes = StreamSupport
                .stream(clienteService.findAll().spliterator(), false)
                .collect(Collectors.toList());
        modelClientes.setNumRows(0);

        for (Cliente datos : datosClientes) {
            Object[] fila = {datos.getId(), datos.getApellido(), datos.getNombre(), datos.getCuit(), datos.getEstado()};
            modelClientes.addRow(fila);
        }

        tablaClientes.getColumnModel().getColumn(0).setMaxWidth(0);
        tablaClientes.getColumnModel().getColumn(0).setMinWidth(0);
        tablaClientes.getColumnModel().getColumn(0).setPreferredWidth(0);

    }

    public void cargarTablaEquipos() {

        modelEquipos = (DefaultTableModel) tablaEquipos.getModel();
        List<Equipo> datosEquipos = StreamSupport
                .stream(equipoService.findAll().spliterator(), false)
                .collect(Collectors.toList());
        modelEquipos.setNumRows(0);

        for (Equipo datos : datosEquipos) {
            Object[] fila = {datos.getId(), datos.getMarca(), datos.getModelo(), datos.getCliente().getApellido() + ", " + datos.getCliente().getNombre(), datos.getEstado()};
            modelEquipos.addRow(fila);
        }

        tablaEquipos.getColumnModel().getColumn(0).setMaxWidth(0);
        tablaEquipos.getColumnModel().getColumn(0).setMinWidth(0);
        tablaEquipos.getColumnModel().getColumn(0).setPreferredWidth(0);

    }

    public void cargarTablaUsuarios() {

        modelUsuarios = (DefaultTableModel) tablaUsuarios.getModel();
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
    
    void bajaCliente (int id) {
        Cliente cliente = clienteService.findById(id).get();
        cliente.setEstado(false);        
        clienteService.save(cliente);
    }
    
    void bajaEquipo (int id) {
        Equipo equipo = equipoService.findById(id).get();
        equipo.setEstado(false);        
        equipoService.save(equipo);
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
        txtBuscar = new RSMaterialComponent.RSTextFieldMaterial();
        rSLabelIcon2 = new RSMaterialComponent.RSLabelIcon();
        btnModificarOrden = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnNuevaOrden = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnNuevaOrden1 = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnNuevaOrden2 = new RSMaterialComponent.RSButtonMaterialIconOne();
        panelClientes = new javax.swing.JPanel();
        panelTablaClientes = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaClientes = new RSMaterialComponent.RSTableMetro();
        txtBuscarCliente = new RSMaterialComponent.RSTextFieldMaterial();
        rSLabelIcon3 = new RSMaterialComponent.RSLabelIcon();
        btnModificarCliente = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnNuevoCliente = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnNuevoCliente1 = new RSMaterialComponent.RSButtonMaterialIconOne();
        panelEquipos = new javax.swing.JPanel();
        panelTablaEquipos = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaEquipos = new RSMaterialComponent.RSTableMetro();
        txtBuscarEquipo = new RSMaterialComponent.RSTextFieldMaterial();
        rSLabelIcon4 = new RSMaterialComponent.RSLabelIcon();
        btnNuevoEquipo = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnModificarEquipo = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnBajaEquipo = new RSMaterialComponent.RSButtonMaterialIconOne();
        panelUsuarios = new javax.swing.JPanel();
        panelTablaUsuarios = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaUsuarios = new RSMaterialComponent.RSTableMetro();
        rSLabelIcon5 = new RSMaterialComponent.RSLabelIcon();
        txtBuscarUsuario = new RSMaterialComponent.RSTextFieldMaterial();
        btnNuevoUsuario = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnModificarUsuario = new RSMaterialComponent.RSButtonMaterialIconOne();
        panelBotonCerrar = new javax.swing.JPanel();
        btnCerrar = new RSMaterialComponent.RSButtonIconOne();
        jLabel2 = new javax.swing.JLabel();
        btnCerrar1 = new RSMaterialComponent.RSButtonIconOne();
        jLabel1 = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
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
                "Número", "Fecha", "Equipo", "Cliente", "Técnico", "Estado", "idEstado", "idUsuario"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
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

        rSLabelIcon2.setForeground(new java.awt.Color(255, 255, 255));
        rSLabelIcon2.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SEARCH);

        javax.swing.GroupLayout panelTablaOrdenesLayout = new javax.swing.GroupLayout(panelTablaOrdenes);
        panelTablaOrdenes.setLayout(panelTablaOrdenesLayout);
        panelTablaOrdenesLayout.setHorizontalGroup(
            panelTablaOrdenesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaOrdenesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTablaOrdenesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 784, Short.MAX_VALUE)
                    .addGroup(panelTablaOrdenesLayout.createSequentialGroup()
                        .addComponent(rSLabelIcon2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelTablaOrdenesLayout.setVerticalGroup(
            panelTablaOrdenesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTablaOrdenesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTablaOrdenesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSLabelIcon2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnModificarOrden.setBackground(new java.awt.Color(255, 255, 255));
        btnModificarOrden.setText("Modificar orden");
        btnModificarOrden.setBackgroundHover(new java.awt.Color(102, 102, 102));
        btnModificarOrden.setForegroundText(new java.awt.Color(51, 153, 255));
        btnModificarOrden.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnModificarOrden.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.MODE_EDIT);
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

        btnNuevaOrden1.setBackground(new java.awt.Color(255, 153, 51));
        btnNuevaOrden1.setText("Modificar estado");
        btnNuevaOrden1.setBackgroundHover(new java.awt.Color(204, 102, 0));
        btnNuevaOrden1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnNuevaOrden1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.MOUSE);
        btnNuevaOrden1.setRound(20);
        btnNuevaOrden1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaOrden1ActionPerformed(evt);
            }
        });

        btnNuevaOrden2.setBackground(new java.awt.Color(255, 153, 51));
        btnNuevaOrden2.setText("Reporte");
        btnNuevaOrden2.setBackgroundHover(new java.awt.Color(204, 102, 0));
        btnNuevaOrden2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnNuevaOrden2.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.RECEIPT);
        btnNuevaOrden2.setRound(20);
        btnNuevaOrden2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaOrden2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelOrdenesLayout = new javax.swing.GroupLayout(panelOrdenes);
        panelOrdenes.setLayout(panelOrdenesLayout);
        panelOrdenesLayout.setHorizontalGroup(
            panelOrdenesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTablaOrdenes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelOrdenesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevaOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnNuevaOrden1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnNuevaOrden2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnModificarOrden, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelOrdenesLayout.setVerticalGroup(
            panelOrdenesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOrdenesLayout.createSequentialGroup()
                .addComponent(panelTablaOrdenes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelOrdenesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificarOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevaOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevaOrden1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevaOrden2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                "Id", "Apellido", "Nombre", "CUIT", "Estado"
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

        txtBuscarCliente.setBackground(new java.awt.Color(255, 255, 255));
        txtBuscarCliente.setForeground(new java.awt.Color(0, 0, 0));
        txtBuscarCliente.setColorMaterial(new java.awt.Color(51, 153, 255));
        txtBuscarCliente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtBuscarCliente.setPhColor(new java.awt.Color(0, 0, 0));
        txtBuscarCliente.setPlaceholder("Buscar");
        txtBuscarCliente.setSelectionColor(new java.awt.Color(51, 153, 255));
        txtBuscarCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarClienteKeyReleased(evt);
            }
        });

        rSLabelIcon3.setForeground(new java.awt.Color(255, 255, 255));
        rSLabelIcon3.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SEARCH);

        javax.swing.GroupLayout panelTablaClientesLayout = new javax.swing.GroupLayout(panelTablaClientes);
        panelTablaClientes.setLayout(panelTablaClientesLayout);
        panelTablaClientesLayout.setHorizontalGroup(
            panelTablaClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTablaClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 784, Short.MAX_VALUE)
                    .addGroup(panelTablaClientesLayout.createSequentialGroup()
                        .addComponent(rSLabelIcon3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelTablaClientesLayout.setVerticalGroup(
            panelTablaClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTablaClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTablaClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSLabelIcon3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnModificarCliente.setBackground(new java.awt.Color(255, 255, 255));
        btnModificarCliente.setText("Modificar cliente");
        btnModificarCliente.setBackgroundHover(new java.awt.Color(102, 102, 102));
        btnModificarCliente.setForegroundText(new java.awt.Color(51, 153, 255));
        btnModificarCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnModificarCliente.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.MODE_EDIT);
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

        btnNuevoCliente1.setBackground(new java.awt.Color(255, 51, 51));
        btnNuevoCliente1.setText("Dar de baja cliente");
        btnNuevoCliente1.setBackgroundHover(new java.awt.Color(153, 0, 0));
        btnNuevoCliente1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnNuevoCliente1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.REMOVE);
        btnNuevoCliente1.setRound(20);
        btnNuevoCliente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoCliente1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelClientesLayout = new javax.swing.GroupLayout(panelClientes);
        panelClientes.setLayout(panelClientesLayout);
        panelClientesLayout.setHorizontalGroup(
            panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnNuevoCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(btnModificarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNuevoCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                "Id", "Marca", "Modelo", "Cliente", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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

        txtBuscarEquipo.setBackground(new java.awt.Color(255, 255, 255));
        txtBuscarEquipo.setForeground(new java.awt.Color(0, 0, 0));
        txtBuscarEquipo.setColorMaterial(new java.awt.Color(51, 153, 255));
        txtBuscarEquipo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtBuscarEquipo.setPhColor(new java.awt.Color(0, 0, 0));
        txtBuscarEquipo.setPlaceholder("Buscar");
        txtBuscarEquipo.setSelectionColor(new java.awt.Color(51, 153, 255));
        txtBuscarEquipo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarEquipoKeyReleased(evt);
            }
        });

        rSLabelIcon4.setForeground(new java.awt.Color(255, 255, 255));
        rSLabelIcon4.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SEARCH);

        javax.swing.GroupLayout panelTablaEquiposLayout = new javax.swing.GroupLayout(panelTablaEquipos);
        panelTablaEquipos.setLayout(panelTablaEquiposLayout);
        panelTablaEquiposLayout.setHorizontalGroup(
            panelTablaEquiposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaEquiposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTablaEquiposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 784, Short.MAX_VALUE)
                    .addGroup(panelTablaEquiposLayout.createSequentialGroup()
                        .addComponent(rSLabelIcon4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscarEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelTablaEquiposLayout.setVerticalGroup(
            panelTablaEquiposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTablaEquiposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTablaEquiposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBuscarEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSLabelIcon4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
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
        btnModificarEquipo.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.MODE_EDIT);
        btnModificarEquipo.setRound(20);
        btnModificarEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarEquipoActionPerformed(evt);
            }
        });

        btnBajaEquipo.setBackground(new java.awt.Color(255, 51, 51));
        btnBajaEquipo.setText("Baja equipo");
        btnBajaEquipo.setBackgroundHover(new java.awt.Color(153, 0, 0));
        btnBajaEquipo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnBajaEquipo.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.REMOVE);
        btnBajaEquipo.setRound(20);
        btnBajaEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBajaEquipoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelEquiposLayout = new javax.swing.GroupLayout(panelEquipos);
        panelEquipos.setLayout(panelEquiposLayout);
        panelEquiposLayout.setHorizontalGroup(
            panelEquiposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEquiposLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevoEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBajaEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(btnNuevoEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBajaEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        rSLabelIcon5.setForeground(new java.awt.Color(255, 255, 255));
        rSLabelIcon5.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SEARCH);

        txtBuscarUsuario.setBackground(new java.awt.Color(255, 255, 255));
        txtBuscarUsuario.setForeground(new java.awt.Color(0, 0, 0));
        txtBuscarUsuario.setColorMaterial(new java.awt.Color(51, 153, 255));
        txtBuscarUsuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtBuscarUsuario.setPhColor(new java.awt.Color(0, 0, 0));
        txtBuscarUsuario.setPlaceholder("Buscar");
        txtBuscarUsuario.setSelectionColor(new java.awt.Color(51, 153, 255));
        txtBuscarUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarUsuarioKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout panelTablaUsuariosLayout = new javax.swing.GroupLayout(panelTablaUsuarios);
        panelTablaUsuarios.setLayout(panelTablaUsuariosLayout);
        panelTablaUsuariosLayout.setHorizontalGroup(
            panelTablaUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaUsuariosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTablaUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(panelTablaUsuariosLayout.createSequentialGroup()
                        .addComponent(rSLabelIcon5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelTablaUsuariosLayout.setVerticalGroup(
            panelTablaUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTablaUsuariosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTablaUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBuscarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSLabelIcon5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
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
        btnModificarUsuario.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.MODE_EDIT);
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

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Dialog.plain", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("YBG órdenes de trabajo");

        btnCerrar1.setBackground(new java.awt.Color(255, 255, 255));
        btnCerrar1.setForeground(new java.awt.Color(51, 153, 255));
        btnCerrar1.setBackgroundHover(new java.awt.Color(0, 102, 204));
        btnCerrar1.setForegroundText(new java.awt.Color(51, 153, 255));
        btnCerrar1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.REMOVE);
        btnCerrar1.setSizeIcon(20.0F);
        btnCerrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBotonCerrarLayout = new javax.swing.GroupLayout(panelBotonCerrar);
        panelBotonCerrar.setLayout(panelBotonCerrarLayout);
        panelBotonCerrarLayout.setHorizontalGroup(
            panelBotonCerrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBotonCerrarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCerrar1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelBotonCerrarLayout.setVerticalGroup(
            panelBotonCerrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonCerrarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBotonCerrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBotonCerrarLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                        .addGap(10, 10, 10))
                    .addGroup(panelBotonCerrarLayout.createSequentialGroup()
                        .addGroup(panelBotonCerrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCerrar1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText(" Usuario: ");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        lblUsuario.setBackground(new java.awt.Color(255, 255, 255));
        lblUsuario.setFont(new java.awt.Font("Dialog.plain", 1, 14)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuario.setText("Usuario prueba");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
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
                        .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(lblUsuario)
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

        btnOrdenes.setBackground(Color.decode("#cc6600"));
        btnClientes.setBackground(Color.decode("#ff9933"));
        btnEquipos.setBackground(Color.decode("#ff9933"));
        btnUsuarios.setBackground(Color.decode("#ff9933"));

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

        btnOrdenes.setBackground(Color.decode("#ff9933"));
        btnClientes.setBackground(Color.decode("#cc6600"));
        btnEquipos.setBackground(Color.decode("#ff9933"));
        btnUsuarios.setBackground(Color.decode("#ff9933"));

        panelOrdenes.setVisible(false);
        panelClientes.setVisible(true);
        panelEquipos.setVisible(false);
        panelUsuarios.setVisible(false);
        cargarTablaClientes();

    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnEquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEquiposActionPerformed

        btnOrdenes.setBackground(Color.decode("#ff9933"));
        btnClientes.setBackground(Color.decode("#ff9933"));
        btnEquipos.setBackground(Color.decode("#cc6600"));
        btnUsuarios.setBackground(Color.decode("#ff9933"));

        panelOrdenes.setVisible(false);
        panelClientes.setVisible(false);
        panelEquipos.setVisible(true);
        panelUsuarios.setVisible(false);
        cargarTablaEquipos();

    }//GEN-LAST:event_btnEquiposActionPerformed

    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosActionPerformed

        btnOrdenes.setBackground(Color.decode("#ff9933"));
        btnClientes.setBackground(Color.decode("#ff9933"));
        btnEquipos.setBackground(Color.decode("#ff9933"));
        btnUsuarios.setBackground(Color.decode("#cc6600"));

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

        if (tablaOrdenes.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una orden");
        } else {
            Optional<Orden> orden = ordenService.findById(Integer.valueOf(tablaOrdenes.getValueAt(tablaOrdenes.getSelectedRow(), 0).toString()));
            idOrdenes = orden.get().getId();
            Optional<Cliente> cliente = clienteService.findById(orden.get().getEquipo().getCliente().getId());
            idClientes = cliente.get().getId();
            modificarOrden();
        }

    }//GEN-LAST:event_btnModificarOrdenActionPerformed

    private void btnNuevaOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaOrdenActionPerformed
        
        altaOrdenes.cargarUsuarios();
        altaOrdenes.cargarEquipos();
        altaOrdenes.setVisible(true);
        cargarTablaOrdenes();


    }//GEN-LAST:event_btnNuevaOrdenActionPerformed

    private void btnModificarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarClienteActionPerformed
        
        if (tablaClientes.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un cliente");
        } else {
            Optional<Cliente> cliente = clienteService.findById(Integer.valueOf(tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 0).toString()));
            idClientes = cliente.get().getId();
            modificarCliente();
        }
        
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

        if (tablaUsuarios.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un usuario");
        } else {
            Optional<Usuario> usuarioObject = usuarioService.findById(Integer.valueOf(tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 0).toString()));
            idUsuarios = usuarioObject.get().getId();
            modificarUsuario();
            cargarTablaUsuarios();
        }

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
            if (usuarioService.findById(idUsuario).get().getPermisos() == 0) {
                Optional<Usuario> usuarioObject = usuarioService.findById(Integer.valueOf(tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 0).toString()));
                idUsuarios = usuarioObject.get().getId();
                modificarUsuario();
            }
        }

    }//GEN-LAST:event_tablaUsuariosMouseClicked

    private void tablaOrdenesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaOrdenesMouseClicked

        if (evt.getClickCount() == 2) {
            Optional<Orden> orden = ordenService.findById(Integer.valueOf(tablaOrdenes.getValueAt(tablaOrdenes.getSelectedRow(), 0).toString()));
            idOrdenes = orden.get().getId();
            modificarOrden();

        }

    }//GEN-LAST:event_tablaOrdenesMouseClicked

    private void btnNuevaOrden1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaOrden1ActionPerformed

        if (tablaOrdenes.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una orden");
        } else {
            if ((idUsuario == Integer.valueOf(tablaOrdenes.getValueAt(tablaOrdenes.getSelectedRow(), 7).toString())) || (usuarioService.findById(idUsuario).get().getPermisos() == 0)) {
                idEstado = Integer.valueOf(tablaOrdenes.getValueAt(tablaOrdenes.getSelectedRow(), 6).toString());
                idOrdenes = Integer.valueOf(tablaOrdenes.getValueAt(tablaOrdenes.getSelectedRow(), 0).toString());
                estado.setVisible(true);
                cargarTablaOrdenes();
            } else {
                JOptionPane.showMessageDialog(null, "Esta orden no puede ser modificada por este usuario");
            }
        }

    }//GEN-LAST:event_btnNuevaOrden1ActionPerformed

    private void btnNuevaOrden2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaOrden2ActionPerformed

        if (tablaOrdenes.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una orden");
        } else {
            Optional<Orden> orden = ordenService.findById(Integer.valueOf(tablaOrdenes.getValueAt(tablaOrdenes.getSelectedRow(), 0).toString()));
            Report report = new Report();
            report.imprimirReportes(report.OrdenDeTrabajo(orden.get()), report.OrdenDeTrabajoDuplicado(orden.get()), orden.get());
        }


    }//GEN-LAST:event_btnNuevaOrden2ActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased

        TableRowSorter sorter = new TableRowSorter(modelOrdenes);
        sorter.setRowFilter(RowFilter.regexFilter(".*" + txtBuscar.getText() + ".*"));
        tablaOrdenes.setRowSorter(sorter);

    }//GEN-LAST:event_txtBuscarKeyReleased

    private void txtBuscarClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarClienteKeyReleased

        TableRowSorter sorter = new TableRowSorter(modelClientes);
        sorter.setRowFilter(RowFilter.regexFilter(".*" + txtBuscarCliente.getText() + ".*"));
        tablaClientes.setRowSorter(sorter);

    }//GEN-LAST:event_txtBuscarClienteKeyReleased

    private void txtBuscarEquipoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarEquipoKeyReleased

        TableRowSorter sorter = new TableRowSorter(modelEquipos);
        sorter.setRowFilter(RowFilter.regexFilter(".*" + txtBuscarEquipo.getText() + ".*"));
        tablaEquipos.setRowSorter(sorter);

    }//GEN-LAST:event_txtBuscarEquipoKeyReleased

    private void txtBuscarUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarUsuarioKeyReleased

        TableRowSorter sorter = new TableRowSorter(modelUsuarios);
        sorter.setRowFilter(RowFilter.regexFilter(".*" + txtBuscarUsuario.getText() + ".*"));
        tablaUsuarios.setRowSorter(sorter);

    }//GEN-LAST:event_txtBuscarUsuarioKeyReleased

    private void btnCerrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrar1ActionPerformed

        this.setExtendedState(ICONIFIED);

    }//GEN-LAST:event_btnCerrar1ActionPerformed

    private void btnNuevoCliente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoCliente1ActionPerformed

        if (tablaClientes.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un cliente");
        } else {
            Optional<Cliente> cliente = clienteService.findById(Integer.valueOf(tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 0).toString()));
            idClientes = cliente.get().getId();
            bajaCliente(idClientes);
            cargarTablaClientes();
        }
        
    }//GEN-LAST:event_btnNuevoCliente1ActionPerformed

    private void btnBajaEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBajaEquipoActionPerformed

    if (tablaEquipos.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un cliente");
        } else {
            Optional<Equipo> equipo = equipoService.findById(Integer.valueOf(tablaEquipos.getValueAt(tablaEquipos.getSelectedRow(), 0).toString()));
            idEquipos = equipo.get().getId();
            bajaEquipo(idEquipos);
            cargarTablaEquipos();
        }
        
    }//GEN-LAST:event_btnBajaEquipoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSButtonMaterialIconOne btnBajaEquipo;
    private RSMaterialComponent.RSButtonIconOne btnCerrar;
    private RSMaterialComponent.RSButtonIconOne btnCerrar1;
    private RSMaterialComponent.RSButtonMaterialIconOne btnClientes;
    private RSMaterialComponent.RSButtonMaterialIconOne btnEquipos;
    private RSMaterialComponent.RSButtonMaterialIconOne btnModificarCliente;
    private RSMaterialComponent.RSButtonMaterialIconOne btnModificarEquipo;
    private RSMaterialComponent.RSButtonMaterialIconOne btnModificarOrden;
    public static RSMaterialComponent.RSButtonMaterialIconOne btnModificarUsuario;
    private RSMaterialComponent.RSButtonMaterialIconOne btnNuevaOrden;
    private RSMaterialComponent.RSButtonMaterialIconOne btnNuevaOrden1;
    private RSMaterialComponent.RSButtonMaterialIconOne btnNuevaOrden2;
    private RSMaterialComponent.RSButtonMaterialIconOne btnNuevoCliente;
    private RSMaterialComponent.RSButtonMaterialIconOne btnNuevoCliente1;
    private RSMaterialComponent.RSButtonMaterialIconOne btnNuevoEquipo;
    public static RSMaterialComponent.RSButtonMaterialIconOne btnNuevoUsuario;
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
    public javax.swing.JLabel lblUsuario;
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
    private RSMaterialComponent.RSLabelIcon rSLabelIcon2;
    private RSMaterialComponent.RSLabelIcon rSLabelIcon3;
    private RSMaterialComponent.RSLabelIcon rSLabelIcon4;
    private RSMaterialComponent.RSLabelIcon rSLabelIcon5;
    private RSMaterialComponent.RSTableMetro tablaClientes;
    private RSMaterialComponent.RSTableMetro tablaEquipos;
    public static RSMaterialComponent.RSTableMetro tablaOrdenes;
    private RSMaterialComponent.RSTableMetro tablaUsuarios;
    private RSMaterialComponent.RSTextFieldMaterial txtBuscar;
    private RSMaterialComponent.RSTextFieldMaterial txtBuscarCliente;
    private RSMaterialComponent.RSTextFieldMaterial txtBuscarEquipo;
    private RSMaterialComponent.RSTextFieldMaterial txtBuscarUsuario;
    // End of variables declaration//GEN-END:variables

}
