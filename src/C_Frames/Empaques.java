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
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ITESZ-80
 */

public class Empaques extends javax.swing.JPanel {

    /**
     * Creates new form Deduciiones
     */
    
    Conexion erp;
  

    public Empaques() {
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

        txfConsultar = new javax.swing.JTextField();
        btnEditarDeducciones = new javax.swing.JButton();
        btnEliDeducciones = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEmp = new javax.swing.JTable();
        btnConsultar = new javax.swing.JButton();
        btnAgregarDe = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(254, 254, 254));
        setForeground(new java.awt.Color(254, 254, 254));
        setLayout(null);

        txfConsultar.setBackground(new java.awt.Color(254, 254, 254));
        txfConsultar.setForeground(new java.awt.Color(1, 1, 1));
        add(txfConsultar);
        txfConsultar.setBounds(180, 30, 386, 20);

        btnEditarDeducciones.setBackground(new java.awt.Color(254, 254, 254));
        btnEditarDeducciones.setForeground(new java.awt.Color(254, 254, 254));
        btnEditarDeducciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon-cambiar.png"))); // NOI18N
        btnEditarDeducciones.setBorderPainted(false);
        btnEditarDeducciones.setContentAreaFilled(false);
        btnEditarDeducciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarDeduccionesActionPerformed(evt);
            }
        });
        add(btnEditarDeducciones);
        btnEditarDeducciones.setBounds(444, 484, 81, 57);

        btnEliDeducciones.setBackground(new java.awt.Color(254, 254, 254));
        btnEliDeducciones.setForeground(new java.awt.Color(254, 254, 254));
        btnEliDeducciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/borar1-icon.png"))); // NOI18N
        btnEliDeducciones.setBorderPainted(false);
        btnEliDeducciones.setContentAreaFilled(false);
        btnEliDeducciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliDeduccionesActionPerformed(evt);
            }
        });
        add(btnEliDeducciones);
        btnEliDeducciones.setBounds(572, 468, 79, 73);

        tablaEmp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID empaque", "Nombre", "Capacidad", "Estatus", "ID unidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaEmp.setToolTipText("");
        tablaEmp.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tablaEmp);

        add(jScrollPane1);
        jScrollPane1.setBounds(30, 100, 800, 320);

        btnConsultar.setBackground(new java.awt.Color(254, 254, 254));
        btnConsultar.setForeground(new java.awt.Color(254, 254, 254));
        btnConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon-buscar.png"))); // NOI18N
        btnConsultar.setBorderPainted(false);
        btnConsultar.setContentAreaFilled(false);
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });
        add(btnConsultar);
        btnConsultar.setBounds(580, 10, 75, 57);

        btnAgregarDe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregar.png"))); // NOI18N
        btnAgregarDe.setBorderPainted(false);
        btnAgregarDe.setContentAreaFilled(false);
        btnAgregarDe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarDeMouseClicked(evt);
            }
        });
        btnAgregarDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarDeActionPerformed(evt);
            }
        });
        add(btnAgregarDe);
        btnAgregarDe.setBounds(697, 484, 81, 57);

        jLabel1.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(1, 1, 1));
        jLabel1.setText("BUSCAR POR NOMBRE");
        add(jLabel1);
        jLabel1.setBounds(40, 30, 129, 16);

        jButton1.setBackground(new java.awt.Color(254, 254, 254));
        jButton1.setForeground(new java.awt.Color(254, 254, 254));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/refresh_icon.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(38, 468, 97, 73);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarDeduccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarDeduccionesActionPerformed

        C_MOD_Emp erp = new C_MOD_Emp();
         erp.setLocationRelativeTo(erp);
        erp.setVisible(true);
        int ID = 0;
        try{
            ID = Integer.parseInt(tablaEmp.getValueAt(tablaEmp.getSelectedRow(),0)+"");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage(),"Error" ,JOptionPane.INFORMATION_MESSAGE);
        }
        erp.Id.setText(ID+"");
    
    }//GEN-LAST:event_btnEditarDeduccionesActionPerformed
public void borrarTabla(JTable tab) {
        try {
            DefaultTableModel tabT = (DefaultTableModel) tab.getModel();
            for (int i = tabT.getRowCount() - 1; i > -1; i--) {
                tabT.removeRow(i);
            }
        } catch (Exception e) {
       
        }
    }
    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        borrarTabla(tablaEmp);
        erp.OpenCon("ERP", "erp");
        erp.Emp_Search(txfConsultar.getText(), tablaEmp);
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnEliDeduccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliDeduccionesActionPerformed
        int ID = 0;
        int con=tablaEmp.getSelectedRow();
        
        if (con>=0){
            String es= String.valueOf(tablaEmp.getValueAt(con,3));
            if(es.equals("A"))
            {
            ID = Integer.parseInt(tablaEmp.getValueAt(tablaEmp.getSelectedRow(),0)+"");
            if(JOptionPane.showConfirmDialog (null, "Desea dar de baja","Informacion",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
               erp.SQL("update empaques set estatus='B' where idempaque ="+ID);
            }
            }else{
                JOptionPane.showMessageDialog(null,"Seleccione un producto con estatus A","Error" ,JOptionPane.INFORMATION_MESSAGE);
            }
        }else {
            JOptionPane.showMessageDialog(null,"Seleccione un renglon","Error" ,JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnEliDeduccionesActionPerformed

    private void btnAgregarDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarDeActionPerformed
// TODO add your handling code here:
        C_ADD_Emp erp = new C_ADD_Emp();
        erp.setLocationRelativeTo(erp);
        erp.setVisible(true);
    }//GEN-LAST:event_btnAgregarDeActionPerformed

    private void btnAgregarDeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarDeMouseClicked
              // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarDeMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int ID = 0;
        int con=tablaEmp.getSelectedRow();
        
        if (con>=0){
            String es= String.valueOf(tablaEmp.getValueAt(con,3));
            if(es.equals("B"))
            {
            ID = Integer.parseInt(tablaEmp.getValueAt(tablaEmp.getSelectedRow(),0)+"");
            if(JOptionPane.showConfirmDialog (null, "Desea dar de alta","Informacion",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
               erp.SQL("update empaques set estatus='A' where idempaque ="+ID);
            }
            }else{
                JOptionPane.showMessageDialog(null,"Seleccione un producto con estatus B","Error" ,JOptionPane.INFORMATION_MESSAGE);
            }
        }else {
            JOptionPane.showMessageDialog(null,"Seleccione un renglon","Error" ,JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarDe;
    public javax.swing.JButton btnConsultar;
    public javax.swing.JButton btnEditarDeducciones;
    public javax.swing.JButton btnEliDeducciones;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tablaEmp;
    public javax.swing.JTextField txfConsultar;
    // End of variables declaration//GEN-END:variables
}
