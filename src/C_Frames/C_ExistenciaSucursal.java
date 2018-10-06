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
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rocker
 */
public class C_ExistenciaSucursal extends javax.swing.JPanel {

    /**
     * Creates new form Ciudades
     */int ids=0,idp = 0;
    Conexion erp;
    public C_ExistenciaSucursal() {
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

        btnBuscar = new javax.swing.JButton();
        C_Categorias_txfBuscar = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        C_ExistenciaSucursal_tabla = new javax.swing.JTable();
        btnNuevo = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(254, 254, 254));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        setForeground(new java.awt.Color(254, 254, 254));
        setPreferredSize(new java.awt.Dimension(861, 554));

        btnBuscar.setBackground(new java.awt.Color(254, 254, 254));
        btnBuscar.setForeground(new java.awt.Color(254, 254, 254));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon-buscar.png"))); // NOI18N
        btnBuscar.setBorderPainted(false);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        C_Categorias_txfBuscar.setBackground(new java.awt.Color(254, 254, 254));
        C_Categorias_txfBuscar.setForeground(new java.awt.Color(1, 1, 1));

        jButton1.setBackground(new java.awt.Color(254, 254, 254));
        jButton1.setForeground(new java.awt.Color(254, 254, 254));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/refresh_icon.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        C_ExistenciaSucursal_tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IDP", "IDS", "Nombre", "Precio de venta", "Reorden", "Cantidad", "Producto", "Empaque"
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

        btnNuevo.setBackground(new java.awt.Color(254, 254, 254));
        btnNuevo.setForeground(new java.awt.Color(254, 254, 254));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregar.png"))); // NOI18N
        btnNuevo.setBorder(null);
        btnNuevo.setBorderPainted(false);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(254, 254, 254));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/borar1-icon.png"))); // NOI18N
        btnEliminar.setBorder(null);
        btnEliminar.setBorderPainted(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnActualizar.setBackground(new java.awt.Color(254, 254, 254));
        btnActualizar.setForeground(new java.awt.Color(254, 254, 254));
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon-cambiar.png"))); // NOI18N
        btnActualizar.setBorderPainted(false);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(1, 1, 1));
        jLabel1.setText("BUSCAR POR NOMBRE SUCURSAL");
        jLabel1.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addComponent(C_Categorias_txfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(btnBuscar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 785, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnActualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminar)
                .addGap(18, 18, 18)
                .addComponent(btnNuevo)
                .addGap(58, 58, 58))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(C_Categorias_txfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBuscar)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );
    }// </editor-fold>//GEN-END:initComponents
public void borrarTabla(JTable tab) {
        try {
            DefaultTableModel tabT = (DefaultTableModel) tab.getModel();
            for (int i = tabT.getRowCount() - 1; i > -1; i--) {
                tabT.removeRow(i);
            }
        } catch (Exception e) {
       
        }
    }
  String Sql;
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
      borrarTabla(C_ExistenciaSucursal_tabla);
      C_ExistenciaSucursal_tabla.setVisible(false);
    
    
        
        
      C_ExistenciaSucursal_tabla.setVisible(true);
      erp.OpenCon("ERP", "erp");
      String a=C_Categorias_txfBuscar.getText();
      if(a.isEmpty()){
           Sql = "select es.idpresentacion,es.idsucursal,sc.NOMBRE, pp.PRECIOVENTA, pp.PUNTOREORDEN,es.cantidad, pt.NOMBRE as NOM,em.NOMBRE as NO from EXISTENCIASUCURSAL es inner join SUCURSAL sc \n" +
"                    on sc.IDSUCURSAL=es.IDSUCURSAL inner join\n" +
"                     PRESENTACIONESPRODUCTO pp on pp.IDPRESENTACION=es.IDPRESENTACION inner \n" +
"                    join PRODUCTOS pt on pt.idproducto=pp.idproducto inner join empaques em on em.idempaque=pp.idempaque";
        
      erp.ExistenciaSucursal_search(C_ExistenciaSucursal_tabla,Sql);}else{
          
            Sql = "select es.IDSUCURSAL,es.IDPRESENTACION,sc.NOMBRE, pp.PRECIOVENTA, pp.PUNTOREORDEN,es.cantidad, pt.NOMBRE as NOM,em.NOMBRE as NO from EXISTENCIASUCURSAL es inner join SUCURSAL sc "
                    + "on sc.IDSUCURSAL=es.IDSUCURSAL inner join"
                    + " PRESENTACIONESPRODUCTO pp on pp.IDPRESENTACION=es.IDPRESENTACION inner "
                    + "join PRODUCTOS pt on pt.idproducto=pp.idproducto inner join empaques em on em.idempaque=pp.idempaque where sc.nombre = '"+a.toString()+"'";
        
      erp.ExistenciaSucursal_search_nombre(C_ExistenciaSucursal_tabla,Sql);
      }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        C_ADD_ES aCiu = new C_ADD_ES();
        aCiu.setLocationRelativeTo(aCiu);
        aCiu.setVisible(true);
    }//GEN-LAST:event_btnNuevoActionPerformed

        
    
         
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
   if(C_ExistenciaSucursal_tabla.getSelectedRow()>-1){
  
   idp=Integer.parseInt(C_ExistenciaSucursal_tabla.getValueAt(C_ExistenciaSucursal_tabla.getSelectedRow(), 0).toString() );
                  ids=  Integer.parseInt(C_ExistenciaSucursal_tabla.getValueAt(C_ExistenciaSucursal_tabla.getSelectedRow(), 1).toString());
                   
       
        //confirma eliminacion
        int dialogButton = JOptionPane.YES_NO_OPTION;
            JOptionPane.showConfirmDialog (null, "Desea eliminar","Informacion", dialogButton);
            if(dialogButton == JOptionPane.YES_OPTION) {
                erp.SQL("delete existenciasucursal where idpresentacion="+idp+" and idsucursal="
                        + ids);
            if(dialogButton == JOptionPane.NO_OPTION) {
                  remove(dialogButton);
                }
              }}else{ JOptionPane.showMessageDialog(null, "Selecione un renglon");}
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
        
                //
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
       C_MOD_ExistenciaSucursal edg = new C_MOD_ExistenciaSucursal();
        
         if(C_ExistenciaSucursal_tabla.getSelectedRow() > -1){
           int a= C_ExistenciaSucursal_tabla.getSelectedRow();
           
    String b =   (String) C_ExistenciaSucursal_tabla.getValueAt(C_ExistenciaSucursal_tabla.getSelectedRow(), 0).toString();
        
           edg.r=a;
           edg.setLocationRelativeTo(edg);
         edg.setVisible(true);
        }else{
             edg.r=-1;
         edg.setLocationRelativeTo(edg);
        edg.setVisible(true);
         }
        borrarTabla(C_ExistenciaSucursal_tabla);
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
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
        
    }//GEN-LAST:event_jButton1ActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField C_Categorias_txfBuscar;
    public javax.swing.JTable C_ExistenciaSucursal_tabla;
    public javax.swing.JButton btnActualizar;
    public javax.swing.JButton btnBuscar;
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnNuevo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}