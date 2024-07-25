package dentadmin;

import dentadmin.Admin.AdminMenu;
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

public class Main extends javax.swing.JFrame {

    FondoPanel fondo = new FondoPanel();

    Connect con = new Connect();
    Connection reg = con.conexion();

    private FileInputStream fis;
    private int longitudBytes;
    private Font customFont;

    public Main() {
        this.setContentPane(fondo);
        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
        try {
            Font customFont = loadCustomFont("Recoleta-Regular.ttf").deriveFont(Font.PLAIN, 16);
            setFontRecursively(PrincipalPanel, customFont);
            titulo.setFont(loadCustomFont("Recoleta-Bold.ttf").deriveFont(Font.PLAIN, 50));
            texto.setFont(loadCustomFont("Recoleta-Regular.ttf").deriveFont(Font.PLAIN, 20));

            text.setBorder(null);
            text1.setBorder(null);
            text1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
            text1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
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
        jPanel2 = new ConsultorioPanel();
        myButton2 = new Items.MyButton();
        jLabel1 = new javax.swing.JLabel();
        text = new javax.swing.JScrollPane();
        texto = new javax.swing.JTextArea();
        jPanel3 = new LogoPanel();
        text1 = new javax.swing.JScrollPane();
        titulo = new javax.swing.JTextArea();
        myButton3 = new Items.MyButton();

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
        PrincipalPanel.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 20, -1, -1));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        PrincipalPanel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 50, 390, 660));

        myButton2.setForeground(new java.awt.Color(255, 255, 255));
        myButton2.setText("Iniciar sesión");
        myButton2.setRadius(40);
        myButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton2ActionPerformed(evt);
            }
        });
        PrincipalPanel.add(myButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 640, 122, 44));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setForeground(new java.awt.Color(116, 76, 68));
        jLabel1.setText("Let us help you ");
        PrincipalPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, -1, -1));

        texto.setEditable(false);
        texto.setBackground(new java.awt.Color(251, 246, 239));
        texto.setColumns(20);
        texto.setForeground(new java.awt.Color(116, 76, 68));
        texto.setRows(5);
        texto.setText("Zen Dental Studio brings you a modern, calming experience \nthat leaves your teeth healthy and your soul rejuvenated.\n\nCome experience the modern, transformative way to receive \ndental care in San Francisco and Mountain View.");
        texto.setBorder(null);
        text.setViewportView(texto);

        PrincipalPanel.add(text, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 370, 620, 220));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        PrincipalPanel.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 111, 52));

        titulo.setEditable(false);
        titulo.setBackground(new java.awt.Color(251, 246, 239));
        titulo.setColumns(20);
        titulo.setForeground(new java.awt.Color(116, 76, 68));
        titulo.setRows(5);
        titulo.setText("Reconnect with \nyour smile");
        titulo.setBorder(null);
        text1.setViewportView(titulo);

        PrincipalPanel.add(text1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 620, 130));

        myButton3.setForeground(new java.awt.Color(255, 255, 255));
        myButton3.setText("Administrador");
        myButton3.setRadius(40);
        myButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton3ActionPerformed(evt);
            }
        });
        PrincipalPanel.add(myButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 640, 150, 44));

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

    private void myButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton2ActionPerformed
        new LoginDoc().setVisible(true);
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_myButton2ActionPerformed

    private void myButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton3ActionPerformed
        new AdminMenu().setVisible(true);
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_myButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PrincipalPanel;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private Items.MyButton myButton2;
    private Items.MyButton myButton3;
    private javax.swing.JScrollPane text;
    private javax.swing.JScrollPane text1;
    private javax.swing.JTextArea texto;
    private javax.swing.JTextArea titulo;
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

    class ConsultorioPanel extends JPanel {

        private Image imagen;

        @Override
        public void paint(Graphics g) {
            imagen = new ImageIcon(getClass().getResource("/Images/Imagenes.png")).getImage();
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }
    }
}
