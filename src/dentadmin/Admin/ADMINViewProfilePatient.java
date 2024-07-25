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

public class ADMINViewProfilePatient extends javax.swing.JFrame {

    FondoPanel fondo = new FondoPanel();
    Connect con = new Connect();
    Connection reg = con.conexion();

    private FileInputStream fis;
    private int longitudBytes;
    private Font customFont;
    private int idDoctor;
    private int idPaciente;
    private MenuDocPacientes menuDoc;

    public ADMINViewProfilePatient() {
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
        cargarDatosPaciente();
        
    }

    private void cargarDatosPaciente() {
        String sql = "SELECT * FROM pacientes WHERE Identificacion = ?";
        try (PreparedStatement pst = reg.prepareStatement(sql)) {
            pst.setInt(1, idPaciente);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    txtIdenti.setText(rs.getString("Identificacion"));
                    txtNombre.setText(rs.getString("Nombre"));
                    txtApaterno.setText(rs.getString("ApellidoPaterno"));
                    txtAmaterno.setText(rs.getString("ApellidoMaterno"));
                    txtCurp.setText(rs.getString("Curp"));
                    txtTelefono.setText(rs.getString("Telefono"));
                    txtEmail.setText(rs.getString("Email"));
                    DateChooseFechaNac.setDate(rs.getDate("FechaNacimiento"));
                    cmbGenero.setSelectedItem(rs.getString("Genero"));
                    textArea1.setText(rs.getString("Alergias"));
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al cargar datos del paciente: " + ex.getMessage());
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
        txtIdenti = new Items.TextField();
        txtCurp = new Items.TextField();
        txtTelefono = new Items.TextField();
        txtEmail = new Items.TextField();
        DateChooseFechaNac = new com.toedter.calendar.JDateChooser();
        txtNombre = new Items.TextField();
        cmbGenero = new Items.Combobox();
        textAreaScroll1 = new Items.TextAreaScroll();
        textArea1 = new Items.TextArea();
        txtApaterno = new Items.TextField();
        txtAmaterno = new Items.TextField();
        myButton12 = new Items.MyButton();
        panelRound2 = new Items.PanelRound();
        menuPacientes1 = new Items.MyButton();
        menuPacientes = new Items.MyButton();

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
        titulo.setText("Información del paciente");
        panelRound1.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, 510, 60));

        txtIdenti.setBackground(new java.awt.Color(251, 246, 239));
        txtIdenti.setForeground(new java.awt.Color(116, 76, 68));
        txtIdenti.setLabelText("Identificación");
        txtIdenti.setLineColor(new java.awt.Color(125, 84, 75));
        panelRound1.add(txtIdenti, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 240, -1));

        txtCurp.setBackground(new java.awt.Color(251, 246, 239));
        txtCurp.setForeground(new java.awt.Color(116, 76, 68));
        txtCurp.setLabelText("Curp");
        txtCurp.setLineColor(new java.awt.Color(125, 84, 75));
        panelRound1.add(txtCurp, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 310, 270, -1));

        txtTelefono.setBackground(new java.awt.Color(251, 246, 239));
        txtTelefono.setForeground(new java.awt.Color(116, 76, 68));
        txtTelefono.setLabelText("Teléfono");
        txtTelefono.setLineColor(new java.awt.Color(125, 84, 75));
        panelRound1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 370, 270, -1));

        txtEmail.setBackground(new java.awt.Color(248, 239, 230));
        txtEmail.setForeground(new java.awt.Color(116, 76, 68));
        txtEmail.setLabelText("Email");
        txtEmail.setLineColor(new java.awt.Color(125, 84, 75));
        panelRound1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 370, 270, -1));

        DateChooseFechaNac.setBackground(new java.awt.Color(248, 239, 230));
        DateChooseFechaNac.setForeground(new java.awt.Color(116, 76, 68));
        panelRound1.add(DateChooseFechaNac, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 310, 270, 50));

        txtNombre.setBackground(new java.awt.Color(251, 246, 239));
        txtNombre.setForeground(new java.awt.Color(116, 76, 68));
        txtNombre.setLabelText("Nombre");
        txtNombre.setLineColor(new java.awt.Color(125, 84, 75));
        panelRound1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 250, 270, -1));

        cmbGenero.setBackground(new java.awt.Color(248, 239, 230));
        cmbGenero.setForeground(new java.awt.Color(125, 84, 75));
        cmbGenero.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Masculino", "Femenino" }));
        cmbGenero.setSelectedIndex(-1);
        cmbGenero.setLabeText("Genero");
        cmbGenero.setLineColor(new java.awt.Color(125, 84, 75));
        panelRound1.add(cmbGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 310, 280, 50));

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

        panelRound1.add(textAreaScroll1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 430, 590, 140));

        txtApaterno.setBackground(new java.awt.Color(251, 246, 239));
        txtApaterno.setForeground(new java.awt.Color(116, 76, 68));
        txtApaterno.setLabelText("Apellido paterno");
        txtApaterno.setLineColor(new java.awt.Color(125, 84, 75));
        panelRound1.add(txtApaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 250, 280, -1));

        txtAmaterno.setBackground(new java.awt.Color(251, 246, 239));
        txtAmaterno.setForeground(new java.awt.Color(116, 76, 68));
        txtAmaterno.setLabelText("Apellido materno");
        txtAmaterno.setLineColor(new java.awt.Color(125, 84, 75));
        panelRound1.add(txtAmaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 240, 280, -1));

        myButton12.setBackground(new java.awt.Color(250, 246, 238));
        myButton12.setForeground(new java.awt.Color(120, 79, 71));
        myButton12.setText("Regresar");
        myButton12.setColor(new java.awt.Color(250, 246, 238));
        myButton12.setColorOver(new java.awt.Color(216, 198, 179));
        myButton12.setRadius(40);
        myButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton12ActionPerformed(evt);
            }
        });
        panelRound1.add(myButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 560, 189, 44));

        panelRound2.setBackground(new java.awt.Color(112, 77, 71));
        panelRound2.setRoundBottomLeft(100);
        panelRound2.setRoundBottomRight(50);
        panelRound2.setRoundTopLeft(50);
        panelRound2.setRoundTopRight(50);
        panelRound2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuPacientes1.setBackground(new java.awt.Color(250, 246, 238));
        menuPacientes1.setForeground(new java.awt.Color(120, 79, 71));
        menuPacientes1.setText("Buscar");
        menuPacientes1.setColor(new java.awt.Color(250, 246, 238));
        menuPacientes1.setColorOver(new java.awt.Color(216, 198, 179));
        menuPacientes1.setRadius(40);
        menuPacientes1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPacientes1ActionPerformed(evt);
            }
        });
        panelRound2.add(menuPacientes1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 189, 44));

        panelRound1.add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 300, 310));

        menuPacientes.setBackground(new java.awt.Color(250, 246, 238));
        menuPacientes.setForeground(new java.awt.Color(120, 79, 71));
        menuPacientes.setText("Actualizar datos");
        menuPacientes.setColor(new java.awt.Color(250, 246, 238));
        menuPacientes.setColorOver(new java.awt.Color(216, 198, 179));
        menuPacientes.setRadius(40);
        menuPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPacientesActionPerformed(evt);
            }
        });
        panelRound1.add(menuPacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 500, 189, 44));

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

    private void myButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton12ActionPerformed
        AdminMenu menuPrincipal = new AdminMenu();
        menuPrincipal.setVisible(true);
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_myButton12ActionPerformed

    private void menuPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPacientesActionPerformed
    String identificacion = txtIdenti.getText();
    String nombre = txtNombre.getText();
    String apellidoPaterno = txtApaterno.getText();
    String apellidoMaterno = txtAmaterno.getText();
    String curp = txtCurp.getText();
    String telefono = txtTelefono.getText();
    String email = txtEmail.getText();
    String genero = (String) cmbGenero.getSelectedItem();
    java.util.Date fechaNacimiento = DateChooseFechaNac.getDate();
    String alergias = textArea1.getText();

    if (!identificacion.isEmpty() && fechaNacimiento != null) {
        java.sql.Date sqlFechaNacimiento = new java.sql.Date(fechaNacimiento.getTime());

        String sql = "UPDATE pacientes SET Nombre = ?, ApellidoPaterno = ?, ApellidoMaterno = ?, Curp = ?, Telefono = ?, Email = ?, FechaNacimiento = ?, Genero = ?, Alergias = ? WHERE Identificacion = ?";
        try (PreparedStatement pst = reg.prepareStatement(sql)) {
            pst.setString(1, nombre);
            pst.setString(2, apellidoPaterno);
            pst.setString(3, apellidoMaterno);
            pst.setString(4, curp);
            pst.setString(5, telefono);
            pst.setString(6, email);
            pst.setDate(7, sqlFechaNacimiento);
            pst.setString(8, genero);
            pst.setString(9, alergias);
            pst.setString(10, identificacion);

            int affectedRows = pst.executeUpdate();
            if (affectedRows > 0) {
                JOptionPane.showMessageDialog(this, "Datos actualizados correctamente");
            } else {
                JOptionPane.showMessageDialog(this, "Error: no se encontró el paciente con la identificación proporcionada");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al actualizar los datos del paciente: " + ex.getMessage());
        }
    } else {
        JOptionPane.showMessageDialog(this, "Por favor ingrese una identificación válida y fecha de nacimiento");
    }      
    }//GEN-LAST:event_menuPacientesActionPerformed

    private void menuPacientes1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPacientes1ActionPerformed
        String identificacion = txtIdenti.getText();
    if (!identificacion.isEmpty()) {
        String sql = "SELECT * FROM pacientes WHERE Identificacion = ?";
        try (PreparedStatement pst = reg.prepareStatement(sql)) {
            pst.setString(1, identificacion);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    txtNombre.setText(rs.getString("Nombre"));
                    txtApaterno.setText(rs.getString("ApellidoPaterno"));
                    txtAmaterno.setText(rs.getString("ApellidoMaterno"));
                    txtCurp.setText(rs.getString("Curp"));
                    txtTelefono.setText(rs.getString("Telefono"));
                    txtEmail.setText(rs.getString("Email"));
                    DateChooseFechaNac.setDate(rs.getDate("FechaNacimiento"));
                    cmbGenero.setSelectedItem(rs.getString("Genero"));
                    textArea1.setText(rs.getString("Alergias"));
                } else {
                    JOptionPane.showMessageDialog(this, "Paciente no encontrado");
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al buscar paciente: " + ex.getMessage());
        }
    } else {
        JOptionPane.showMessageDialog(this, "Por favor ingrese una identificación");
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
            java.util.logging.Logger.getLogger(ADMINViewProfilePatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ADMINViewProfilePatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ADMINViewProfilePatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ADMINViewProfilePatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LoginDoc loginDoc = new LoginDoc();
                int idDoctor = loginDoc.getIdDoctor();
                MenuDocPacientes menuDoc = new MenuDocPacientes(idDoctor);
                int idPaciente = menuDoc.getIdPacienteSeleccionado();
                if (idPaciente != -1) {
                    new ADMINViewProfilePatient().setVisible(true);
                } else {
                    System.out.println("No patient selected");
                }
            }

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateChooseFechaNac;
    private javax.swing.JPanel PrincipalPanel;
    private Items.Combobox cmbGenero;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel2;
    private Items.MyButton menuPacientes;
    private Items.MyButton menuPacientes1;
    private Items.MyButton myButton12;
    private Items.PanelRound panelRound1;
    private Items.PanelRound panelRound2;
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
