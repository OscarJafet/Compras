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
public class C_Unidad extends javax.swing.JPanel {

    /**
     * Creates new form Percepciones1
     */
    Conexion erp;
    public C_Unidad() {
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
        btnConsultarPercepcion = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUM = new javax.swing.JTable();
        btnAgregarPercepcion = new javax.swing.JButton();
        btnEditarPercecion = new javax.swing.JButton();
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
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfBuscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfBuscarKeyTyped(evt);
            }
        });
        add(txfBuscar);
        txfBuscar.setBounds(190, 30, 330, 30);

        btnConsultarPercepcion.setBackground(new java.awt.Color(254, 254, 254));
        btnConsultarPercepcion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon-buscar.png"))); // NOI18N
        btnConsultarPercepcion.setBorderPainted(false);
        btnConsultarPercepcion.setContentAreaFilled(false);
        btnConsultarPercepcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarPercepcionActionPerformed(evt);
            }
        });
        add(btnConsultarPercepcion);
        btnConsultarPercepcion.setBounds(540, 10, 60, 50);

        tblUM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID UNIDAD", "NOMBRE", "SIGLAS", "ESTATUS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblUM.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblUM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUMMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblUMMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(tblUM);

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

        btnEditarPercecion.setBackground(new java.awt.Color(254, 254, 254));
        btnEditarPercecion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon-cambiar.png"))); // NOI18N
        btnEditarPercecion.setBorderPainted(false);
        btnEditarPercecion.setContentAreaFilled(false);
        btnEditarPercecion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarPercecionActionPerformed(evt);
            }
        });
        add(btnEditarPercecion);
        btnEditarPercecion.setBounds(580, 430, 81, 57);

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
        jLabel1.setBounds(40, 40, 129, 16);

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
        C_ADD_Unidad erp = new C_ADD_Unidad();
        erp.setLocationRelativeTo(erp);
        erp.setVisible(true);
    }//GEN-LAST:event_btnAgregarPercepcionActionPerformed

    private void btnEliminarPercepcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPercepcionActionPerformed
        int ID = 0;
        int con = tblUM.getSelectedRow();

        if (con >= 0) {
            String es = String.valueOf(tblUM.getValueAt(con, 3));
            if (es.equals("A")) {
                ID = Integer.parseInt(tblUM.getValueAt(tblUM.getSelectedRow(), 0) + "");
                if (JOptionPane.showConfirmDialog(null, "Desea Eliminar", "Informacion", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    erp.SQL("update unidadmedida set estatus='B' where idunidad =" + ID);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una unidad con estatus A", "Error", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una unidad", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        btnConsultarPercepcion.doClick();
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
    
    private void btnConsultarPercepcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarPercepcionActionPerformed
        borrarTabla(tblUM);
        erp.OpenCon("ERP", "erp");
        erp.Unidad_Search(txfBuscar.getText(),tblUM);
    }//GEN-LAST:event_btnConsultarPercepcionActionPerformed

    private void btnEditarPercecionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarPercecionActionPerformed
        int con = tblUM.getSelectedRow();
        if (con >= 0) {
        String a = (String) tblUM.getValueAt(tblUM.getSelectedRow(), 0);
        String b = (String) tblUM.getValueAt(tblUM.getSelectedRow(), 1);
        String c = (String) tblUM.getValueAt(tblUM.getSelectedRow(), 2);        
        C_MOD_Unidad erp =new C_MOD_Unidad();
        erp.setLocationRelativeTo(erp);
        erp.Datos(a, b, c);
        erp.setVisible(true);
        int ID = 0;
        try{
            ID = Integer.parseInt(tblUM.getValueAt(tblUM.getSelectedRow(),0)+"");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage(),"Error" ,JOptionPane.INFORMATION_MESSAGE);
        }
        erp.Id.setText(ID+"");
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una unidad", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarPercecionActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int ID = 0;
        int con = tblUM.getSelectedRow();

        if (con >= 0) {
            String es = String.valueOf(tblUM.getValueAt(con, 3));
            if (es.equals("B")) {
                ID = Integer.parseInt(tblUM.getValueAt(tblUM.getSelectedRow(), 0) + "");
                if (JOptionPane.showConfirmDialog(null, "Desea dar de Activar", "Informacion", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    erp.SQL("update UnidadMedida set estatus='A' where idUnidadMedida =" + ID);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una unidad con estatus B", "Error", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una unidad", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txfBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfBuscarActionPerformed

    private void tblUMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUMMouseClicked
        String a=(String) tblUM.getValueAt(tblUM.getSelectedRow(),0);
        String b=(String) tblUM.getValueAt(tblUM.getSelectedRow(),1);
        String c=(String) tblUM.getValueAt(tblUM.getSelectedRow(),2);
        
                       
         if (evt.getClickCount()==2){
         C_MOD_Unidad UM= new C_MOD_Unidad();
         UM.setLocationRelativeTo(UM);
         UM.Datos(a, b, c);
         UM.setVisible(true);
         }

        



    }//GEN-LAST:event_tblUMMouseClicked

    private void txfBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfBuscarKeyReleased
        btnConsultarPercepcion.doClick();
        // TODO add your handling code here:
    }//GEN-LAST:event_txfBuscarKeyReleased

    private void txfBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfBuscarKeyTyped
                char c=evt.getKeyChar();
        if((c<'a' || c>'z')&&(c<'A' || c>'Z')&&(c<' '||c>' ')){
            evt.consume();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txfBuscarKeyTyped

    private void tblUMMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUMMouseEntered
        btnConsultarPercepcion.doClick();
        // TODO add your handling code here:
    }//GEN-LAST:event_tblUMMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarPercepcion;
    public javax.swing.JButton btnConsultarPercepcion;
    private javax.swing.JButton btnEditarPercecion;
    private javax.swing.JButton btnEliminarPercepcion;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblUM;
    private javax.swing.JTextField txfBuscar;
    // End of variables declaration//GEN-END:variables
}
