package dentadmin.AddThings;

import dentadmin.Connect;
import dentadmin.LoginDoc;
import dentadmin.MenusDoctores.MenuDocConsultas;
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

public class AddConsulta extends javax.swing.JFrame {

    FondoPanel fondo = new FondoPanel();

    Connect con = new Connect();
    Connection reg = con.conexion();

    private FileInputStream fis;
    private int longitudBytes;
    private Font customFont;
    private int idDoctor;

    public AddConsulta(int idDoctor) {
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
        btnAddConsulta = new Items.MyButton();
        txtPrecio = new Items.TextField();
        btnRegresar = new Items.MyButton();
        textAreaScroll1 = new Items.TextAreaScroll();
        textArea1 = new Items.TextArea();
        textAreaScroll2 = new Items.TextAreaScroll();
        textArea2 = new Items.TextArea();
        txtIdenti = new Items.TextField();

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
        titulo.setText("Agregar consulta");
        panelRound1.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, 510, 60));

        btnAddConsulta.setBackground(new java.awt.Color(250, 246, 238));
        btnAddConsulta.setForeground(new java.awt.Color(120, 79, 71));
        btnAddConsulta.setText("Nueva consulta");
        btnAddConsulta.setColor(new java.awt.Color(250, 246, 238));
        btnAddConsulta.setColorOver(new java.awt.Color(216, 198, 179));
        btnAddConsulta.setRadius(40);
        btnAddConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddConsultaActionPerformed(evt);
            }
        });
        panelRound1.add(btnAddConsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 480, 180, 50));

        txtPrecio.setBackground(new java.awt.Color(251, 246, 239));
        txtPrecio.setForeground(new java.awt.Color(116, 76, 68));
        txtPrecio.setLabelText("Precio consulta");
        txtPrecio.setLineColor(new java.awt.Color(125, 84, 75));
        panelRound1.add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 470, 270, -1));

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
        panelRound1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, 130, 50));

        textAreaScroll1.setBackground(new java.awt.Color(248, 239, 230));
        textAreaScroll1.setForeground(new java.awt.Color(248, 239, 230));
        textAreaScroll1.setLabelText("Motivo");
        textAreaScroll1.setLineColor(new java.awt.Color(116, 76, 68));

        textArea1.setBackground(new java.awt.Color(248, 239, 230));
        textArea1.setColumns(20);
        textArea1.setForeground(new java.awt.Color(116, 76, 68));
        textArea1.setRows(5);
        textArea1.setSelectionColor(new java.awt.Color(116, 76, 68));
        textAreaScroll1.setViewportView(textArea1);

        panelRound1.add(textAreaScroll1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 590, 140));

        textAreaScroll2.setBackground(new java.awt.Color(248, 239, 230));
        textAreaScroll2.setForeground(new java.awt.Color(248, 239, 230));
        textAreaScroll2.setLabelText("Tratamiento");
        textAreaScroll2.setLineColor(new java.awt.Color(116, 76, 68));

        textArea2.setBackground(new java.awt.Color(248, 239, 230));
        textArea2.setColumns(20);
        textArea2.setForeground(new java.awt.Color(116, 76, 68));
        textArea2.setRows(5);
        textArea2.setSelectionColor(new java.awt.Color(116, 76, 68));
        textAreaScroll2.setViewportView(textArea2);

        panelRound1.add(textAreaScroll2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 310, 590, 140));

        txtIdenti.setBackground(new java.awt.Color(251, 246, 239));
        txtIdenti.setForeground(new java.awt.Color(116, 76, 68));
        txtIdenti.setLabelText("Identificación");
        txtIdenti.setLineColor(new java.awt.Color(125, 84, 75));
        panelRound1.add(txtIdenti, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, 270, -1));

        PrincipalPanel.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 1010, 560));

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

    private void btnAddConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddConsultaActionPerformed
    String identificacion = txtIdenti.getText().trim();
    String motivo = textArea1.getText().trim();
    String tratamiento = textArea2.getText().trim();
    String precioConsulta = txtPrecio.getText().trim();

    if (identificacion.isEmpty() || motivo.isEmpty() || tratamiento.isEmpty() || precioConsulta.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        String getPacienteSql = "SELECT IdPaciente FROM pacientes WHERE Identificacion = ?";
        int idPaciente = -1;
        try (PreparedStatement getPst = reg.prepareStatement(getPacienteSql)) {
            getPst.setString(1, identificacion);
            ResultSet rs = getPst.executeQuery();
            if (rs.next()) {
                idPaciente = rs.getInt("IdPaciente");
            } else {
                JOptionPane.showMessageDialog(this, "El paciente con identificación " + identificacion + " no existe.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        String sqlConsulta = "INSERT INTO consultas (IdDoctor, IdPaciente, Motivo, Tratamiento, FechaCita, PrecioConsulta) VALUES (?, ?, ?, ?, CURRENT_DATE(), ?)";
        try (PreparedStatement pstConsulta = reg.prepareStatement(sqlConsulta)) {
            pstConsulta.setInt(1, idDoctor);
            pstConsulta.setInt(2, idPaciente);
            pstConsulta.setString(3, motivo);
            pstConsulta.setString(4, tratamiento);
            pstConsulta.setString(5, precioConsulta);

            int rowsAffectedConsulta = pstConsulta.executeUpdate();

            if (rowsAffectedConsulta > 0) {
                JOptionPane.showMessageDialog(this, "La consulta se ha agregado correctamente.", "Consulta Agregada", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo agregar la consulta.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        String sqlPago = "INSERT INTO pagos (IdDoctor, IdPaciente, FechaPago, CantidadAPagar, CantidadPagada) VALUES (?, ?, CURRENT_DATE(), ?, 0)";
        try (PreparedStatement pstPago = reg.prepareStatement(sqlPago)) {
            pstPago.setInt(1, idDoctor);
            pstPago.setInt(2, idPaciente);
            pstPago.setString(3, precioConsulta);

            int rowsAffectedPago = pstPago.executeUpdate();

            if (rowsAffectedPago > 0) {
                JOptionPane.showMessageDialog(this, "El pago se ha registrado correctamente.", "Pago Registrado", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo registrar el pago.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        new MenuDocConsultas(idDoctor).setVisible(true);
        this.dispose();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error al agregar la consulta y el pago: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnAddConsultaActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        MenuDocConsultas menuPrincipal = new MenuDocConsultas(idDoctor);
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
            java.util.logging.Logger.getLogger(AddConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new AddConsulta(idDoctor).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PrincipalPanel;
    private Items.MyButton btnAddConsulta;
    private Items.MyButton btnRegresar;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel2;
    private Items.PanelRound panelRound1;
    private Items.TextArea textArea1;
    private Items.TextArea textArea2;
    private Items.TextAreaScroll textAreaScroll1;
    private Items.TextAreaScroll textAreaScroll2;
    private javax.swing.JLabel titulo;
    private Items.TextField txtIdenti;
    private Items.TextField txtPrecio;
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
