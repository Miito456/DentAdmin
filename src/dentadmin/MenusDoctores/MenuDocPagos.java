package dentadmin.MenusDoctores;

import Items_cell.TableActionCellEditor;
import Items_cell.TableActionCellRender;
import Items_cell.TableActionEvent;
import dentadmin.AddThings.AddPago;
import dentadmin.Connect;
import dentadmin.LoginDoc;
import dentadmin.VistasDatosPacientes.ViewAbonos;
import dentadmin.VistasDatosPacientes.ViewProfileDoctor;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableRowSorter;

public class MenuDocPagos extends javax.swing.JFrame {

    FondoPanel fondo = new FondoPanel();

    Connect con = new Connect();
    Connection reg = con.conexion();

    private FileInputStream fis;
    private int longitudBytes;
    private Font customFont;
    private int idDoctor;

    public MenuDocPagos(int idDoctor) {
        this.idDoctor = idDoctor;
        this.setContentPane(fondo);
        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
        try {
            Font customFont = loadCustomFont("Recoleta-Regular.ttf").deriveFont(Font.PLAIN, 16);
            setFontRecursively(PrincipalPanel, customFont);
            titulo.setFont(loadCustomFont("Recoleta-Regular.ttf").deriveFont(Font.BOLD, 40));

        } catch (Exception e) {
            System.out.println("Font unvaliable" + e);
        }

        TableActionEvent event = new TableActionEvent() {

            @Override
            public void onDelete(int row) {
                if (table.isEditing()) {
                    table.getCellEditor().stopCellEditing();
                }

                DefaultTableModel model = (DefaultTableModel) table.getModel();
                int idPago = (int) model.getValueAt(row, 0);

                int confirm = JOptionPane.showConfirmDialog(
                        MenuDocPagos.this,
                        "¿Está seguro de que desea eliminar este pago?",
                        "Confirmar eliminación",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );

                if (confirm == JOptionPane.YES_OPTION) {
                    model.removeRow(row);

                    try {
                        String deleteQuery = "DELETE FROM pagos WHERE IdPago = ?";
                        PreparedStatement pst = reg.prepareStatement(deleteQuery);
                        pst.setInt(1, idPago);
                        pst.executeUpdate();
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(MenuDocPagos.this, "Error al eliminar el pago: " + ex.getMessage());
                    }
                }
            }

            @Override
            public void onView(int row) {
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                int idPago = (int) model.getValueAt(row, 0); 

                String nuevoPrecioStr = JOptionPane.showInputDialog(MenuDocPagos.this, "Ingrese el nuevo precio de la consulta:");
                if (nuevoPrecioStr != null) {
                    try {
                        double nuevoPrecio = Double.parseDouble(nuevoPrecioStr);
                        double cantidadPagada = (double) model.getValueAt(row, 4);

                        if (nuevoPrecio < cantidadPagada) {
                            JOptionPane.showMessageDialog(MenuDocPagos.this, "El nuevo precio no puede ser menor que la cantidad pagada.");
                            return;
                        }

                        String updateQuery = "UPDATE pagos SET CantidadAPagar = ? WHERE IdPago = ?";
                        PreparedStatement pst = reg.prepareStatement(updateQuery);
                        pst.setDouble(1, nuevoPrecio);
                        pst.setInt(2, idPago);
                        pst.executeUpdate();

                        double nuevaCantidadPorPagar = nuevoPrecio - cantidadPagada;

                        model.setValueAt(nuevoPrecio, row, 3);
                        model.setValueAt(nuevaCantidadPorPagar, row, 5);

                        JOptionPane.showMessageDialog(MenuDocPagos.this, "El precio de la consulta se ha actualizado correctamente.");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(MenuDocPagos.this, "Por favor, ingrese un número válido.");
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(MenuDocPagos.this, "Error al actualizar el precio de la consulta: " + ex.getMessage());
                    }
                }
            }

        };
        table.getColumnModel().getColumn(6).setCellRenderer(new TableActionCellRender());
        table.getColumnModel().getColumn(6).setCellEditor(new TableActionCellEditor(event));
        table.getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
                setHorizontalAlignment(SwingConstants.RIGHT);
                return super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1);
            }
        });

        Buscar.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                filterTable();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filterTable();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                filterTable();
            }
        });
        mostrarPagos();

    }

    private void updateConsultationPrice(int row, double newPrice) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int idPayment = (int) model.getValueAt(row, 0);

        try {
            String updateQuery = "UPDATE pagos SET CantidadAPagar = ?, CantidadAPagar = ? WHERE IdPago = ?";
            PreparedStatement pst = reg.prepareStatement(updateQuery);
            pst.setDouble(1, newPrice);
            pst.setDouble(2, newPrice - (double) model.getValueAt(row, 4));
            pst.setInt(3, idPayment);
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(MenuDocPagos.this, "Error al actualizar el precio de consulta: " + ex.getMessage());
        }
    }

    private void filterTable() {
        String query = Buscar.getText().toLowerCase();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + query));
    }

    private Font loadCustomFont(String fontName) {
        try {
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File(fontName));
            return customFont.deriveFont(Font.PLAIN, 16);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
            return new Font("Arial", Font.PLAIN, 16);
        }
    }

    private void setFontRecursively(Container container, Font font) {
        Component[] components = container.getComponents();
        for (Component component : components) {
            if (component instanceof Container) {
                setFontRecursively((Container) component, font);
            }
            component.setFont(font);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PrincipalPanel = new FondoPanel();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new LogoPanel();
        panelRound1 = new Items.PanelRound();
        titulo = new javax.swing.JLabel();
        btnAgregarPago = new Items.MyButton();
        Buscar = new Items.TextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btnAbonos = new Items.MyButton();
        panelRound2 = new Items.PanelRound();
        menuCerrarsesion = new Items.MyButton();
        menuPacientes = new Items.MyButton();
        menuConsultas = new Items.MyButton();
        menuPagos = new Items.MyButton();
        menuPerfil = new Items.MyButton();
        menuCitas = new Items.MyButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PrincipalPanel.setBackground(new java.awt.Color(251, 243, 235));
        PrincipalPanel.setForeground(new java.awt.Color(251, 243, 235));
        PrincipalPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton4.setBackground(new java.awt.Color(255, 51, 51));
        jButton4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("X");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        PrincipalPanel.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 10, -1, -1));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        PrincipalPanel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 111, 52));

        panelRound1.setBackground(new java.awt.Color(112, 77, 71));
        panelRound1.setRoundBottomLeft(50);
        panelRound1.setRoundBottomRight(50);
        panelRound1.setRoundTopLeft(50);
        panelRound1.setRoundTopRight(50);
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titulo.setBackground(new java.awt.Color(255, 255, 255));
        titulo.setForeground(new java.awt.Color(251, 246, 239));
        titulo.setText("Pagos");
        panelRound1.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 510, 60));

        btnAgregarPago.setBackground(new java.awt.Color(250, 246, 238));
        btnAgregarPago.setForeground(new java.awt.Color(120, 79, 71));
        btnAgregarPago.setText("Agregar Pagos");
        btnAgregarPago.setColor(new java.awt.Color(250, 246, 238));
        btnAgregarPago.setColorOver(new java.awt.Color(216, 198, 179));
        btnAgregarPago.setRadius(40);
        btnAgregarPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPagoActionPerformed(evt);
            }
        });
        panelRound1.add(btnAgregarPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 90, 180, 50));

        Buscar.setBackground(new java.awt.Color(248, 239, 230));
        Buscar.setForeground(new java.awt.Color(116, 76, 68));
        Buscar.setCaretColor(new java.awt.Color(204, 204, 204));
        Buscar.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        Buscar.setLabelText("Buscar");
        Buscar.setLineColor(new java.awt.Color(251, 246, 239));
        panelRound1.add(Buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 160, 410, -1));

        table.setBackground(new java.awt.Color(251, 243, 235));
        table.setForeground(new java.awt.Color(112, 77, 71));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Pago Referencia", "Nombre del paciente", "Fecha de Pago", "Precio de la consulta", "Cantidad pagada", "Cantidad por pagar", "Acciones"
            }
        ));
        table.setRowHeight(50);
        jScrollPane1.setViewportView(table);

        panelRound1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, 980, 390));

        btnAbonos.setBackground(new java.awt.Color(250, 246, 238));
        btnAbonos.setForeground(new java.awt.Color(120, 79, 71));
        btnAbonos.setText("Ver historial de pagos");
        btnAbonos.setColor(new java.awt.Color(250, 246, 238));
        btnAbonos.setColorOver(new java.awt.Color(216, 198, 179));
        btnAbonos.setRadius(40);
        btnAbonos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbonosActionPerformed(evt);
            }
        });
        panelRound1.add(btnAbonos, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 90, 210, 50));

        panelRound2.setBackground(new java.awt.Color(112, 77, 71));
        panelRound2.setRoundBottomLeft(100);
        panelRound2.setRoundBottomRight(50);
        panelRound2.setRoundTopLeft(50);
        panelRound2.setRoundTopRight(50);
        panelRound2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuCerrarsesion.setBackground(new java.awt.Color(250, 246, 238));
        menuCerrarsesion.setForeground(new java.awt.Color(120, 79, 71));
        menuCerrarsesion.setText("Cerrar Sesión");
        menuCerrarsesion.setColor(new java.awt.Color(250, 246, 238));
        menuCerrarsesion.setColorOver(new java.awt.Color(216, 198, 179));
        menuCerrarsesion.setRadius(40);
        menuCerrarsesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCerrarsesionActionPerformed(evt);
            }
        });
        panelRound2.add(menuCerrarsesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 189, 44));

        menuPacientes.setBackground(new java.awt.Color(250, 246, 238));
        menuPacientes.setForeground(new java.awt.Color(120, 79, 71));
        menuPacientes.setText("Pacientes");
        menuPacientes.setColor(new java.awt.Color(250, 246, 238));
        menuPacientes.setColorOver(new java.awt.Color(216, 198, 179));
        menuPacientes.setRadius(40);
        menuPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPacientesActionPerformed(evt);
            }
        });
        panelRound2.add(menuPacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 25, 189, 44));

        menuConsultas.setBackground(new java.awt.Color(250, 246, 238));
        menuConsultas.setForeground(new java.awt.Color(120, 79, 71));
        menuConsultas.setText("Consultas");
        menuConsultas.setColor(new java.awt.Color(250, 246, 238));
        menuConsultas.setColorOver(new java.awt.Color(216, 198, 179));
        menuConsultas.setRadius(40);
        menuConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuConsultasActionPerformed(evt);
            }
        });
        panelRound2.add(menuConsultas, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 189, 44));

        menuPagos.setBackground(new java.awt.Color(250, 246, 238));
        menuPagos.setForeground(new java.awt.Color(120, 79, 71));
        menuPagos.setText("Pagos");
        menuPagos.setColor(new java.awt.Color(250, 246, 238));
        menuPagos.setColorOver(new java.awt.Color(216, 198, 179));
        menuPagos.setRadius(40);
        menuPagos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPagosActionPerformed(evt);
            }
        });
        panelRound2.add(menuPagos, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 189, 44));

        menuPerfil.setBackground(new java.awt.Color(250, 246, 238));
        menuPerfil.setForeground(new java.awt.Color(120, 79, 71));
        menuPerfil.setText("Perfil");
        menuPerfil.setColor(new java.awt.Color(250, 246, 238));
        menuPerfil.setColorOver(new java.awt.Color(216, 198, 179));
        menuPerfil.setRadius(40);
        menuPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPerfilActionPerformed(evt);
            }
        });
        panelRound2.add(menuPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 189, 44));

        menuCitas.setBackground(new java.awt.Color(250, 246, 238));
        menuCitas.setForeground(new java.awt.Color(120, 79, 71));
        menuCitas.setText("Citas");
        menuCitas.setColor(new java.awt.Color(250, 246, 238));
        menuCitas.setColorOver(new java.awt.Color(216, 198, 179));
        menuCitas.setRadius(40);
        menuCitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCitasActionPerformed(evt);
            }
        });
        panelRound2.add(menuCitas, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 189, 44));

        panelRound1.add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 300, 440));

        PrincipalPanel.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 1260, 620));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PrincipalPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1366, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PrincipalPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnAgregarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPagoActionPerformed
        new AddPago(idDoctor).setVisible(true);
        this.dispose();
     }//GEN-LAST:event_btnAgregarPagoActionPerformed

    private void btnAbonosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbonosActionPerformed
        new ViewAbonos(idDoctor).setVisible(true);
        this.dispose(); // TODO add your handling code here:
    }//GEN-LAST:event_btnAbonosActionPerformed

    private void menuCerrarsesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCerrarsesionActionPerformed
        new LoginDoc().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuCerrarsesionActionPerformed

    private void menuPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPacientesActionPerformed
        MenuDocPacientes menuPrincipal = new MenuDocPacientes(idDoctor);
        menuPrincipal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuPacientesActionPerformed

    private void menuConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConsultasActionPerformed
        new MenuDocConsultas(idDoctor).setVisible(true);
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_menuConsultasActionPerformed

    private void menuPagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPagosActionPerformed
        new MenuDocPagos(idDoctor).setVisible(true);
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_menuPagosActionPerformed

    private void menuPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPerfilActionPerformed

        new ViewProfileDoctor(idDoctor).setVisible(true);
        this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_menuPerfilActionPerformed

    private void menuCitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCitasActionPerformed
        new MenuDocCitas(idDoctor).setVisible(true);
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_menuCitasActionPerformed

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
            java.util.logging.Logger.getLogger(MenuDocPagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuDocPagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuDocPagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuDocPagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LoginDoc loginDoc = new LoginDoc();
                int idDoctor = loginDoc.getIdDoctor();
                new MenuDocPagos(idDoctor).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Items.TextField Buscar;
    private javax.swing.JPanel PrincipalPanel;
    private Items.MyButton btnAbonos;
    private Items.MyButton btnAgregarPago;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private Items.MyButton menuCerrarsesion;
    private Items.MyButton menuCitas;
    private Items.MyButton menuConsultas;
    private Items.MyButton menuPacientes;
    private Items.MyButton menuPagos;
    private Items.MyButton menuPerfil;
    private Items.PanelRound panelRound1;
    private Items.PanelRound panelRound2;
    private javax.swing.JTable table;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables

    class FondoPanel extends JPanel {

        private Image imagen;

        @Override
        public void paint(Graphics g) {
            imagen = new ImageIcon(getClass().getResource("/Images/Fondo.png")).getImage();
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }
    }

    class LogoPanel extends JPanel {

        private Image imagen;

        @Override
        public void paint(Graphics g) {
            imagen = new ImageIcon(getClass().getResource("/Images/logo.png")).getImage();
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }
    }

    private void mostrarPagos() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        String sql = "SELECT pg.IdPago, CONCAT(p.Nombre, ' ', p.ApellidoPaterno, ' ', p.ApellidoMaterno) AS NombreCompleto, "
                + "pg.FechaPago, pg.CantidadAPagar, pg.CantidadPagada, "
                + "(pg.CantidadAPagar - pg.CantidadPagada) AS CantidadPorPagar "
                + "FROM pagos pg "
                + "JOIN pacientes p ON pg.IdPaciente = p.IdPaciente "
                + "WHERE pg.IdDoctor = ?";
        try (PreparedStatement pst = reg.prepareStatement(sql)) {
            pst.setInt(1, idDoctor);
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    Object[] row = new Object[]{
                        rs.getInt("IdPago"),
                        rs.getString("NombreCompleto"),
                        rs.getString("FechaPago"),
                        rs.getDouble("CantidadAPagar"),
                        rs.getDouble("CantidadPagada"),
                        rs.getDouble("CantidadPorPagar")
                    };
                    model.addRow(row);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al cargar pagos: " + ex.getMessage());
        }
    }

}
