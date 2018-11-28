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
public class C_ProductosProveedor extends javax.swing.JPanel {

    /**
     * Creates new form Percepciones1
     */
    Conexion erp;
    public C_ProductosProveedor() {
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
        btnConsultarProPro = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProPro = new javax.swing.JTable();
        btnAgregarProPro = new javax.swing.JButton();
        btnEditarProProPro = new javax.swing.JButton();
        btnEliminarProPro = new javax.swing.JButton();
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
        txfBuscar.setBounds(240, 30, 330, 30);

        btnConsultarProPro.setBackground(new java.awt.Color(254, 254, 254));
        btnConsultarProPro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon-buscar.png"))); // NOI18N
        btnConsultarProPro.setBorderPainted(false);
        btnConsultarProPro.setContentAreaFilled(false);
        btnConsultarProPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarProProActionPerformed(evt);
            }
        });
        add(btnConsultarProPro);
        btnConsultarProPro.setBounds(570, 20, 60, 50);

        tblProPro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PROVEEDOR", "PRODUCTO", "PRESENTACION", "DIASRETARDO", "PRECIOESTANDAR", "PRECIOULTIMACOMPRA", "CANTMINPEDIR", "CANTMAXPEDIR", "ESTATUS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProPro.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblProPro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProProMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblProProMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(tblProPro);

        add(jScrollPane1);
        jScrollPane1.setBounds(30, 80, 789, 311);

        btnAgregarProPro.setBackground(new java.awt.Color(254, 254, 254));
        btnAgregarProPro.setForeground(new java.awt.Color(254, 254, 254));
        btnAgregarProPro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregar.png"))); // NOI18N
        btnAgregarProPro.setBorderPainted(false);
        btnAgregarProPro.setContentAreaFilled(false);
        btnAgregarProPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProProActionPerformed(evt);
            }
        });
        add(btnAgregarProPro);
        btnAgregarProPro.setBounds(760, 430, 81, 57);

        btnEditarProProPro.setBackground(new java.awt.Color(254, 254, 254));
        btnEditarProProPro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon-cambiar.png"))); // NOI18N
        btnEditarProProPro.setBorderPainted(false);
        btnEditarProProPro.setContentAreaFilled(false);
        btnEditarProProPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarProProProActionPerformed(evt);
            }
        });
        add(btnEditarProProPro);
        btnEditarProProPro.setBounds(580, 430, 81, 57);

        btnEliminarProPro.setBackground(new java.awt.Color(254, 254, 254));
        btnEliminarProPro.setForeground(new java.awt.Color(254, 254, 254));
        btnEliminarProPro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/borar1-icon.png"))); // NOI18N
        btnEliminarProPro.setBorderPainted(false);
        btnEliminarProPro.setContentAreaFilled(false);
        btnEliminarProPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProProActionPerformed(evt);
            }
        });
        add(btnEliminarProPro);
        btnEliminarProPro.setBounds(690, 420, 52, 67);

        jLabel1.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(1, 1, 1));
        jLabel1.setText("BUSCAR POR NOMBRE DEL PROVEEDOR");
        add(jLabel1);
        jLabel1.setBounds(9, 30, 230, 20);

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

    private void btnAgregarProProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProProActionPerformed
        C_ADD_ProductosProveedor erp = new C_ADD_ProductosProveedor();
        erp.setLocationRelativeTo(erp);
        erp.setVisible(true);
    }//GEN-LAST:event_btnAgregarProProActionPerformed

    private void btnEliminarProProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProProActionPerformed
        int idproveedor=0,idpresentacion=0;
        int con=tblProPro.getSelectedRow();
        if (con>=0){
            String es= String.valueOf(tblProPro.getValueAt(con,7));
            if(es.equals("A"))
            {
                            try {
            erp.OpenCon("ERP", "erp");
            erp.stn= (Statement) erp.con.createStatement();
            erp.rs= erp.stn.executeQuery("select * from Proveedores where nombre='"+tblProPro.getValueAt(tblProPro.getSelectedRow(),0)+"'");
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
            erp.rs= erp.stn.executeQuery("select * from PresentacionesProducto where nombre='"+tblProPro.getValueAt(tblProPro.getSelectedRow(),1)+"'");
            while (erp.rs.next()){
                String id= String.valueOf(erp.rs.getObject("idpresentacion"));
                idpresentacion= Integer.parseInt(id);
            }
        
        }catch(SQLException ex){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            if(JOptionPane.showConfirmDialog (null, "Desea eliminar","Informacion",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
                erp.SQL("update ProductosProveedor set estatus='B' where idproveedor="+idproveedor+" and idpresentacion="+idpresentacion);
                btnConsultarProPro.doClick();
            }
            }else {
                JOptionPane.showMessageDialog(null,"Seleccione un producto con estatus A","Error" ,JOptionPane.INFORMATION_MESSAGE);
            }
        }else {
            JOptionPane.showMessageDialog(null,"Seleccione un producto","Error" ,JOptionPane.INFORMATION_MESSAGE);
        }       //confirma eliminacion
    }//GEN-LAST:event_btnEliminarProProActionPerformed
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
    
    private void btnConsultarProProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarProProActionPerformed
        borrarTabla(tblProPro);
        erp.OpenCon("ERP", "erp");
        erp.ProductoProveedor_Search(txfBuscar.getText(),tblProPro);
    }//GEN-LAST:event_btnConsultarProProActionPerformed

    private void btnEditarProProProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarProProProActionPerformed
        int con=tblProPro.getSelectedRow();
        if (con>=0){
        String a=(String) tblProPro.getValueAt(tblProPro.getSelectedRow(),0);
        String d=(String) tblProPro.getValueAt(tblProPro.getSelectedRow(),1);
        String b=(String) tblProPro.getValueAt(tblProPro.getSelectedRow(),2);
        String c=(String) tblProPro.getValueAt(tblProPro.getSelectedRow(),3);
        String ce=(String) tblProPro.getValueAt(tblProPro.getSelectedRow(),4);
        String f=(String) tblProPro.getValueAt(tblProPro.getSelectedRow(),4);
        String h=(String) tblProPro.getValueAt(tblProPro.getSelectedRow(),6);
        String i=(String) tblProPro.getValueAt(tblProPro.getSelectedRow(),7);

        
        
        C_MOD_ProductosProveedor pro =new C_MOD_ProductosProveedor();
        pro.setLocationRelativeTo(pro);
        pro.Datos(a, b, c, ce, f, h,i,d);
        pro.setVisible(true);
        String nombre = null;
        try{
            nombre = String.valueOf(tblProPro.getValueAt(tblProPro.getSelectedRow(),0)+"");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage(),"Error" ,JOptionPane.INFORMATION_MESSAGE);
        }
        pro.txfProveedor.setText(nombre);
        }else {
            JOptionPane.showMessageDialog(null,"Seleccione un producto","Error" ,JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarProProProActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//        int ID = 0;
//        int idproveedor=0,idpresentacion=0;
//        int con=tblProPro.getSelectedRow();
//        if (con>=0){
//            String es= String.valueOf(tblProPro.getValueAt(con,7));
//            if(es.equals("B"))
//            {
//                                        try {
//            erp.OpenCon("ERP", "erp");
//            erp.stn= (Statement) erp.con.createStatement();
//            erp.rs= erp.stn.executeQuery("select * from Proveedores where nombre='"+tblProPro.getValueAt(tblProPro.getSelectedRow(),0)+"'");
//            while (erp.rs.next()){
//                String id= String.valueOf(erp.rs.getObject("idproveedor"));
//                idproveedor= Integer.parseInt(id);
//            }
//        
//        }catch(SQLException ex){
//            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
//        }
//                        try {
//            erp.OpenCon("ERP", "erp");
//            erp.stn= (Statement) erp.con.createStatement();
//            erp.rs= erp.stn.executeQuery("select * from PresentacionesProducto where nombre='"+tblProPro.getValueAt(tblProPro.getSelectedRow(),1)+"'");
//            while (erp.rs.next()){
//                String id= String.valueOf(erp.rs.getObject("idpresentacion"));
//                idpresentacion= Integer.parseInt(id);
//            }
//        
//        }catch(SQLException ex){
//            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
//        }    
//            if(JOptionPane.showConfirmDialog (null, "Desea dar de alta","Informacion",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
//            erp.SQL("update ProductosProveedor set estatus='A' where idproveedor="+idproveedor+" and idpresentacion="+idpresentacion);
//            btnConsultarProPro.doClick();
//            }
//            }else {
//                JOptionPane.showMessageDialog(null,"Seleccione un producto con estatus B","Error" ,JOptionPane.INFORMATION_MESSAGE);
//            }
//        }else {
//            JOptionPane.showMessageDialog(null,"Seleccione un producto","Error" ,JOptionPane.INFORMATION_MESSAGE);
//        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txfBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfBuscarKeyTyped
        char c=evt.getKeyChar();
        if((c<'0' || c>'9')&&(c<'a' || c>'z')&&(c<'A' || c>'Z')&&(c<' '||c>' ')){
            evt.consume();
        }      
    }//GEN-LAST:event_txfBuscarKeyTyped

    private void tblProProMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProProMouseClicked
        String a=(String) tblProPro.getValueAt(tblProPro.getSelectedRow(),0);
        String d=(String) tblProPro.getValueAt(tblProPro.getSelectedRow(),1);
        String b=(String) tblProPro.getValueAt(tblProPro.getSelectedRow(),2);
        String c=(String) tblProPro.getValueAt(tblProPro.getSelectedRow(),3);
        String ce=(String) tblProPro.getValueAt(tblProPro.getSelectedRow(),4);
        String f=(String) tblProPro.getValueAt(tblProPro.getSelectedRow(),4);
        String h=(String) tblProPro.getValueAt(tblProPro.getSelectedRow(),6);
        String i=(String) tblProPro.getValueAt(tblProPro.getSelectedRow(),7);
        
                       
         if (evt.getClickCount()==2){
         C_MOD_ProductosProveedor pro= new C_MOD_ProductosProveedor();
         pro.setLocationRelativeTo(pro);
         pro.Datos(a, b, c, ce, f, h,i,d);
         pro.setVisible(true);
         }
    }//GEN-LAST:event_tblProProMouseClicked

    private void txfBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfBuscarKeyReleased
        borrarTabla(tblProPro);
        erp.OpenCon("ERP", "erp");
        erp.ProductoProveedor_Search(txfBuscar.getText(), tblProPro);
    }//GEN-LAST:event_txfBuscarKeyReleased

    private void tblProProMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProProMouseEntered
        borrarTabla(tblProPro);
        erp.OpenCon("ERP", "erp");
        erp.ProductoProveedor_Search(txfBuscar.getText(), tblProPro);
// TODO add your handling code here:
    }//GEN-LAST:event_tblProProMouseEntered

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarProPro;
    public javax.swing.JButton btnConsultarProPro;
    private javax.swing.JButton btnEditarProProPro;
    private javax.swing.JButton btnEliminarProPro;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tblProPro;
    private javax.swing.JTextField txfBuscar;
    // End of variables declaration//GEN-END:variables
}
