package dentadmin.MenusDoctores;

import dentadmin.Connect;
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
import dentadmin.LoginDoc;
import dentadmin.LoginDoc;
import dentadmin.VistasDatosPacientes.ViewProfileDoctor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class MenuPrincipal extends javax.swing.JFrame {

    FondoPanel fondo = new FondoPanel();

    Connect con = new Connect();
    Connection reg = con.conexion();

    private FileInputStream fis;
    private int longitudBytes;
    private Font customFont;
    private int idDoctor;

    public MenuPrincipal(int idDoctor) {
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

        int totalCitas = contarCitasDoctor(idDoctor);
        labelcitas.setText(String.valueOf(totalCitas));
        int totalPacientes = contarPacientesDoctor(idDoctor);
        labelPacientes.setText(String.valueOf(totalPacientes));
        int totalPagos = contarPagosDoctor(idDoctor);
        labelPagos.setText(String.valueOf(totalPagos));
        System.out.println("El id doctor: " + idDoctor);

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
        panelRound2 = new Items.PanelRound();
        menuCerrarsesion = new Items.MyButton();
        menuPacientes = new Items.MyButton();
        menuConsultas = new Items.MyButton();
        menuPagos = new Items.MyButton();
        menuPerfil = new Items.MyButton();
        menuCitas = new Items.MyButton();
        panelRound3 = new Items.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        labelcitas = new javax.swing.JLabel();
        panelRound4 = new Items.PanelRound();
        labelPacientes = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        panelRound5 = new Items.PanelRound();
        jLabel3 = new javax.swing.JLabel();
        labelPagos = new javax.swing.JLabel();

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
        titulo.setText("Menú principal");
        panelRound1.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, 510, 60));

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

        panelRound3.setBackground(new java.awt.Color(248, 239, 230));
        panelRound3.setRoundBottomLeft(50);
        panelRound3.setRoundBottomRight(50);
        panelRound3.setRoundTopLeft(50);
        panelRound3.setRoundTopRight(50);
        panelRound3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Citas");
        panelRound3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, -1, -1));

        labelcitas.setText("0");
        panelRound3.add(labelcitas, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 20, -1));

        panelRound1.add(panelRound3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 180, 250, 200));

        panelRound4.setBackground(new java.awt.Color(248, 239, 230));
        panelRound4.setRoundBottomLeft(50);
        panelRound4.setRoundBottomRight(50);
        panelRound4.setRoundTopLeft(50);
        panelRound4.setRoundTopRight(50);
        panelRound4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelPacientes.setText("0");
        panelRound4.add(labelPacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 110, 30, -1));

        jLabel5.setText("Pacientes");
        panelRound4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, -1, -1));

        panelRound1.add(panelRound4, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 180, 260, 190));

        panelRound5.setBackground(new java.awt.Color(248, 239, 230));
        panelRound5.setRoundBottomLeft(50);
        panelRound5.setRoundBottomRight(50);
        panelRound5.setRoundTopLeft(50);
        panelRound5.setRoundTopRight(50);
        panelRound5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("Pagos");
        panelRound5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, -1, -1));

        labelPagos.setText("0");
        panelRound5.add(labelPagos, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 20, -1));

        panelRound1.add(panelRound5, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 180, 270, 190));

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

    private void menuPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPacientesActionPerformed
        MenuDocPacientes menuPrincipal = new MenuDocPacientes(idDoctor);
        menuPrincipal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuPacientesActionPerformed

    private void menuCerrarsesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCerrarsesionActionPerformed
        new LoginDoc().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuCerrarsesionActionPerformed

    private void menuPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPerfilActionPerformed
       
         new ViewProfileDoctor(idDoctor).setVisible(true);
        this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_menuPerfilActionPerformed

    private void menuConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConsultasActionPerformed
        new MenuDocConsultas(idDoctor).setVisible(true);
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_menuConsultasActionPerformed

    private void menuCitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCitasActionPerformed
        new MenuDocCitas(idDoctor).setVisible(true);
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_menuCitasActionPerformed

    private void menuPagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPagosActionPerformed
        new MenuDocPagos(idDoctor).setVisible(true);
        this.dispose();
// TODO add your handling code here:
    }//GEN-LAST:event_menuPagosActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LoginDoc loginDoc = new LoginDoc();
                int idDoctor = loginDoc.getIdDoctor();
                new MenuPrincipal(idDoctor).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PrincipalPanel;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelPacientes;
    private javax.swing.JLabel labelPagos;
    private javax.swing.JLabel labelcitas;
    private Items.MyButton menuCerrarsesion;
    private Items.MyButton menuCitas;
    private Items.MyButton menuConsultas;
    private Items.MyButton menuPacientes;
    private Items.MyButton menuPagos;
    private Items.MyButton menuPerfil;
    private Items.PanelRound panelRound1;
    private Items.PanelRound panelRound2;
    private Items.PanelRound panelRound3;
    private Items.PanelRound panelRound4;
    private Items.PanelRound panelRound5;
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

    public int contarCitasDoctor(int idDoctor) {
        int count = 0;
        String consulta = "SELECT COUNT(*) AS totalCitas FROM citas WHERE IdDoctor = ?";
        try {
            PreparedStatement ps = reg.prepareStatement(consulta);
            ps.setInt(1, idDoctor);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt("totalCitas");
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return count;
    }

    public int contarPacientesDoctor(int idDoctor) {
        int count = 0;
        String consulta = "SELECT COUNT(*) AS totalPacientes FROM pacientes WHERE IdDoctor = ?";
        try {
            PreparedStatement ps = reg.prepareStatement(consulta);
            ps.setInt(1, idDoctor);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt("totalPacientes");
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        labelPacientes.setText("" + count);
        return count;
    }

    public int contarPagosDoctor(int idDoctor) {
        int count = 0;
        String consulta = "SELECT COUNT(*) AS totalPagos FROM pagos WHERE IdDoctor = ?";
        try {
            PreparedStatement ps = reg.prepareStatement(consulta);
            ps.setInt(1, idDoctor);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt("totalPagos");
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        labelPagos.setText("" + count);
        return count;
    }

}
