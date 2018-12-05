/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package C_Frames;

import C_Conexion.Conexion;
import static C_Conexion.Conexion.con;
import java.security.Principal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author ITESZ-80
 */

public class C_Pagos extends javax.swing.JPanel {

    /**
     * Creates new form Deduciiones
     */
    
    Conexion erp;
  public String idPeddd;

    public C_Pagos() {
        initComponents();
        erp = new Conexion();
        Ord.setEnabled(false);
        
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NomPro = new javax.swing.JTextField();
        btnConsultar = new javax.swing.JButton();
        btnAgregarDe = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPedidoDet = new javax.swing.JTable();
        Ord = new javax.swing.JButton();
        Usuario = new javax.swing.JLabel();
        realizar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();

        setBackground(new java.awt.Color(254, 254, 254));
        setForeground(new java.awt.Color(254, 254, 254));
        setLayout(null);

        NomPro.setBackground(new java.awt.Color(254, 254, 254));
        NomPro.setForeground(new java.awt.Color(1, 1, 1));
        NomPro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NomProMouseClicked(evt);
            }
        });
        NomPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomProActionPerformed(evt);
            }
        });
        NomPro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                NomProKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NomProKeyTyped(evt);
            }
        });
        add(NomPro);
        NomPro.setBounds(180, 30, 386, 25);

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
        btnConsultar.setBounds(750, 10, 75, 57);

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
        btnAgregarDe.setBounds(760, 470, 81, 57);

        jLabel1.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(1, 1, 1));
        jLabel1.setText("BUSCAR POR NOMBRE");
        add(jLabel1);
        jLabel1.setBounds(40, 30, 129, 16);

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        tablaPedidoDet.setFont(new java.awt.Font("Ebrima", 0, 11)); // NOI18N
        tablaPedidoDet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idPago", "fecha", "Sucursal", "Dir. Suc.", "Tel. Suc.", "Proveedor", "ID Cuenta", "No Cuenta", "Dir. Prov.", "Telefono", "Forma Pago", "Cantidad", "Descripcion", "Precio unidad", "Subtotal", "Total", "Importe", "ID Pedido", "Estatus"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaPedidoDet.setToolTipText("");
        tablaPedidoDet.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaPedidoDet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPedidoDetMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaPedidoDet);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1259, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jScrollPane3.setViewportView(jPanel1);

        add(jScrollPane3);
        jScrollPane3.setBounds(10, 70, 840, 380);

        Ord.setText("Orden de Compra");
        Ord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrdActionPerformed(evt);
            }
        });
        add(Ord);
        Ord.setBounds(590, 30, 130, 23);
        add(Usuario);
        Usuario.setBounds(10, 470, 180, 0);

        realizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icono-ingresar.png"))); // NOI18N
        realizar.setBorderPainted(false);
        realizar.setContentAreaFilled(false);
        realizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                realizarMouseClicked(evt);
            }
        });
        realizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                realizarActionPerformed(evt);
            }
        });
        add(realizar);
        realizar.setBounds(680, 480, 60, 40);

        cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icono-salir.png"))); // NOI18N
        cancelar.setBorderPainted(false);
        cancelar.setContentAreaFilled(false);
        cancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelarMouseClicked(evt);
            }
        });
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        add(cancelar);
        cancelar.setBounds(600, 480, 60, 50);
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
    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        borrarTabla(tablaPedidoDet);
        try{
        erp.OpenCon("ERP", "erp");
        erp.Pagos_Search_Bien_Vergas(NomPro.getText(), tablaPedidoDet);
        //erp.Detalles_seacrh(txfConsultar.getText(), tablaPedidoDet, cmbSe.getItemAt(cmbSe.getSelectedIndex()).charAt(0) );
        }
        catch(Exception e){
        
        }
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnAgregarDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarDeActionPerformed
// TODO add your handling code here:
       C_ADD_Pagos erp = new C_ADD_Pagos();
        erp.setLocationRelativeTo(erp);
        erp.setVisible(true);
        erp.cmbFp.setEnabled(false);
        erp.cmbCP.setEnabled(false);
        erp.Importe.setEnabled(false);
        erp.Sucursal.setEnabled(false);
    }//GEN-LAST:event_btnAgregarDeActionPerformed

    private void btnAgregarDeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarDeMouseClicked
              // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarDeMouseClicked

    private void NomProMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NomProMouseClicked
        // TODO add your handling code here:
        //cmbSe.setSelectedIndex(0);
    }//GEN-LAST:event_NomProMouseClicked

    private void tablaPedidoDetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPedidoDetMouseClicked
        // TODO add your handling code here:
       try{
        if(evt.getClickCount()==2){
            C_DET_PAGOS erp = new C_DET_PAGOS();
            erp.idPe.setText(tablaPedidoDet.getValueAt(tablaPedidoDet.getSelectedRow(), 17)+"");
                erp.setLocationRelativeTo(erp);
                erp.setVisible(true);
                
        }
        if(tablaPedidoDet.getSelectedRow()>=0){
         Ord.setEnabled(true);
        }else{
            Ord.setEnabled(false);
        }
       }catch(Exception e){
           
       }    
    }//GEN-LAST:event_tablaPedidoDetMouseClicked

    private void NomProKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NomProKeyTyped
                        char c=evt.getKeyChar();
        if((c<'0' || c>'9')&&(c<'a' || c>'z')&&(c<'A' || c>'Z')&&(c<' '||c>' ')){
            evt.consume();
        }
    }//GEN-LAST:event_NomProKeyTyped

    private void NomProKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NomProKeyReleased

        borrarTabla(tablaPedidoDet);
        try{
        erp.OpenCon("ERP", "erp");
      //erp.Detalles_seacrh(txfConsultar.getText(), tablaPedidoDet, cmbSe.getItemAt(cmbSe.getSelectedIndex()).charAt(0) );
        }
        catch(Exception e){
        
        }// TODO add your handling code here:
    }//GEN-LAST:event_NomProKeyReleased

    private void NomProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomProActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NomProActionPerformed

    private void OrdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrdActionPerformed
        // TODO add your handling code here:
        
        try{
            String Detalles = erp.Det_Pagos_Ya_Me_Enfade(Integer.parseInt(tablaPedidoDet.getValueAt(tablaPedidoDet.getSelectedRow(), 17)+""));
            String PreCompra = erp.Det_Pagos_Neta_Ya(Integer.parseInt(tablaPedidoDet.getValueAt(tablaPedidoDet.getSelectedRow(), 17)+""));
            JasperReport jr = (JasperReport)JRLoader.loadObject(Principal.class.getResource("/C_Frames/ORDENCOMPRA.jasper"));
            Map parametros = new HashMap<String,Object>();
            parametros.put("NF", tablaPedidoDet.getValueAt(tablaPedidoDet.getSelectedRow(), 0));
            parametros.put("FE",tablaPedidoDet.getValueAt(tablaPedidoDet.getSelectedRow(), 1));
            parametros.put("NSC", tablaPedidoDet.getValueAt(tablaPedidoDet.getSelectedRow(), 2));
            parametros.put("DSC",tablaPedidoDet.getValueAt(tablaPedidoDet.getSelectedRow(), 3));
            parametros.put("TSC", tablaPedidoDet.getValueAt(tablaPedidoDet.getSelectedRow(), 4));
            parametros.put("NE",Usuario.getText());
            parametros.put("NP",tablaPedidoDet.getValueAt(tablaPedidoDet.getSelectedRow(), 5));
            parametros.put("DP", tablaPedidoDet.getValueAt(tablaPedidoDet.getSelectedRow(), 8));
            parametros.put("TP",tablaPedidoDet.getValueAt(tablaPedidoDet.getSelectedRow(), 9));
            parametros.put("CNT", tablaPedidoDet.getValueAt(tablaPedidoDet.getSelectedRow(), 11));
            parametros.put("DESC",""+Detalles);
            parametros.put("PU", ""+PreCompra);
            parametros.put("IM",tablaPedidoDet.getValueAt(tablaPedidoDet.getSelectedRow(), 16));
            parametros.put("ST", tablaPedidoDet.getValueAt(tablaPedidoDet.getSelectedRow(), 14));
            parametros.put("IV", "0.0");
            parametros.put("T", tablaPedidoDet.getValueAt(tablaPedidoDet.getSelectedRow(), 15));
            
            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, new JREmptyDataSource());
            JasperViewer jv = new JasperViewer(jp,false);
            jv.show();
            //jv.setDefaultCloseOperation(jv.DISPOSE_ON_CLOSE);
            //jv.show();
        }catch(Exception e){
            
        }
        
    }//GEN-LAST:event_OrdActionPerformed

    private void realizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_realizarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_realizarMouseClicked

    private void realizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_realizarActionPerformed
        // TODO add your handling code here:
        if((tablaPedidoDet.getValueAt(tablaPedidoDet.getSelectedRow(), 18)+"").equals("P") ||(tablaPedidoDet.getValueAt(tablaPedidoDet.getSelectedRow(), 18)+"").isEmpty())
        if(JOptionPane.showConfirmDialog(null, "¿Ya se deposito el pago?\tenga en cuenta que no se podra modificar después","Informacion",
            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            
            erp.SQL("Update Pagos set estatus = 'R' where idpago = "+tablaPedidoDet.getValueAt(tablaPedidoDet.getSelectedRow(), 0));
        
        }else{
            System.out.println("noo");
        }
        btnConsultar.doClick();
    }//GEN-LAST:event_realizarActionPerformed

    private void cancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelarMouseClicked

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        // TODO add your handling code here:
        if((tablaPedidoDet.getValueAt(tablaPedidoDet.getSelectedRow(), 18)+"").equals("P")||(tablaPedidoDet.getValueAt(tablaPedidoDet.getSelectedRow(), 18)+"").isEmpty())
        if(JOptionPane.showConfirmDialog(null, "¿Deséa cancelarlo?\tenga en cuenta que no se podra modificar después","Informacion",
            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            
            erp.SQL("Update Pagos set estatus = 'C' where idpago = "+tablaPedidoDet.getValueAt(tablaPedidoDet.getSelectedRow(), 0));
        
        }
        btnConsultar.doClick();
    }//GEN-LAST:event_cancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField NomPro;
    private javax.swing.JButton Ord;
    public javax.swing.JLabel Usuario;
    private javax.swing.JButton btnAgregarDe;
    public javax.swing.JButton btnConsultar;
    private javax.swing.JButton cancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton realizar;
    public javax.swing.JTable tablaPedidoDet;
    // End of variables declaration//GEN-END:variables
}
