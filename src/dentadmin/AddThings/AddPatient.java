package dentadmin.AddThings;

import dentadmin.Connect;
import dentadmin.LoginDoc;
import dentadmin.MenusDoctores.MenuDocPacientes;
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

public class AddPatient extends javax.swing.JFrame {

    FondoPanel fondo = new FondoPanel();

    Connect con = new Connect();
    Connection reg = con.conexion();

    private FileInputStream fis;
    private int longitudBytes;
    private Font customFont;
    private int idDoctor;

    public AddPatient(int idDoctor) {
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
        btnAddPatient = new Items.MyButton();
        txtIdenti = new Items.TextField();
        txtNombre = new Items.TextField();
        txtApaterno = new Items.TextField();
        txtAmaterno = new Items.TextField();
        txtCurp = new Items.TextField();
        DateChooseFechaNac = new com.toedter.calendar.JDateChooser();
        txtTelefono = new Items.TextField();
        txtEmail = new Items.TextField();
        cmbGenero = new Items.Combobox();
        textAreaScroll1 = new Items.TextAreaScroll();
        textArea1 = new Items.TextArea();
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
        titulo.setText("Agregar paciente");
        panelRound1.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, 510, 60));

        btnAddPatient.setBackground(new java.awt.Color(250, 246, 238));
        btnAddPatient.setForeground(new java.awt.Color(120, 79, 71));
        btnAddPatient.setText("Agregar paciente");
        btnAddPatient.setColor(new java.awt.Color(250, 246, 238));
        btnAddPatient.setColorOver(new java.awt.Color(216, 198, 179));
        btnAddPatient.setRadius(40);
        btnAddPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPatientActionPerformed(evt);
            }
        });
        panelRound1.add(btnAddPatient, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 470, 180, 50));

        txtIdenti.setBackground(new java.awt.Color(251, 246, 239));
        txtIdenti.setForeground(new java.awt.Color(116, 76, 68));
        txtIdenti.setLabelText("Identificación");
        txtIdenti.setLineColor(new java.awt.Color(125, 84, 75));
        panelRound1.add(txtIdenti, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 270, -1));

        txtNombre.setBackground(new java.awt.Color(251, 246, 239));
        txtNombre.setForeground(new java.awt.Color(116, 76, 68));
        txtNombre.setLabelText("Nombre");
        txtNombre.setLineColor(new java.awt.Color(125, 84, 75));
        panelRound1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, 270, -1));

        txtApaterno.setBackground(new java.awt.Color(251, 246, 239));
        txtApaterno.setForeground(new java.awt.Color(116, 76, 68));
        txtApaterno.setLabelText("Apellido paterno");
        txtApaterno.setLineColor(new java.awt.Color(125, 84, 75));
        panelRound1.add(txtApaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 90, 280, -1));

        txtAmaterno.setBackground(new java.awt.Color(251, 246, 239));
        txtAmaterno.setForeground(new java.awt.Color(116, 76, 68));
        txtAmaterno.setLabelText("Apellido materno");
        txtAmaterno.setLineColor(new java.awt.Color(125, 84, 75));
        panelRound1.add(txtAmaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 90, 280, -1));

        txtCurp.setBackground(new java.awt.Color(251, 246, 239));
        txtCurp.setForeground(new java.awt.Color(116, 76, 68));
        txtCurp.setLabelText("Curp");
        txtCurp.setLineColor(new java.awt.Color(125, 84, 75));
        panelRound1.add(txtCurp, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 270, -1));

        DateChooseFechaNac.setBackground(new java.awt.Color(248, 239, 230));
        DateChooseFechaNac.setForeground(new java.awt.Color(116, 76, 68));
        panelRound1.add(DateChooseFechaNac, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 160, 270, 50));

        txtTelefono.setBackground(new java.awt.Color(251, 246, 239));
        txtTelefono.setForeground(new java.awt.Color(116, 76, 68));
        txtTelefono.setLabelText("Teléfono");
        txtTelefono.setLineColor(new java.awt.Color(125, 84, 75));
        panelRound1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 270, -1));

        txtEmail.setBackground(new java.awt.Color(248, 239, 230));
        txtEmail.setForeground(new java.awt.Color(116, 76, 68));
        txtEmail.setLabelText("Email");
        txtEmail.setLineColor(new java.awt.Color(125, 84, 75));
        panelRound1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 240, 270, -1));

        cmbGenero.setBackground(new java.awt.Color(248, 239, 230));
        cmbGenero.setForeground(new java.awt.Color(125, 84, 75));
        cmbGenero.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Masculino", "Femenino" }));
        cmbGenero.setSelectedIndex(-1);
        cmbGenero.setLabeText("Genero");
        cmbGenero.setLineColor(new java.awt.Color(125, 84, 75));
        panelRound1.add(cmbGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 160, 280, 50));

        textAreaScroll1.setBackground(new java.awt.Color(248, 239, 230));
        textAreaScroll1.setForeground(new java.awt.Color(248, 239, 230));
        textAreaScroll1.setLabelText("Alergias");
        textAreaScroll1.setLineColor(new java.awt.Color(116, 76, 68));

        textArea1.setBackground(new java.awt.Color(248, 239, 230));
        textArea1.setColumns(20);
        textArea1.setForeground(new java.awt.Color(116, 76, 68));
        textArea1.setRows(5);
        textArea1.setSelectionColor(new java.awt.Color(116, 76, 68));
        textAreaScroll1.setViewportView(textArea1);

        panelRound1.add(textAreaScroll1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 220, 590, 140));

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
        panelRound1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 130, 50));

        PrincipalPanel.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 1260, 530));

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

    private void btnAddPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPatientActionPerformed
        String identificacion = txtIdenti.getText();
        String nombre = txtNombre.getText();
        String aPaterno = txtApaterno.getText();
        String aMaterno = txtAmaterno.getText();
        String curp = txtCurp.getText();
        java.util.Date fechaNacimiento = DateChooseFechaNac.getDate();
        String telefono = txtTelefono.getText();
        String email = txtEmail.getText();
        String genero = (String) cmbGenero.getSelectedItem();
        String alergias = textArea1.getText();

        if (fechaNacimiento != null) {
            java.sql.Date sqlFechaNacimiento = new java.sql.Date(fechaNacimiento.getTime());

            String sql = "INSERT INTO pacientes (Identificacion, Nombre, ApellidoPaterno, ApellidoMaterno, Curp, FechaNacimiento, Genero, Telefono, Email, Alergias,IdDoctor) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement pst = reg.prepareStatement(sql)) {
                pst.setString(1, identificacion);
                pst.setString(2, nombre);
                pst.setString(3, aPaterno);
                pst.setString(4, aMaterno);
                pst.setString(5, curp);
                pst.setDate(6, sqlFechaNacimiento);
                pst.setString(7, genero);
                pst.setString(8, telefono);
                pst.setString(9, email);
                pst.setString(10, alergias);
                pst.setInt(11, idDoctor);

                int rowsInserted = pst.executeUpdate();
                if (rowsInserted > 0) {
                    JOptionPane.showMessageDialog(this, "Paciente agregado exitosamente.");
                    new MenuDocPacientes(idDoctor).setVisible(true);
                    this.dispose();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error al agregar paciente: " + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese una fecha de nacimiento válida.");
        }
    }//GEN-LAST:event_btnAddPatientActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        MenuDocPacientes menuPrincipal = new MenuDocPacientes(idDoctor);
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
            java.util.logging.Logger.getLogger(AddPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LoginDoc loginDoc = new LoginDoc();
                int idDoctor = loginDoc.getIdDoctor();
                new AddPatient(idDoctor).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateChooseFechaNac;
    private javax.swing.JPanel PrincipalPanel;
    private Items.MyButton btnAddPatient;
    private Items.MyButton btnRegresar;
    private Items.Combobox cmbGenero;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel2;
    private Items.PanelRound panelRound1;
    private Items.TextArea textArea1;
    private Items.TextAreaScroll textAreaScroll1;
    private javax.swing.JLabel titulo;
    private Items.TextField txtAmaterno;
    private Items.TextField txtApaterno;
    private Items.TextField txtCurp;
    private Items.TextField txtEmail;
    private Items.TextField txtIdenti;
    private Items.TextField txtNombre;
    private Items.TextField txtTelefono;
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
