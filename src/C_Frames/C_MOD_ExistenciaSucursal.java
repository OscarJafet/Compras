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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rocker
 */
public class C_MOD_ExistenciaSucursal extends javax.swing.JFrame {

    /**
     * Creates new form ModificarCiudades
     */
    Conexion erp;
    int r;
    String Producto;
    public C_MOD_ExistenciaSucursal() {
        initComponents();
        erp = new Conexion();
          String Sql = "select es.IDSUCURSAL,es.IDPRESENTACION,sc.NOMBRE, pp.PRECIOVENTA, pp.PUNTOREORDEN,es.cantidad, pt.NOMBRE as NOM,em.NOMBRE as NO from "
                  + "EXISTENCIASUCURSAL es inner join SUCURSAL sc "
                    + "on sc.IDSUCURSAL=es.IDSUCURSAL inner join"
                    + " PRESENTACIONESPRODUCTO pp on pp.IDPRESENTACION=es.IDPRESENTACION inner "
                    + "join PRODUCTOS pt on pt.idproducto=pp.idproducto inner join empaques em on em.idempaque=pp.idempaque";
          erp.OpenCon("ERP","erp");
          erp.ExistenciaSucursal_search_claves(C_ExistenciaSucursal_tabla, Sql);
          
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
        jLabel2 = new javax.swing.JLabel();
        txfCantidadNueva = new javax.swing.JTextField();
        btnAgrefarEstados = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        C_ExistenciaSucursal_tabla = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(254, 254, 254));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(206, 255, 0)), "MODIFICAR", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(255, 0, 0))); // NOI18N

        jLabel2.setBackground(new java.awt.Color(1, 1, 1));
        jLabel2.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(1, 1, 1));
        jLabel2.setText("Cantidad Nueva");

        txfCantidadNueva.setBackground(new java.awt.Color(253, 239, 239));
        txfCantidadNueva.setForeground(new java.awt.Color(1, 1, 1));
        txfCantidadNueva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfCantidadNuevaActionPerformed(evt);
            }
        });
        txfCantidadNueva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfCantidadNuevaKeyTyped(evt);
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

        C_ExistenciaSucursal_tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IDSucursal", "IDPresentacion", "Nombre", "Precio de venta", "Reorden", "Cantidad", "Producto", "Empaque"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        C_ExistenciaSucursal_tabla.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(C_ExistenciaSucursal_tabla);

        jLabel3.setBackground(new java.awt.Color(1, 1, 1));
        jLabel3.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(1, 1, 1));
        jLabel3.setText("Seleciona una sucursal");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txfCantidadNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(121, 121, 121)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAgrefarEstados, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(283, 283, 283))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnAgrefarEstados, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txfCantidadNueva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgrefarEstadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgrefarEstadosActionPerformed
       erp.OpenCon("ERP", "erp");
       
    
        
        if(C_ExistenciaSucursal_tabla.getSelectedRow() > -1 && !txfCantidadNueva.getText().isEmpty()){
             int i = Integer.parseInt(txfCantidadNueva.getText().toString());
//             if(i < Integer.parseInt(C_ExistenciaSucursal_tabla.getValueAt(C_ExistenciaSucursal_tabla.getSelectedRow(), 4).toString())){
//                 JOptionPane.showMessageDialog(null, "Tu cantidad es escasa a punto de Reorden");}
             
erp.SQL("update EXISTENCIASUCURSAL set CANTIDAD = "+i+" where  IDSUCURSAL = "+
        Integer.parseInt(C_ExistenciaSucursal_tabla.getValueAt(C_ExistenciaSucursal_tabla.getSelectedRow(), 0).toString())+" and IDPRESENTACION = "+
        Integer.parseInt(C_ExistenciaSucursal_tabla.getValueAt(C_ExistenciaSucursal_tabla.getSelectedRow(), 1).toString()));
            
}else{
    JOptionPane.showMessageDialog(null, "SELECIONE EN TABLA UN PRODUCTO E INGRESE UNA CANTIDAD");
}
        
        
        
        borrarTabla(C_ExistenciaSucursal_tabla);
      String Sql = "select es.IDSUCURSAL,es.IDPRESENTACION,sc.NOMBRE, pp.PRECIOVENTA, pp.PUNTOREORDEN,es.cantidad, pt.NOMBRE as NOM,em.NOMBRE as NO from "
                  + "EXISTENCIASUCURSAL es inner join SUCURSAL sc "
                    + "on sc.IDSUCURSAL=es.IDSUCURSAL inner join"
                    + " PRESENTACIONESPRODUCTO pp on pp.IDPRESENTACION=es.IDPRESENTACION inner "
                    + "join PRODUCTOS pt on pt.idproducto=pp.idproducto inner join empaques em on em.idempaque=pp.idempaque";
          erp.OpenCon("ERP","erp");
          erp.ExistenciaSucursal_search_claves(C_ExistenciaSucursal_tabla, Sql);   
          
          C_ExistenciaSucursal_tabla.setVisible(false);
          C_ExistenciaSucursal_tabla.setVisible(true);
        
    }//GEN-LAST:event_btnAgrefarEstadosActionPerformed
public void borrarTabla(JTable tab) {
        try {
            DefaultTableModel tabT = (DefaultTableModel) tab.getModel();
            for (int i = tabT.getRowCount() - 1; i > -1; i--) {
                tabT.removeRow(i);
            }
        } catch (Exception e) {
       
        }
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txfCantidadNuevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfCantidadNuevaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfCantidadNuevaActionPerformed
    DefaultComboBoxModel modelocombo = new DefaultComboBoxModel();
    DefaultComboBoxModel modelocombo1 = new DefaultComboBoxModel();
//    public void llenarCombo(){
//        try {
//            erp.OpenCon("ERP", "erp");
//            erp.stn= (Statement) erp.con.createStatement();
//            
//            erp.rs= erp.stn.executeQuery("select es.IDSUCURSAL,es.IDPRESENTACION,sc.NOMBRE, pp.PRECIOVENTA, "
//                    + "pp.PUNTOREORDEN,es.cantidad,pt.NOMBRE as NOM,em.NOMBRE as NO from  EXISTENCIASUCURSAL es inner join SUCURSAL"
//                    + " sc on sc.IDSUCURSAL=es.IDSUCURSAL inner join PRESENTACIONESPRODUCTO pp on pp.IDPRESENTACION=es.IDPRESENTACION inner join "
//                    + "PRODUCTOS pt on pt.idproducto=pp.idproducto inner join empaques em on em.idempaque=pp.idempaque");
//            
//            modelocombo.addElement("Selecione una Sucursal");
//            
//            cbxpro1.setModel(modelocombo);
//            while (erp.rs.next()){
//                String IDPRESENTACION=String.valueOf( erp.rs.getObject("IDSUCURSAL"));
//                String Nombre=(String) erp.rs.getObject("NOMBRE");
//
//                modelocombo.addElement(IDPRESENTACION +" "+ Nombre);
//                cbxpro1.setModel(modelocombo);
//            }
//        
//        }catch(SQLException ex){
//            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//    }
    private void txfCantidadNuevaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfCantidadNuevaKeyTyped
char caracter = evt.getKeyChar();

      // Verificar si la tecla pulsada no es un digito
      if(((caracter < '0') ||
         (caracter > '9')) &&
         (caracter != '\b' /*corresponde a BACK_SPACE*/))
      {
         evt.consume(); 
        JOptionPane.showMessageDialog(null, "Solo numeros");  
// ignorar el evento de teclado
      }        // TODO add your handling code here:
    }//GEN-LAST:event_txfCantidadNuevaKeyTyped

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
            java.util.logging.Logger.getLogger(C_MOD_ExistenciaSucursal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(C_MOD_ExistenciaSucursal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(C_MOD_ExistenciaSucursal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(C_MOD_ExistenciaSucursal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new C_MOD_ExistenciaSucursal().setVisible(true);
            }
        });
   
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable C_ExistenciaSucursal_tabla;
    public javax.swing.JButton btnAgrefarEstados;
    public javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextField txfCantidadNueva;
    // End of variables declaration//GEN-END:variables
}