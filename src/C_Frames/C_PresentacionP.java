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
import java.util.StringTokenizer;
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

public class C_PresentacionP extends javax.swing.JPanel {

    /**
     * Creates new form Deduciiones
     */
    
    Conexion erp;
  

    public C_PresentacionP() {
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
        tablaPress = new javax.swing.JTable();
        btnConsultar = new javax.swing.JButton();
        btnAgregarDe = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        cmbSe = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(254, 254, 254));
        setForeground(new java.awt.Color(254, 254, 254));
        setLayout(null);

        txfConsultar.setBackground(new java.awt.Color(254, 254, 254));
        txfConsultar.setForeground(new java.awt.Color(1, 1, 1));
        txfConsultar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txfConsultarMouseClicked(evt);
            }
        });
        add(txfConsultar);
        txfConsultar.setBounds(180, 30, 386, 25);

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

        tablaPress.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Presentación", "Precio compra", "Precio venta", "Punto reorden", "ID Producto", "ID Empaque", "Estatus"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaPress.setToolTipText("");
        jScrollPane1.setViewportView(tablaPress);

        add(jScrollPane1);
        jScrollPane1.setBounds(10, 100, 820, 320);

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
        btnConsultar.setBounds(720, 10, 75, 57);

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

        cmbSe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Estatus", "A", "B" }));
        cmbSe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbSeMouseClicked(evt);
            }
        });
        add(cmbSe);
        cmbSe.setBounds(600, 30, 90, 20);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarDeduccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarDeduccionesActionPerformed

        C_MOD_Presentacion erp = new C_MOD_Presentacion();
         erp.setLocationRelativeTo(erp);
        erp.setVisible(true);
        int ID = 0;
        try{
            ID = Integer.parseInt(tablaPress.getValueAt(tablaPress.getSelectedRow(),0)+"");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage(),"Error" ,JOptionPane.INFORMATION_MESSAGE);
        }
        erp.Id.setText(ID+"");
        erp.preCom.setText(tablaPress.getValueAt(tablaPress.getSelectedRow(),1)+"");
        erp.preVen.setText(tablaPress.getValueAt(tablaPress.getSelectedRow(),2)+"");
        erp.preRe.setText(tablaPress.getValueAt(tablaPress.getSelectedRow(),3)+"");
        int b = 0;
        for (int i = 0; i < erp.cmbProd.getItemCount(); i++) {
            StringTokenizer idPr = new StringTokenizer(erp.cmbProd.getItemAt(i).toString()," ");
             int a = Integer.parseInt((tablaPress.getValueAt(tablaPress.getSelectedRow(),4)+""));
            try{
                b = Integer.parseInt(idPr.nextToken());
            }catch(Exception e){
                b = 0;
            }
            System.out.println(a+" "+b);
            if(a==b){
                System.out.println("entro");
                erp.cmbProd.setSelectedIndex(i);
            }
        }
        int b1;
        System.out.println("dossssssss");
        for (int i = 0; i < erp.cmbEmp.getItemCount(); i++) {
            StringTokenizer idE = new StringTokenizer(erp.cmbEmp.getItemAt(i).toString()," ");
            int a = Integer.parseInt((tablaPress.getValueAt(tablaPress.getSelectedRow(),5)+""));
            try{
                b1 = Integer.parseInt(idE.nextToken());
            }catch(Exception e){
                b1 = 0;
            }
            System.out.println(a+" "+b1);
            if(a==b1){
                System.out.println("entro");
                erp.cmbEmp.setSelectedIndex(i);
            }
        }
    
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
        borrarTabla(tablaPress);
        erp.OpenCon("ERP", "erp");
        erp.Presentacion_seacrh(txfConsultar.getText(), tablaPress,cmbSe.getItemAt(cmbSe.getSelectedIndex()).charAt(0));
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnEliDeduccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliDeduccionesActionPerformed
       int ID = 0;
        try{
            ID = Integer.parseInt(tablaPress.getValueAt(tablaPress.getSelectedRow(),0)+"");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage(),"Error" ,JOptionPane.INFORMATION_MESSAGE);
        }
        //confirma eliminacion
        int dialogButton = JOptionPane.YES_NO_OPTION;
            JOptionPane.showConfirmDialog (null, "¿Desea eliminarlo?","Informacion", dialogButton);
            if(dialogButton == JOptionPane.YES_OPTION) {
                erp.SQL("update PresentacionesProducto set estatus = 'B' where idPresentacion = "+ID);
            if(dialogButton == JOptionPane.NO_OPTION) {
                  remove(dialogButton);
                }
              }
    }//GEN-LAST:event_btnEliDeduccionesActionPerformed

    private void btnAgregarDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarDeActionPerformed
// TODO add your handling code here:
        C_ADD_Presentacion erp = new C_ADD_Presentacion();
        erp.setLocationRelativeTo(erp);
        erp.setVisible(true);
    }//GEN-LAST:event_btnAgregarDeActionPerformed

    private void btnAgregarDeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarDeMouseClicked
              // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarDeMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        borrarTabla(tablaPress);
        erp.OpenCon("ERP", "erp");
        erp.Presentacion_seacrh(txfConsultar.getText(), tablaPress,cmbSe.getItemAt(cmbSe.getSelectedIndex()).charAt(0));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cmbSeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbSeMouseClicked
        // TODO add your handling code here:
        //txfConsultar.setText("");
    }//GEN-LAST:event_cmbSeMouseClicked

    private void txfConsultarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txfConsultarMouseClicked
        // TODO add your handling code here:
        //cmbSe.setSelectedIndex(0);
    }//GEN-LAST:event_txfConsultarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarDe;
    public javax.swing.JButton btnConsultar;
    public javax.swing.JButton btnEditarDeducciones;
    public javax.swing.JButton btnEliDeducciones;
    private javax.swing.JComboBox<String> cmbSe;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tablaPress;
    public javax.swing.JTextField txfConsultar;
    // End of variables declaration//GEN-END:variables
}
