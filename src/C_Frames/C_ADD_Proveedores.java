
package C_Frames;

import C_Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import C_Frames.C_Categorias;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

/**
 *
 * @author rocker
 */
public class C_ADD_Proveedores extends javax.swing.JFrame {

    /**
     * Creates new form AgregarCiudad
     */
    Conexion erp;
    DefaultComboBoxModel modelocombo = new DefaultComboBoxModel();
    DefaultComboBoxModel modelocombo1 = new DefaultComboBoxModel();
    public C_ADD_Proveedores() {
        initComponents();
        erp = new Conexion();
        llenarCombo();
        this.CB_CUIDAD.setEnabled(false);
    }
    C_Categorias cd;
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
        btnAgregar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        C_ADD_Proveedores_txftel = new javax.swing.JTextField();
        C_ADD_Proveedores_txfdir = new javax.swing.JTextField();
        C_ADD_Proveedores_txfcol = new javax.swing.JTextField();
        C_ADD_Proveedores_txfcodPos = new javax.swing.JTextField();
        C_ADD_Proveedores_txfnom = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        CB_CUIDAD = new javax.swing.JComboBox();
        C_ADD_Proveedores_txfEMAIL = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        CB_ESTADO = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(40, 183, 41)), "AGREGAR PROVEEDOR", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(255, 0, 0))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(254, 254, 254));

        jLabel1.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(1, 1, 1));
        jLabel1.setText("NOMBRE PROVEEDOR");

        btnAgregar.setBackground(new java.awt.Color(254, 254, 254));
        btnAgregar.setForeground(new java.awt.Color(254, 254, 254));
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregar.png"))); // NOI18N
        btnAgregar.setToolTipText("Guadar");
        btnAgregar.setBorderPainted(false);
        btnAgregar.setContentAreaFilled(false);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(254, 254, 254));
        btnCancelar.setForeground(new java.awt.Color(254, 254, 254));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon-cancelar.png"))); // NOI18N
        btnCancelar.setToolTipText("Cerrar");
        btnCancelar.setBorderPainted(false);
        btnCancelar.setContentAreaFilled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnLimpiar.setBackground(new java.awt.Color(254, 254, 254));
        btnLimpiar.setForeground(new java.awt.Color(254, 254, 254));
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/borar1-icon.png"))); // NOI18N
        btnLimpiar.setToolTipText("Limpiar Campos");
        btnLimpiar.setBorderPainted(false);
        btnLimpiar.setContentAreaFilled(false);
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(254, 254, 254));
        jLabel3.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(1, 1, 1));
        jLabel3.setText("TELEFONO");

        jLabel4.setBackground(new java.awt.Color(254, 254, 254));
        jLabel4.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(1, 1, 1));
        jLabel4.setText("DIRECCIÓN");

        jLabel5.setBackground(new java.awt.Color(254, 254, 254));
        jLabel5.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(1, 1, 1));
        jLabel5.setText("COLONIA");

        jLabel6.setBackground(new java.awt.Color(254, 254, 254));
        jLabel6.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(1, 1, 1));
        jLabel6.setText("CODIGO POSTAL");

        jLabel8.setBackground(new java.awt.Color(254, 254, 254));
        jLabel8.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(1, 1, 1));
        jLabel8.setText("EMAIL");

        C_ADD_Proveedores_txftel.setBackground(new java.awt.Color(254, 254, 254));
        C_ADD_Proveedores_txftel.setForeground(new java.awt.Color(1, 1, 1));
        C_ADD_Proveedores_txftel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                C_ADD_Proveedores_txftelKeyTyped(evt);
            }
        });

        C_ADD_Proveedores_txfdir.setBackground(new java.awt.Color(254, 254, 254));
        C_ADD_Proveedores_txfdir.setForeground(new java.awt.Color(1, 1, 1));
        C_ADD_Proveedores_txfdir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C_ADD_Proveedores_txfdirActionPerformed(evt);
            }
        });
        C_ADD_Proveedores_txfdir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                C_ADD_Proveedores_txfdirKeyTyped(evt);
            }
        });

        C_ADD_Proveedores_txfcol.setBackground(new java.awt.Color(254, 254, 254));
        C_ADD_Proveedores_txfcol.setForeground(new java.awt.Color(1, 1, 1));
        C_ADD_Proveedores_txfcol.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                C_ADD_Proveedores_txfcolKeyTyped(evt);
            }
        });

        C_ADD_Proveedores_txfcodPos.setBackground(new java.awt.Color(254, 254, 254));
        C_ADD_Proveedores_txfcodPos.setForeground(new java.awt.Color(1, 1, 1));
        C_ADD_Proveedores_txfcodPos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                C_ADD_Proveedores_txfcodPosKeyTyped(evt);
            }
        });

        C_ADD_Proveedores_txfnom.setBackground(new java.awt.Color(254, 254, 254));
        C_ADD_Proveedores_txfnom.setForeground(new java.awt.Color(1, 1, 1));
        C_ADD_Proveedores_txfnom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                C_ADD_Proveedores_txfnomKeyTyped(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(254, 254, 254));
        jLabel9.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(1, 1, 1));
        jLabel9.setText("CUIDAD");

        CB_CUIDAD.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        C_ADD_Proveedores_txfEMAIL.setBackground(new java.awt.Color(254, 254, 254));
        C_ADD_Proveedores_txfEMAIL.setForeground(new java.awt.Color(1, 1, 1));
        C_ADD_Proveedores_txfEMAIL.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                C_ADD_Proveedores_txfEMAILKeyTyped(evt);
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
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLimpiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAgregar)
                        .addGap(26, 26, 26))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(C_ADD_Proveedores_txfdir, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(C_ADD_Proveedores_txfnom, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                                    .addComponent(C_ADD_Proveedores_txftel)
                                    .addComponent(C_ADD_Proveedores_txfEMAIL)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(C_ADD_Proveedores_txfcodPos, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(C_ADD_Proveedores_txfcol, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(78, 293, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(151, 151, 151)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CB_CUIDAD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CB_ESTADO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(C_ADD_Proveedores_txfnom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(C_ADD_Proveedores_txftel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(C_ADD_Proveedores_txfEMAIL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(C_ADD_Proveedores_txfdir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(C_ADD_Proveedores_txfcol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(C_ADD_Proveedores_txfcodPos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(CB_ESTADO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(CB_CUIDAD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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
//for( e = name(first),r = name(last), p= name(other_last);e<r<p;e+=r,r+= p,p++ ){
//}
        
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
      private JTextField jTextFieldName = new JTextField();

      private int limite = 5, limite2=10;
      

  
   
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        String ba,b,c,d,e;
        ba=C_ADD_Proveedores_txfnom.getText();
        b=C_ADD_Proveedores_txftel.getText();
        c=C_ADD_Proveedores_txfdir.getText();
        d=C_ADD_Proveedores_txfcol.getText();
        String h=C_ADD_Proveedores_txfcodPos.getText();
        e=C_ADD_Proveedores_txfEMAIL.getText();
        
        int g=CB_CUIDAD.getSelectedIndex();
        
        
        int idc = 0;
        if((!ba.isEmpty())&&(!b.isEmpty())&&(!c.isEmpty())&&(!d.isEmpty())&&(!e.isEmpty())&&(!h.isEmpty())&&(g!=0)){
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
        erp.SQLLupita("insert into PROVEEDORES values (ERP.PROVEE.nextval,"
                + "'" + C_ADD_Proveedores_txfnom.getText() + "',"
                + "'" + C_ADD_Proveedores_txftel.getText() + "',"
                + "'" + C_ADD_Proveedores_txfEMAIL.getText() + "',"
                + "'" + C_ADD_Proveedores_txfdir.getText() + "',"
                + "'" + C_ADD_Proveedores_txfcol.getText() + "',"
                + "'" + C_ADD_Proveedores_txfcodPos.getText() + "',"
                + idc+ ","
                + "'A'"
                + ")");

        
        }
        else {
            JOptionPane.showMessageDialog(null,"No se permiten campos vacios o Cuidad sin asignar","Error" ,JOptionPane.INFORMATION_MESSAGE);
        }
        
       
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        this.C_ADD_Proveedores_txfnom.setText("");
        this.C_ADD_Proveedores_txftel.setText("");
        this.C_ADD_Proveedores_txfdir.setText("");
        this.C_ADD_Proveedores_txfcol.setText("");
        this.C_ADD_Proveedores_txfcodPos.setText("");
        this.C_ADD_Proveedores_txfEMAIL.setText("");
        this.CB_CUIDAD.setSelectedIndex(0);
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void C_ADD_Proveedores_txfdirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C_ADD_Proveedores_txfdirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_C_ADD_Proveedores_txfdirActionPerformed

    private void C_ADD_Proveedores_txfnomKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_C_ADD_Proveedores_txfnomKeyTyped
        char c=evt.getKeyChar();
        if((c<'a' || c>'z')&&(c<'A' || c>'Z')&&(c<' '||c>' ')) evt.consume();
    }//GEN-LAST:event_C_ADD_Proveedores_txfnomKeyTyped

    private void C_ADD_Proveedores_txftelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_C_ADD_Proveedores_txftelKeyTyped
        int c=evt.getKeyChar();
        if((c<'0' || c>'9')&&(c<'-' || c>'-'))evt.consume();
        if (C_ADD_Proveedores_txftel.getText().length() == limite2) {
            evt.consume();
        }
    }//GEN-LAST:event_C_ADD_Proveedores_txftelKeyTyped

    private void C_ADD_Proveedores_txfdirKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_C_ADD_Proveedores_txfdirKeyTyped
        char c=evt.getKeyChar();
        if((c<'a' || c>'z')&&(c<'A' || c>'Z')&&(c<'0'|| c>'9') &&(c>'#'|| c<'#')&&(c>' '|| c<' ')&&(c<'.'||c>'.')) evt.consume();

    }//GEN-LAST:event_C_ADD_Proveedores_txfdirKeyTyped

    private void C_ADD_Proveedores_txfcolKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_C_ADD_Proveedores_txfcolKeyTyped
        char c=evt.getKeyChar();
        if((c<'a' || c>'z')&&(c<'A' || c>'Z')&&(c>' '|| c<' ')) evt.consume();
    }//GEN-LAST:event_C_ADD_Proveedores_txfcolKeyTyped

    private void C_ADD_Proveedores_txfcodPosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_C_ADD_Proveedores_txfcodPosKeyTyped
        int c=evt.getKeyChar();
        if(c<'0' || c>'9')evt.consume();
        if (C_ADD_Proveedores_txfcodPos.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_C_ADD_Proveedores_txfcodPosKeyTyped

    private void C_ADD_Proveedores_txfEMAILKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_C_ADD_Proveedores_txfEMAILKeyTyped
        char c=evt.getKeyChar();
        if((c<'a' || c>'z')&&(c<'A' || c>'Z')&&(c<' '||c>' ')&&
        (c!='@'||C_ADD_Proveedores_txfEMAIL.getText().contains("@"))&&
        (c!='.'||C_ADD_Proveedores_txfEMAIL.getText().contains(".")) 
         && (validar(C_ADD_Proveedores_txfEMAIL.getText()))) evt.consume();
        
        
    }//GEN-LAST:event_C_ADD_Proveedores_txfEMAILKeyTyped

    private void CB_ESTADOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_ESTADOActionPerformed

        if(CB_ESTADO.getSelectedIndex()>=0){
        llenarCombo1();
        CB_CUIDAD.setEnabled(true);
        }
    }//GEN-LAST:event_CB_ESTADOActionPerformed
    
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
            java.util.logging.Logger.getLogger(C_ADD_Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(C_ADD_Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(C_ADD_Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(C_ADD_Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new C_ADD_Proveedores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox CB_CUIDAD;
    private javax.swing.JComboBox CB_ESTADO;
    private javax.swing.JTextField C_ADD_Proveedores_txfEMAIL;
    private javax.swing.JTextField C_ADD_Proveedores_txfcodPos;
    private javax.swing.JTextField C_ADD_Proveedores_txfcol;
    private javax.swing.JTextField C_ADD_Proveedores_txfdir;
    private javax.swing.JTextField C_ADD_Proveedores_txfnom;
    private javax.swing.JTextField C_ADD_Proveedores_txftel;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
