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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jose
 */
public class C_Sucursales extends javax.swing.JPanel {

    /**
     * Creates new form Percepciones1
     */
    Conexion erp;
    public C_Sucursales() {
        initComponents();
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

        txfBuscar = new javax.swing.JTextField();
        btnConsultarSucursal = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblsucursal = new javax.swing.JTable();
        btnAgregarPercepcion = new javax.swing.JButton();
        btnEditarsucursal = new javax.swing.JButton();
        btnEliminarPercepcion = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(254, 254, 254));
        setForeground(new java.awt.Color(254, 254, 254));
        setLayout(null);

        txfBuscar.setBackground(new java.awt.Color(254, 254, 254));
        txfBuscar.setForeground(new java.awt.Color(1, 1, 1));
        txfBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfBuscarActionPerformed(evt);
            }
        });
        txfBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfBuscarKeyTyped(evt);
            }
        });
        add(txfBuscar);
        txfBuscar.setBounds(200, 30, 330, 30);

        btnConsultarSucursal.setBackground(new java.awt.Color(254, 254, 254));
        btnConsultarSucursal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon-buscar.png"))); // NOI18N
        btnConsultarSucursal.setBorderPainted(false);
        btnConsultarSucursal.setContentAreaFilled(false);
        btnConsultarSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarSucursalActionPerformed(evt);
            }
        });
        add(btnConsultarSucursal);
        btnConsultarSucursal.setBounds(540, 10, 60, 50);

        tblsucursal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID SUCURSAL", "NOMBRE", "TELEFONO", "DIRECCION", "COLONIA", "CODIGOPOSTAL", "PRESUPUESTO", "ESTATUS", "CUIDAD"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblsucursal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblsucursalMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblsucursal);

        add(jScrollPane1);
        jScrollPane1.setBounds(30, 80, 789, 311);

        btnAgregarPercepcion.setBackground(new java.awt.Color(254, 254, 254));
        btnAgregarPercepcion.setForeground(new java.awt.Color(254, 254, 254));
        btnAgregarPercepcion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregar.png"))); // NOI18N
        btnAgregarPercepcion.setBorderPainted(false);
        btnAgregarPercepcion.setContentAreaFilled(false);
        btnAgregarPercepcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPercepcionActionPerformed(evt);
            }
        });
        add(btnAgregarPercepcion);
        btnAgregarPercepcion.setBounds(760, 430, 81, 57);

        btnEditarsucursal.setBackground(new java.awt.Color(254, 254, 254));
        btnEditarsucursal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon-cambiar.png"))); // NOI18N
        btnEditarsucursal.setBorderPainted(false);
        btnEditarsucursal.setContentAreaFilled(false);
        btnEditarsucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarsucursalActionPerformed(evt);
            }
        });
        add(btnEditarsucursal);
        btnEditarsucursal.setBounds(580, 430, 81, 57);

        btnEliminarPercepcion.setBackground(new java.awt.Color(254, 254, 254));
        btnEliminarPercepcion.setForeground(new java.awt.Color(254, 254, 254));
        btnEliminarPercepcion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/borar1-icon.png"))); // NOI18N
        btnEliminarPercepcion.setBorderPainted(false);
        btnEliminarPercepcion.setContentAreaFilled(false);
        btnEliminarPercepcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPercepcionActionPerformed(evt);
            }
        });
        add(btnEliminarPercepcion);
        btnEliminarPercepcion.setBounds(690, 420, 52, 67);

        jLabel1.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(1, 1, 1));
        jLabel1.setText("BUSCAR POR NOMBRE");
        add(jLabel1);
        jLabel1.setBounds(40, 30, 129, 16);

        jButton1.setBackground(new java.awt.Color(254, 254, 254));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/refresh_icon.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(10, 440, 68, 60);
        add(jLabel2);
        jLabel2.setBounds(343, 465, 0, 0);
    }// </editor-fold>//GEN-END:initComponents

    private void txfConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfConsultarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfConsultarActionPerformed

    private void btnAgregarPercepcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPercepcionActionPerformed
        C_ADD_Sucursales erp = new C_ADD_Sucursales();
        erp.setLocationRelativeTo(erp);
        erp.setVisible(true);
    }//GEN-LAST:event_btnAgregarPercepcionActionPerformed

    private void btnEliminarPercepcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPercepcionActionPerformed
      int ID = 0;
        try{
            ID = Integer.parseInt(tblsucursal.getValueAt(tblsucursal.getSelectedRow(),0)+"");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage(),"Error" ,JOptionPane.INFORMATION_MESSAGE);
        }
        //confirma eliminacion
        int dialogButton = JOptionPane.YES_NO_OPTION;
            JOptionPane.showConfirmDialog (null, "Desea eliminar","Informacion", dialogButton);
            if(dialogButton == JOptionPane.YES_OPTION) {
                erp.SQL("update UnidadMedida set estatus = 'B' where idUnidad = "+ID);
            if(dialogButton == JOptionPane.NO_OPTION) {
                  remove(dialogButton);
                }
              }
        
    }//GEN-LAST:event_btnEliminarPercepcionActionPerformed
public void borrarTabla(JTable tab) {
        try {
            DefaultTableModel tabT = (DefaultTableModel) tab.getModel();
            for (int i = tabT.getRowCount() - 1; i > -1; i--) {
                tabT.removeRow(i);
            }
        } catch (Exception e) {
       
        }
    }
    
    private void btnConsultarSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarSucursalActionPerformed
        borrarTabla(tblsucursal);
        erp.OpenCon("ERP", "erp");
        erp.Sucursales_Search(txfBuscar.getText(),tblsucursal);
        
    }//GEN-LAST:event_btnConsultarSucursalActionPerformed

    private void btnEditarsucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarsucursalActionPerformed
        C_MOD_Sucursales suc =new C_MOD_Sucursales();
        suc.setLocationRelativeTo(suc);
        suc.setVisible(true);
        int ID = 0;
        try{
            ID = Integer.parseInt(tblsucursal.getValueAt(tblsucursal.getSelectedRow(),0)+"");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage(),"Error" ,JOptionPane.INFORMATION_MESSAGE);
        }
      suc.txfIdSucursal.setText(ID+"");
    }//GEN-LAST:event_btnEditarsucursalActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        borrarTabla(tblsucursal);
        erp.OpenCon("ERP", "erp");
        erp.Unidad_Search(txfBuscar.getText(),tblsucursal);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txfBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfBuscarActionPerformed

    private void tblsucursalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblsucursalMouseClicked
        String a,b,c,d,e,f,h,i;
        
        a=(String) tblsucursal.getValueAt(tblsucursal.getSelectedRow(),0);
        b=(String) tblsucursal.getValueAt(tblsucursal.getSelectedRow(),1);
        c=(String) tblsucursal.getValueAt(tblsucursal.getSelectedRow(),2);
        d=(String) tblsucursal.getValueAt(tblsucursal.getSelectedRow(),3);
        e=(String) tblsucursal.getValueAt(tblsucursal.getSelectedRow(),4);
        f=(String) tblsucursal.getValueAt(tblsucursal.getSelectedRow(),5);
        h=(String) tblsucursal.getValueAt(tblsucursal.getSelectedRow(),6);
        
                       
        
         C_MOD_Sucursales suc= new C_MOD_Sucursales();
         suc.setLocationRelativeTo(suc);
         suc.Datos(a, b, c, d, e, f, h);
         suc.setVisible(true);
       

    }//GEN-LAST:event_tblsucursalMouseClicked

    private void txfBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfBuscarKeyTyped
         char c = evt.getKeyChar();
        if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z'))  evt.consume();
    }//GEN-LAST:event_txfBuscarKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarPercepcion;
    private javax.swing.JButton btnConsultarSucursal;
    private javax.swing.JButton btnEditarsucursal;
    private javax.swing.JButton btnEliminarPercepcion;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblsucursal;
    private javax.swing.JTextField txfBuscar;
    // End of variables declaration//GEN-END:variables
}
