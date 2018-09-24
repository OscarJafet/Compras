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
import javax.swing.JOptionPane;

/**
 *
 * @author carlo
 */
public class C_MOD_Emp extends javax.swing.JFrame {

    /**
     * Creates new form EditarDeducciones
     */
    Conexion erp;
    public C_MOD_Emp() {
        initComponents();
        this.Id.setEditable(false);
        erp = new Conexion();
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
        lblIdDeduccion = new javax.swing.JLabel();
        lblIdDeduccion1 = new javax.swing.JLabel();
        lblIdDeduccion2 = new javax.swing.JLabel();
        lblIdDeduccion3 = new javax.swing.JLabel();
        Id = new javax.swing.JTextField();
        nom = new javax.swing.JTextField();
        cap = new javax.swing.JTextField();
        btnEliminarDed = new javax.swing.JButton();
        btnAgregarDed = new javax.swing.JButton();
        cmb = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(254, 254, 254));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "EDITAR DEDUCCIONES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(255, 0, 0))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(254, 254, 254));

        lblIdDeduccion.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        lblIdDeduccion.setForeground(new java.awt.Color(1, 1, 1));
        lblIdDeduccion.setText("ID EMPAQUE");

        lblIdDeduccion1.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        lblIdDeduccion1.setForeground(new java.awt.Color(1, 1, 1));
        lblIdDeduccion1.setText("NOMBRE");

        lblIdDeduccion2.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        lblIdDeduccion2.setForeground(new java.awt.Color(1, 1, 1));
        lblIdDeduccion2.setText("CAPACIDAD");

        lblIdDeduccion3.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        lblIdDeduccion3.setForeground(new java.awt.Color(1, 1, 1));
        lblIdDeduccion3.setText("ESTATUS");

        Id.setEditable(false);
        Id.setBackground(new java.awt.Color(254, 254, 254));
        Id.setForeground(new java.awt.Color(1, 1, 1));

        nom.setBackground(new java.awt.Color(254, 254, 254));
        nom.setForeground(new java.awt.Color(1, 1, 1));

        cap.setBackground(new java.awt.Color(254, 254, 254));
        cap.setForeground(new java.awt.Color(1, 1, 1));

        btnEliminarDed.setBackground(new java.awt.Color(254, 254, 254));
        btnEliminarDed.setForeground(new java.awt.Color(254, 254, 254));
        btnEliminarDed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon-cancelar.png"))); // NOI18N
        btnEliminarDed.setBorderPainted(false);
        btnEliminarDed.setContentAreaFilled(false);
        btnEliminarDed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarDedActionPerformed(evt);
            }
        });

        btnAgregarDed.setBackground(new java.awt.Color(254, 254, 254));
        btnAgregarDed.setForeground(new java.awt.Color(254, 254, 254));
        btnAgregarDed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/refresh_icon.png"))); // NOI18N
        btnAgregarDed.setBorderPainted(false);
        btnAgregarDed.setContentAreaFilled(false);
        btnAgregarDed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarDedActionPerformed(evt);
            }
        });

        cmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B" }));
        cmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEliminarDed)
                .addGap(18, 18, 18)
                .addComponent(btnAgregarDed)
                .addGap(20, 20, 20))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblIdDeduccion1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblIdDeduccion)
                        .addGap(45, 45, 45)
                        .addComponent(Id, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblIdDeduccion2)
                            .addComponent(lblIdDeduccion3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cap, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(194, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblIdDeduccion)
                    .addComponent(Id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIdDeduccion1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdDeduccion2)
                    .addComponent(cap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdDeduccion3)
                    .addComponent(cmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addComponent(btnEliminarDed))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAgregarDed))
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

    private void btnAgregarDedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarDedActionPerformed
 //ing code here:
        erp.OpenCon("ERP", "erp");
       int ID =Integer.parseInt(Id.getText());
        float cap = 0;
        try{
            cap = Float.parseFloat(this.cap.getText());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage(),"Error" ,JOptionPane.INFORMATION_MESSAGE);
        
        }
       erp.SQL("update Empaques set nombre = '"+nom.getText()+"',capacidad = "+cap+", estatus = '"+cmb.getItemAt(cmb.getSelectedIndex()).charAt(0)+"' where idEmpaque = "+ID);
    }//GEN-LAST:event_btnAgregarDedActionPerformed

    private void btnEliminarDedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarDedActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnEliminarDedActionPerformed

    private void cmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbActionPerformed

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
            java.util.logging.Logger.getLogger(C_MOD_Emp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(C_MOD_Emp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(C_MOD_Emp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(C_MOD_Emp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new C_MOD_Emp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField Id;
    public javax.swing.JButton btnAgregarDed;
    public javax.swing.JButton btnEliminarDed;
    public javax.swing.JTextField cap;
    private javax.swing.JComboBox<String> cmb;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblIdDeduccion;
    private javax.swing.JLabel lblIdDeduccion1;
    private javax.swing.JLabel lblIdDeduccion2;
    private javax.swing.JLabel lblIdDeduccion3;
    public javax.swing.JTextField nom;
    // End of variables declaration//GEN-END:variables
}
