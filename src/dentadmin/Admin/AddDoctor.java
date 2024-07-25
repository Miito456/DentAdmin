package dentadmin.Admin;

import dentadmin.AddThings.AddDoctorSchedule;
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
import java.io.FileNotFoundException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class AddDoctor extends javax.swing.JFrame {

    FondoPanel fondo = new FondoPanel();

    Connect con = new Connect();
    Connection reg = con.conexion();

    private FileInputStream fis;
    private int longitudBytes;
    private Font customFont;
    private int idDoctor;

    public AddDoctor() {
        this.setContentPane(fondo);
        setUndecorated(true);
        initComponents();
        
        
    ((AbstractDocument) txtTelefono.getDocument()).setDocumentFilter(new NumberOnlyFilter());
    ((AbstractDocument) txtNuminterior.getDocument()).setDocumentFilter(new NumberOnlyFilter());
    ((AbstractDocument) txtNumexterior.getDocument()).setDocumentFilter(new NumberOnlyFilter());

        setLocationRelativeTo(null);
        try {
            Font customFont = loadCustomFont("Recoleta-Regular.ttf").deriveFont(Font.PLAIN, 16);
            setFontRecursively(PrincipalPanel, customFont);
            titulo.setFont(loadCustomFont("Recoleta-Regular.ttf").deriveFont(Font.BOLD, 40));

        } catch (Exception e) {
            System.out.println("Font unvaliable" + e);
        }
        cargarEspecialidades();
    }

    
// Implementa un DocumentFilter para aceptar solo números
class NumberOnlyFilter extends DocumentFilter {
    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
        if (string == null) return;
        if (containsOnlyNumbers(string)) {
            super.insertString(fb, offset, string, attr);
        }
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        if (text == null) return;
        if (containsOnlyNumbers(text)) {
            super.replace(fb, offset, length, text, attrs);
        }
    }

    private boolean containsOnlyNumbers(String text) {
        for (int i = 0; i < text.length(); i++) {
            if (!Character.isDigit(text.charAt(i))) {
                return false;
            }
        }
        return true;
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
        txtCedula = new Items.TextField();
        txtNombre = new Items.TextField();
        txtApaterno = new Items.TextField();
        txtAmaterno = new Items.TextField();
        txtCurp = new Items.TextField();
        DateChooseFechaNac = new com.toedter.calendar.JDateChooser();
        txtCalle = new Items.TextField();
        txtColonia = new Items.TextField();
        txtNuminterior = new Items.TextField();
        txtNumexterior = new Items.TextField();
        txtTelefono = new Items.TextField();
        txtEmail = new Items.TextField();
        txtUsuario = new Items.TextField();
        txtContra = new Items.TextField();
        cmbEspecialidad = new Items.Combobox();
        panelRound2 = new Items.PanelRound();
        jFoto = new javax.swing.JLabel();
        btnAgregarDoctor = new Items.MyButton();
        cmbGenero = new Items.Combobox();

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
        titulo.setText("Agregar doctor");
        panelRound1.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, 510, 60));

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

        txtCedula.setBackground(new java.awt.Color(251, 246, 239));
        txtCedula.setForeground(new java.awt.Color(116, 76, 68));
        txtCedula.setLabelText("Cédula Profesional");
        txtCedula.setLineColor(new java.awt.Color(125, 84, 75));
        panelRound1.add(txtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 270, -1));

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
        panelRound1.add(DateChooseFechaNac, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 160, 270, 50));

        txtCalle.setBackground(new java.awt.Color(251, 246, 239));
        txtCalle.setForeground(new java.awt.Color(116, 76, 68));
        txtCalle.setLabelText("Calle");
        txtCalle.setLineColor(new java.awt.Color(125, 84, 75));
        panelRound1.add(txtCalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 270, -1));

        txtColonia.setBackground(new java.awt.Color(251, 246, 239));
        txtColonia.setForeground(new java.awt.Color(116, 76, 68));
        txtColonia.setLabelText("Colonia");
        txtColonia.setLineColor(new java.awt.Color(125, 84, 75));
        panelRound1.add(txtColonia, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 230, 270, -1));

        txtNuminterior.setBackground(new java.awt.Color(251, 246, 239));
        txtNuminterior.setForeground(new java.awt.Color(116, 76, 68));
        txtNuminterior.setLabelText("Número interior");
        txtNuminterior.setLineColor(new java.awt.Color(125, 84, 75));
        panelRound1.add(txtNuminterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 240, 280, -1));

        txtNumexterior.setBackground(new java.awt.Color(251, 246, 239));
        txtNumexterior.setForeground(new java.awt.Color(116, 76, 68));
        txtNumexterior.setLabelText("Número exterior");
        txtNumexterior.setLineColor(new java.awt.Color(125, 84, 75));
        panelRound1.add(txtNumexterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 240, 280, -1));

        txtTelefono.setBackground(new java.awt.Color(251, 246, 239));
        txtTelefono.setForeground(new java.awt.Color(116, 76, 68));
        txtTelefono.setLabelText("Teléfono");
        txtTelefono.setLineColor(new java.awt.Color(125, 84, 75));
        panelRound1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 270, -1));

        txtEmail.setBackground(new java.awt.Color(251, 246, 239));
        txtEmail.setForeground(new java.awt.Color(116, 76, 68));
        txtEmail.setLabelText("Email");
        txtEmail.setLineColor(new java.awt.Color(125, 84, 75));
        panelRound1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 310, 270, -1));

        txtUsuario.setBackground(new java.awt.Color(251, 246, 239));
        txtUsuario.setForeground(new java.awt.Color(116, 76, 68));
        txtUsuario.setLabelText("Usuario");
        txtUsuario.setLineColor(new java.awt.Color(125, 84, 75));
        panelRound1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 340, 270, -1));

        txtContra.setBackground(new java.awt.Color(251, 246, 239));
        txtContra.setForeground(new java.awt.Color(116, 76, 68));
        txtContra.setLabelText("Contraseña");
        txtContra.setLineColor(new java.awt.Color(125, 84, 75));
        panelRound1.add(txtContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 400, 270, -1));

        cmbEspecialidad.setForeground(new java.awt.Color(125, 84, 75));
        cmbEspecialidad.setLabeText("Especialidad");
        cmbEspecialidad.setLineColor(new java.awt.Color(125, 84, 75));
        panelRound1.add(cmbEspecialidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 160, 280, 50));

        panelRound2.setBackground(new java.awt.Color(125, 84, 75));
        panelRound2.setRoundBottomLeft(50);
        panelRound2.setRoundBottomRight(50);
        panelRound2.setRoundTopLeft(50);
        panelRound2.setRoundTopRight(50);
        panelRound2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jFoto.setBackground(new java.awt.Color(202, 232, 106));
        jFoto.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        jFoto.setForeground(new java.awt.Color(255, 255, 255));
        jFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jFoto.setText("Foto");
        jFoto.setToolTipText("");
        jFoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jFotoMouseClicked(evt);
            }
        });
        panelRound2.add(jFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 208, 130));

        panelRound1.add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 380, 260, 130));

        btnAgregarDoctor.setBackground(new java.awt.Color(250, 246, 238));
        btnAgregarDoctor.setForeground(new java.awt.Color(120, 79, 71));
        btnAgregarDoctor.setText("Agregar doctor");
        btnAgregarDoctor.setColor(new java.awt.Color(250, 246, 238));
        btnAgregarDoctor.setColorOver(new java.awt.Color(216, 198, 179));
        btnAgregarDoctor.setRadius(40);
        btnAgregarDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarDoctorActionPerformed(evt);
            }
        });
        panelRound1.add(btnAgregarDoctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 470, 180, 50));

        cmbGenero.setForeground(new java.awt.Color(125, 84, 75));
        cmbGenero.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Masculino", "Femenino" }));
        cmbGenero.setSelectedIndex(-1);
        cmbGenero.setLabeText("Genero");
        cmbGenero.setLineColor(new java.awt.Color(125, 84, 75));
        panelRound1.add(cmbGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 160, 280, 50));

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

    private void jFotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jFotoMouseClicked
        JFileChooser se = new JFileChooser();
        se.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int estado = se.showOpenDialog(null);
        if (estado == JFileChooser.APPROVE_OPTION) {
            try {
                fis = new FileInputStream(se.getSelectedFile());
                this.longitudBytes = (int) se.getSelectedFile().length();
                Image icono = ImageIO.read(se.getSelectedFile()).getScaledInstance(jFoto.getWidth(), jFoto.getHeight(), Image.SCALE_DEFAULT);
                jFoto.setIcon(new ImageIcon(icono));
                jFoto.updateUI();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println("Error: " + e);

            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error segundo catch: " + e);
            }
        }
    }//GEN-LAST:event_jFotoMouseClicked

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        new Main().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnAgregarDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarDoctorActionPerformed
        int doctorId = registrarDoctorEnBaseDeDatos();
        if (doctorId != -1) {
            JOptionPane.showMessageDialog(null, "Doctor registrado exitosamente");
            new AddDoctorSchedule(doctorId).setVisible(true); // Pasa el IdDoctor a la siguiente ventana
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Error al registrar el doctor");
        }
    }//GEN-LAST:event_btnAgregarDoctorActionPerformed

    private int registrarDoctorEnBaseDeDatos() {
        String sqlDoctor = "INSERT INTO doctores (CedulaProfesional, Nombre, ApellidoPaterno, ApellidoMaterno, Curp, FechaNacimiento, Genero, Calle, Colonia, NumInterior, NumExterior, Telefono, Email, Foto) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String sqlLogin = "INSERT INTO logindoctores (IdDoctor, Email, Contraseña) VALUES (?, ?, ?)";
        String sqlDoctorEspecialidad = "INSERT INTO doctoresespecialidad (IdDoctor, IdEspecialidad) VALUES (?, ?)";

        try {
            PreparedStatement pstDoctor = reg.prepareStatement(sqlDoctor, Statement.RETURN_GENERATED_KEYS);
            PreparedStatement pstLogin = reg.prepareStatement(sqlLogin);
            PreparedStatement pstDoctorEspecialidad = reg.prepareStatement(sqlDoctorEspecialidad);

            pstDoctor.setString(1, txtCedula.getText());
            pstDoctor.setString(2, txtNombre.getText());
            pstDoctor.setString(3, txtApaterno.getText());
            pstDoctor.setString(4, txtAmaterno.getText());
            pstDoctor.setString(5, txtCurp.getText());
            pstDoctor.setDate(6, new java.sql.Date(DateChooseFechaNac.getDate().getTime()));
            pstDoctor.setString(7, cmbGenero.getSelectedItem().toString());
            pstDoctor.setString(8, txtCalle.getText());
            pstDoctor.setString(9, txtColonia.getText());
            pstDoctor.setString(10, txtNuminterior.getText());
            pstDoctor.setString(11, txtNumexterior.getText());
            pstDoctor.setString(12, txtTelefono.getText());
            pstDoctor.setString(13, txtEmail.getText());

            if (fis != null) {
                pstDoctor.setBinaryStream(14, fis, longitudBytes);
            } else {
                pstDoctor.setNull(14, java.sql.Types.BLOB);
            }

            int affectedRowsDoctor = pstDoctor.executeUpdate();

            if (affectedRowsDoctor > 0) {
                ResultSet generatedKeysDoctor = pstDoctor.getGeneratedKeys();
                if (generatedKeysDoctor.next()) {
                    int doctorId = generatedKeysDoctor.getInt(1);
                    pstLogin.setInt(1, doctorId);
                    pstLogin.setString(2, txtUsuario.getText());
                    pstLogin.setString(3, txtContra.getText());

                    int affectedRowsLogin = pstLogin.executeUpdate();

                    if (affectedRowsLogin > 0) {
                        // Ahora insertamos en la tabla doctoresespecialidad
                        pstDoctorEspecialidad.setInt(1, doctorId);
                        pstDoctorEspecialidad.setInt(2, cmbEspecialidad.getSelectedIndex() + 1); // Ojo: índice + 1 porque los índices de la base de datos comienzan en 1

                        int affectedRowsDoctorEspecialidad = pstDoctorEspecialidad.executeUpdate();

                        if (affectedRowsDoctorEspecialidad > 0) {
                            return doctorId;
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al registrar el doctor: " + e.getMessage());
        }
        return -1;
    }

    private void cargarEspecialidades() {
        String sql = "SELECT Nombre FROM especialidades";
        try {
            Statement st = reg.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                cmbEspecialidad.addItem(rs.getString("Nombre"));
                cmbEspecialidad.setSelectedIndex(-1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al cargar especialidades: " + e.getMessage());
        }
    }

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
            java.util.logging.Logger.getLogger(AddDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddDoctor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateChooseFechaNac;
    private javax.swing.JPanel PrincipalPanel;
    public Items.MyButton btnAgregarDoctor;
    private Items.MyButton btnRegresar;
    private Items.Combobox cmbEspecialidad;
    private Items.Combobox cmbGenero;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jFoto;
    private javax.swing.JPanel jPanel2;
    private Items.PanelRound panelRound1;
    private Items.PanelRound panelRound2;
    private javax.swing.JLabel titulo;
    private Items.TextField txtAmaterno;
    private Items.TextField txtApaterno;
    private Items.TextField txtCalle;
    private Items.TextField txtCedula;
    private Items.TextField txtColonia;
    private Items.TextField txtContra;
    private Items.TextField txtCurp;
    private Items.TextField txtEmail;
    private Items.TextField txtNombre;
    private Items.TextField txtNumexterior;
    private Items.TextField txtNuminterior;
    private Items.TextField txtTelefono;
    private Items.TextField txtUsuario;
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
