/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package C_Frames;

import C_Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author carlo
 */
public class C_MOD_Proveedores extends javax.swing.JFrame {

    /**
     * Creates new form EditarEstados
     */
    Conexion erp;
     DefaultComboBoxModel modelocombo = new DefaultComboBoxModel();
    DefaultComboBoxModel modelocombo1 = new DefaultComboBoxModel();
    public C_MOD_Proveedores() {
        initComponents();
        erp = new Conexion();
        llenarCombo1();
        llenarCombo();
        this.txfIdProveedor.setEditable(false);
        
    }

    private JTextField jTextFieldName = new JTextField();
    private int limite = 5;
    private int limite2 = 10;
    
     
              
    public void Datos(int id, String Nombre, String no, String tel, String ema, String dir, String col, String cod) {
        
        modelocombo.setSelectedItem(id+" "+Nombre);
        CB_CUIDAD.setModel(modelocombo);
        C_MOD_Proveedor_txfnom.setText(no);
        C_MOD_Proveedor_txftel.setText(tel);
        C_MOD_Proveedor_txfemail.setText(ema);
        C_MOD_Proveedor_txfdir.setText(dir);
        C_MOD_Proveedor_txfcol.setText(col);
        C_MOD_Proveedor_txfcodPos.setText(cod);
        int a = Integer.parseInt(erp.consultaEdo(id));
     
            for (int i = 1; i < 10; i++) {
                StringTokenizer erp = new StringTokenizer(CB_ESTADO.getItemAt(i).toString()," ");
                int b = Integer.parseInt(erp.nextToken());
            if(b ==  a){
                CB_ESTADO.setSelectedIndex(i);
            }
        }
    }
    public void llenarCombo(){
        try {
            erp.OpenCon("ERP", "erp");
            erp.stn= (Statement) erp.con.createStatement();
            erp.rs= erp.stn.executeQuery("select * from estados where estatus='A'");
            modelocombo1.addElement("Seleccione Estado");
            CB_ESTADO.setModel(modelocombo1);
            while (erp.rs.next()){
                 String ID= String.valueOf(erp.rs.getObject("idestado"));
                String nombre= String.valueOf(erp.rs.getObject("nombre"));
                modelocombo1.addElement(ID+" "+nombre);
                CB_ESTADO.setModel(modelocombo1);
            }
        
        }catch(SQLException ex){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
     public void llenarCombo1(){

         try {
            erp.OpenCon("ERP", "erp");
            erp.stn= (Statement) erp.con.createStatement();
            erp.rs= erp.stn.executeQuery("select * from ciudad where estatus='A' ");
            modelocombo.addElement("Seleccione ciudad");
            CB_CUIDAD.setModel(modelocombo);
            while (erp.rs.next()){
                 String ID= String.valueOf(erp.rs.getObject("idciudad"));
                String nombre= String.valueOf(erp.rs.getObject("nombre"));
                modelocombo.addElement(ID+" "+nombre);
                CB_CUIDAD.setModel(modelocombo);
            }
        
        }catch(SQLException ex){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
     
     public void llenarCombo2(){
     int idc = 0;
        StringTokenizer numero = new StringTokenizer(CB_ESTADO.getSelectedItem().toString(), " ");
        int C = 0;
        CB_CUIDAD.removeAllItems();
        while (numero.hasMoreTokens()) {
            String a = numero.nextToken();
            C++;
            if (C == 1) {
                idc = Integer.parseInt(a);
            }

        }
         try {
            erp.OpenCon("ERP", "erp");
            erp.stn= (Statement) erp.con.createStatement();
            erp.rs= erp.stn.executeQuery("select * from ciudad where estatus='A' and idestado="+idc);
            modelocombo.addElement("Seleccione ciudad");
            CB_CUIDAD.setModel(modelocombo);
            while (erp.rs.next()){
                 String ID= String.valueOf(erp.rs.getObject("idciudad"));
                String nombre= String.valueOf(erp.rs.getObject("nombre"));
                modelocombo.addElement(ID+" "+nombre);
                CB_CUIDAD.setModel(modelocombo);
            }
        
        }catch(SQLException ex){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnAgrefarEstados = new javax.swing.JButton();
        txfIdProveedor = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        C_MOD_Proveedor_txfnom = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        C_MOD_Proveedor_txftel = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        C_MOD_Proveedor_txfemail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        C_MOD_Proveedor_txfdir = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        C_MOD_Proveedor_txfcol = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        C_MOD_Proveedor_txfcodPos = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        CB_CUIDAD = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        CB_ESTADO = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(254, 254, 254));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "EDITAR PROVEEDOR", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(255, 0, 0))); // NOI18N

        jLabel1.setBackground(new java.awt.Color(254, 254, 254));
        jLabel1.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(1, 1, 1));
        jLabel1.setText("ID");

        jButton1.setBackground(new java.awt.Color(254, 254, 254));
        jButton1.setForeground(new java.awt.Color(254, 254, 254));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon-cancelar.png"))); // NOI18N
        jButton1.setToolTipText("Cerrar");
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnAgrefarEstados.setBackground(new java.awt.Color(254, 254, 254));
        btnAgrefarEstados.setForeground(new java.awt.Color(254, 254, 254));
        btnAgrefarEstados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/refresh_icon.png"))); // NOI18N
        btnAgrefarEstados.setToolTipText("Actualizar");
        btnAgrefarEstados.setBorderPainted(false);
        btnAgrefarEstados.setContentAreaFilled(false);
        btnAgrefarEstados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgrefarEstadosActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(1, 1, 1));
        jLabel8.setText("NOMBRE PROVEEPOR");

        C_MOD_Proveedor_txfnom.setBackground(new java.awt.Color(254, 254, 254));
        C_MOD_Proveedor_txfnom.setForeground(new java.awt.Color(1, 1, 1));
        C_MOD_Proveedor_txfnom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                C_MOD_Proveedor_txfnomKeyTyped(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(254, 254, 254));
        jLabel3.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(1, 1, 1));
        jLabel3.setText("TELEFONO");

        C_MOD_Proveedor_txftel.setBackground(new java.awt.Color(254, 254, 254));
        C_MOD_Proveedor_txftel.setForeground(new java.awt.Color(1, 1, 1));
        C_MOD_Proveedor_txftel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                C_MOD_Proveedor_txftelKeyTyped(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(254, 254, 254));
        jLabel9.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(1, 1, 1));
        jLabel9.setText("EMAIL");

        C_MOD_Proveedor_txfemail.setBackground(new java.awt.Color(254, 254, 254));
        C_MOD_Proveedor_txfemail.setForeground(new java.awt.Color(1, 1, 1));
        C_MOD_Proveedor_txfemail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                C_MOD_Proveedor_txfemailKeyTyped(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(254, 254, 254));
        jLabel4.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(1, 1, 1));
        jLabel4.setText("DIRECCIÓN");

        C_MOD_Proveedor_txfdir.setBackground(new java.awt.Color(254, 254, 254));
        C_MOD_Proveedor_txfdir.setForeground(new java.awt.Color(1, 1, 1));
        C_MOD_Proveedor_txfdir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C_MOD_Proveedor_txfdirActionPerformed(evt);
            }
        });
        C_MOD_Proveedor_txfdir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                C_MOD_Proveedor_txfdirKeyTyped(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(254, 254, 254));
        jLabel5.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(1, 1, 1));
        jLabel5.setText("COLONIA");

        C_MOD_Proveedor_txfcol.setBackground(new java.awt.Color(254, 254, 254));
        C_MOD_Proveedor_txfcol.setForeground(new java.awt.Color(1, 1, 1));
        C_MOD_Proveedor_txfcol.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                C_MOD_Proveedor_txfcolKeyTyped(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(254, 254, 254));
        jLabel6.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(1, 1, 1));
        jLabel6.setText("CODIGO POSTAL");

        C_MOD_Proveedor_txfcodPos.setBackground(new java.awt.Color(254, 254, 254));
        C_MOD_Proveedor_txfcodPos.setForeground(new java.awt.Color(1, 1, 1));
        C_MOD_Proveedor_txfcodPos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                C_MOD_Proveedor_txfcodPosKeyTyped(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(254, 254, 254));
        jLabel10.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(1, 1, 1));
        jLabel10.setText("CIUDAD");

        CB_CUIDAD.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        CB_CUIDAD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_CUIDADActionPerformed(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(254, 254, 254));
        jLabel11.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(1, 1, 1));
        jLabel11.setText("ESTADO");

        CB_ESTADO.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        CB_ESTADO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_ESTADOActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(151, 151, 151)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CB_CUIDAD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CB_ESTADO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAgrefarEstados, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(C_MOD_Proveedor_txfdir, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(C_MOD_Proveedor_txfcodPos, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(C_MOD_Proveedor_txfcol, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel9))
                                        .addGap(18, 18, 18))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(122, 122, 122)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txfIdProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(C_MOD_Proveedor_txfnom)
                                        .addComponent(C_MOD_Proveedor_txftel)
                                        .addComponent(C_MOD_Proveedor_txfemail, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(302, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txfIdProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(C_MOD_Proveedor_txfnom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(C_MOD_Proveedor_txftel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(C_MOD_Proveedor_txfemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(C_MOD_Proveedor_txfdir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(C_MOD_Proveedor_txfcol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(C_MOD_Proveedor_txfcodPos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgrefarEstados, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(15, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(CB_ESTADO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(CB_CUIDAD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgrefarEstadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgrefarEstadosActionPerformed
        String no, tel, ema, dir, col, cod;
        no = C_MOD_Proveedor_txfnom.getText();
        tel = C_MOD_Proveedor_txftel.getText();
        ema = C_MOD_Proveedor_txfemail.getText();
        dir = C_MOD_Proveedor_txfdir.getText();
        col = C_MOD_Proveedor_txfcol.getText();
        cod = C_MOD_Proveedor_txfcodPos.getText();

        int idc = 0;
        if ((!no.isEmpty()) && (!tel.isEmpty()) && (!ema.isEmpty()) && (!dir.isEmpty())
                && (!col.isEmpty()) && (!cod.isEmpty())) {
        StringTokenizer numero = new StringTokenizer(CB_CUIDAD.getSelectedItem().toString(), " ");
        erp.OpenCon("ERP", "erp");
        int C = 0;
        while (numero.hasMoreTokens()) {
            String a = numero.nextToken();
            C++;
            if (C == 1) {
                idc = Integer.parseInt(a);
            }

        }

            erp.OpenCon("ERP", "erp");
            int ID = Integer.parseInt(txfIdProveedor.getText());
            erp.SQLLupita("update proveedores set nombre ="
                    + "'" + C_MOD_Proveedor_txfnom.getText() + "',"
                    + "telefono ='" + C_MOD_Proveedor_txftel.getText() + "',"
                    + "email='" + C_MOD_Proveedor_txfemail.getText() + "',"
                    + "direccion ='" + C_MOD_Proveedor_txfdir.getText() + "',"
                    + "colonia ='" + C_MOD_Proveedor_txfcol.getText() + "',"
                    + "codigopostal ='" + C_MOD_Proveedor_txfcodPos.getText() + "',"
                    + "idciudad="+ idc
                    + "where idproveedor ="
                    + ID);
        } else {
            JOptionPane.showMessageDialog(null, "No se permiten campos vacios", "Error", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_btnAgrefarEstadosActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
C_Proveedores p= new C_Proveedores();
        p.borrarTabla(p.tblpROVEEDORES);
        erp.Proveedores_Search("",p.tblpROVEEDORES);
        
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void C_MOD_Proveedor_txfnomKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_C_MOD_Proveedor_txfnomKeyTyped
        char c=evt.getKeyChar();
        if((c<'a' || c>'z')&&(c<'A' || c>'Z')&&(c<' '||c>' ')) evt.consume();
    }//GEN-LAST:event_C_MOD_Proveedor_txfnomKeyTyped

    private void C_MOD_Proveedor_txftelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_C_MOD_Proveedor_txftelKeyTyped
        int c=evt.getKeyChar();
        if((c<'0' || c>'9')&&(c<'-' || c>'-'))evt.consume();
        if (C_MOD_Proveedor_txftel.getText().length() == limite2) {
            evt.consume();
        }
    }//GEN-LAST:event_C_MOD_Proveedor_txftelKeyTyped

    private void C_MOD_Proveedor_txfemailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_C_MOD_Proveedor_txfemailKeyTyped
        char c=evt.getKeyChar();
        if((c<'a' || c>'z')&&(c<'A' || c>'Z')&&(c<' '||c>' ')&&
        (c!='@'||C_MOD_Proveedor_txfemail.getText().contains("@"))&&
        (c!='.'||C_MOD_Proveedor_txfemail.getText().contains("."))
        && (validar(C_MOD_Proveedor_txfemail.getText()))) evt.consume();
    }//GEN-LAST:event_C_MOD_Proveedor_txfemailKeyTyped

    private void C_MOD_Proveedor_txfdirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C_MOD_Proveedor_txfdirActionPerformed
        
    }//GEN-LAST:event_C_MOD_Proveedor_txfdirActionPerformed

    private void C_MOD_Proveedor_txfdirKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_C_MOD_Proveedor_txfdirKeyTyped
        char c=evt.getKeyChar();
        if((c<'a' || c>'z')&&(c<'A' || c>'Z')&&(c<'0'|| c>'9') &&(c>'#'|| c<'#')&&(c>' '|| c<' ')&&(c<'.'||c>'.')) evt.consume();
    }//GEN-LAST:event_C_MOD_Proveedor_txfdirKeyTyped

    private void C_MOD_Proveedor_txfcolKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_C_MOD_Proveedor_txfcolKeyTyped
        char c=evt.getKeyChar();
        if((c<'a' || c>'z')&&(c<'A' || c>'Z')&&(c>' '|| c<' ')) evt.consume();
    }//GEN-LAST:event_C_MOD_Proveedor_txfcolKeyTyped

    private void C_MOD_Proveedor_txfcodPosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_C_MOD_Proveedor_txfcodPosKeyTyped
        int c=evt.getKeyChar();
        if(c<'0' || c>'9')evt.consume();
        if (C_MOD_Proveedor_txfcodPos.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_C_MOD_Proveedor_txfcodPosKeyTyped

    private void CB_ESTADOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_ESTADOActionPerformed
     
    }//GEN-LAST:event_CB_ESTADOActionPerformed

    private void CB_CUIDADActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_CUIDADActionPerformed
   
    }//GEN-LAST:event_CB_CUIDADActionPerformed
       public boolean validar(String correo) {
        Pattern pat = null;
        Matcher mat = null;
        
        pat=Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        mat = pat.matcher(correo);
        if (mat.find()) {
            return true;
        } else {
            return false;
        }
    }
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
            java.util.logging.Logger.getLogger(C_MOD_Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(C_MOD_Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(C_MOD_Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(C_MOD_Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new C_MOD_Proveedores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox CB_CUIDAD;
    public javax.swing.JComboBox CB_ESTADO;
    private javax.swing.JTextField C_MOD_Proveedor_txfcodPos;
    private javax.swing.JTextField C_MOD_Proveedor_txfcol;
    private javax.swing.JTextField C_MOD_Proveedor_txfdir;
    private javax.swing.JTextField C_MOD_Proveedor_txfemail;
    private javax.swing.JTextField C_MOD_Proveedor_txfnom;
    private javax.swing.JTextField C_MOD_Proveedor_txftel;
    public javax.swing.JButton btnAgrefarEstados;
    public javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JTextField txfIdProveedor;
    // End of variables declaration//GEN-END:variables
}
