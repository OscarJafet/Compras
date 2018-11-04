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
import java.util.Calendar;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author carlo
 */
public class C_MOD_Pedidos extends javax.swing.JFrame {

    /**
     * Creates new form EditarEstados
     */
    Conexion erp;
    public C_MOD_Pedidos() {
        initComponents();
        erp = new Conexion();
        this.txfIdLab.setEditable(false);
         txfcantida.setEnabled(false);
    }
    
    int total=0,totalfinal=0;
         public void Datos(String a, String b,String c,String c1,String c2,String c3,String c4,String c5,String c6){
           txfIdLab.setText(a);
         
        
          total=Integer.parseInt(c1);
             llenarProducto(c4);
             cbxempleado.addItem(llenarempleado(a)+" "+c6);
             cbxsucursal.addItem(llenarsucursal(a)+" "+c5);
             llenarfecha(a);
    }
         
      DefaultComboBoxModel modelocombo = new DefaultComboBoxModel();
    DefaultComboBoxModel modelocombo1 = new DefaultComboBoxModel();
    
    public void llenarProducto(String s){
        cbxproducto.removeAllItems();
        cbxproducto.removeAllItems();
         s=s.replace(" ", "%");
    for (int i = 0; i < s.length(); i++) {
        if(s.charAt(i)=='%'){
         s=s.substring(i+1, s.length());
         break;
        }
    }
        try {
            erp.OpenCon("ERP", "erp");
            erp.stn= (Statement) erp.con.createStatement();
            
            erp.rs= erp.stn.executeQuery("select pt.nombre, em.nombre as nom from  ((((productosproveedor ptp inner join proveedores pro\n" +
"                    on pro.idproveedor=ptp.idproveedor)inner join\n" +
"                    presentacionesproducto prt on prt.idpresentacion=\n" +
"                    ptp.idpresentacion)inner join productos pt on prt.idproducto=pt.idproducto)inner join empaques em on prt.idempaque=em.idempaque)\n"  +
"                    where pro.nombre='"+s+"'");
            
            modelocombo1.addElement("Selecione un producto");
            
            cbxproducto.setModel(modelocombo1);
            while (erp.rs.next()){
                String IDPRESENTACION=String.valueOf( erp.rs.getObject("nombre"));
                String Nombre=(String) erp.rs.getObject("nom");
            

                modelocombo1.addElement(IDPRESENTACION +" "+ Nombre );
                cbxproducto.setModel(modelocombo1);
            }
        
        }catch(SQLException ex){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    DefaultComboBoxModel modelocombo4 = new DefaultComboBoxModel();
    
    public void llenarempleado(){
      cbxempleado.removeAllItems();
        try {
            erp.OpenCon("ERP", "erp");
            erp.stn= (Statement) erp.con.createStatement();
            
            erp.rs= erp.stn.executeQuery("select em.idempleado as NOM,em.NOMBRE as NO from empleados em" );

            
            modelocombo4.addElement("Selecione un empleado");
            
            cbxempleado.setModel(modelocombo4);
            while (erp.rs.next()){
                String IDPRESENTACION=String.valueOf( erp.rs.getObject("NOM"));
                String Nombre=(String) erp.rs.getObject("NO");
            

                modelocombo4.addElement(IDPRESENTACION +" "+ Nombre );
                cbxempleado.setModel(modelocombo4);
            }
        
        }catch(SQLException ex){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
        public void llenarfecha(String fecha){
    
        try {
            erp.OpenCon("ERP", "erp");
            erp.stn= (Statement) erp.con.createStatement();
            
            erp.rs= erp.stn.executeQuery("select fecharecepcion from pedidos where idpedido= "+fecha );

         
            while (erp.rs.next()){
                String IDPRESENTACION=String.valueOf( erp.rs.getObject("fecharecepcion"));
      
                StringTokenizer token=new StringTokenizer(IDPRESENTACION, "-");
           String Elemento[]=new String[3];  
           int cont=0;
           while(token.hasMoreTokens()){
            String b=token.nextToken().toString();
            Elemento[cont]=b;
                    cont++;
             }
               txfanio.setText(Elemento[0]);
               txfmes.setText(Elemento[1]);
               txfdia.setText(Elemento[2]);
                 
            }
        
        }catch(SQLException ex){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        
    
     String llenarsucursal(String fecha){
    
        try {
            erp.OpenCon("ERP", "erp");
            erp.stn= (Statement) erp.con.createStatement();
            
            erp.rs= erp.stn.executeQuery("select idsucursal from pedidos where idpedido= "+fecha );

         
            while (erp.rs.next()){
                String IDPRESENTACION=String.valueOf( erp.rs.getObject("idsucursal"));
            

             return IDPRESENTACION;
            }
        
        }catch(SQLException ex){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
      
     String llenarempleado(String fecha){
    
        try {
            erp.OpenCon("ERP", "erp");
            erp.stn= (Statement) erp.con.createStatement();
            
            erp.rs= erp.stn.executeQuery("select idempleado from pedidos where idpedido= "+fecha );

         
            while (erp.rs.next()){
                String IDPRESENTACION=String.valueOf( erp.rs.getObject("idempleado"));
            

             return IDPRESENTACION;
            }
        
        }catch(SQLException ex){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
     
     
    int preciototal;
     public void precio(String s){
        
   String s1=null;
   String s2=null;
    int cont=0;
    
         for (int i = 0; i < s.length(); i++) {
             if(s.charAt(i)==' '||(i+1)==s.length()){
                
                 if(s.charAt(i)==' '){
                     cont=i;
                  s2=s.substring(0, i);
                 }
                 if((i+1)==s.length()){
                 s1=s.substring(cont+1, s.length());}
                 
             }
         }
        try {
            erp.OpenCon("ERP", "erp");
            erp.stn= (Statement) erp.con.createStatement();
         
            erp.rs= erp.stn.executeQuery("select pp.preciocompra from\n" +
"           PRESENTACIONESPRODUCTO pp  inner \n" +
"           join PRODUCTOS pt on pt.idproducto=pp.idproducto inner join empaques em on em.idempaque=pp.idempaque "
                    + "where pt.nombre='"+s2+"' and em.nombre='"+s1+"'");
            
        
            
           
            while (erp.rs.next()){
                String Nombre=String.valueOf( erp.rs.getObject("preciocompra"));
            preciototal=Integer.parseInt(Nombre);
                    }
        
        }catch(SQLException ex){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
    public void llenarSucursal(){
        try {
            erp.OpenCon("ERP", "erp");
            erp.stn= (Statement) erp.con.createStatement();
            
            erp.rs= erp.stn.executeQuery("select IDSUCURSAL,NOMBRE from sucursal where ESTATUS='A'");
            
            modelocombo.addElement("Selecione una Sucursal");
            
            cbxsucursal.setModel(modelocombo);
            while (erp.rs.next()){
                String IDPRESENTACION=String.valueOf( erp.rs.getObject("IDSUCURSAL"));
                String Nombre=(String) erp.rs.getObject("NOMBRE");

                modelocombo.addElement(IDPRESENTACION +" "+ Nombre);
                cbxsucursal.setModel(modelocombo);
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
        txfIdLab = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cbxsucursal = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cbxempleado = new javax.swing.JComboBox();
        txfcantida = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblproducto = new javax.swing.JTable();
        btnAgregarPerce1 = new javax.swing.JButton();
        btnAgregarPerce2 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        cbxproducto = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        txfdia = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txfmes = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txfanio = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(254, 254, 254));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "EDITAR PEDIDO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(255, 0, 0))); // NOI18N

        jLabel1.setBackground(new java.awt.Color(254, 254, 254));
        jLabel1.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(1, 1, 1));
        jLabel1.setText("ID");

        jButton1.setBackground(new java.awt.Color(254, 254, 254));
        jButton1.setForeground(new java.awt.Color(254, 254, 254));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon-cancelar.png"))); // NOI18N
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
        btnAgrefarEstados.setToolTipText("");
        btnAgrefarEstados.setBorderPainted(false);
        btnAgrefarEstados.setContentAreaFilled(false);
        btnAgrefarEstados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgrefarEstadosActionPerformed(evt);
            }
        });

        txfIdLab.setBackground(new java.awt.Color(253, 239, 239));
        txfIdLab.setForeground(new java.awt.Color(1, 1, 1));

        jLabel7.setBackground(new java.awt.Color(254, 254, 254));
        jLabel7.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(1, 1, 1));

        cbxsucursal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cbxsucursalFocusGained(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(1, 1, 1));
        jLabel10.setText("Seleccione una sucursal ");

        jLabel12.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(1, 1, 1));
        jLabel12.setText("Seleccione un empleado");

        cbxempleado.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cbxempleadoFocusGained(evt);
            }
        });

        txfcantida.setBackground(new java.awt.Color(254, 254, 254));
        txfcantida.setForeground(new java.awt.Color(1, 1, 1));
        txfcantida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfcantidaActionPerformed(evt);
            }
        });
        txfcantida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfcantidaKeyTyped(evt);
            }
        });

        tblproducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre Producto y paquete", "Precio Total"
            }
        ));
        jScrollPane1.setViewportView(tblproducto);

        btnAgregarPerce1.setBackground(new java.awt.Color(254, 254, 254));
        btnAgregarPerce1.setText("Agregar Producto");
        btnAgregarPerce1.setBorderPainted(false);
        btnAgregarPerce1.setContentAreaFilled(false);
        btnAgregarPerce1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPerce1ActionPerformed(evt);
            }
        });

        btnAgregarPerce2.setBackground(new java.awt.Color(254, 254, 254));
        btnAgregarPerce2.setText("Elimina Producto");
        btnAgregarPerce2.setBorderPainted(false);
        btnAgregarPerce2.setContentAreaFilled(false);
        btnAgregarPerce2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPerce2ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(1, 1, 1));
        jLabel11.setText("cantidad del producto solicitado");

        cbxproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxproductoActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(1, 1, 1));
        jLabel6.setText("Seleccione un producto");

        txfdia.setBackground(new java.awt.Color(254, 254, 254));
        txfdia.setForeground(new java.awt.Color(1, 1, 1));
        txfdia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfdiaActionPerformed(evt);
            }
        });
        txfdia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfdiaKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(1, 1, 1));
        jLabel9.setText("Fecha de llegada");

        jLabel13.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(1, 1, 1));
        jLabel13.setText("dia");

        jLabel8.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(1, 1, 1));
        jLabel8.setText("/ mes");

        txfmes.setBackground(new java.awt.Color(254, 254, 254));
        txfmes.setForeground(new java.awt.Color(1, 1, 1));
        txfmes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfmesKeyTyped(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(1, 1, 1));
        jLabel14.setText("/ año");

        txfanio.setBackground(new java.awt.Color(254, 254, 254));
        txfanio.setForeground(new java.awt.Color(1, 1, 1));
        txfanio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfanioKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAgrefarEstados, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxsucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12)
                            .addComponent(cbxempleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(txfcantida, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(50, 50, 50)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnAgregarPerce1)
                                    .addComponent(btnAgregarPerce2))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txfdia, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txfmes, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txfanio, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(87, 87, 87)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(cbxproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfIdLab, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txfIdLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txfdia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(txfmes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(txfanio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(cbxproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel11))
                            .addComponent(btnAgregarPerce1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txfcantida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgregarPerce2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxsucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxempleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgrefarEstados, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
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

    private void cbxproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxproductoActionPerformed
        if(cbxproducto.getSelectedIndex()>0){
            precio(cbxproducto.getSelectedItem().toString());
            txfcantida.setEnabled(true);

        }
    }//GEN-LAST:event_cbxproductoActionPerformed

    private void btnAgregarPerce2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPerce2ActionPerformed
        if(tblproducto.getSelectedRow()>-1){

            DefaultTableModel tabT = (DefaultTableModel) tblproducto.getModel();

            tabT.removeRow(tblproducto.getSelectedRow());

        }
    }//GEN-LAST:event_btnAgregarPerce2ActionPerformed

    private void btnAgregarPerce1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPerce1ActionPerformed
        if(cbxproducto.getSelectedIndex()>0 && !txfcantida.getText().isEmpty() && !txfcantida.getText().toString().equals("0")){

            precio(cbxproducto.getSelectedItem().toString());
            int total=Integer.parseInt(txfcantida.getText()) * preciototal;

            DefaultTableModel tablaTemp = (DefaultTableModel) tblproducto.getModel();
            Object datosRenglon[]={cbxproducto.getSelectedItem(),total};
            tablaTemp.addRow(datosRenglon);

            tblproducto.setModel(tablaTemp);

        }
    }//GEN-LAST:event_btnAgregarPerce1ActionPerformed

    private void txfcantidaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfcantidaKeyTyped
        char caracter = evt.getKeyChar();

        // Verificar si la tecla pulsada no es un digito
        if(((caracter < '0') ||
            (caracter > '9')) &&
        (caracter != '\b' /*corresponde a BACK_SPACE*/))
        {
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txfcantidaKeyTyped

    private void txfcantidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfcantidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfcantidaActionPerformed

    private void btnAgrefarEstadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgrefarEstadosActionPerformed
       
        
   
      
 erp.OpenCon("ERP", "erp");
        
    
        
if(!cbxempleado.getSelectedItem().toString().equals("Selecione un empleado")&&
        !cbxsucursal.getSelectedItem().toString().equals("Selecione una Sucursal")&& !txfanio.getText().isEmpty()&&
        !txfdia.getText().isEmpty()
        &&!txfmes.getText().isEmpty()){

        
        String fech = null;
        int dia= Integer.parseInt(txfdia.getText().toString());
        int mes= Integer.parseInt(txfmes.getText().toString());
        int año=Integer.parseInt(txfanio.getText().toString());
        int numDias = 0;
       boolean bandera=false;        
        
        if(mes<=12 && mes >0){
       
        switch (mes) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                numDias = 31;
                break;
            case 4: case 6: case 9: case 11:
                numDias = 30;
                break;
            case 2:
                if((año%4==0 && año%100!=0) || año%400==0){
                    numDias = 29;
                }
                else{
                    numDias = 28;
                }
                break;
        }
        if(dia <= numDias && dia > 0){
           
        if(año > 1000){
           
         fech= String.valueOf(dia)+"/"+String.valueOf(mes)+"/"+String.valueOf(año);}
        else{
        JOptionPane.showMessageDialog(null, "año invalido");
        }
          
        }else{JOptionPane.showMessageDialog(null, "dia invalido");}
      }else{JOptionPane.showMessageDialog(null, "mes invalido");}
      
    
    String a=String.valueOf(cbxsucursal.getSelectedItem()).toString().replace(" ", "%"),
            a2 = null;
        
    
    for (int i = 0; i < a.length(); i++) {
        if(a.charAt(i)=='%'){
         a2=String.valueOf(cbxsucursal.getSelectedItem()).substring(0, i);
         break;
        }
    }
    
   
    String em=String.valueOf(cbxempleado.getSelectedItem()).toString().replace(" ", "%");
   String e=null;
    for (int i = 0; i < em.length(); i++) {
        if(em.charAt(i)=='%'){
         e=String.valueOf(cbxempleado.getSelectedItem()).substring(0, i);
         break;
        }
    }

    for (int i = 0; i < tblproducto.getRowCount(); i++) {
       
        totalfinal=totalfinal+ Integer.parseInt(String.valueOf( tblproducto.getValueAt(i, 1)));
        
        
    }
  
if(fech!=null){
    if(totalfinal==0){
      String sql="update  pedidos set fecharecepcion='"+fech+"', idsucursal= "+Integer.parseInt(a2) +", idempleado="+Integer.parseInt(e)+", totalpagar="+
           total+" where idpedido= "+Integer.parseInt(txfIdLab.getText());
    erp.SQL("update  pedidos set fecharecepcion='"+fech+"', idsucursal= "+Integer.parseInt(a2) +", idempleado="+Integer.parseInt(e)+", totalpagar="+
           total+" where idpedido= "+Integer.parseInt(txfIdLab.getText()));
    
        }else{
    totalfinal+=total;
      erp.SQL("update  pedidos set fecharecepcion='"+fech+"', idsucursal= "+Integer.parseInt(a2) +", idempleado="+Integer.parseInt(e)+", totalpagar="
              +totalfinal+" where idpedido= "+Integer.parseInt(txfIdLab.getText()));
    }
}

}else{
    JOptionPane.showMessageDialog(null, "ingrese campos de sucursal y empleado y fecha");
}
        
          
        
    }//GEN-LAST:event_btnAgrefarEstadosActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbxsucursalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbxsucursalFocusGained
llenarSucursal();
    }//GEN-LAST:event_cbxsucursalFocusGained

    private void cbxempleadoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbxempleadoFocusGained
llenarempleado();        // TODO add your handling code here:
    }//GEN-LAST:event_cbxempleadoFocusGained

    private void txfdiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfdiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfdiaActionPerformed

    private void txfdiaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfdiaKeyTyped
        char caracter = evt.getKeyChar();

        // Verificar si la tecla pulsada no es un digito
        if(((caracter < '0') ||
            (caracter > '9')) &&
        (caracter != '\b' /*corresponde a BACK_SPACE*/))
        {
            evt.consume();
        }
        // ignorar el evento de teclado        // TODO add your handling code here:
    }//GEN-LAST:event_txfdiaKeyTyped

    private void txfmesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfmesKeyTyped
        char caracter = evt.getKeyChar();

        // Verificar si la tecla pulsada no es un digito
        if(((caracter < '0') ||
            (caracter > '9')) &&
        (caracter != '\b' /*corresponde a BACK_SPACE*/))
        {
            evt.consume();
        }
        // ignorar el evento de teclado
    }//GEN-LAST:event_txfmesKeyTyped

    private void txfanioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfanioKeyTyped
        char caracter = evt.getKeyChar();

        // Verificar si la tecla pulsada no es un digito
        if(((caracter < '0') ||
            (caracter > '9')) &&
        (caracter != '\b' /*corresponde a BACK_SPACE*/))
        {
            evt.consume();
        }
        // ignorar el evento de teclado
    }//GEN-LAST:event_txfanioKeyTyped

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
            java.util.logging.Logger.getLogger(C_MOD_Pedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(C_MOD_Pedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(C_MOD_Pedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(C_MOD_Pedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new C_MOD_Pedidos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAgrefarEstados;
    private javax.swing.JButton btnAgregarPerce1;
    private javax.swing.JButton btnAgregarPerce2;
    private javax.swing.JComboBox cbxempleado;
    private javax.swing.JComboBox cbxproducto;
    private javax.swing.JComboBox cbxsucursal;
    public javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblproducto;
    public javax.swing.JTextField txfIdLab;
    private javax.swing.JTextField txfanio;
    private javax.swing.JTextField txfcantida;
    private javax.swing.JTextField txfdia;
    private javax.swing.JTextField txfmes;
    // End of variables declaration//GEN-END:variables
}
