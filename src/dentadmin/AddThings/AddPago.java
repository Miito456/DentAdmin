package dentadmin.AddThings;

import dentadmin.Connect;
import dentadmin.LoginDoc;
import dentadmin.MenusDoctores.MenuDocPagos;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class AddPago extends javax.swing.JFrame {

    FondoPanel fondo = new FondoPanel();

    Connect con = new Connect();
    Connection reg = con.conexion();

    private FileInputStream fis;
    private int longitudBytes;
    private Font customFont;
    private int idDoctor;

    public AddPago(int idDoctor) {
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
        System.out.println("" + idDoctor);
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
        btnNuevoPago = new Items.MyButton();
        btnRegresar = new Items.MyButton();
        txtCanAPagar = new Items.TextField();
        txtReferenciaPago = new Items.TextField();

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
        titulo.setText("Agregar pago");
        panelRound1.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 510, 60));

        btnNuevoPago.setBackground(new java.awt.Color(250, 246, 238));
        btnNuevoPago.setForeground(new java.awt.Color(120, 79, 71));
        btnNuevoPago.setText("Nuevo pago");
        btnNuevoPago.setColor(new java.awt.Color(250, 246, 238));
        btnNuevoPago.setColorOver(new java.awt.Color(216, 198, 179));
        btnNuevoPago.setRadius(40);
        btnNuevoPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoPagoActionPerformed(evt);
            }
        });
        panelRound1.add(btnNuevoPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 350, 180, 50));

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
        panelRound1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 130, 50));

        txtCanAPagar.setBackground(new java.awt.Color(251, 246, 239));
        txtCanAPagar.setForeground(new java.awt.Color(116, 76, 68));
        txtCanAPagar.setLabelText("Cantidad a pagar");
        txtCanAPagar.setLineColor(new java.awt.Color(125, 84, 75));
        panelRound1.add(txtCanAPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 270, -1));

        txtReferenciaPago.setBackground(new java.awt.Color(251, 246, 239));
        txtReferenciaPago.setForeground(new java.awt.Color(116, 76, 68));
        txtReferenciaPago.setLabelText("Referencia Pago");
        txtReferenciaPago.setLineColor(new java.awt.Color(125, 84, 75));
        panelRound1.add(txtReferenciaPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 270, -1));

        PrincipalPanel.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 190, 420, 420));

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

    private void btnNuevoPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoPagoActionPerformed
        try {
            int idPago = Integer.parseInt(txtReferenciaPago.getText());
            double cantidadAbonada = Double.parseDouble(txtCanAPagar.getText());

            String query = "SELECT CantidadAPagar, CantidadPagada FROM pagos WHERE IdPago = ?";
            try (PreparedStatement pst = reg.prepareStatement(query)) {
                pst.setInt(1, idPago);
                try (ResultSet rs = pst.executeQuery()) {
                    if (rs.next()) {
                        double cantidadAPagar = rs.getDouble("CantidadAPagar");
                        double cantidadPagada = rs.getDouble("CantidadPagada");

                        if (cantidadPagada + cantidadAbonada <= cantidadAPagar) {
                            reg.setAutoCommit(false);

                            String updateQuery = "UPDATE pagos SET CantidadPagada = CantidadPagada + ? WHERE IdPago = ?";
                            try (PreparedStatement updatePst = reg.prepareStatement(updateQuery)) {
                                updatePst.setDouble(1, cantidadAbonada);
                                updatePst.setInt(2, idPago);
                                updatePst.executeUpdate();
                            }

                            String insertQuery = "INSERT INTO abonos (IdPago, CantidadAbonada, FechaAbono) VALUES (?, ?, NOW())";
                            try (PreparedStatement insertPst = reg.prepareStatement(insertQuery)) {
                                insertPst.setInt(1, idPago);
                                insertPst.setDouble(2, cantidadAbonada);
                                insertPst.executeUpdate();
                            }

                            reg.commit();

                            JOptionPane.showMessageDialog(this, "Pago registrado exitosamente.");
                            new MenuDocPagos(idDoctor).setVisible(true);
                            this.dispose();
                        } else {
                            JOptionPane.showMessageDialog(this, "La cantidad abonada excede la cantidad a pagar.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "ID de pago no encontrado.");
                    }
                }
            } catch (SQLException ex) {
                reg.rollback();
                JOptionPane.showMessageDialog(this, "Error al registrar el pago: " + ex.getMessage());
            } finally {
                reg.setAutoCommit(true);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error de SQL: " + ex.getMessage());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese valores válidos.");
        }
    }//GEN-LAST:event_btnNuevoPagoActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
         new MenuDocPagos(idDoctor).setVisible(true);
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
            java.util.logging.Logger.getLogger(AddPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                LoginDoc loginDoc = new LoginDoc();
                int idDoctor = loginDoc.getIdDoctor();
                new AddPago(idDoctor).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PrincipalPanel;
    private Items.MyButton btnNuevoPago;
    private Items.MyButton btnRegresar;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel2;
    private Items.PanelRound panelRound1;
    private javax.swing.JLabel titulo;
    private Items.TextField txtCanAPagar;
    private Items.TextField txtReferenciaPago;
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

}
