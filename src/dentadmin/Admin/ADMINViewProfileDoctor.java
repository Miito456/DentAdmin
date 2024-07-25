package dentadmin.Admin;

import Items_cell.TableActionCellEditor;
import Items_cell.TableActionCellRender;
import Items_cell.TableActionEvent;
import dentadmin.Connect;
import dentadmin.LoginDoc;
import dentadmin.MenusDoctores.MenuDocPacientes;
import java.awt.Color;
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

public class ADMINViewProfileDoctor extends javax.swing.JFrame {

    FondoPanel fondo = new FondoPanel();
    Connect con = new Connect();
    Connection reg = con.conexion();

    private FileInputStream fis;
    private int longitudBytes;
    private Font customFont;
    private int idDoctor;
    private int idPaciente;
    private MenuDocPacientes menuDoc;

    public ADMINViewProfileDoctor() {
        this.idPaciente = idPaciente;
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
            System.out.println("Font unavailable" + e);
        }
        System.out.println("CHECANDOOO profilepatient " + idDoctor);
        loadDoctorData(idDoctor);
    }

    private void loadDoctorData(int idDoctor) {
        String sql = "SELECT d.CedulaProfesional, d.Nombre, d.ApellidoPaterno, d.ApellidoMaterno, d.Curp, "
                + "d.FechaNacimiento, d.Genero, d.Calle, d.Colonia, d.NumInterior, d.NumExterior, d.Telefono, "
                + "d.Email, d.Foto, e.Nombre AS Especialidad, l.Email AS Usuario, l.Contraseña "
                + "FROM doctores d "
                + "JOIN doctoresespecialidad de ON d.IdDoctor = de.IdDoctor "
                + "JOIN especialidades e ON de.IdEspecialidad = e.IdEspecialidad "
                + "JOIN logindoctores l ON d.IdDoctor = l.IdDoctor "
                + "WHERE d.IdDoctor = ?";

        try {
            PreparedStatement pst = reg.prepareStatement(sql);
            pst.setInt(1, idDoctor);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                txtCedula.setText(rs.getString("CedulaProfesional"));
                txtNombre.setText(rs.getString("Nombre"));
                txtApaterno.setText(rs.getString("ApellidoPaterno"));
                txtAmaterno.setText(rs.getString("ApellidoMaterno"));
                txtCurp.setText(rs.getString("Curp"));
                DateChooseFechaNac.setDate(rs.getDate("FechaNacimiento"));
                cmbGenero.setSelectedItem(rs.getString("Genero"));
                txtCalle.setText(rs.getString("Calle"));
                txtColonia.setText(rs.getString("Colonia"));
                txtNuminterior.setText(rs.getString("NumInterior"));
                txtNumexterior.setText(rs.getString("NumExterior"));
                txtTelefono.setText(rs.getString("Telefono"));
                txtEmail.setText(rs.getString("Email"));
                cmbEspecialidad.setSelectedItem(rs.getString("Especialidad"));
                txtUsuario.setText(rs.getString("Usuario"));
                txtContra.setText(rs.getString("Contraseña"));

                byte[] imgBytes = rs.getBytes("Foto");
                if (imgBytes != null) {
                    ImageIcon imageIcon = new ImageIcon(new ImageIcon(imgBytes).getImage().getScaledInstance(jFoto.getWidth(), jFoto.getHeight(), Image.SCALE_SMOOTH));
                    jFoto.setIcon(imageIcon);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al cargar los datos del doctor", "Error", JOptionPane.ERROR_MESSAGE);
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
        txtCalle = new Items.TextField();
        txtCurp = new Items.TextField();
        txtCedula = new Items.TextField();
        txtNombre = new Items.TextField();
        DateChooseFechaNac = new com.toedter.calendar.JDateChooser();
        txtApaterno = new Items.TextField();
        cmbGenero = new Items.Combobox();
        txtNumexterior = new Items.TextField();
        cmbEspecialidad = new Items.Combobox();
        txtAmaterno = new Items.TextField();
        txtNuminterior = new Items.TextField();
        txtEmail = new Items.TextField();
        txtColonia = new Items.TextField();
        txtTelefono = new Items.TextField();
        panelRound2 = new Items.PanelRound();
        jFoto = new javax.swing.JLabel();
        txtUsuario = new Items.TextField();
        txtContra = new Items.TextField();
        panelRound3 = new Items.PanelRound();
        menuCerrarsesion = new Items.MyButton();
        menuPacientes = new Items.MyButton();
        menuPacientes1 = new Items.MyButton();

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
        titulo.setText("Infromacion del doctor");
        panelRound1.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, 510, 60));

        txtCalle.setBackground(new java.awt.Color(251, 246, 239));
        txtCalle.setForeground(new java.awt.Color(116, 76, 68));
        txtCalle.setLabelText("Calle");
        txtCalle.setLineColor(new java.awt.Color(125, 84, 75));
        panelRound1.add(txtCalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 370, 280, -1));

        txtCurp.setBackground(new java.awt.Color(251, 246, 239));
        txtCurp.setForeground(new java.awt.Color(116, 76, 68));
        txtCurp.setLabelText("Curp");
        txtCurp.setLineColor(new java.awt.Color(125, 84, 75));
        panelRound1.add(txtCurp, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 230, 280, -1));

        txtCedula.setBackground(new java.awt.Color(251, 246, 239));
        txtCedula.setForeground(new java.awt.Color(116, 76, 68));
        txtCedula.setLabelText("Cédula Profesional");
        txtCedula.setLineColor(new java.awt.Color(125, 84, 75));
        panelRound1.add(txtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 280, -1));

        txtNombre.setBackground(new java.awt.Color(251, 246, 239));
        txtNombre.setForeground(new java.awt.Color(116, 76, 68));
        txtNombre.setLabelText("Nombre");
        txtNombre.setLineColor(new java.awt.Color(125, 84, 75));
        panelRound1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 90, 280, -1));
        panelRound1.add(DateChooseFechaNac, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 230, 280, 50));

        txtApaterno.setBackground(new java.awt.Color(251, 246, 239));
        txtApaterno.setForeground(new java.awt.Color(116, 76, 68));
        txtApaterno.setLabelText("Apellido paterno");
        txtApaterno.setLineColor(new java.awt.Color(125, 84, 75));
        panelRound1.add(txtApaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 160, 280, -1));

        cmbGenero.setForeground(new java.awt.Color(125, 84, 75));
        cmbGenero.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Masculino", "Femenino" }));
        cmbGenero.setSelectedIndex(-1);
        cmbGenero.setLabeText("Genero");
        cmbGenero.setLineColor(new java.awt.Color(125, 84, 75));
        panelRound1.add(cmbGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 300, 280, 50));

        txtNumexterior.setBackground(new java.awt.Color(251, 246, 239));
        txtNumexterior.setForeground(new java.awt.Color(116, 76, 68));
        txtNumexterior.setLabelText("Número exterior");
        txtNumexterior.setLineColor(new java.awt.Color(125, 84, 75));
        panelRound1.add(txtNumexterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 440, 280, -1));

        cmbEspecialidad.setForeground(new java.awt.Color(125, 84, 75));
        cmbEspecialidad.setLabeText("Especialidad");
        cmbEspecialidad.setLineColor(new java.awt.Color(125, 84, 75));
        panelRound1.add(cmbEspecialidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 300, 280, 50));

        txtAmaterno.setBackground(new java.awt.Color(251, 246, 239));
        txtAmaterno.setForeground(new java.awt.Color(116, 76, 68));
        txtAmaterno.setLabelText("Apellido materno");
        txtAmaterno.setLineColor(new java.awt.Color(125, 84, 75));
        panelRound1.add(txtAmaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 160, 280, -1));

        txtNuminterior.setBackground(new java.awt.Color(251, 246, 239));
        txtNuminterior.setForeground(new java.awt.Color(116, 76, 68));
        txtNuminterior.setLabelText("Número interior");
        txtNuminterior.setLineColor(new java.awt.Color(125, 84, 75));
        panelRound1.add(txtNuminterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 440, 280, -1));

        txtEmail.setBackground(new java.awt.Color(251, 246, 239));
        txtEmail.setForeground(new java.awt.Color(116, 76, 68));
        txtEmail.setLabelText("Email");
        txtEmail.setLineColor(new java.awt.Color(125, 84, 75));
        panelRound1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 370, 270, -1));

        txtColonia.setBackground(new java.awt.Color(251, 246, 239));
        txtColonia.setForeground(new java.awt.Color(116, 76, 68));
        txtColonia.setLabelText("Colonia");
        txtColonia.setLineColor(new java.awt.Color(125, 84, 75));
        panelRound1.add(txtColonia, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 370, 280, -1));

        txtTelefono.setBackground(new java.awt.Color(251, 246, 239));
        txtTelefono.setForeground(new java.awt.Color(116, 76, 68));
        txtTelefono.setLabelText("Teléfono");
        txtTelefono.setLineColor(new java.awt.Color(125, 84, 75));
        panelRound1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 440, 270, -1));

        panelRound2.setBackground(new java.awt.Color(112, 77, 71));
        panelRound2.setRoundBottomLeft(50);
        panelRound2.setRoundBottomRight(50);
        panelRound2.setRoundTopLeft(50);
        panelRound2.setRoundTopRight(50);
        panelRound2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jFoto.setBackground(new java.awt.Color(112, 77, 71));
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
        panelRound2.add(jFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 270));

        panelRound1.add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, 230, 260));

        txtUsuario.setBackground(new java.awt.Color(251, 246, 239));
        txtUsuario.setForeground(new java.awt.Color(116, 76, 68));
        txtUsuario.setLabelText("Usuario");
        txtUsuario.setLineColor(new java.awt.Color(125, 84, 75));
        panelRound1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 520, 280, -1));

        txtContra.setBackground(new java.awt.Color(251, 246, 239));
        txtContra.setForeground(new java.awt.Color(116, 76, 68));
        txtContra.setLabelText("Contraseña");
        txtContra.setLineColor(new java.awt.Color(125, 84, 75));
        panelRound1.add(txtContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 520, 280, -1));

        panelRound3.setBackground(new java.awt.Color(112, 77, 71));
        panelRound3.setRoundBottomLeft(100);
        panelRound3.setRoundBottomRight(50);
        panelRound3.setRoundTopLeft(50);
        panelRound3.setRoundTopRight(50);
        panelRound3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuCerrarsesion.setBackground(new java.awt.Color(250, 246, 238));
        menuCerrarsesion.setForeground(new java.awt.Color(120, 79, 71));
        menuCerrarsesion.setText("Regresar");
        menuCerrarsesion.setColor(new java.awt.Color(250, 246, 238));
        menuCerrarsesion.setColorOver(new java.awt.Color(216, 198, 179));
        menuCerrarsesion.setRadius(40);
        menuCerrarsesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCerrarsesionActionPerformed(evt);
            }
        });
        panelRound3.add(menuCerrarsesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 189, 44));

        menuPacientes.setBackground(new java.awt.Color(250, 246, 238));
        menuPacientes.setForeground(new java.awt.Color(120, 79, 71));
        menuPacientes.setText("Buscar");
        menuPacientes.setColor(new java.awt.Color(250, 246, 238));
        menuPacientes.setColorOver(new java.awt.Color(216, 198, 179));
        menuPacientes.setRadius(40);
        menuPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPacientesActionPerformed(evt);
            }
        });
        panelRound3.add(menuPacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 189, 44));

        menuPacientes1.setBackground(new java.awt.Color(250, 246, 238));
        menuPacientes1.setForeground(new java.awt.Color(120, 79, 71));
        menuPacientes1.setText("Actualizar datos");
        menuPacientes1.setColor(new java.awt.Color(250, 246, 238));
        menuPacientes1.setColorOver(new java.awt.Color(216, 198, 179));
        menuPacientes1.setRadius(40);
        menuPacientes1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPacientes1ActionPerformed(evt);
            }
        });
        panelRound3.add(menuPacientes1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 189, 44));

        panelRound1.add(panelRound3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 300, 440));

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

    private void jFotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jFotoMouseClicked

    }//GEN-LAST:event_jFotoMouseClicked

    private void menuPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPacientesActionPerformed
    String cedulaProfesional = txtCedula.getText();

    String sql = "SELECT * FROM doctores WHERE CedulaProfesional = ?";

    try {
        PreparedStatement pst = reg.prepareStatement(sql);
        pst.setString(1, cedulaProfesional);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            txtNombre.setText(rs.getString("Nombre"));
            txtApaterno.setText(rs.getString("ApellidoPaterno"));
            txtAmaterno.setText(rs.getString("ApellidoMaterno"));
            txtCurp.setText(rs.getString("Curp"));
            DateChooseFechaNac.setDate(rs.getDate("FechaNacimiento"));
            cmbGenero.setSelectedItem(rs.getString("Genero"));
            txtCalle.setText(rs.getString("Calle"));
            txtColonia.setText(rs.getString("Colonia"));
            txtNuminterior.setText(rs.getString("NumInterior"));
            txtNumexterior.setText(rs.getString("NumExterior"));
            txtTelefono.setText(rs.getString("Telefono"));
            txtEmail.setText(rs.getString("Email"));

            JOptionPane.showMessageDialog(null, "Doctor encontrado");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró ningún doctor con la cédula profesional ingresada", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al buscar al doctor", "Error", JOptionPane.ERROR_MESSAGE);
    }

    }//GEN-LAST:event_menuPacientesActionPerformed

    private void menuCerrarsesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCerrarsesionActionPerformed
        new AdminMenu().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuCerrarsesionActionPerformed

    private void menuPacientes1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPacientes1ActionPerformed
 // Obtener los datos actualizados del doctor
    String cedulaProfesional = txtCedula.getText();
    String nombre = txtNombre.getText();
    String apellidoPaterno = txtApaterno.getText();
    String apellidoMaterno = txtAmaterno.getText();
    String curp = txtCurp.getText();
    java.util.Date fechaNacimiento = DateChooseFechaNac.getDate();
    String genero = (String) cmbGenero.getSelectedItem();
    String calle = txtCalle.getText();
    String colonia = txtColonia.getText();
    String numInterior = txtNuminterior.getText();
    String numExterior = txtNumexterior.getText();
    String telefono = txtTelefono.getText();
    String email = txtEmail.getText();
    String especialidad = (String) cmbEspecialidad.getSelectedItem();
    String usuario = txtUsuario.getText();
    String contraseña = txtContra.getText();

    String sql = "UPDATE doctores SET Nombre = ?, ApellidoPaterno = ?, ApellidoMaterno = ?, Curp = ?, "
            + "FechaNacimiento = ?, Genero = ?, Calle = ?, Colonia = ?, NumInterior = ?, NumExterior = ?, "
            + "Telefono = ?, Email = ? WHERE CedulaProfesional = ?";

    try {
        PreparedStatement pst = reg.prepareStatement(sql);
        pst.setString(1, nombre);
        pst.setString(2, apellidoPaterno);
        pst.setString(3, apellidoMaterno);
        pst.setString(4, curp);
        pst.setDate(5, new java.sql.Date(fechaNacimiento.getTime()));
        pst.setString(6, genero);
        pst.setString(7, calle);
        pst.setString(8, colonia);
        pst.setString(9, numInterior);
        pst.setString(10, numExterior);
        pst.setString(11, telefono);
        pst.setString(12, email);
        pst.setString(13, cedulaProfesional);

        int rowsAffected = pst.executeUpdate();

        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "Datos del doctor actualizados correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar los datos del doctor", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al actualizar los datos del doctor", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_menuPacientes1ActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ADMINViewProfileDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ADMINViewProfileDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ADMINViewProfileDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ADMINViewProfileDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

                new ADMINViewProfileDoctor().setVisible(true);

            }

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateChooseFechaNac;
    private javax.swing.JPanel PrincipalPanel;
    private Items.Combobox cmbEspecialidad;
    private Items.Combobox cmbGenero;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jFoto;
    private javax.swing.JPanel jPanel2;
    private Items.MyButton menuCerrarsesion;
    private Items.MyButton menuPacientes;
    private Items.MyButton menuPacientes1;
    private Items.PanelRound panelRound1;
    private Items.PanelRound panelRound2;
    private Items.PanelRound panelRound3;
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
