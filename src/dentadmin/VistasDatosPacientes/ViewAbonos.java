package dentadmin.VistasDatosPacientes;

import dentadmin.AddThings.AddPago;
import dentadmin.MenusDoctores.MenuDocPagos;
import Items_cell.TableActionCellEditor;
import Items_cell.TableActionCellRender;
import Items_cell.TableActionEvent;
import dentadmin.Connect;
import dentadmin.LoginDoc;
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
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableRowSorter;

public class ViewAbonos extends javax.swing.JFrame {

    FondoPanel fondo = new FondoPanel();

    Connect con = new Connect();
    Connection reg = con.conexion();

    private FileInputStream fis;
    private int longitudBytes;
    private Font customFont;
    private int idDoctor;

    public ViewAbonos(int idDoctor) {
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
                int confirm = JOptionPane.showConfirmDialog(null,
                        "¿Está seguro de que desea eliminar este registro?",
                        "Confirmación de eliminación",
                        JOptionPane.YES_NO_OPTION);

                if (confirm == JOptionPane.YES_OPTION) {
                    if (table.isEditing()) {
                        table.getCellEditor().stopCellEditing();
                    }

                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    int idAbono = (int) model.getValueAt(row, 0);

                    eliminarAbono(idAbono);

                    model.removeRow(row);
                }
            }

            @Override
            public void onView(int row) {
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                int idAbono = (int) model.getValueAt(row, 0);

                String sql = "SELECT a.IdAbono, a.IdPago, a.CantidadAbonada, a.FechaAbono, "
                        + "p.CantidadAPagar, p.CantidadPagada, "
                        + "CONCAT(pa.Nombre, ' ', pa.ApellidoPaterno, ' ', pa.ApellidoMaterno) AS NombreCompleto "
                        + "FROM abonos a "
                        + "JOIN pagos p ON a.IdPago = p.IdPago "
                        + "JOIN pacientes pa ON p.IdPaciente = pa.IdPaciente "
                        + "WHERE a.IdAbono = ?";

                try (PreparedStatement pst = reg.prepareStatement(sql)) {
                    pst.setInt(1, idAbono);
                    try (ResultSet rs = pst.executeQuery()) {
                        if (rs.next()) {
                            int idPago = rs.getInt("IdPago");
                            double cantidadAbonada = rs.getDouble("CantidadAbonada");
                            Date fechaAbono = rs.getDate("FechaAbono");
                            double cantidadAPagar = rs.getDouble("CantidadAPagar");
                            double cantidadPagada = rs.getDouble("CantidadPagada");
                            String nombreCompleto = rs.getString("NombreCompleto");

                            String mensaje = String.format("Detalles del Abono:\n\n"
                                    + "ID Abono: %d\n"
                                    + "ID Pago: %d\n"
                                    + "Nombre del Paciente: %s\n"
                                    + "Fecha del Abono: %s\n"
                                    + "Cantidad Abonada: %.2f\n"
                                    + "Cantidad a Pagar: %.2f\n"
                                    + "Cantidad Pagada: %.2f\n\n"
                                    + "Ingrese una nueva cantidad abonada:",
                                    idAbono, idPago, nombreCompleto, fechaAbono.toString(),
                                    cantidadAbonada, cantidadAPagar, cantidadPagada);

                            String nuevaCantidadStr = JOptionPane.showInputDialog(null, mensaje, "Actualizar Cantidad Abonada", JOptionPane.INFORMATION_MESSAGE);

                            if (nuevaCantidadStr != null && !nuevaCantidadStr.isEmpty()) {
                                double nuevaCantidad = Double.parseDouble(nuevaCantidadStr);

                                if (nuevaCantidad < 0) {
                                    JOptionPane.showMessageDialog(null, "La cantidad abonada no puede ser negativa.", "Error", JOptionPane.ERROR_MESSAGE);
                                    return;
                                }

                                double diferencia = nuevaCantidad - cantidadAbonada;
                                double cantidadRestante = cantidadAPagar - cantidadPagada;

                                if (cantidadPagada + diferencia < 0) {
                                    JOptionPane.showMessageDialog(null, "La cantidad pagada no puede ser negativa.", "Error", JOptionPane.ERROR_MESSAGE);
                                    return;
                                }

                                if (cantidadPagada + diferencia > cantidadAPagar) {
                                    JOptionPane.showMessageDialog(null, "La cantidad abonada no puede superar el total a pagar.", "Error", JOptionPane.ERROR_MESSAGE);
                                    return;
                                }

                                String updateAbonoSql = "UPDATE abonos SET CantidadAbonada = ? WHERE IdAbono = ?";
                                String updatePagoSql = "UPDATE pagos SET CantidadPagada = CantidadPagada + ? WHERE IdPago = ?";

                                try (PreparedStatement pst1 = reg.prepareStatement(updateAbonoSql); PreparedStatement pst2 = reg.prepareStatement(updatePagoSql)) {

                                    pst1.setDouble(1, nuevaCantidad);
                                    pst1.setInt(2, idAbono);
                                    pst1.executeUpdate();

                                    pst2.setDouble(1, diferencia);
                                    pst2.setInt(2, idPago);
                                    pst2.executeUpdate();

                                    model.setValueAt(nuevaCantidad, row, 4);

                                    JOptionPane.showMessageDialog(null, "Cantidad abonada actualizada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "No se encontraron detalles para este abono.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error al obtener los detalles del abono: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

        };
        table.getColumnModel().getColumn(5).setCellRenderer(new TableActionCellRender());
        table.getColumnModel().getColumn(5).setCellEditor(new TableActionCellEditor(event));
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
        mostrarAbonos();

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
      private void filterTable() {
        String query = Buscar.getText().toLowerCase();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + query));
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
        btnAgregarPago1 = new Items.MyButton();
        btnRegresar = new Items.MyButton();

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
        titulo.setText("Historial de pagos");
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
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Pago Referencia", "Nombre del paciente", "Fecha de Pago", "Precio de la consulta", "Cantidad pagada", "Acciones"
            }
        ));
        table.setRowHeight(50);
        jScrollPane1.setViewportView(table);

        panelRound1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, 980, 390));

        btnAgregarPago1.setBackground(new java.awt.Color(250, 246, 238));
        btnAgregarPago1.setForeground(new java.awt.Color(120, 79, 71));
        btnAgregarPago1.setText("Agregar Pagos");
        btnAgregarPago1.setColor(new java.awt.Color(250, 246, 238));
        btnAgregarPago1.setColorOver(new java.awt.Color(216, 198, 179));
        btnAgregarPago1.setRadius(40);
        btnAgregarPago1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPago1ActionPerformed(evt);
            }
        });
        panelRound1.add(btnAgregarPago1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 90, 180, 50));

        btnRegresar.setBackground(new java.awt.Color(250, 246, 238));
        btnRegresar.setForeground(new java.awt.Color(120, 79, 71));
        btnRegresar.setText("Regresar");
        btnRegresar.setColor(new java.awt.Color(250, 246, 238));
        btnRegresar.setColorOver(new java.awt.Color(216, 198, 179));
        btnRegresar.setRadius(40);
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        panelRound1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 550, 130, 50));

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

    private void btnAgregarPago1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPago1ActionPerformed
        new AddPago(idDoctor).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAgregarPago1ActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        MenuDocPagos menuPrincipal = new MenuDocPagos(idDoctor);
        menuPrincipal.setVisible(true);
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegresarActionPerformed

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
            java.util.logging.Logger.getLogger(ViewAbonos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewAbonos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewAbonos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewAbonos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LoginDoc loginDoc = new LoginDoc();
                int idDoctor = loginDoc.getIdDoctor();
                new ViewAbonos(idDoctor).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Items.TextField Buscar;
    private javax.swing.JPanel PrincipalPanel;
    private Items.MyButton btnAgregarPago;
    private Items.MyButton btnAgregarPago1;
    private Items.MyButton btnRegresar;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private Items.PanelRound panelRound1;
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

    private void mostrarAbonos() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        String sql = "SELECT a.IdAbono, CONCAT(pa.Nombre, ' ', pa.ApellidoPaterno, ' ', pa.ApellidoMaterno) AS NombreCompleto, "
                + "p.FechaPago, p.CantidadAPagar, a.CantidadAbonada "
                + "FROM abonos a "
                + "JOIN pagos p ON a.IdPago = p.IdPago "
                + "JOIN pacientes pa ON p.IdPaciente = pa.IdPaciente "
                + "WHERE p.IdDoctor = ?";
        try (PreparedStatement pst = reg.prepareStatement(sql)) {
            pst.setInt(1, idDoctor);
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    Object[] row = new Object[]{
                        rs.getInt("IdAbono"),
                        rs.getString("NombreCompleto"),
                        rs.getDate("FechaPago"),
                        rs.getDouble("CantidadAPagar"),
                        rs.getDouble("CantidadAbonada")
                    };
                    model.addRow(row);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al cargar abonos: " + ex.getMessage());
        }
    }

    private void eliminarAbono(int idAbono) {
        String getAbonoDetailsSql = "SELECT IdPago, CantidadAbonada FROM abonos WHERE IdAbono = ?";
        String updatePagoSql = "UPDATE pagos SET CantidadPagada = CantidadPagada - ? WHERE IdPago = ?";
        String deleteAbonoSql = "DELETE FROM abonos WHERE IdAbono = ?";

        try (PreparedStatement pst1 = reg.prepareStatement(getAbonoDetailsSql)) {
            pst1.setInt(1, idAbono);
            try (ResultSet rs = pst1.executeQuery()) {
                if (rs.next()) {
                    int idPago = rs.getInt("IdPago");
                    double cantidadAbonada = rs.getDouble("CantidadAbonada");

                    try (PreparedStatement pst2 = reg.prepareStatement(updatePagoSql)) {
                        pst2.setDouble(1, cantidadAbonada);
                        pst2.setInt(2, idPago);
                        pst2.executeUpdate();
                    }

                    try (PreparedStatement pst3 = reg.prepareStatement(deleteAbonoSql)) {
                        pst3.setInt(1, idAbono);
                        int rowsAffected = pst3.executeUpdate();
                        if (rowsAffected > 0) {
                            JOptionPane.showMessageDialog(this, "Registro eliminado exitosamente.");
                        } else {
                            JOptionPane.showMessageDialog(this, "No se pudo eliminar el registro.");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontró el abono.");
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al eliminar el abono: " + ex.getMessage());
        }
    }

}
