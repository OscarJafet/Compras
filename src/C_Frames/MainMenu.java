/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package C_Frames;

import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rocker
 */
public class MainMenu extends javax.swing.JFrame {

    /**
     * Creates new form MainMenu
     */
    Calendar fecha = Calendar.getInstance();
    String dia = String.valueOf(fecha.get(Calendar.DAY_OF_MONTH));
    String mes = String.valueOf(fecha.get(Calendar.MONTH));
    String año = String.valueOf(fecha.get(Calendar.YEAR));
    String usuario;
    public MainMenu() {
        initComponents();
        this.lblFecha.setText(dia + "/" + mes + "/" + año);
    }

    String[] titulos = new String[]{"ESTADOS", "CIUDADES", "PERCEPCIONES ", "DEDUCCIONES"};

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpLogo = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        C_Lab = new javax.swing.JButton();
        C_Cat = new javax.swing.JButton();
        C_UM = new javax.swing.JButton();
        C_EM = new javax.swing.JButton();
        C_PP = new javax.swing.JButton();
        C_PD = new javax.swing.JButton();
        C_SC = new javax.swing.JButton();
        C_ES = new javax.swing.JButton();
        lblUsuario = new javax.swing.JLabel();
        lblreloj = new javax.swing.JLabel();
        C_Pv = new javax.swing.JButton();
        C_PROPOR = new javax.swing.JButton();
        C_PED = new javax.swing.JButton();
        C_PED1 = new javax.swing.JButton();
        jpTitulo = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblCerrar = new javax.swing.JLabel();
        lblMinimizar = new javax.swing.JLabel();
        lblUsers = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jpFrames = new javax.swing.JPanel();
        jFrames = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jpLogo.setBackground(new java.awt.Color(254, 254, 254));
        jpLogo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 240, 0)));
        jpLogo.setForeground(new java.awt.Color(254, 254, 254));
        jpLogo.setPreferredSize(new java.awt.Dimension(211, 1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/if-advantage-teamwork-1034367_88840 (1).png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Noto Sans", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(1, 1, 1));
        jLabel1.setText("COMPRAS");

        jLabel4.setForeground(new java.awt.Color(52, 47, 47));
        jLabel4.setText("ERP-CM v. 2.0");

        lblFecha.setForeground(new java.awt.Color(1, 1, 1));

        C_Lab.setBackground(new java.awt.Color(255, 255, 255));
        C_Lab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Lab.png"))); // NOI18N
        C_Lab.setToolTipText("LABORATORIOS");
        C_Lab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C_LabActionPerformed(evt);
            }
        });

        C_Cat.setBackground(new java.awt.Color(255, 255, 255));
        C_Cat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Toxicidad.png"))); // NOI18N
        C_Cat.setToolTipText("CATEGORIAS");
        C_Cat.setBorder(null);
        C_Cat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C_CatActionPerformed(evt);
            }
        });

        C_UM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Unidad.png"))); // NOI18N
        C_UM.setToolTipText("UNIDAD MEDIDA");
        C_UM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C_UMActionPerformed(evt);
            }
        });

        C_EM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Empaques.png"))); // NOI18N
        C_EM.setToolTipText("EMPAQUE");
        C_EM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C_EMActionPerformed(evt);
            }
        });

        C_PP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ProductosP.png"))); // NOI18N
        C_PP.setToolTipText("PRESENTACION PRODUCTO");
        C_PP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C_PPActionPerformed(evt);
            }
        });

        C_PD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Productos.png"))); // NOI18N
        C_PD.setToolTipText("PRODUCTOS");
        C_PD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C_PDActionPerformed(evt);
            }
        });

        C_SC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Sucursal.png"))); // NOI18N
        C_SC.setToolTipText("SUCURSAL");
        C_SC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C_SCActionPerformed(evt);
            }
        });

        C_ES.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ExistenciaS.png"))); // NOI18N
        C_ES.setToolTipText("EXISTENCIA SUCURSAL");
        C_ES.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C_ESActionPerformed(evt);
            }
        });

        lblreloj.setText("jLabel5");

        C_Pv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Pr.png"))); // NOI18N
        C_Pv.setToolTipText("PROVEEDORES");
        C_Pv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C_PvActionPerformed(evt);
            }
        });

        C_PROPOR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/PrP.png"))); // NOI18N
        C_PROPOR.setToolTipText("PRODUCTOS PROVEEDOR");
        C_PROPOR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C_PROPORActionPerformed(evt);
            }
        });

        C_PED.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/C_PED.png"))); // NOI18N
        C_PED.setToolTipText("DETALLE DEL PEDIDO");
        C_PED.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C_PEDActionPerformed(evt);
            }
        });

        C_PED1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/512x512bb.jpg"))); // NOI18N
        C_PED1.setToolTipText("PEDIDOS");
        C_PED1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C_PED1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpLogoLayout = new javax.swing.GroupLayout(jpLogo);
        jpLogo.setLayout(jpLogoLayout);
        jpLogoLayout.setHorizontalGroup(
            jpLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpLogoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpLogoLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jpLogoLayout.createSequentialGroup()
                        .addGroup(jpLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpLogoLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jpLogoLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(C_PD, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(C_PP, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(C_SC, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(C_ES, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
            .addGroup(jpLogoLayout.createSequentialGroup()
                .addGroup(jpLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpLogoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(C_Lab, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(C_Cat, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(C_UM, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(C_EM, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpLogoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblUsuario))
                    .addGroup(jpLogoLayout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addGroup(jpLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblreloj, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpLogoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(C_Pv, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(C_PROPOR, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(C_PED, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(C_PED1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jpLogoLayout.setVerticalGroup(
            jpLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpLogoLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jpLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpLogoLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpLogoLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addGroup(jpLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(C_Lab, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(C_Cat, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(C_EM, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(C_UM, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jpLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(C_PD, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(C_PP, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(C_ES, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(C_SC, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(C_Pv, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(C_PED, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(C_PED1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(C_PROPOR, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(lblUsuario)
                .addGap(30, 30, 30)
                .addGroup(jpLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblreloj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addComponent(jLabel4))
        );

        jpTitulo.setBackground(new java.awt.Color(254, 254, 254));
        jpTitulo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 244, 0)));
        jpTitulo.setForeground(new java.awt.Color(254, 254, 254));

        jLabel3.setFont(new java.awt.Font("Noto Sans", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(1, 1, 1));
        jLabel3.setText("AGROQUÍMICA - COMPRAS");

        lblTitulo.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        lblTitulo.setToolTipText("");

        lblCerrar.setBackground(new java.awt.Color(254, 254, 254));
        lblCerrar.setForeground(new java.awt.Color(254, 254, 254));
        lblCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icono-salir.png"))); // NOI18N
        lblCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCerrarMouseClicked(evt);
            }
        });

        lblMinimizar.setBackground(new java.awt.Color(254, 254, 254));
        lblMinimizar.setForeground(new java.awt.Color(254, 254, 254));
        lblMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/minimize_icon-.png"))); // NOI18N
        lblMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMinimizarMouseClicked(evt);
            }
        });

        lblUsers.setForeground(new java.awt.Color(31, 28, 28));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/if_Close_1891023.png"))); // NOI18N
        jButton1.setText("Cerrar Sesion");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpTituloLayout = new javax.swing.GroupLayout(jpTitulo);
        jpTitulo.setLayout(jpTituloLayout);
        jpTituloLayout.setHorizontalGroup(
            jpTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTituloLayout.createSequentialGroup()
                .addGroup(jpTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpTituloLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(169, 169, 169)
                        .addComponent(lblMinimizar)
                        .addGap(18, 18, 18)
                        .addComponent(lblCerrar))
                    .addGroup(jpTituloLayout.createSequentialGroup()
                        .addGap(400, 400, 400)
                        .addComponent(lblTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 210, Short.MAX_VALUE)
                        .addComponent(lblUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        jpTituloLayout.setVerticalGroup(
            jpTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTituloLayout.createSequentialGroup()
                .addGroup(jpTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMinimizar)
                    .addComponent(lblCerrar)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(jpTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpTituloLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jpTituloLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(lblUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jpFrames.setBackground(new java.awt.Color(254, 254, 254));
        jpFrames.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 217, 0)));
        jpFrames.setForeground(new java.awt.Color(254, 254, 254));

        jFrames.setBackground(new java.awt.Color(254, 254, 254));
        jFrames.setForeground(new java.awt.Color(254, 254, 254));

        javax.swing.GroupLayout jFramesLayout = new javax.swing.GroupLayout(jFrames);
        jFrames.setLayout(jFramesLayout);
        jFramesLayout.setHorizontalGroup(
            jFramesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jFramesLayout.setVerticalGroup(
            jFramesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jpFramesLayout = new javax.swing.GroupLayout(jpFrames);
        jpFrames.setLayout(jpFramesLayout);
        jpFramesLayout.setHorizontalGroup(
            jpFramesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFrames, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpFramesLayout.setVerticalGroup(
            jpFramesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFrames, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpFrames, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpLogo, javax.swing.GroupLayout.DEFAULT_SIZE, 662, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpFrames, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseClicked
        if (JOptionPane.showConfirmDialog(rootPane, "¿Desea  salir del sistema?",
                "Salir del sistema", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_lblCerrarMouseClicked

    private void lblMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizarMouseClicked
        this.setState(this.ICONIFIED);
    }//GEN-LAST:event_lblMinimizarMouseClicked

    private void C_CatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C_CatActionPerformed
        // TODO add your handling code here:
        C_Categorias erp = new C_Categorias();
        erp.setSize(jFrames.getSize());
        erp.setLocation(0, 0);
        jFrames.removeAll();
        jFrames.add(erp);
        jFrames.revalidate();
        jFrames.repaint();
    }//GEN-LAST:event_C_CatActionPerformed

    private void C_EMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C_EMActionPerformed
        // TODO add your handling code here:
        Empaques erp = new Empaques();
        erp.setSize(jFrames.getSize());
        erp.setLocation(0, 0);
        jFrames.removeAll();
        jFrames.add(erp);
        jFrames.revalidate();
        jFrames.repaint();
    }//GEN-LAST:event_C_EMActionPerformed

    private void C_LabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C_LabActionPerformed
        // TODO add your handling code here:
        C_Laboratorios erp = new C_Laboratorios();
        erp.setSize(jFrames.getSize());
        erp.setLocation(0, 0);
        jFrames.removeAll();
        jFrames.add(erp);
        jFrames.revalidate();
        jFrames.repaint();
    }//GEN-LAST:event_C_LabActionPerformed

    private void C_UMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C_UMActionPerformed
        // TODO add your handling code here:
        C_Unidad erp = new C_Unidad();
        erp.setSize(jFrames.getSize());
        erp.setLocation(0, 0);
        jFrames.removeAll();
        jFrames.add(erp);
        jFrames.revalidate();
        jFrames.repaint();
    }//GEN-LAST:event_C_UMActionPerformed

    private void C_PDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C_PDActionPerformed
        C_Productos erp = new C_Productos();
        erp.setSize(jFrames.getSize());
        erp.setLocation(0, 0);
        jFrames.removeAll();
        jFrames.add(erp);
        jFrames.revalidate();
        jFrames.repaint();
    }//GEN-LAST:event_C_PDActionPerformed

    private void C_SCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C_SCActionPerformed
        C_Sucursales erp = new C_Sucursales();
        erp.setSize(jFrames.getSize());
        erp.setLocation(0, 0);
        jFrames.removeAll();
        jFrames.add(erp);
        jFrames.revalidate();
        jFrames.repaint();
    }//GEN-LAST:event_C_SCActionPerformed

    private void C_ESActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C_ESActionPerformed
       C_ExistenciaSucursal erp = new C_ExistenciaSucursal();
        erp.setSize(jFrames.getSize());
        erp.setLocation(0, 0);
        jFrames.removeAll();
        jFrames.add(erp);
        jFrames.revalidate();
        jFrames.repaint();
    }//GEN-LAST:event_C_ESActionPerformed

    private void C_PPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C_PPActionPerformed
        // TODO add your handling code here:
         C_PresentacionP erp = new C_PresentacionP();
        erp.setSize(jFrames.getSize());
        erp.setLocation(0, 0);
        jFrames.removeAll();
        jFrames.add(erp);
        jFrames.revalidate();
        jFrames.repaint();
    }//GEN-LAST:event_C_PPActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        lblUsuario.setText("Usuario: "+usuario);
        Reloj r = new Reloj(lblreloj);
        r.iniciar();
        r.start();
    }//GEN-LAST:event_formWindowGainedFocus

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       if(JOptionPane.showConfirmDialog (null, "Desea cerrar la sesion","Cerrar Sesion",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
        
            Login lo= new Login();
            lo.setVisible(true);
            dispose();
       }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void C_PvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C_PvActionPerformed
        C_Proveedores erp = new C_Proveedores();
        erp.setSize(jFrames.getSize());
        erp.setLocation(0, 0);
        jFrames.removeAll();
        jFrames.add(erp);
        jFrames.revalidate();
        jFrames.repaint();

    }//GEN-LAST:event_C_PvActionPerformed

    private void C_PROPORActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C_PROPORActionPerformed
        C_ProductosProveedor erp = new C_ProductosProveedor();
        erp.setSize(jFrames.getSize());
        erp.setLocation(0, 0);
        jFrames.removeAll();
        jFrames.add(erp);
        jFrames.revalidate();
        jFrames.repaint();
    }//GEN-LAST:event_C_PROPORActionPerformed

    private void C_PEDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C_PEDActionPerformed
        // TODO add your handling code here:
        C_PedidoDetalle erp = new C_PedidoDetalle();
        erp.setSize(jFrames.getSize());
        erp.setLocation(0, 0);
        jFrames.removeAll();
        jFrames.add(erp);
        jFrames.revalidate();
        jFrames.repaint();
    }//GEN-LAST:event_C_PEDActionPerformed

    private void C_PED1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C_PED1ActionPerformed
      Pedidos erp = new Pedidos();
        erp.setSize(jFrames.getSize());
        erp.setLocation(0, 0);
        jFrames.removeAll();
        jFrames.add(erp);
        jFrames.revalidate();
        jFrames.repaint();  // TODO add your handling code here:
    }//GEN-LAST:event_C_PED1ActionPerformed

    void setTitulo(int i) {
        lblTitulo.setText(titulos[i]);
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
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton C_Cat;
    private javax.swing.JButton C_EM;
    private javax.swing.JButton C_ES;
    private javax.swing.JButton C_Lab;
    private javax.swing.JButton C_PD;
    private javax.swing.JButton C_PED;
    private javax.swing.JButton C_PED1;
    private javax.swing.JButton C_PP;
    private javax.swing.JButton C_PROPOR;
    private javax.swing.JButton C_Pv;
    private javax.swing.JButton C_SC;
    private javax.swing.JButton C_UM;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jFrames;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jpFrames;
    private javax.swing.JPanel jpLogo;
    private javax.swing.JPanel jpTitulo;
    private javax.swing.JLabel lblCerrar;
    public javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblMinimizar;
    private javax.swing.JLabel lblTitulo;
    public javax.swing.JLabel lblUsers;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblreloj;
    // End of variables declaration//GEN-END:variables
}
