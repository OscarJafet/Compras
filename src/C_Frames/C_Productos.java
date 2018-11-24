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
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jose
 */
public class C_Productos extends javax.swing.JPanel {

    /**
     * Creates new form Percepciones1
     */
    Conexion erp;
    public C_Productos() {
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
        btnConsultarProducto = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPro = new javax.swing.JTable();
        btnAgregarProducto = new javax.swing.JButton();
        btnEditarProducto = new javax.swing.JButton();
        btnEliminarProducto = new javax.swing.JButton();
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
        txfBuscar.setBounds(200, 30, 330, 30);

        btnConsultarProducto.setBackground(new java.awt.Color(254, 254, 254));
        btnConsultarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon-buscar.png"))); // NOI18N
        btnConsultarProducto.setBorderPainted(false);
        btnConsultarProducto.setContentAreaFilled(false);
        btnConsultarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarProductoActionPerformed(evt);
            }
        });
        add(btnConsultarProducto);
        btnConsultarProducto.setBounds(540, 10, 60, 50);

        tblPro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IDPRODUCTO", "NOMBRE", "DESCRIPCION", "INGREDIENTEACTIVO", "BANDATOXICOLOGICA", "APLICACION", "USO", "ESTATUS", "IDLABORATORIO", "IDCATEGORIA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPro.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblPro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPro);

        add(jScrollPane1);
        jScrollPane1.setBounds(30, 80, 789, 311);

        btnAgregarProducto.setBackground(new java.awt.Color(254, 254, 254));
        btnAgregarProducto.setForeground(new java.awt.Color(254, 254, 254));
        btnAgregarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregar.png"))); // NOI18N
        btnAgregarProducto.setBorderPainted(false);
        btnAgregarProducto.setContentAreaFilled(false);
        btnAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoActionPerformed(evt);
            }
        });
        add(btnAgregarProducto);
        btnAgregarProducto.setBounds(760, 430, 81, 57);

        btnEditarProducto.setBackground(new java.awt.Color(254, 254, 254));
        btnEditarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon-cambiar.png"))); // NOI18N
        btnEditarProducto.setBorderPainted(false);
        btnEditarProducto.setContentAreaFilled(false);
        btnEditarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarProductoActionPerformed(evt);
            }
        });
        add(btnEditarProducto);
        btnEditarProducto.setBounds(580, 430, 81, 57);

        btnEliminarProducto.setBackground(new java.awt.Color(254, 254, 254));
        btnEliminarProducto.setForeground(new java.awt.Color(254, 254, 254));
        btnEliminarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/borar1-icon.png"))); // NOI18N
        btnEliminarProducto.setBorderPainted(false);
        btnEliminarProducto.setContentAreaFilled(false);
        btnEliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProductoActionPerformed(evt);
            }
        });
        add(btnEliminarProducto);
        btnEliminarProducto.setBounds(690, 420, 52, 67);

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

    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoActionPerformed
        C_ADD_Productos erp = new C_ADD_Productos();
        erp.setLocationRelativeTo(erp);
        erp.setVisible(true);
    }//GEN-LAST:event_btnAgregarProductoActionPerformed

    private void btnEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProductoActionPerformed
        int ID = 0;
        int con=tblPro.getSelectedRow();
        if (con>=0){
            String es= String.valueOf(tblPro.getValueAt(con,7));
            if(es.equals("A"))
            {    
            ID = Integer.parseInt(tblPro.getValueAt(tblPro.getSelectedRow(),0)+"");
            if(JOptionPane.showConfirmDialog (null, "Desea eliminar","Informacion",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
                ProcedimientoProductos();
            }
            }else {
                JOptionPane.showMessageDialog(null,"Seleccione un producto con estatus A","Error" ,JOptionPane.INFORMATION_MESSAGE);
            }
        }else {
            JOptionPane.showMessageDialog(null,"Seleccione un producto","Error" ,JOptionPane.INFORMATION_MESSAGE);
        }       //confirma eliminacion
    }//GEN-LAST:event_btnEliminarProductoActionPerformed
public void borrarTabla(JTable tab) {
        try {
            DefaultTableModel tabT = (DefaultTableModel) tab.getModel();
            for (int i = tabT.getRowCount() - 1; i > -1; i--) {
                tabT.removeRow(i);
            }
        } catch (Exception e) {
       
        }
    }
    
    private void btnConsultarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarProductoActionPerformed
        borrarTabla(tblPro);
        erp.OpenCon("ERP", "erp");
        erp.Producto_Search(txfBuscar.getText(),tblPro);
    }//GEN-LAST:event_btnConsultarProductoActionPerformed

    private void btnEditarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarProductoActionPerformed
        int con=tblPro.getSelectedRow();
        if (con>=0){
        String a=(String) tblPro.getValueAt(tblPro.getSelectedRow(),0);
        String b=(String) tblPro.getValueAt(tblPro.getSelectedRow(),1);
        String c=(String) tblPro.getValueAt(tblPro.getSelectedRow(),2);
        String ce=(String) tblPro.getValueAt(tblPro.getSelectedRow(),3);
        String f=(String) tblPro.getValueAt(tblPro.getSelectedRow(),4);
        String h=(String) tblPro.getValueAt(tblPro.getSelectedRow(),5);
        String i=(String) tblPro.getValueAt(tblPro.getSelectedRow(),6);
        String j=(String) tblPro.getValueAt(tblPro.getSelectedRow(),8);
        String k=(String) tblPro.getValueAt(tblPro.getSelectedRow(),9);

        
        
        C_MOD_Productos pro =new C_MOD_Productos();
        pro.setLocationRelativeTo(pro);
        pro.Datos(a, b, c, ce, f, h,i,j,k);
        pro.setVisible(true);
        int ID = 0;
        try{
            ID = Integer.parseInt(tblPro.getValueAt(tblPro.getSelectedRow(),0)+"");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage(),"Error" ,JOptionPane.INFORMATION_MESSAGE);
        }
        pro.txfIDProducto.setText(ID+"");
        }else {
            JOptionPane.showMessageDialog(null,"Seleccione un producto","Error" ,JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarProductoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int ID = 0;
        int con=tblPro.getSelectedRow();
        if (con>=0){
            String es= String.valueOf(tblPro.getValueAt(con,7));
            if(es.equals("B"))
            {    
            ID = Integer.parseInt(tblPro.getValueAt(tblPro.getSelectedRow(),0)+"");
            if(JOptionPane.showConfirmDialog (null, "Desea dar de alta","Informacion",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
                ProcedimientoProductosAlta();
            }
            }else {
                JOptionPane.showMessageDialog(null,"Seleccione un producto con estatus B","Error" ,JOptionPane.INFORMATION_MESSAGE);
            }
        }else {
            JOptionPane.showMessageDialog(null,"Seleccione un producto","Error" ,JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txfBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfBuscarKeyTyped
        char c=evt.getKeyChar();
        if((c<'0' || c>'9')&&(c<'a' || c>'z')&&(c<'A' || c>'Z')&&(c<' '||c>' ')){
            evt.consume();
        }      
    }//GEN-LAST:event_txfBuscarKeyTyped

    private void tblProMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProMouseClicked
        String a,b,c,d,e,f,h,i;
        
        a=(String) tblPro.getValueAt(tblPro.getSelectedRow(),0);
        b=(String) tblPro.getValueAt(tblPro.getSelectedRow(),1);
        c=(String) tblPro.getValueAt(tblPro.getSelectedRow(),2);
        e=(String) tblPro.getValueAt(tblPro.getSelectedRow(),3);
        f=(String) tblPro.getValueAt(tblPro.getSelectedRow(),4);
        h=(String) tblPro.getValueAt(tblPro.getSelectedRow(),5);
        i=(String) tblPro.getValueAt(tblPro.getSelectedRow(),6);
        String j=(String) tblPro.getValueAt(tblPro.getSelectedRow(),8);
        String k=(String) tblPro.getValueAt(tblPro.getSelectedRow(),9);        
                       
         if (evt.getClickCount()==2){
         C_MOD_Productos pro= new C_MOD_Productos();
         pro.setLocationRelativeTo(pro);
         pro.Datos(a, b, c, e, f, h,i,j,k);
         pro.setVisible(true);
         }
    }//GEN-LAST:event_tblProMouseClicked

    private void txfBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfBuscarKeyReleased
        borrarTabla(tblPro);
        erp.OpenCon("ERP", "erp");
        erp.Producto_Search(txfBuscar.getText(), tblPro);
    }//GEN-LAST:event_txfBuscarKeyReleased
      public void ProcedimientoProductos(){
           int ID = 0;
     
           ID = Integer.parseInt(tblPro.getValueAt(tblPro.getSelectedRow(),0)+"");
          try {
          CallableStatement cst= con.prepareCall("{call ELPRO (?,?)}");
            cst.setInt(1, ID);
            
            cst.registerOutParameter(2,java.sql.Types.VARCHAR);
            cst.execute();
            
            String msg= cst.getString(2);
            JOptionPane.showMessageDialog(null,msg,"Accion Realizada" ,JOptionPane.INFORMATION_MESSAGE);
          }
          catch (SQLException ex){
              JOptionPane.showMessageDialog(null,ex.getMessage(),"Error" ,JOptionPane.INFORMATION_MESSAGE);
          }
          
          
      }
      
            public void ProcedimientoProductosAlta(){
           int ID = 0;
     
           ID = Integer.parseInt(tblPro.getValueAt(tblPro.getSelectedRow(),0)+"");
          try {
          CallableStatement cst= con.prepareCall("{call ALTAPRO (?,?)}");
            cst.setInt(1, ID);
            
            cst.registerOutParameter(2,java.sql.Types.VARCHAR);
            cst.execute();
            
            String msg= cst.getString(2);
            JOptionPane.showMessageDialog(null,msg,"Accion Realizada" ,JOptionPane.INFORMATION_MESSAGE);
          }
          catch (SQLException ex){
              JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.INFORMATION_MESSAGE);
          }
          
          
      }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarProducto;
    public javax.swing.JButton btnConsultarProducto;
    private javax.swing.JButton btnEditarProducto;
    private javax.swing.JButton btnEliminarProducto;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPro;
    private javax.swing.JTextField txfBuscar;
    // End of variables declaration//GEN-END:variables
}
