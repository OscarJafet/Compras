/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package C_Frames;

import C_Conexion.Conexion;
import static C_Conexion.Conexion.con;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jose
 */
public class C_CuentasProveedor extends javax.swing.JPanel {

    /**
     * Creates new form Percepciones1
     */
    Conexion erp;
    public C_CuentasProveedor() {
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
        btnConsultarCuentasProveedor = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCuentas = new javax.swing.JTable();
        btnAgregarCuentas = new javax.swing.JButton();
        btnEditarCuentas = new javax.swing.JButton();
        btnEliminarCuentas = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(254, 254, 254));
        setForeground(new java.awt.Color(254, 254, 254));
        setLayout(null);

        txfBuscar.setBackground(new java.awt.Color(254, 254, 254));
        txfBuscar.setForeground(new java.awt.Color(1, 1, 1));
        txfBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfBuscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfBuscarKeyTyped(evt);
            }
        });
        add(txfBuscar);
        txfBuscar.setBounds(270, 30, 330, 30);

        btnConsultarCuentasProveedor.setBackground(new java.awt.Color(254, 254, 254));
        btnConsultarCuentasProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon-buscar.png"))); // NOI18N
        btnConsultarCuentasProveedor.setBorderPainted(false);
        btnConsultarCuentasProveedor.setContentAreaFilled(false);
        btnConsultarCuentasProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarCuentasProveedorActionPerformed(evt);
            }
        });
        add(btnConsultarCuentasProveedor);
        btnConsultarCuentasProveedor.setBounds(610, 20, 60, 50);

        tblCuentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IDCUENTAPROVEEDOR", "PROVEEDOR", "NUMEROCUENTA", "BANCO", "ESTATUS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCuentas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblCuentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCuentasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblCuentasMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(tblCuentas);

        add(jScrollPane1);
        jScrollPane1.setBounds(30, 80, 789, 311);

        btnAgregarCuentas.setBackground(new java.awt.Color(254, 254, 254));
        btnAgregarCuentas.setForeground(new java.awt.Color(254, 254, 254));
        btnAgregarCuentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregar.png"))); // NOI18N
        btnAgregarCuentas.setBorderPainted(false);
        btnAgregarCuentas.setContentAreaFilled(false);
        btnAgregarCuentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCuentasActionPerformed(evt);
            }
        });
        add(btnAgregarCuentas);
        btnAgregarCuentas.setBounds(760, 430, 81, 57);

        btnEditarCuentas.setBackground(new java.awt.Color(254, 254, 254));
        btnEditarCuentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon-cambiar.png"))); // NOI18N
        btnEditarCuentas.setBorderPainted(false);
        btnEditarCuentas.setContentAreaFilled(false);
        btnEditarCuentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarCuentasActionPerformed(evt);
            }
        });
        add(btnEditarCuentas);
        btnEditarCuentas.setBounds(580, 430, 81, 57);

        btnEliminarCuentas.setBackground(new java.awt.Color(254, 254, 254));
        btnEliminarCuentas.setForeground(new java.awt.Color(254, 254, 254));
        btnEliminarCuentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/borar1-icon.png"))); // NOI18N
        btnEliminarCuentas.setBorderPainted(false);
        btnEliminarCuentas.setContentAreaFilled(false);
        btnEliminarCuentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCuentasActionPerformed(evt);
            }
        });
        add(btnEliminarCuentas);
        btnEliminarCuentas.setBounds(690, 420, 52, 67);

        jLabel1.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(1, 1, 1));
        jLabel1.setText("BUSCAR POR NOMBRE DEL PROVEEDOR");
        add(jLabel1);
        jLabel1.setBounds(30, 40, 230, 16);

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

    private void btnAgregarCuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCuentasActionPerformed
        C_ADD_ProductosProveedor erp = new C_ADD_ProductosProveedor();
        erp.setLocationRelativeTo(erp);
        erp.setVisible(true);
    }//GEN-LAST:event_btnAgregarCuentasActionPerformed

    private void btnEliminarCuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCuentasActionPerformed
        int idproveedor=0,idpresentacion=0;
        int con=tblCuentas.getSelectedRow();
        if (con>=0){
            String es= String.valueOf(tblCuentas.getValueAt(con,7));
            if(es.equals("A"))
            {
                            try {
            erp.OpenCon("ERP", "erp");
            erp.stn= (Statement) erp.con.createStatement();
            erp.rs= erp.stn.executeQuery("select * from Proveedores where nombre='"+tblCuentas.getValueAt(tblCuentas.getSelectedRow(),0)+"'");
            while (erp.rs.next()){
                String id= String.valueOf(erp.rs.getObject("idproveedor"));
                idproveedor= Integer.parseInt(id);
            }
        
        }catch(SQLException ex){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
                        try {
            erp.OpenCon("ERP", "erp");
            erp.stn= (Statement) erp.con.createStatement();
            erp.rs= erp.stn.executeQuery("select * from PresentacionesProducto where nombre='"+tblCuentas.getValueAt(tblCuentas.getSelectedRow(),1)+"'");
            while (erp.rs.next()){
                String id= String.valueOf(erp.rs.getObject("idpresentacion"));
                idpresentacion= Integer.parseInt(id);
            }
        
        }catch(SQLException ex){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            if(JOptionPane.showConfirmDialog (null, "Desea eliminar","Informacion",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
                erp.SQL("update ProductosProveedor set estatus='B' where idproveedor="+idproveedor+" and idpresentacion="+idpresentacion);
                btnConsultarCuentasProveedor.doClick();
            }
            }else {
                JOptionPane.showMessageDialog(null,"Seleccione un producto con estatus A","Error" ,JOptionPane.INFORMATION_MESSAGE);
            }
        }else {
            JOptionPane.showMessageDialog(null,"Seleccione un producto","Error" ,JOptionPane.INFORMATION_MESSAGE);
        }       //confirma eliminacion
    }//GEN-LAST:event_btnEliminarCuentasActionPerformed
public void borrarTabla(JTable tab) {
        try {
            DefaultTableModel tabT = (DefaultTableModel) tab.getModel();
            for (int i = tabT.getRowCount() - 1; i > -1; i--) {
                tabT.removeRow(i);
                tabT.removeTableModelListener(tab);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    private void btnConsultarCuentasProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarCuentasProveedorActionPerformed
        borrarTabla(tblCuentas);
        erp.OpenCon("ERP", "erp");
        erp.CuentasProveedor_Search(txfBuscar.getText(),tblCuentas);
    }//GEN-LAST:event_btnConsultarCuentasProveedorActionPerformed

    private void btnEditarCuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarCuentasActionPerformed
        int con=tblCuentas.getSelectedRow();
        if (con>=0){
        String a=(String) tblCuentas.getValueAt(tblCuentas.getSelectedRow(),0);
        String d=(String) tblCuentas.getValueAt(tblCuentas.getSelectedRow(),1);
        String b=(String) tblCuentas.getValueAt(tblCuentas.getSelectedRow(),2);
        String c=(String) tblCuentas.getValueAt(tblCuentas.getSelectedRow(),3);
        String ce=(String) tblCuentas.getValueAt(tblCuentas.getSelectedRow(),4);
        String f=(String) tblCuentas.getValueAt(tblCuentas.getSelectedRow(),4);
        String h=(String) tblCuentas.getValueAt(tblCuentas.getSelectedRow(),6);
        String i=(String) tblCuentas.getValueAt(tblCuentas.getSelectedRow(),7);

        
        
        C_MOD_ProductosProveedor pro =new C_MOD_ProductosProveedor();
        pro.setLocationRelativeTo(pro);
        pro.Datos(a, b, c, ce, f, h,i,d);
        pro.setVisible(true);
        String nombre = null;
        try{
            nombre = String.valueOf(tblCuentas.getValueAt(tblCuentas.getSelectedRow(),0)+"");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage(),"Error" ,JOptionPane.INFORMATION_MESSAGE);
        }
        pro.txfProveedor.setText(nombre);
        }else {
            JOptionPane.showMessageDialog(null,"Seleccione un producto","Error" ,JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarCuentasActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    }//GEN-LAST:event_jButton1ActionPerformed

    private void txfBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfBuscarKeyTyped
        char c=evt.getKeyChar();
        if((c<'0' || c>'9')&&(c<'a' || c>'z')&&(c<'A' || c>'Z')&&(c<' '||c>' ')){
            evt.consume();
        }      
    }//GEN-LAST:event_txfBuscarKeyTyped

    private void tblCuentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCuentasMouseClicked
        String a=(String) tblCuentas.getValueAt(tblCuentas.getSelectedRow(),0);
        String d=(String) tblCuentas.getValueAt(tblCuentas.getSelectedRow(),1);
        String b=(String) tblCuentas.getValueAt(tblCuentas.getSelectedRow(),2);
        String c=(String) tblCuentas.getValueAt(tblCuentas.getSelectedRow(),3);
        String ce=(String) tblCuentas.getValueAt(tblCuentas.getSelectedRow(),4);
        String f=(String) tblCuentas.getValueAt(tblCuentas.getSelectedRow(),4);
        String h=(String) tblCuentas.getValueAt(tblCuentas.getSelectedRow(),6);
        String i=(String) tblCuentas.getValueAt(tblCuentas.getSelectedRow(),7);
        
                       
         if (evt.getClickCount()==2){
         C_MOD_ProductosProveedor pro= new C_MOD_ProductosProveedor();
         pro.setLocationRelativeTo(pro);
         pro.Datos(a, b, c, ce, f, h,i,d);
         pro.setVisible(true);
         }
    }//GEN-LAST:event_tblCuentasMouseClicked

    private void txfBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfBuscarKeyReleased
        borrarTabla(tblCuentas);
        erp.OpenCon("ERP", "erp");
        erp.CuentasProveedor_Search(txfBuscar.getText(),tblCuentas);
    }//GEN-LAST:event_txfBuscarKeyReleased

    private void tblCuentasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCuentasMouseEntered
        borrarTabla(tblCuentas);
        erp.OpenCon("ERP", "erp");
        erp.CuentasProveedor_Search(txfBuscar.getText(),tblCuentas);
    }//GEN-LAST:event_tblCuentasMouseEntered

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarCuentas;
    public javax.swing.JButton btnConsultarCuentasProveedor;
    private javax.swing.JButton btnEditarCuentas;
    private javax.swing.JButton btnEliminarCuentas;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tblCuentas;
    private javax.swing.JTextField txfBuscar;
    // End of variables declaration//GEN-END:variables
}
