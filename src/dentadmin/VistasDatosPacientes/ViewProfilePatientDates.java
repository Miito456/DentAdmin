package dentadmin.VistasDatosPacientes;

import dentadmin.MenusDoctores.MenuDocPacientes;
import Items_cell.TableActionCellEditor;
import Items_cell.TableActionCellRender;
import Items_cell.TableActionEvent;
import dentadmin.Connect;
import dentadmin.LoginDoc;
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
import java.text.SimpleDateFormat;
import java.util.Date;

public class ViewProfilePatientDates extends javax.swing.JFrame {

    FondoPanel fondo = new FondoPanel();
    Connect con = new Connect();
    Connection reg = con.conexion();

    private FileInputStream fis;
    private int longitudBytes;
    private Font customFont;
    private int idDoctor;
    private int idPaciente;
    private MenuDocPacientes menuDoc;

    public ViewProfilePatientDates(int idPaciente, int idDoctor, MenuDocPacientes menuDocPacientes) {
        this.menuDoc = menuDocPacientes;
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
        System.out.println("idpacientemandado profilepatient" + idPaciente);
        int idPacient = menuDocPacientes.getIdPacienteGlobal();
        System.out.println("METODO " + idPacient);

        mostrarCitas();
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
        myButton12 = new Items.MyButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        panelRound2 = new Items.PanelRound();
        menuPacientes = new Items.MyButton();
        menuConsultas = new Items.MyButton();
        menuPagos = new Items.MyButton();
        menuCitas = new Items.MyButton();

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

        table.setBackground(new java.awt.Color(251, 243, 235));
        table.setForeground(new java.awt.Color(112, 77, 71));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Fecha de la cita", "Dia de la semana", "Hora inicio", "Hora fin"
            }
        ));
        table.setRowHeight(50);
        jScrollPane1.setViewportView(table);

        panelRound1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, 980, 390));

        panelRound2.setBackground(new java.awt.Color(112, 77, 71));
        panelRound2.setRoundBottomLeft(100);
        panelRound2.setRoundBottomRight(50);
        panelRound2.setRoundTopLeft(50);
        panelRound2.setRoundTopRight(50);
        panelRound2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuPacientes.setBackground(new java.awt.Color(250, 246, 238));
        menuPacientes.setForeground(new java.awt.Color(120, 79, 71));
        menuPacientes.setText("Informacion");
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

        panelRound1.add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 300, 310));

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
        MenuDocPacientes menuPrincipal = new MenuDocPacientes(idDoctor);
        menuPrincipal.setVisible(true);
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_myButton12ActionPerformed

    private void menuPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPacientesActionPerformed
        new ViewProfilePatient(idPaciente, idDoctor, menuDoc).setVisible(true);
        dispose();
    }//GEN-LAST:event_menuPacientesActionPerformed

    private void menuConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConsultasActionPerformed
        new ViewProfilePatientConsultas(idPaciente, idDoctor, menuDoc).setVisible(true);
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_menuConsultasActionPerformed

    private void menuPagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPagosActionPerformed
        new ViewProfilePatientPagos(idPaciente, idDoctor, menuDoc).setVisible(true);
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_menuPagosActionPerformed

    private void menuCitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCitasActionPerformed
        new ViewProfilePatientDates(idPaciente, idDoctor, menuDoc).setVisible(true);
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_menuCitasActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewProfilePatientDates.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewProfilePatientDates.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewProfilePatientDates.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewProfilePatientDates.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                    new ViewProfilePatientDates(idPaciente, idDoctor, menuDoc).setVisible(true);
                } else {
                    System.out.println("No patient selected");
                }
            }

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PrincipalPanel;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private Items.MyButton menuCitas;
    private Items.MyButton menuConsultas;
    private Items.MyButton menuPacientes;
    private Items.MyButton menuPagos;
    private Items.MyButton myButton12;
    private Items.PanelRound panelRound1;
    private Items.PanelRound panelRound2;
    private javax.swing.JTable table;
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

    private void mostrarCitas() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        String sql = "SELECT c.FechaCita, c.DiaSemana, c.HoraInicio, c.HoraFin "
                + "FROM citas c "
                + "JOIN pacientes p ON c.IdPaciente = p.IdPaciente "
                + "WHERE c.IdPaciente = (SELECT IdPaciente FROM pacientes WHERE Identificacion = ?) AND p.IdDoctor = ?";
        try (PreparedStatement pst = reg.prepareStatement(sql)) {
            pst.setInt(1, idPaciente); // Utilizamos el id del paciente en lugar del identificador
            pst.setInt(2, idDoctor);

            try (ResultSet rs = pst.executeQuery()) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                while (rs.next()) {
                    Date fechaCita = rs.getDate("FechaCita");
                    String diaSemana = rs.getString("DiaSemana");
                    String horaInicio = rs.getString("HoraInicio");
                    String horaFin = rs.getString("HoraFin");
                    String fechaCitaFormatted = dateFormat.format(fechaCita);

                    Object[] row = new Object[]{
                        fechaCitaFormatted,
                        diaSemana,
                        horaInicio,
                        horaFin,
                        "Acciones"
                    };
                    model.addRow(row);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al cargar citas: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

}
