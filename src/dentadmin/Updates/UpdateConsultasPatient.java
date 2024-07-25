package dentadmin.Updates;

import dentadmin.MenusDoctores.MenuDocConsultas;
import dentadmin.MenusDoctores.MenuDocPacientes;
import Items_cell.TableActionCellEditor;
import Items_cell.TableActionCellRender;
import Items_cell.TableActionEvent;
import dentadmin.Connect;
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

public class UpdateConsultasPatient extends javax.swing.JFrame {

    FondoPanel fondo = new FondoPanel();
    Connect con = new Connect();
    Connection reg = con.conexion();

    private FileInputStream fis;
    private int longitudBytes;
    private Font customFont;
    private int idDoctor;
    private int idPaciente;
    private MenuDocPacientes menuDoc;
    private MenuDocPacientes parentFrame;
    private int idConsulta;

    public UpdateConsultasPatient(int idPaciente, int idDoctor, int idConsulta, MenuDocConsultas parentFrame) {
        this.idPaciente = idPaciente;
        this.idDoctor = idDoctor;
        this.idConsulta = idConsulta;
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
        cargarDatosConsulta();
    }

    private void cargarDatosConsulta() {
        try {
            System.out.println("ID del paciente recuperado: " + idPaciente); 

            String queryConsulta = "SELECT p.Identificacion, CONCAT(p.Nombre, ' ', p.ApellidoPaterno, ' ', p.ApellidoMaterno) AS NombreCompleto, "
                    + "c.Motivo, c.Tratamiento, c.PrecioConsulta "
                    + "FROM pacientes p "
                    + "JOIN consultas c ON p.IdPaciente = c.IdPaciente "
                    + "WHERE p.IdPaciente = ? AND c.IdConsulta = ?";
            PreparedStatement pstConsulta = reg.prepareStatement(queryConsulta);
            pstConsulta.setInt(1, idPaciente);
            pstConsulta.setInt(2, idConsulta);
            ResultSet rsConsulta = pstConsulta.executeQuery();

            if (rsConsulta.next()) {
                String identificacion = rsConsulta.getString("Identificacion");
                String nombreCompleto = rsConsulta.getString("NombreCompleto");
                String motivoConsulta = rsConsulta.getString("Motivo");
                String tratamiento = rsConsulta.getString("Tratamiento");
                String precioConsulta = rsConsulta.getString("PrecioConsulta");

                txtIdenti.setText(identificacion);
                txtNombre1.setText(nombreCompleto);
                textArea2.setText(motivoConsulta);
                textArea1.setText(tratamiento);
                txtPrecio.setText(precioConsulta);

                pstConsulta.close();
                rsConsulta.close();
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró ninguna consulta con el idPaciente y idConsulta proporcionados.");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al cargar los datos de la consulta: " + ex.getMessage());
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
        txtPrecio = new Items.TextField();
        textAreaScroll1 = new Items.TextAreaScroll();
        textArea1 = new Items.TextArea();
        myButton12 = new Items.MyButton();
        textAreaScroll2 = new Items.TextAreaScroll();
        textArea2 = new Items.TextArea();
        txtNombre1 = new Items.TextField();
        myButton13 = new Items.MyButton();

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
        titulo.setText("Actualizar consulta");
        panelRound1.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 30, 510, 60));

        txtIdenti.setBackground(new java.awt.Color(251, 246, 239));
        txtIdenti.setForeground(new java.awt.Color(116, 76, 68));
        txtIdenti.setLabelText("Identificacion");
        txtIdenti.setLineColor(new java.awt.Color(125, 84, 75));
        panelRound1.add(txtIdenti, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, 270, -1));

        txtPrecio.setBackground(new java.awt.Color(251, 246, 239));
        txtPrecio.setForeground(new java.awt.Color(116, 76, 68));
        txtPrecio.setLabelText("Precio consulta");
        txtPrecio.setLineColor(new java.awt.Color(125, 84, 75));
        panelRound1.add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 450, 270, -1));

        textAreaScroll1.setBackground(new java.awt.Color(248, 239, 230));
        textAreaScroll1.setForeground(new java.awt.Color(248, 239, 230));
        textAreaScroll1.setLabelText("Tratamiento");
        textAreaScroll1.setLineColor(new java.awt.Color(116, 76, 68));

        textArea1.setBackground(new java.awt.Color(248, 239, 230));
        textArea1.setColumns(20);
        textArea1.setForeground(new java.awt.Color(116, 76, 68));
        textArea1.setRows(5);
        textArea1.setSelectionColor(new java.awt.Color(116, 76, 68));
        textAreaScroll1.setViewportView(textArea1);

        panelRound1.add(textAreaScroll1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 230, 590, 140));

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
        panelRound1.add(myButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 560, 189, 44));

        textAreaScroll2.setBackground(new java.awt.Color(248, 239, 230));
        textAreaScroll2.setForeground(new java.awt.Color(248, 239, 230));
        textAreaScroll2.setLabelText("Motivo");
        textAreaScroll2.setLineColor(new java.awt.Color(116, 76, 68));

        textArea2.setBackground(new java.awt.Color(248, 239, 230));
        textArea2.setColumns(20);
        textArea2.setForeground(new java.awt.Color(116, 76, 68));
        textArea2.setRows(5);
        textArea2.setSelectionColor(new java.awt.Color(116, 76, 68));
        textAreaScroll2.setViewportView(textArea2);

        panelRound1.add(textAreaScroll2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 590, 140));

        txtNombre1.setBackground(new java.awt.Color(251, 246, 239));
        txtNombre1.setForeground(new java.awt.Color(116, 76, 68));
        txtNombre1.setLabelText("Nombre del paciente");
        txtNombre1.setLineColor(new java.awt.Color(125, 84, 75));
        panelRound1.add(txtNombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 120, 270, -1));

        myButton13.setBackground(new java.awt.Color(250, 246, 238));
        myButton13.setForeground(new java.awt.Color(120, 79, 71));
        myButton13.setText("Actualizar datos");
        myButton13.setColor(new java.awt.Color(250, 246, 238));
        myButton13.setColorOver(new java.awt.Color(216, 198, 179));
        myButton13.setRadius(40);
        myButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton13ActionPerformed(evt);
            }
        });
        panelRound1.add(myButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 560, 189, 44));

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
        MenuDocConsultas menuPrincipal = new MenuDocConsultas(idDoctor);
        menuPrincipal.setVisible(true);
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_myButton12ActionPerformed

    private void myButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton13ActionPerformed

        try {
            String motivo = textArea2.getText();
            String tratamiento = textArea1.getText();
            String precioConsulta = txtPrecio.getText();


            String updateConsulta = "UPDATE consultas SET Motivo = ?, Tratamiento = ?, PrecioConsulta = ? WHERE IdConsulta = ?";
            PreparedStatement pstUpdate = reg.prepareStatement(updateConsulta);
            pstUpdate.setString(1, motivo);
            pstUpdate.setString(2, tratamiento);
            pstUpdate.setString(3, precioConsulta);
            pstUpdate.setInt(4, idConsulta);

            int result = pstUpdate.executeUpdate();

            if (result > 0) {
                JOptionPane.showMessageDialog(this, "Datos de consulta actualizados exitosamente.");
                MenuDocConsultas menuPrincipal = new MenuDocConsultas(idDoctor);
                menuPrincipal.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Error al actualizar los datos de la consulta.");
            }

            pstUpdate.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al actualizar los datos de la consulta: " + ex.getMessage());
        }
    }//GEN-LAST:event_myButton13ActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UpdateConsultasPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateConsultasPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateConsultasPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateConsultasPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PrincipalPanel;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel2;
    private Items.MyButton myButton12;
    private Items.MyButton myButton13;
    private Items.PanelRound panelRound1;
    private Items.TextArea textArea1;
    private Items.TextArea textArea2;
    private Items.TextAreaScroll textAreaScroll1;
    private Items.TextAreaScroll textAreaScroll2;
    private javax.swing.JLabel titulo;
    private Items.TextField txtIdenti;
    private Items.TextField txtNombre1;
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
