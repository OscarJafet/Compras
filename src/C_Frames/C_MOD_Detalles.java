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
import java.util.StringTokenizer;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author carlo
 */
public class C_MOD_Detalles extends javax.swing.JFrame {

    /**
     * Creates new form EditarDeducciones
     */
    Conexion erp;
    C_PedidoDetalle edg;
    public C_MOD_Detalles() {
        initComponents();
        this.IdDet.setEditable(false);
        this.IdDet.setEnabled(false);
        this.cmbPed.setEnabled(false);
        this.cmbPres.setEnabled(false);
        this.preCom.setEnabled(false);
        
        erp = new Conexion();
        edg = new C_PedidoDetalle();
        llenarCombo1();
        llenarCombo2();
        
    }
     DefaultComboBoxModel modelocombo = new DefaultComboBoxModel();
    DefaultComboBoxModel modelocombo1 = new DefaultComboBoxModel();
public void llenarCombo1(){
        try {
            erp.OpenCon("ERP", "erp");
            erp.stn= (Statement) erp.con.createStatement();
            erp.rs= erp.stn.executeQuery("SELECT SUCURSALES.NOMBRE, PEDIDOS.idPedido FROM PEDIDOS\n" +
"INNER JOIN ERP.SUCURSALES \n" +
"ON PEDIDOS.IDSUCURSAL = SUCURSALES.IDSUCURSAL WHERE PEDIDOS.ESTATUS = 'A' or PEDIDOS.ESTATUS = 'E'");
            cmbPed.setModel(modelocombo);
            modelocombo.addElement("Selecione Pedido");
            while (erp.rs.next()){
                modelocombo.addElement(erp.rs.getObject("idPedido")+" "+erp.rs.getObject("nombre"));
                cmbPed.setModel(modelocombo);
            }
           
        
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Error" ,JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
public void llenarCombo2(){
        try {
            erp.OpenCon("ERP", "erp");
            erp.stn= (Statement) erp.con.createStatement();
            erp.rs= erp.stn.executeQuery("SELECT * FROM ERP.PRESENTACIONESPRODUCTO WHERE ESTATUS = 'A'");
            modelocombo1.addElement("Seleccione Presentación");
            cmbPres.setModel(modelocombo1);
            while (erp.rs.next()){
                modelocombo1.addElement(erp.rs.getObject("idPresentacion")+" "+erp.rs.getObject("nombre"));
                cmbPres.setModel(modelocombo1);
            }
        
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Error" ,JOptionPane.INFORMATION_MESSAGE);
        }
        
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
        IdDet = new javax.swing.JTextField();
        preCom = new javax.swing.JTextField();
        CantP = new javax.swing.JTextField();
        btnEliminarDed = new javax.swing.JButton();
        btnAgregarDed = new javax.swing.JButton();
        SubTotal = new javax.swing.JTextField();
        cmbPed = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        cmbPres = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        lblIdDeduccion4 = new javax.swing.JLabel();
        CantRec = new javax.swing.JTextField();
        lblIdDeduccion5 = new javax.swing.JLabel();
        CantRech = new javax.swing.JTextField();
        CantAcep = new javax.swing.JTextField();
        lblIdDeduccion6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(254, 254, 254));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "EDITAR PRESENTACIÓN", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(255, 0, 0))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(254, 254, 254));

        lblIdDeduccion.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        lblIdDeduccion.setForeground(new java.awt.Color(1, 1, 1));
        lblIdDeduccion.setText("ID DETALLE");

        lblIdDeduccion1.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        lblIdDeduccion1.setForeground(new java.awt.Color(1, 1, 1));
        lblIdDeduccion1.setText("PRECIO COMPRA");

        lblIdDeduccion2.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        lblIdDeduccion2.setForeground(new java.awt.Color(1, 1, 1));
        lblIdDeduccion2.setText("CANT. P");

        lblIdDeduccion3.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        lblIdDeduccion3.setForeground(new java.awt.Color(1, 1, 1));
        lblIdDeduccion3.setText("SUBTOTAL");

        IdDet.setEditable(false);
        IdDet.setBackground(new java.awt.Color(254, 254, 254));
        IdDet.setForeground(new java.awt.Color(1, 1, 1));

        preCom.setBackground(new java.awt.Color(254, 254, 254));
        preCom.setForeground(new java.awt.Color(1, 1, 1));
        preCom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                preComKeyTyped(evt);
            }
        });

        CantP.setBackground(new java.awt.Color(254, 254, 254));
        CantP.setForeground(new java.awt.Color(1, 1, 1));
        CantP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CantPKeyTyped(evt);
            }
        });

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

        SubTotal.setEditable(false);
        SubTotal.setBackground(new java.awt.Color(254, 254, 254));
        SubTotal.setForeground(new java.awt.Color(1, 1, 1));
        SubTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SubTotalKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(1, 1, 1));
        jLabel2.setText("ID PEDIDO");

        cmbPres.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbPresItemStateChanged(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(1, 1, 1));
        jLabel4.setText("ID PRESENTACION");

        lblIdDeduccion4.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        lblIdDeduccion4.setForeground(new java.awt.Color(1, 1, 1));
        lblIdDeduccion4.setText("CANT.  RECIBIDA");

        CantRec.setBackground(new java.awt.Color(254, 254, 254));
        CantRec.setForeground(new java.awt.Color(1, 1, 1));
        CantRec.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CantRecKeyTyped(evt);
            }
        });

        lblIdDeduccion5.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        lblIdDeduccion5.setForeground(new java.awt.Color(1, 1, 1));
        lblIdDeduccion5.setText("CANT.  RECHAZADA");

        CantRech.setBackground(new java.awt.Color(254, 254, 254));
        CantRech.setForeground(new java.awt.Color(1, 1, 1));
        CantRech.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CantRechActionPerformed(evt);
            }
        });
        CantRech.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CantRechKeyTyped(evt);
            }
        });

        CantAcep.setBackground(new java.awt.Color(254, 254, 254));
        CantAcep.setForeground(new java.awt.Color(1, 1, 1));
        CantAcep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CantAcepActionPerformed(evt);
            }
        });
        CantAcep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CantAcepKeyTyped(evt);
            }
        });

        lblIdDeduccion6.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        lblIdDeduccion6.setForeground(new java.awt.Color(1, 1, 1));
        lblIdDeduccion6.setText("CANT.  ACEPTADA");

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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblIdDeduccion5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CantRech, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                        .addGap(403, 403, 403))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblIdDeduccion4)
                                .addGap(18, 18, 18)
                                .addComponent(CantRec))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblIdDeduccion2)
                                    .addComponent(lblIdDeduccion3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(SubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lblIdDeduccion)
                                .addGap(45, 45, 45)
                                .addComponent(IdDet, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lblIdDeduccion1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(CantP, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                                    .addComponent(preCom))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(lblIdDeduccion6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbPed, 0, 125, Short.MAX_VALUE)
                            .addComponent(cmbPres, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CantAcep, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
                        .addGap(92, 92, 92))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblIdDeduccion)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(IdDet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbPed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(preCom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4))
                            .addComponent(lblIdDeduccion1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(cmbPres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdDeduccion2)
                    .addComponent(CantP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblIdDeduccion3)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CantAcep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblIdDeduccion6))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdDeduccion4)
                    .addComponent(CantRec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdDeduccion5)
                    .addComponent(CantRech, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEliminarDed, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAgregarDed, javax.swing.GroupLayout.Alignment.TRAILING)))
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
       int ID =Integer.parseInt(IdDet.getText()),idEmp = 0,idPedi = 0;
        float CPed = 0,Com = 0,sub = 0, rec = 0, reci = 0, acp = 0;
        StringTokenizer idPedido = new StringTokenizer(cmbPed.getItemAt(cmbPed.getSelectedIndex()).toString()," ");
        StringTokenizer idPress = new StringTokenizer(cmbPres.getItemAt(cmbPres.getSelectedIndex()).toString()," ");
        try{
            CPed = Float.parseFloat(this.CantP.getText());
            Com = Float.parseFloat(preCom.getText());
            sub = Float.parseFloat(SubTotal.getText());
            idPedi = Integer.parseInt(idPedido.nextToken());
            rec = Float.parseFloat(CantRech.getText());
            reci = Float.parseFloat(CantRec.getText());
            acp = Float.parseFloat(CantAcep.getText());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage(),"Error" ,JOptionPane.INFORMATION_MESSAGE);
        
        }
        if(reci > 0 && (reci == (acp+rec))){
            sub = acp*Com;
            if(JOptionPane.showConfirmDialog(null, "¿Deseá guardar las modificaciones?\nsub total = "+sub,"Informacion",
        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                erp.SQL("Update PedidoDetalle set  subtotal = "+sub+", cantrecibida = "+reci+",cantrechazada = "+rec+", cantaceptada = "+acp+" where idpedidodetalle = "+ID);
                erp.Update_Ped_Det_Total(idPedi);
              }else{
                JOptionPane.showMessageDialog(null,"No Modificado","Infromación" ,JOptionPane.INFORMATION_MESSAGE);
            }
            
        }else{
            JOptionPane.showMessageDialog(null,"Por favor revise si sus datos son correctos","Datos no congruentes", JOptionPane.INFORMATION_MESSAGE);
        }
       
    }//GEN-LAST:event_btnAgregarDedActionPerformed

    private void btnEliminarDedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarDedActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnEliminarDedActionPerformed

    private void cmbPresItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbPresItemStateChanged
        // TODO add your handling code here:
        if(cmbPres.getItemAt(cmbPres.getSelectedIndex()) == "Crear Empaque"){
            C_ADD_Emp erp = new C_ADD_Emp();
            erp.setLocationRelativeTo(erp);
            erp.setVisible(true);
        }
    }//GEN-LAST:event_cmbPresItemStateChanged

    private void preComKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_preComKeyTyped
        // TODO add your handling code here:
         char c=evt.getKeyChar();
        if(preCom.getText().contains(".")){
            if(c<'0'||c>'9')
                evt.consume();
        }else if((c<'0' || c>'9')&& (c>'.' || c<'.'))
            evt.consume();
    }//GEN-LAST:event_preComKeyTyped

    private void CantPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CantPKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(CantP.getText().contains(".")){
            if(c<'0'||c>'9')
                evt.consume();
        }else if((c<'0' || c>'9')&& (c>'.' || c<'.'))
            evt.consume();
    }//GEN-LAST:event_CantPKeyTyped

    private void SubTotalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SubTotalKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if((c<'0' || c>'9')&& (c>'.' || c<'.'))
            evt.consume();
    }//GEN-LAST:event_SubTotalKeyTyped

    private void CantRecKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CantRecKeyTyped
        // TODO add your handling code here:
     
                 char c=evt.getKeyChar();
        if(CantRec.getText().contains(".")){
            if(c<'0'||c>'9')
                evt.consume();
        }else if((c<'0' || c>'9')&& (c>'.' || c<'.'))
            evt.consume();
    }//GEN-LAST:event_CantRecKeyTyped

    private void CantRechKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CantRechKeyTyped
        // TODO add your handling code here:
                 char c=evt.getKeyChar();
        if(CantRech.getText().contains(".")){
            if(c<'0'||c>'9')
                evt.consume();
        }else if((c<'0' || c>'9')&& (c>'.' || c<'.'))
            evt.consume();
    }//GEN-LAST:event_CantRechKeyTyped

    private void CantRechActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CantRechActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CantRechActionPerformed

    private void CantAcepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CantAcepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CantAcepActionPerformed

    private void CantAcepKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CantAcepKeyTyped
        // TODO add your handling code here:
        //Acp
                          char c=evt.getKeyChar();
        if(CantAcep.getText().contains(".")){
            if(c<'0'||c>'9')
                evt.consume();
        }else if((c<'0' || c>'9')&& (c>'.' || c<'.'))
            evt.consume();
    }//GEN-LAST:event_CantAcepKeyTyped

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
            java.util.logging.Logger.getLogger(C_MOD_Detalles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(C_MOD_Detalles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(C_MOD_Detalles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(C_MOD_Detalles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new C_MOD_Detalles().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField CantAcep;
    public javax.swing.JTextField CantP;
    public javax.swing.JTextField CantRec;
    public javax.swing.JTextField CantRech;
    public javax.swing.JTextField IdDet;
    public javax.swing.JTextField SubTotal;
    public javax.swing.JButton btnAgregarDed;
    public javax.swing.JButton btnEliminarDed;
    public javax.swing.JComboBox cmbPed;
    public javax.swing.JComboBox cmbPres;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblIdDeduccion;
    private javax.swing.JLabel lblIdDeduccion1;
    private javax.swing.JLabel lblIdDeduccion2;
    private javax.swing.JLabel lblIdDeduccion3;
    private javax.swing.JLabel lblIdDeduccion4;
    private javax.swing.JLabel lblIdDeduccion5;
    private javax.swing.JLabel lblIdDeduccion6;
    public javax.swing.JTextField preCom;
    // End of variables declaration//GEN-END:variables
}
