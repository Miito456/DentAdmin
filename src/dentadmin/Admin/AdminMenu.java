package dentadmin.Admin;

import dentadmin.Admin.ADMINViewProfileDoctor;
import dentadmin.Admin.ADMINViewProfilePatient;
import dentadmin.Connect;
import dentadmin.Main;
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

public class AdminMenu extends javax.swing.JFrame {

    FondoPanel fondo = new FondoPanel();

    Connect con = new Connect();
    Connection reg = con.conexion();

    private FileInputStream fis;
    private int longitudBytes;
    private Font customFont;

    public AdminMenu() {
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
        btnRegresar = new Items.MyButton();
        AltaEspe = new Items.MyButton();
        AltaDoc = new Items.MyButton();
        AltaEspe1 = new Items.MyButton();

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
        titulo.setText("Bienvenido administrador");
        panelRound1.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 620, 60));

        btnRegresar.setBackground(new java.awt.Color(250, 246, 238));
        btnRegresar.setForeground(new java.awt.Color(120, 79, 71));
        btnRegresar.setText("Regresar");
        btnRegresar.setColor(new java.awt.Color(250, 246, 238));
        btnRegresar.setColorOver(new java.awt.Color(216, 198, 179));
        btnRegresar.setPreferredSize(new java.awt.Dimension(99, 23));
        btnRegresar.setRadius(40);
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        panelRound1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 400, 240, 50));

        AltaEspe.setBackground(new java.awt.Color(250, 246, 238));
        AltaEspe.setForeground(new java.awt.Color(120, 79, 71));
        AltaEspe.setText("Editar datos de un paciente");
        AltaEspe.setColor(new java.awt.Color(250, 246, 238));
        AltaEspe.setColorOver(new java.awt.Color(216, 198, 179));
        AltaEspe.setRadius(40);
        AltaEspe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AltaEspeActionPerformed(evt);
            }
        });
        panelRound1.add(AltaEspe, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 310, 240, 50));

        AltaDoc.setBackground(new java.awt.Color(250, 246, 238));
        AltaDoc.setForeground(new java.awt.Color(120, 79, 71));
        AltaDoc.setText("Dar de alta a un doctor");
        AltaDoc.setColor(new java.awt.Color(250, 246, 238));
        AltaDoc.setColorOver(new java.awt.Color(216, 198, 179));
        AltaDoc.setRadius(40);
        AltaDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AltaDocActionPerformed(evt);
            }
        });
        panelRound1.add(AltaDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 240, 50));

        AltaEspe1.setBackground(new java.awt.Color(250, 246, 238));
        AltaEspe1.setForeground(new java.awt.Color(120, 79, 71));
        AltaEspe1.setText("Editar datos de un doctor");
        AltaEspe1.setColor(new java.awt.Color(250, 246, 238));
        AltaEspe1.setColorOver(new java.awt.Color(216, 198, 179));
        AltaEspe1.setRadius(40);
        AltaEspe1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AltaEspe1ActionPerformed(evt);
            }
        });
        panelRound1.add(AltaEspe1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 240, 50));

        PrincipalPanel.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, 640, 530));

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

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        new Main().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed
    public int idDoctor;

    private void AltaEspeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AltaEspeActionPerformed
        new ADMINViewProfilePatient().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_AltaEspeActionPerformed

    private void AltaDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AltaDocActionPerformed
        new AddDoctor().setVisible(true);
        this.dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_AltaDocActionPerformed

    private void AltaEspe1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AltaEspe1ActionPerformed
        new ADMINViewProfileDoctor().setVisible(true);
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_AltaEspe1ActionPerformed

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
            java.util.logging.Logger.getLogger(AdminMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new AdminMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Items.MyButton AltaDoc;
    private Items.MyButton AltaEspe;
    private Items.MyButton AltaEspe1;
    private javax.swing.JPanel PrincipalPanel;
    private Items.MyButton btnRegresar;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel2;
    private Items.PanelRound panelRound1;
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

    public int getIdDoctor() {
        return idDoctor;
    }
}
