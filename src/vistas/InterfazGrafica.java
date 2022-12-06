/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;

import controladores.ControladorClientes;
import controladores.ControladorCompras;
import controladores.ControladorPlantas;
import controladores.ControladorProductos;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelos.Cliente;
import modelos.Compra;
import modelos.Planta;
import modelos.Producto;
import servicios.Servicio;

/**
 *
 * @author jpgonzalez
 */
public class InterfazGrafica extends javax.swing.JFrame {
    ControladorPlantas miControladorPlantas;
    ControladorProductos miControladorProductos;
    ControladorClientes miControladorClientes;
    ControladorCompras miControladorCompras;
    LinkedList<Producto> productos = new LinkedList<>();
    LinkedList<Planta> plantas = new LinkedList<>();
    LinkedList<Cliente> clientes = new LinkedList<>();
    Cliente clienteActual = null;
    
    public InterfazGrafica() {
        initComponents();
        Servicio miServicio = new Servicio("http://localhost:8080/");
        this.miControladorPlantas  = new ControladorPlantas(miServicio);
        this.miControladorProductos = new ControladorProductos(miServicio);
        this.miControladorClientes = new ControladorClientes(miServicio);
        this.miControladorCompras = new ControladorCompras(miServicio);
        //inicializacion listas
        this.productos = this.miControladorProductos.listar();
        this.plantas = this.miControladorPlantas.listar();
        this.clientes = this.miControladorClientes.listar();
        actualizarTablaPlantas();
        actualizarTablaProductos(this.tablaProductos);
        actualizarTablaProductos(this.tablaProductosClientes);
        actualizarTablaClientes();
        actualizarTablaCompras();
    }

    public void llenarCompras(){
        LinkedList<Compra> temp = this.miControladorCompras.listar();
        for(int i = 0; i < temp.size(); i++){
            
        }
    }
    
    public void actualizarTablaProductos(JTable tabla){
        this.productos = this.miControladorProductos.listar();
        String nombresColumnas[]={"Id","Nombre","Tipo","Valor" ,"Cantidad"};
        DefaultTableModel miModelo= new DefaultTableModel(null, nombresColumnas);
        tabla.setModel(miModelo);
        for (Producto actual:productos) {
            String fila[]=new String[nombresColumnas.length];
            fila[0]=actual.getId();
            fila[1]=actual.getNombre();
            fila[2]=actual.getTipo();
            fila[3]=""+actual.getValor();
            fila[4]=""+actual.getExistencia();
            miModelo.addRow(fila);
        }
    }
    
    public void actualizarTablaCompras(){
//        if(this.clienteActual != null){    
//            String idCompra  = this.clienteActual.getMi_compra().getId();
//            this.clienteActual.getMi_compra().setProductos(this.miControladorProductos.produtosEncompra(idCompra));
//            String nombresColumnas[]={"Id","Nombre","Tipo","Valor" ,"Cantidad"};
//            DefaultTableModel miModelo= new DefaultTableModel(null, nombresColumnas);
//           this.tablaCompras.setModel(miModelo);
//            for (Producto actual: this.productosCompra){
//                String fila[]=new String[nombresColumnas.length];
//                fila[0]=actual.getId();
//                fila[1]=actual.getNombre();
//                fila[2]=actual.getTipo();
//                fila[3]=""+actual.getValor();
//                fila[4]=""+actual.getExistencia();
//                miModelo.addRow(fila);
//            }
//        }
    }
    
    public void actualizarTablaPlantas(){
        this.plantas = this.miControladorPlantas.listar();
        String nombresColumnas[]={"Id","Nombre","Descripción"};
        DefaultTableModel miModelo= new DefaultTableModel(null, nombresColumnas);
        this.tablaPlantas.setModel(miModelo);
        for (Planta actual:plantas) {
            String fila[]=new String[nombresColumnas.length];
            fila[0]=actual.getId();
            fila[1]=actual.getNombre();
            fila[2]=actual.getFuncionalidad();
            miModelo.addRow(fila);
        }
    }
    
    public void actualizarTablaClientes(){
        this.clientes = this.miControladorClientes.listar();
        String modeloColumnas[] = {"ID", "NOMBRE", "CEDULA", "CORREO,", "TELEFONO"};
        DefaultTableModel miModeloTabla = new DefaultTableModel(null, modeloColumnas);
        this.tablaClientes.setModel(miModeloTabla);
        for(Cliente auxiliar : clientes) {
            String fila[] = new String[modeloColumnas.length];
            fila[0] = auxiliar.getId();
            fila[1] = auxiliar.getNombre();
            fila[2] = auxiliar.getCedula();
            fila[3] = auxiliar.getCorreo();
            fila[4] = auxiliar.getTelefono();
            miModeloTabla.addRow(fila);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtTipoProducto = new javax.swing.JTextField();
        txtExistenciaProducto = new javax.swing.JTextField();
        txtNombreProducto = new javax.swing.JTextField();
        txtValorProducto = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaPlantas = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtNombrePlanta = new javax.swing.JTextField();
        txtPropiedadesPlanta = new javax.swing.JTextField();
        btnCrearPlanta = new javax.swing.JButton();
        btnEliminarPlanta = new javax.swing.JButton();
        btnCrearProducto = new javax.swing.JButton();
        btnEliminarProducto = new javax.swing.JButton();
        bntAgregarPlantaAproducto = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombreCliente = new javax.swing.JTextField();
        btnCrearCliente = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtCedulaCliente = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtCorreoCliente = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtTelefonoCliente = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtIDCliente = new javax.swing.JTextField();
        btnActualizarCliente = new javax.swing.JButton();
        btnBuscarCliente = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaProductosClientes = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablaCompras = new javax.swing.JTable();
        btnSeleccionarCliente = new javax.swing.JButton();
        btnComprar = new javax.swing.JButton();
        btnEliminarCliente1 = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("PROPIEDADES:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 140, -1, -1));

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("NOMBRE:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("TIPO:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("EXISTENCIA:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("VALOR:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));

        txtTipoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipoProductoActionPerformed(evt);
            }
        });
        jPanel2.add(txtTipoProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 140, -1));
        jPanel2.add(txtExistenciaProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 140, -1));
        jPanel2.add(txtNombreProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 140, -1));
        jPanel2.add(txtValorProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 140, -1));

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tablaProductos);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 340, 300));

        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("PRODUCTOS");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, -1, -1));

        tablaPlantas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(tablaPlantas);

        jPanel2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 280, 340, 300));

        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("PLANTAS");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 40, -1, -1));

        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("NOMBRE:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 100, -1, -1));
        jPanel2.add(txtNombrePlanta, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 100, 200, -1));

        txtPropiedadesPlanta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPropiedadesPlantaActionPerformed(evt);
            }
        });
        jPanel2.add(txtPropiedadesPlanta, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 140, 200, 120));

        btnCrearPlanta.setText("CREAR");
        btnCrearPlanta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearPlantaActionPerformed(evt);
            }
        });
        jPanel2.add(btnCrearPlanta, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 220, -1, -1));

        btnEliminarPlanta.setText("ELIMINAR");
        btnEliminarPlanta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPlantaActionPerformed(evt);
            }
        });
        jPanel2.add(btnEliminarPlanta, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 250, -1, -1));

        btnCrearProducto.setText("CREAR");
        btnCrearProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearProductoActionPerformed(evt);
            }
        });
        jPanel2.add(btnCrearProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, -1, -1));

        btnEliminarProducto.setText("ELIMINAR");
        btnEliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProductoActionPerformed(evt);
            }
        });
        jPanel2.add(btnEliminarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 250, -1, -1));

        bntAgregarPlantaAproducto.setText("AGREGAR PLANTA A PRODUCTO");
        bntAgregarPlantaAproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntAgregarPlantaAproductoActionPerformed(evt);
            }
        });
        jPanel2.add(bntAgregarPlantaAproducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 590, 230, 30));

        jTabbedPane1.addTab("PRODUCTOS", jPanel2);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("MANEJADOR DE CLIENTES");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 17, -1, 33));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("NOMBRE");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 123, -1, -1));

        txtNombreCliente.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        txtNombreCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0)));
        jPanel1.add(txtNombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 115, 230, 35));

        btnCrearCliente.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        btnCrearCliente.setText("CREAR");
        btnCrearCliente.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        btnCrearCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCrearCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearClienteActionPerformed(evt);
            }
        });
        jPanel1.add(btnCrearCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 60, 40));

        jLabel12.setBackground(new java.awt.Color(0, 0, 0));
        jLabel12.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("CEDULA");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 170, -1, -1));

        txtCedulaCliente.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        txtCedulaCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0)));
        jPanel1.add(txtCedulaCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 162, 230, 35));

        jLabel13.setBackground(new java.awt.Color(0, 0, 0));
        jLabel13.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("CORREO");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 217, -1, -1));

        txtCorreoCliente.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        txtCorreoCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0)));
        jPanel1.add(txtCorreoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 209, 230, 35));

        jLabel14.setBackground(new java.awt.Color(0, 0, 0));
        jLabel14.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("TELEFONO");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 264, -1, -1));

        txtTelefonoCliente.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        txtTelefonoCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0)));
        jPanel1.add(txtTelefonoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 256, 230, 35));

        jLabel15.setBackground(new java.awt.Color(0, 0, 0));
        jLabel15.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("ID");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 76, -1, -1));

        txtIDCliente.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        txtIDCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0)));
        jPanel1.add(txtIDCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 68, 230, 35));

        btnActualizarCliente.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        btnActualizarCliente.setText("ACTUALIZAR");
        btnActualizarCliente.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        btnActualizarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActualizarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarClienteActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, 100, 40));

        btnBuscarCliente.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        btnBuscarCliente.setText("ELIMINAR");
        btnBuscarCliente.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        btnBuscarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 310, 80, 40));

        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaClientes);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, 500, 200));

        tablaProductosClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tablaProductosClientes);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 340, 500, 220));

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("CLIENTES");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 40, -1, -1));

        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("PRODUCTOS");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 320, -1, -1));

        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("COMPRA");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 380, -1, -1));

        tablaCompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(tablaCompras);

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, 300, 190));

        btnSeleccionarCliente.setText("SELECCIONAR CLIENTE");
        btnSeleccionarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarClienteActionPerformed(evt);
            }
        });
        jPanel1.add(btnSeleccionarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 280, 210, 40));

        btnComprar.setText("COMPRAR");
        btnComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprarActionPerformed(evt);
            }
        });
        jPanel1.add(btnComprar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 570, 100, 40));

        btnEliminarCliente1.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        btnEliminarCliente1.setText("BUSCAR");
        btnEliminarCliente1.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        btnEliminarCliente1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarCliente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCliente1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminarCliente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 310, 80, 40));

        jTabbedPane1.addTab("CLIENTES", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearClienteActionPerformed
        try {
            String nombre = this.txtNombreCliente.getText();
            String cedula = this.txtCedulaCliente.getText();
            String correo = this.txtCorreoCliente.getText();
            String telefono = this.txtTelefonoCliente.getText();
            Cliente clienteCreado = new Cliente(nombre, cedula, correo, telefono);
            miControladorClientes.crear(clienteCreado);
            JOptionPane.showMessageDialog(this, "CLIENTE CREADO");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "CLIENTE NO CREADO");
        }        
        this.txtNombreCliente.setText("");
        this.txtCedulaCliente.setText("");
        this.txtCorreoCliente.setText("");
        this.txtTelefonoCliente.setText("");
        actualizarTablaClientes();
    }//GEN-LAST:event_btnCrearClienteActionPerformed

    private void txtPropiedadesPlantaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPropiedadesPlantaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPropiedadesPlantaActionPerformed

    private void txtTipoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipoProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoProductoActionPerformed

    private void btnEliminarPlantaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPlantaActionPerformed
        try {
            int pos = this.tablaPlantas.getSelectedRow();
            Planta eliminar = this.plantas.get(pos);
            this.miControladorPlantas.eliminar(eliminar);
            JOptionPane.showMessageDialog(this, "PLANTA ELIMINADA");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "PLANTA NO ELIMINADA");
        }
        actualizarTablaPlantas();
    }//GEN-LAST:event_btnEliminarPlantaActionPerformed

    private void btnCrearProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearProductoActionPerformed
        try {
            String nombre = this.txtNombreProducto.getText();
            String tipo = this.txtTipoProducto.getText();
            long valor = Long.parseLong(this.txtValorProducto.getText());
            long existencia = Long.parseLong(this.txtExistenciaProducto.getText());
            Producto productoCreado = new Producto(nombre, tipo, valor, existencia);
            miControladorProductos.crear(productoCreado);
            JOptionPane.showMessageDialog(this, "PRODUCTO CREADO");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "PRODUCTO NO CREADO");
        }        
        this.txtNombreProducto.setText("");
        this.txtTipoProducto.setText("");
        this.txtValorProducto.setText("");
        this.txtExistenciaProducto.setText("");
        actualizarTablaProductos(this.tablaProductos);
        actualizarTablaProductos(this.tablaProductosClientes);
    }//GEN-LAST:event_btnCrearProductoActionPerformed

    private void btnEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProductoActionPerformed
        try {
            int pos = this.tablaProductos.getSelectedRow();
            Producto eliminar = this.productos.get(pos);
            this.miControladorProductos.eliminar(eliminar);
            JOptionPane.showMessageDialog(this, "PRODUCTO ELIMINADO");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "PRODUCTO NO ELIMINADO");
        }
        actualizarTablaProductos(this.tablaProductos);
        actualizarTablaProductos(this.tablaProductosClientes);
    }//GEN-LAST:event_btnEliminarProductoActionPerformed

    private void btnCrearPlantaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearPlantaActionPerformed
        try {
            String nombre = this.txtNombrePlanta.getText();
            String descripcion = this.txtPropiedadesPlanta.getText();
            Planta plantaCreada = new Planta(nombre, descripcion);
            this.miControladorPlantas.crear(plantaCreada);
            JOptionPane.showMessageDialog(this, "PLANTA CREADA CON EXITO");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "PLANTA NO CREADA");
        }
        this.txtNombrePlanta.setText("");
        this.txtPropiedadesPlanta.setText("");
        actualizarTablaPlantas();
    }//GEN-LAST:event_btnCrearPlantaActionPerformed

    private void btnActualizarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarClienteActionPerformed
        this.clientes = this.miControladorClientes.listar();
        if(txtTelefonoCliente.getText() != "" || txtCorreoCliente.getText() != ""){    
            try {
                    int pos = this.tablaClientes.getSelectedRow();
                    Cliente aux = this.clientes.get(pos);
                    aux.setCorreo(txtCorreoCliente.getText());
                    aux.setTelefono(txtTelefonoCliente.getText());
                    this.miControladorClientes.editar(aux);
                    JOptionPane.showMessageDialog(this, "CLIENTE ACTUALIZADO");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "CLIENTE NO ACTUALIZADO");
                }
        }
        else{
            JOptionPane.showMessageDialog(this, "INGRESE LA INFORMACION");
        }
        txtNombreCliente.setText("");
        txtCedulaCliente.setText("");
        txtTelefonoCliente.setText("");
        txtCorreoCliente.setText("");
        actualizarTablaClientes();
    }//GEN-LAST:event_btnActualizarClienteActionPerformed

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        try {
            int pos = this.tablaClientes.getSelectedRow();
            Cliente eliminar = this.clientes.get(pos);
            this.miControladorClientes.eliminar(eliminar);
            JOptionPane.showMessageDialog(this, "CLIENTE ELIMINADO");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "CLIENTE NO ELIMINADO");
        }
        actualizarTablaClientes();
    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void bntAgregarPlantaAproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntAgregarPlantaAproductoActionPerformed
        try {
            int posProducto = this.tablaProductos.getSelectedRow();
            int posPlanta = this.tablaPlantas.getSelectedRow();
            Producto productoEncontrado = this.productos.get(posProducto);
            Planta plantaEncontrada = this.plantas.get(posPlanta);
            this.miControladorPlantas.agregarPlantaAProducto(plantaEncontrada, productoEncontrado);
            JOptionPane.showMessageDialog(this, "PLANTA AGREGADA CON EXITO");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "PLANTA NO AGREGADA");
        }
    }//GEN-LAST:event_bntAgregarPlantaAproductoActionPerformed

    private void btnSeleccionarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarClienteActionPerformed
        try {
            int pos = this.tablaClientes.getSelectedRow();
            this.clienteActual = this.clientes.get(pos);
            JOptionPane.showMessageDialog(this, "CLIENTE SELECCIONADO");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "CLIENTE NO SELECCIONADO");
        }
        actualizarTablaCompras();
    }//GEN-LAST:event_btnSeleccionarClienteActionPerformed

    private void btnComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprarActionPerformed
        Producto elProducto = this.productos.get(this.tablaProductosClientes.getSelectedRow());
        if(elProducto.getExistencia() > 0 ){
            Compra laCompra = new Compra();
            try {
            this.clienteActual.setMi_compra(this.miControladorCompras.comprasEnCLiente(this.clienteActual.getId()));
            if(this.clienteActual.getMi_compra() == null){
                laCompra = new Compra("16/01/2001", (long)0);
                laCompra = this.miControladorCompras.crear(laCompra, this.clienteActual);
                this.clienteActual.getMi_compra().setId(laCompra.getId());
            }else{
                laCompra = this.clienteActual.getMi_compra();
            } 
                this.miControladorProductos.agregarProductoAcompra(elProducto, laCompra);
                this.clienteActual.setMi_compra(this.miControladorCompras.comprasEnCLiente(this.clienteActual.getId()));
                this.miControladorClientes.editar(this.clienteActual);
                actualizarTablaProductos(this.tablaProductos);
                actualizarTablaProductos(this.tablaProductosClientes);
                actualizarTablaCompras();
                JOptionPane.showMessageDialog(this, "PRODUCTO COMPRADO");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "PRODUCTO NO COMPRADO");
        }
        }else{
            JOptionPane.showMessageDialog(this, "NO HAY EXISTENCIAS");
        }
        actualizarTablaCompras();
    }//GEN-LAST:event_btnComprarActionPerformed

    private void btnEliminarCliente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCliente1ActionPerformed
        int pos = this.tablaClientes.getSelectedRow();
        Cliente c = this.clientes.get(pos);
        this.txtIDCliente.setText(c.getId());
    }//GEN-LAST:event_btnEliminarCliente1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfazGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazGrafica().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntAgregarPlantaAproducto;
    private javax.swing.JButton btnActualizarCliente;
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnComprar;
    private javax.swing.JButton btnCrearCliente;
    private javax.swing.JButton btnCrearPlanta;
    private javax.swing.JButton btnCrearProducto;
    private javax.swing.JButton btnEliminarCliente1;
    private javax.swing.JButton btnEliminarPlanta;
    private javax.swing.JButton btnEliminarProducto;
    private javax.swing.JButton btnSeleccionarCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tablaClientes;
    private javax.swing.JTable tablaCompras;
    private javax.swing.JTable tablaPlantas;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JTable tablaProductosClientes;
    private javax.swing.JTextField txtCedulaCliente;
    private javax.swing.JTextField txtCorreoCliente;
    private javax.swing.JTextField txtExistenciaProducto;
    private javax.swing.JTextField txtIDCliente;
    private javax.swing.JTextField txtNombreCliente;
    private javax.swing.JTextField txtNombrePlanta;
    private javax.swing.JTextField txtNombreProducto;
    private javax.swing.JTextField txtPropiedadesPlanta;
    private javax.swing.JTextField txtTelefonoCliente;
    private javax.swing.JTextField txtTipoProducto;
    private javax.swing.JTextField txtValorProducto;
    // End of variables declaration//GEN-END:variables
}
