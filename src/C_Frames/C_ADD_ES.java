/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package C_Frames;

import C_Conexion.Conexion;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author je_mg
 */
public class C_ADD_ES extends javax.swing.JFrame {
 Conexion erp;

    /**
     * Creates new form C_ADD_ES
     */
    public C_ADD_ES() {
        initComponents();
        erp=new Conexion();
        erp.OpenCon("ERP", "erp");
       

this.setLocationRelativeTo(null);
llenarCombo2();
llenarCombo();
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
        jLabel3 = new javax.swing.JLabel();
        btnLimpiarPerce = new javax.swing.JButton();
        btnAgregarPerce = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txfcantidad = new javax.swing.JTextField();
        cbxpro = new javax.swing.JComboBox();
        cbxpro1 = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "AGREGAR ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 43, 0))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(1, 1, 1));
        jLabel2.setText("Seleccione un producto");

        jLabel3.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(1, 1, 1));
        jLabel3.setText("Seleccione una sucursal ");

        btnLimpiarPerce.setBackground(new java.awt.Color(254, 254, 254));
        btnLimpiarPerce.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon-cancelar.png"))); // NOI18N
        btnLimpiarPerce.setToolTipText("");
        btnLimpiarPerce.setBorderPainted(false);
        btnLimpiarPerce.setContentAreaFilled(false);
        btnLimpiarPerce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarPerceActionPerformed(evt);
            }
        });

        btnAgregarPerce.setBackground(new java.awt.Color(254, 254, 254));
        btnAgregarPerce.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregar.png"))); // NOI18N
        btnAgregarPerce.setBorderPainted(false);
        btnAgregarPerce.setContentAreaFilled(false);
        btnAgregarPerce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPerceActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(1, 1, 1));
        jLabel5.setText("Ingrese una cantidad");

        txfcantidad.setBackground(new java.awt.Color(254, 254, 254));
        txfcantidad.setForeground(new java.awt.Color(1, 1, 1));
        txfcantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfcantidadKeyTyped(evt);
            }
        });

        cbxpro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxproActionPerformed(evt);
            }
        });

        cbxpro1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxpro1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnLimpiarPerce, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAgregarPerce))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txfcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cbxpro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cbxpro1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(103, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxpro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxpro1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnLimpiarPerce, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarPerce))
                .addGap(56, 56, 56))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarPerceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarPerceActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnLimpiarPerceActionPerformed
    DefaultComboBoxModel modelocombo = new DefaultComboBoxModel();
    DefaultComboBoxModel modelocombo1 = new DefaultComboBoxModel();
    
    public void llenarCombo2(){
        try {
            erp.OpenCon("ERP", "erp");
            erp.stn= (Statement) erp.con.createStatement();
            
            erp.rs= erp.stn.executeQuery("select pp.IDPresentacion, pt.NOMBRE, EM.NOMBRE AS EMPAQUE from presentacionESproducto "
                    + "pp inner join productos pt on pp.idproducto=pt.idproducto inner join "
                    + "EMPAQUES EM ON em.idempaque=pp.idempaque where pt.ESTATUS = 'A'");
            
            modelocombo1.addElement("Selecione un producto");
            
            cbxpro.setModel(modelocombo1);
            while (erp.rs.next()){
                String IDPRESENTACION=String.valueOf( erp.rs.getObject("IDPRESENTACION"));
                String Nombre=(String) erp.rs.getObject("NOMBRE");
                String EMPAQUE=(String) erp.rs.getObject("EMPAQUE");

                modelocombo1.addElement(IDPRESENTACION +" "+ Nombre +" "+ EMPAQUE);
                cbxpro.setModel(modelocombo1);
            }
        
        }catch(SQLException ex){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void llenarCombo(){
        try {
            erp.OpenCon("ERP", "erp");
            erp.stn= (Statement) erp.con.createStatement();
            
            erp.rs= erp.stn.executeQuery("select IDSUCURSAL,NOMBRE from sucursal where ESTATUS='A'");
            
            modelocombo.addElement("Selecione una Sucursal");
            
            cbxpro1.setModel(modelocombo);
            while (erp.rs.next()){
                String IDPRESENTACION=String.valueOf( erp.rs.getObject("IDSUCURSAL"));
                String Nombre=(String) erp.rs.getObject("NOMBRE");

                modelocombo.addElement(IDPRESENTACION +" "+ Nombre);
                cbxpro1.setModel(modelocombo);
            }
        
        }catch(SQLException ex){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    private void btnAgregarPerceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPerceActionPerformed
        erp.OpenCon("ERP", "erp");
        
        System.out.println(String.valueOf(cbxpro.getSelectedItem()).substring(0, 1));
       
        
if(cbxpro.getSelectedIndex()> 0 && cbxpro1.getSelectedIndex()> 0 && !txfcantidad.getText().isEmpty()){
    String a=String.valueOf(cbxpro.getSelectedItem()).toString().replace(" ", "%"),a2 = null,b=String.valueOf(cbxpro1.getSelectedItem()).replace(" ", "%"),b2=null;
    
    for (int i = 0; i < a.length(); i++) {
        if(a.charAt(i)=='%'){
         a2=String.valueOf(cbxpro.getSelectedItem()).substring(0, i);
         break;
        }
    }
    
    for (int i = 0; i < b.length(); i++) {
        if(b.charAt(i)=='%'){
         b2=String.valueOf(cbxpro1.getSelectedItem()).substring(0, i);
         break;
        }
    }
    
    
erp.SQL("insert into EXISTENCIASUCURSAL values ("+
        Integer.parseInt(a2)+","+
        Integer.parseInt(b2)+","+
        Integer.parseInt(txfcantidad.getText().toString())+
        ",'A')");
}else{
    JOptionPane.showMessageDialog(null, "Selecione un producto, una sucursal e ingrese una cantidad");
}
        //        erp.SQL("insert into UnidadMedida values ()");

    }//GEN-LAST:event_btnAgregarPerceActionPerformed

    private void txfcantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfcantidadKeyTyped
 char caracter = evt.getKeyChar();

      // Verificar si la tecla pulsada no es un digito
      if(((caracter < '0') ||
         (caracter > '9')) &&
         (caracter != '\b' /*corresponde a BACK_SPACE*/))
      {
         evt.consume(); 
        JOptionPane.showMessageDialog(null, "Solo numeros");  
// ignorar el evento de teclado
      }
          // TODO add your handling code here:
    }//GEN-LAST:event_txfcantidadKeyTyped

    private void cbxproActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxproActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxproActionPerformed

    private void cbxpro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxpro1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxpro1ActionPerformed

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
            java.util.logging.Logger.getLogger(C_ADD_ES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(C_ADD_ES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(C_ADD_ES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(C_ADD_ES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new C_ADD_ES().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarPerce;
    private javax.swing.JButton btnLimpiarPerce;
    private javax.swing.JComboBox cbxpro;
    private javax.swing.JComboBox cbxpro1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txfcantidad;
    // End of variables declaration//GEN-END:variables
}
