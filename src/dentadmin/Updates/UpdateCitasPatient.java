package dentadmin.Updates;

import dentadmin.MenusDoctores.MenuDocConsultas;
import dentadmin.MenusDoctores.MenuDocPacientes;
import Items_cell.TableActionCellEditor;
import Items_cell.TableActionCellRender;
import Items_cell.TableActionEvent;
import dentadmin.Connect;
import dentadmin.MenusDoctores.MenuDocCitas;
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
import java.util.Calendar;
import java.util.Date;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class UpdateCitasPatient extends javax.swing.JFrame {

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
    private int idCita;

    public UpdateCitasPatient(int idPaciente, int idDoctor, int idCita) {
        this.idPaciente = idPaciente;
        this.idDoctor = idDoctor;
        this.idCita = idCita;
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
        cargarDatosCita();
        addSpinnerListeners();

    }

    private void addSpinnerListeners() {
        addSpinnerListener(inicio, fin);

    }

    private void addSpinnerListener(JSpinner inicioSpinner, JSpinner finSpinner) {
        inicioSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int inicioValue = (int) inicioSpinner.getValue();
                if (inicioValue < 0) {
                    JOptionPane.showMessageDialog(null, "La hora de inicio no puede ser negativa.");
                    inicioSpinner.setValue(0);
                    return;
                }
                int finValue = inicioValue + 1;
                finSpinner.setValue(finValue);
            }
        });

        finSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int inicioValue = (int) inicioSpinner.getValue();
                int finValue = (int) finSpinner.getValue();
                if (finValue <= inicioValue) {
                    JOptionPane.showMessageDialog(null, "La hora de fin no puede ser menor o igual a la hora de inicio.");
                    finSpinner.setValue(inicioValue + 1);
                }
            }
        });
    }

    private void cargarDatosCita() {
        String sql = "SELECT p.Identificacion, CONCAT(p.Nombre, ' ', p.ApellidoPaterno, ' ', p.ApellidoMaterno) AS NombreCompleto, "
                + "c.FechaCita, c.HoraInicio, c.HoraFin "
                + "FROM citas c "
                + "JOIN pacientes p ON c.IdPaciente = p.IdPaciente "
                + "WHERE c.IdCita = ? AND c.IdPaciente = ?";

        try (PreparedStatement pst = reg.prepareStatement(sql)) {
            pst.setInt(1, idCita);
            pst.setInt(2, idPaciente);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    String identificacion = rs.getString("Identificacion");
                    String nombreCompleto = rs.getString("NombreCompleto");
                    Date fechaCita = rs.getDate("FechaCita");
                    String horaInicio = rs.getString("HoraInicio");
                    String horaFin = rs.getString("HoraFin");

                    txtIdenti.setText(identificacion);
                    txtNombre1.setText(nombreCompleto);
                    DateChooseCita.setDate(fechaCita);
                    inicio.setValue(Integer.parseInt(horaInicio));
                    fin.setValue(Integer.parseInt(horaFin));
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontraron datos para la cita con ID: " + idCita + " y paciente con ID: " + idPaciente);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al cargar datos de la cita: " + ex.getMessage());
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
        myButton12 = new Items.MyButton();
        txtNombre1 = new Items.TextField();
        myButton13 = new Items.MyButton();
        DateChooseCita = new com.toedter.calendar.JDateChooser();
        inicio = new Items.Spinner();
        fin = new Items.Spinner();

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
        titulo.setText("Cambio de cita ");
        panelRound1.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 510, 60));

        txtIdenti.setBackground(new java.awt.Color(251, 246, 239));
        txtIdenti.setForeground(new java.awt.Color(116, 76, 68));
        txtIdenti.setEnabled(false);
        txtIdenti.setLabelText("Identificacion");
        txtIdenti.setLineColor(new java.awt.Color(125, 84, 75));
        panelRound1.add(txtIdenti, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 270, -1));

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
        panelRound1.add(myButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 560, 189, 44));

        txtNombre1.setBackground(new java.awt.Color(251, 246, 239));
        txtNombre1.setForeground(new java.awt.Color(116, 76, 68));
        txtNombre1.setEnabled(false);
        txtNombre1.setLabelText("Nombre del paciente");
        txtNombre1.setLineColor(new java.awt.Color(125, 84, 75));
        panelRound1.add(txtNombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, 270, -1));

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
        panelRound1.add(myButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 560, 189, 44));
        panelRound1.add(DateChooseCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, 270, 50));

        inicio.setBackground(new java.awt.Color(251, 246, 239));
        inicio.setForeground(new java.awt.Color(116, 76, 68));
        inicio.setModel(new javax.swing.SpinnerNumberModel(0, null, 23, 1));
        inicio.setLabelText("Hora de inicio");
        panelRound1.add(inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 430, 140, -1));

        fin.setBackground(new java.awt.Color(251, 246, 239));
        fin.setForeground(new java.awt.Color(116, 76, 68));
        fin.setLabelText("Hora final");
        panelRound1.add(fin, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 430, 140, -1));

        PrincipalPanel.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, 580, 620));

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
        MenuDocCitas menuPrincipal = new MenuDocCitas(idDoctor);
        menuPrincipal.setVisible(true);
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_myButton12ActionPerformed

    private void myButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton13ActionPerformed
        Date fechaCita = DateChooseCita.getDate();
        int horaInicio = (Integer) inicio.getValue();
        int horaFin = (Integer) fin.getValue();

        if (horaInicio >= horaFin) {
            JOptionPane.showMessageDialog(this, "La hora de inicio debe ser menor que la hora de fin.");
            return;
        }

        if (!verificarHorarioConsulta(fechaCita, horaInicio, horaFin)) {
            JOptionPane.showMessageDialog(this, "La hora de inicio o fin no está dentro del horario de consulta para ese día.");
            return;
        }

        if (existeCita(idDoctor, fechaCita, horaInicio, horaFin)) {
            JOptionPane.showMessageDialog(this, "Ya existe una cita en el mismo día a la misma hora.");
            return;
        }

        actualizarCita(idCita, fechaCita, horaInicio, horaFin);


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
            java.util.logging.Logger.getLogger(UpdateCitasPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateCitasPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateCitasPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateCitasPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

            }

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateChooseCita;
    private javax.swing.JPanel PrincipalPanel;
    private Items.Spinner fin;
    private Items.Spinner inicio;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel2;
    private Items.MyButton myButton12;
    private Items.MyButton myButton13;
    private Items.PanelRound panelRound1;
    private javax.swing.JLabel titulo;
    private Items.TextField txtIdenti;
    private Items.TextField txtNombre1;
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

    private boolean existeCita(int idDoctor, Date fechaCita, int horaInicio, int horaFin) {
        String sql = "SELECT COUNT(*) AS total FROM citas WHERE IdDoctor = ? AND FechaCita = ? AND (HoraInicio < ? AND HoraFin > ?)";
        try (PreparedStatement pst = reg.prepareStatement(sql)) {
            pst.setInt(1, idDoctor);
            pst.setDate(2, new java.sql.Date(fechaCita.getTime()));
            pst.setInt(3, horaFin);
            pst.setInt(4, horaInicio);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    int total = rs.getInt("total");
                    // Imprimir resultado de la consulta
                    System.out.println("Existe cita - Total: " + total);
                    return total > 0;
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al verificar citas existentes: " + ex.getMessage());
        }
        return false;
    }

    private void actualizarCita(int idCita, Date fechaCita, int horaInicio, int horaFin) {
        String sql = "UPDATE citas SET FechaCita = ?, HoraInicio = ?, HoraFin = ? WHERE IdCita = ?";
        try (PreparedStatement pst = reg.prepareStatement(sql)) {
            pst.setDate(1, new java.sql.Date(fechaCita.getTime()));
            pst.setInt(2, horaInicio);
            pst.setInt(3, horaFin);
            pst.setInt(4, idCita);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Cita actualizada correctamente.");
            MenuDocCitas menuPrincipal = new MenuDocCitas(idDoctor);
            menuPrincipal.setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al actualizar la cita: " + ex.getMessage());
        }
    }

    private boolean verificarHorarioConsulta(Date fechaCita, int horaInicio, int horaFin) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaCita);
        String diaSemana = convertirDiaSemana(calendar.get(Calendar.DAY_OF_WEEK));

        String sql = "SELECT HoraInicio, HoraFin FROM horariosconsultas WHERE IdDoctor = ? AND DiaSemana = ?";
        try (PreparedStatement pst = reg.prepareStatement(sql)) {
            pst.setInt(1, idDoctor);
            pst.setString(2, diaSemana);
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    int horaInicioConsulta = rs.getInt("HoraInicio");
                    int horaFinConsulta = rs.getInt("HoraFin");

                    // Verificar si tanto la hora de inicio como la hora de fin ingresadas están dentro del rango
                    if (horaInicio >= horaInicioConsulta && horaFin <= horaFinConsulta) {
                        return true;
                    }
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al verificar el horario de consulta: " + ex.getMessage());
        }
        return false;
    }

    private String convertirDiaSemana(int diaSemana) {
        switch (diaSemana) {
            case Calendar.MONDAY:
                return "Lunes";
            case Calendar.TUESDAY:
                return "Martes";
            case Calendar.WEDNESDAY:
                return "Miércoles";
            case Calendar.THURSDAY:
                return "Jueves";
            case Calendar.FRIDAY:
                return "Viernes";
            case Calendar.SATURDAY:
                return "Sábado";
            case Calendar.SUNDAY:
                return "Domingo";
            default:
                return "";
        }
    }
}
