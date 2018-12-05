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
import C_Frames.C_Categorias;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author rocker
 */
public class C_ADD_Pagos extends javax.swing.JFrame {

    /**
     * Creates new form AgregarCiudad
     */
    Conexion erp;
    public C_ADD_Pagos() {
        initComponents();
        erp = new Conexion();
        llenarC_Proveedor();
        llenarF_Pago();
    }
    C_Categorias cd;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cmbFp = new javax.swing.JComboBox<>();
        SelectP = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        Importe = new javax.swing.JLabel();
        cmbCP = new javax.swing.JComboBox<>();
        lABELcP = new javax.swing.JLabel();
        ID_Ped = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Sucursal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(40, 183, 41)), "AGREGAR CATEGORIA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(255, 0, 0))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(254, 254, 254));

        btnAgregar.setBackground(new java.awt.Color(254, 254, 254));
        btnAgregar.setForeground(new java.awt.Color(254, 254, 254));
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregar.png"))); // NOI18N
        btnAgregar.setBorderPainted(false);
        btnAgregar.setContentAreaFilled(false);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(254, 254, 254));
        btnCancelar.setForeground(new java.awt.Color(254, 254, 254));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon-cancelar.png"))); // NOI18N
        btnCancelar.setBorderPainted(false);
        btnCancelar.setContentAreaFilled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnLimpiar.setBackground(new java.awt.Color(254, 254, 254));
        btnLimpiar.setForeground(new java.awt.Color(254, 254, 254));
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/borar1-icon.png"))); // NOI18N
        btnLimpiar.setBorderPainted(false);
        btnLimpiar.setContentAreaFilled(false);
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(254, 254, 254));
        jLabel3.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(1, 1, 1));
        jLabel3.setText("FORMA DE PAGO:");

        cmbFp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione forma de pago            " }));

        SelectP.setText("Selecione pedido");
        SelectP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectPActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(254, 254, 254));
        jLabel4.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(1, 1, 1));
        jLabel4.setText("IMPORTE: ");

        Importe.setBackground(new java.awt.Color(254, 254, 254));
        Importe.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        Importe.setForeground(new java.awt.Color(1, 1, 1));
        Importe.setText("0.0");

        cmbCP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione cuenta   " }));

        lABELcP.setBackground(new java.awt.Color(254, 254, 254));
        lABELcP.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        lABELcP.setForeground(new java.awt.Color(1, 1, 1));
        lABELcP.setText("CUENTA PROVEEDOR");

        ID_Ped.setBackground(new java.awt.Color(254, 254, 254));
        ID_Ped.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        ID_Ped.setForeground(new java.awt.Color(1, 1, 1));
        ID_Ped.setText("Ninguno");

        jLabel5.setBackground(new java.awt.Color(254, 254, 254));
        jLabel5.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(1, 1, 1));
        jLabel5.setText("PEDIDO SELECCIONADO");

        jLabel6.setBackground(new java.awt.Color(254, 254, 254));
        jLabel6.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(1, 1, 1));
        jLabel6.setText("SUCURSAL: ");

        Sucursal.setBackground(new java.awt.Color(254, 254, 254));
        Sucursal.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        Sucursal.setForeground(new java.awt.Color(1, 1, 1));
        Sucursal.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ID_Ped)
                                .addGap(56, 56, 56)
                                .addComponent(SelectP))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(lABELcP))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(Importe)))
                                .addGap(21, 21, 21)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Sucursal))
                                    .addComponent(cmbCP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbFp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 262, Short.MAX_VALUE)
                        .addComponent(btnLimpiar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAgregar)
                .addContainerGap(150, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(ID_Ped)
                    .addComponent(SelectP))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbFp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Importe)
                    .addComponent(jLabel6)
                    .addComponent(Sucursal))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lABELcP)
                    .addComponent(cmbCP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.Alignment.TRAILING))
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

    private void SelectPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectPActionPerformed
        // TODO add your handling code here:
        /* select P.idPedido,p.fecharegistro,p.fecharecepcion,p.totalpagar,
        p.cantidadpagada,p.estatus, c.idproveedor,c.nombre
        from Pedidos P inner join Proveedores c on p.idproveedor = c.idproveedor
        where p.estatus = 'A';
        el id de pedido lo tomo y consulto en detalles
        select idPedidoDetalle, cantPedida,precioCompra,subtotal,
        cantRecibida,cantRechazada,cantAceptada from PedidoDetalle where idPedido = n*/
        C_Select_Pedido erp = new C_Select_Pedido();
        erp.setLocationRelativeTo(erp);
        erp.setVisible(true);
        dispose();
    }//GEN-LAST:event_SelectPActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed

    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        float Imp = 0;
        int FP = 0, IC = 0,IP = 0,IS = 0;
        StringTokenizer Cuenta = new StringTokenizer(cmbCP.getItemAt(cmbCP.getSelectedIndex())+""," ");
        StringTokenizer idFP = new StringTokenizer(cmbFp.getItemAt(cmbFp.getSelectedIndex())+""," ");
        
        try{
            Imp = Float.parseFloat(Importe.getText());
            FP = Integer.parseInt(idFP.nextToken());
            Cuenta.nextToken();Cuenta.nextToken();Cuenta.nextToken();Cuenta.nextToken();Cuenta.nextToken();
            Cuenta.nextToken();
            IC = Integer.parseInt(Cuenta.nextToken());
            IP = Integer.parseInt(ID_Ped.getText());
            IS = Integer.parseInt(Sucursal.getText());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage(),"Error" ,JOptionPane.INFORMATION_MESSAGE);
        }
        //System.out.println(IC+" idcuenta");
        erp.OpenCon("ERP", "erp");
        float Pre = erp.Presupuesto_Sucursal(IP),newP = 0;
        if (Pre >= Imp){
            newP = Pre-Imp;
            erp.SQL("insert into pagos values(IDPago.nextval,TO_DATE('"+dateFormat.format(date)+"','YYYY-MM-DD'),"+Imp+","+IP+","+FP+","+IC+",'P')");
            erp.SQL("update Pedidos set estatus = 'A' where idpedido = "+IP);
            erp.SQL("update sucursal set presupuesto = "+newP+" where idsucursal = "+IS);
        }else{
             //confirma eliminacion
        if(JOptionPane.showConfirmDialog(null, "No cuentas con el presupuesto suficiente\n¿Deseás continuar?\n*Si fuerzas el pago la sucursal estara en numeros negativos","Informacion",
            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            erp.SQL("insert into pagos values(IDPago.nextval,TO_DATE('"+dateFormat.format(date)+"','YYYY-MM-DD'),"+Imp+","+IP+","+FP+","+IC+",'P')");
            erp.SQL("update Pedidos set estatus = 'A' where idpedido = "+IP);
            erp.SQL("update sucursal set presupuesto = "+newP+" where idsucursal = "+IS);
        
        }else{
            JOptionPane.showMessageDialog(null,"Pago no realizado","Infromación" ,JOptionPane.INFORMATION_MESSAGE);
        }
        }
        //cree la secuencia IDPago
        
    }//GEN-LAST:event_btnAgregarActionPerformed
//for( e = name(first),r = name(last), p= name(other_last);e<r<p;e+=r,r+= p,p++ ){
//}
     DefaultComboBoxModel modelocombo = new DefaultComboBoxModel();
    DefaultComboBoxModel modelocombo1 = new DefaultComboBoxModel();
    
    public void llenarF_Pago(){
        try {
            erp.OpenCon("ERP", "erp");
            erp.stn= (Statement) erp.con.createStatement();
            erp.rs= erp.stn.executeQuery("Select idformapago, nombre from formaspago where estatus = 'A'");
            modelocombo.addElement("Seleccione forma de pago");
            cmbFp.setModel(modelocombo);
            while (erp.rs.next()){
                modelocombo.addElement(erp.rs.getObject("idformapago")+" "+erp.rs.getObject("nombre"));
                cmbFp.setModel(modelocombo);
            }
        
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Error" ,JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    public void llenarC_Proveedor(){
        try {
            erp.OpenCon("ERP", "erp");
            erp.stn= (Statement) erp.con.createStatement();
            erp.rs= erp.stn.executeQuery("select c.idCuentaProveedor, c.idproveedor, p.nombre, c.nocuenta,c.banco \n" +
"from cuentasproveedor c inner join Proveedores p on c.idproveedor = p.idproveedor where c.estatus = 'A'");
            modelocombo1.addElement("Seleccione cuenta");
            cmbFp.setModel(modelocombo);
            while (erp.rs.next()){
                modelocombo1.addElement(erp.rs.getObject("nombre")+" "+erp.rs.getObject("nocuenta")+" "+erp.rs.getObject("banco")+" idPro: "+erp.rs.getObject("idproveedor")+" idC: "+erp.rs.getObject("idcuentaproveedor"));
                
                cmbCP.setModel(modelocombo1);
            }
        
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Error" ,JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
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
            java.util.logging.Logger.getLogger(C_ADD_Pagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(C_ADD_Pagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(C_ADD_Pagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(C_ADD_Pagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new C_ADD_Pagos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel ID_Ped;
    public javax.swing.JLabel Importe;
    private javax.swing.JButton SelectP;
    public javax.swing.JLabel Sucursal;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnLimpiar;
    public javax.swing.JComboBox<String> cmbCP;
    public javax.swing.JComboBox<String> cmbFp;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lABELcP;
    // End of variables declaration//GEN-END:variables
}
