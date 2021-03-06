/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package C_Frames;

import C_Conexion.Conexion;
import static C_Conexion.Conexion.con;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author carlo
 */
public class C_MOD_Productos extends javax.swing.JFrame {

    /**
     * Creates new form EditarEstados
     */
    Conexion erp;
     DefaultComboBoxModel modelocombo = new DefaultComboBoxModel();
    DefaultComboBoxModel modelocombo1 = new DefaultComboBoxModel();
    DefaultComboBoxModel modelocombo2 = new DefaultComboBoxModel();
    public C_MOD_Productos() {
        initComponents();
        erp = new Conexion();
        this.txfIDProducto.setEditable(false);
        llenarCombo();
        llenarCombo1();
        llenarCombo2();
    }
    public void Datos(String a, String b,String c, String e,String f, String h, String i, String j,String k){
           txfIDProducto.setText(a);
           txfNombre.setText(b);
           txfDescripcion.setText(c);
           txfIngrediente.setText(e);
           modelocombo2.setSelectedItem(f);
           txfAplicacion.setText(h);
           txfUso.setText(i);
           
           String id= String.valueOf(erp.consultaLab(j));
           
           modelocombo.setSelectedItem(id+" "+j);
           
           String id1= String.valueOf(erp.consultaCat(k));
           
           modelocombo1.setSelectedItem(id1+" "+k);
    }    
        
    public void llenarCombo(){
        try {
            erp.OpenCon("ERP", "erp");
            erp.stn= (Statement) erp.con.createStatement();
            erp.rs= erp.stn.executeQuery("select * from Laboratorios where estatus='A'");
            modelocombo.addElement("Seleccione Laboratorio");
            cmbLab.setModel(modelocombo);
            while (erp.rs.next()){
                String ID= String.valueOf(erp.rs.getObject("idlaboratorio"));
                String nombre= String.valueOf(erp.rs.getObject("nombre"));
                modelocombo.addElement(ID+" "+nombre);
                cmbLab.setModel(modelocombo);
            }
        
        }catch(SQLException ex){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
        public void llenarCombo1(){
        try {
            erp.OpenCon("ERP", "erp");
            erp.stn= (Statement) erp.con.createStatement();
            erp.rs= erp.stn.executeQuery("select * from Categorias where estatus='A'");
            modelocombo1.addElement("Seleccione Categoria");
            cmbCat.setModel(modelocombo1);
            while (erp.rs.next()){
                String ID= String.valueOf(erp.rs.getObject("idcategoria"));
                String nombre= String.valueOf(erp.rs.getObject("nombre"));
                modelocombo1.addElement(ID+" "+nombre);
                cmbCat.setModel(modelocombo1);
            }
        
        }catch(SQLException ex){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        public void llenarCombo2(){
            modelocombo2.removeAllElements();
            modelocombo2.addElement("SELECCIONE UNA BANDA TOXICOLOGICA");
            modelocombo2.addElement("EXTREMADAMENTE TOXICO");
            modelocombo2.addElement("ALTAMENTE TOXICO");
            modelocombo2.addElement("MEDIANAMENTE TOXICO");
            modelocombo2.addElement("LIGERAMENTE TOXICO");
            
            cmbBanda.setModel(modelocombo2);
        
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
        txfIDProducto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txfNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txfDescripcion = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txfIngrediente = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txfAplicacion = new javax.swing.JTextField();
        txfUso = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cmbLab = new javax.swing.JComboBox();
        cmbCat = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        cmbBanda = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(254, 254, 254));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "EDITAR PRODUCTO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(255, 0, 0))); // NOI18N

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

        txfIDProducto.setBackground(new java.awt.Color(253, 239, 239));
        txfIDProducto.setForeground(new java.awt.Color(1, 1, 1));

        jLabel2.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(1, 1, 1));
        jLabel2.setText("NOMBRE");

        txfNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfNombreKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(1, 1, 1));
        jLabel4.setText("DESCRIPCION");

        jLabel8.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(1, 1, 1));
        jLabel8.setText("INGREDIENTE ACTIVO");

        jLabel9.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(1, 1, 1));
        jLabel9.setText("BANDA TOXICOLOGICA");

        jLabel10.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(1, 1, 1));
        jLabel10.setText("APLICACION");

        jLabel11.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(1, 1, 1));
        jLabel11.setText("USO");

        jLabel12.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(1, 1, 1));
        jLabel12.setText("LABORATORIO");

        cmbLab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbLabActionPerformed(evt);
            }
        });

        cmbCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCatActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(1, 1, 1));
        jLabel13.setText("CATEGORIA");

        cmbBanda.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECCIONE UNA BANDA TOXICOLOGICA", "EXTREMADAMENTE TOXICO", "ALTAMENTE TOXICO", "MEDIANAMENTE TOXICO", "LIGERAMENTE TOXICO" }));
        cmbBanda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbBandaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAgrefarEstados, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(txfIngrediente))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txfAplicacion)
                                            .addComponent(txfUso)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(cmbLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(cmbCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 254, Short.MAX_VALUE))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(cmbBanda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(179, 179, 179))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txfIDProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txfDescripcion)
                                    .addComponent(txfNombre))
                                .addGap(179, 179, 179))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txfIDProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txfDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txfIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(cmbBanda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txfAplicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txfUso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(cmbLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(cmbCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 9, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 188, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(btnAgrefarEstados, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
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

    private void btnAgrefarEstadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgrefarEstadosActionPerformed
        int idl = 0,idc=0;
        String n=txfNombre.getText();
        String d= txfDescripcion.getText();
        String i= txfIngrediente.getText();
        String ap=txfAplicacion.getText();
        String u=txfUso.getText();
        int ba=cmbBanda.getSelectedIndex();
        int la= cmbLab.getSelectedIndex();
        int ca= cmbCat.getSelectedIndex();
        
        
 
        if((!n.isEmpty())&&(!d.isEmpty())&&(!i.isEmpty())&&(!ap.isEmpty())&&(!u.isEmpty())&&(ba!=0)&&(la!=0)&&(ca!=0))
        {
        StringTokenizer numero = new StringTokenizer(cmbLab.getSelectedItem().toString()," ");
        erp.OpenCon("ERP", "erp");
        int C = 0;
        while(numero.hasMoreTokens()){
                String a = numero.nextToken();
              C++;
              if (C == 1)
                  idl = Integer.parseInt(a);
                
        }
        
        StringTokenizer numero1 = new StringTokenizer(cmbCat.getSelectedItem().toString()," ");
        erp.OpenCon("ERP", "erp");
        int C1 = 0;
        while(numero1.hasMoreTokens()){
                String a = numero1.nextToken();
              C1++;
              if (C1 == 1)
                  idc = Integer.parseInt(a);
                
        }
       int ID = Integer.parseInt(txfIDProducto.getText());
       erp.SQL("update Productos set nombre ="
                +"'"+txfNombre.getText()+"',"
                +"descripcion ='"+txfDescripcion.getText()+"',"
                +"ingredienteactivo ='"+txfIngrediente.getText()+"',"
                +"bandatoxicologica ='"+cmbBanda.getSelectedItem()+"',"
                +"aplicacion ='"+txfAplicacion.getText()+"',"
                +"uso ='"+txfUso.getText()+"',"
                +"idlaboratorio ="+idl+","
                +"idcategoria ="+idc
                +" where idproducto ="
                +ID);
        }
                else {
            JOptionPane.showMessageDialog(null,"No se permiten campos vacios o Categoria y/o Laboratorio sin asignar","Error" ,JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnAgrefarEstadosActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txfNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfNombreKeyTyped
                char c=evt.getKeyChar();
        if((c<'0' || c>'9')&&(c<'a' || c>'z')&&(c<'A' || c>'Z')&&(c<' '||c>' ')){
            evt.consume();
        }  
    }//GEN-LAST:event_txfNombreKeyTyped

    private void cmbLabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbLabActionPerformed
            
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbLabActionPerformed

    private void cmbCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCatActionPerformed

    }//GEN-LAST:event_cmbCatActionPerformed

    private void cmbBandaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbBandaActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_cmbBandaActionPerformed

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
            java.util.logging.Logger.getLogger(C_MOD_Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(C_MOD_Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(C_MOD_Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(C_MOD_Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new C_MOD_Productos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAgrefarEstados;
    private javax.swing.JComboBox cmbBanda;
    private javax.swing.JComboBox cmbCat;
    private javax.swing.JComboBox cmbLab;
    public javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txfAplicacion;
    private javax.swing.JTextField txfDescripcion;
    public javax.swing.JTextField txfIDProducto;
    private javax.swing.JTextField txfIngrediente;
    private javax.swing.JTextField txfNombre;
    private javax.swing.JTextField txfUso;
    // End of variables declaration//GEN-END:variables
}
