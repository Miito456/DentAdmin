package dentadmin.AddThings;

import dentadmin.Connect;
import dentadmin.LoginDoc;
import dentadmin.MenusDoctores.MenuDocCitas;
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
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class AddCita extends javax.swing.JFrame {

    FondoPanel fondo = new FondoPanel();

    Connect con = new Connect();
    Connection reg = con.conexion();

    private FileInputStream fis;
    private int longitudBytes;
    private Font customFont;
    private int idDoctor;

    public AddCita(int idDoctor) {
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
        System.out.println("" + idDoctor);
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
        btnAddCita = new Items.MyButton();
        txtIdenti = new Items.TextField();
        btnRegresar = new Items.MyButton();
        inicio = new Items.Spinner();
        fin = new Items.Spinner();
        DateChooseCita = new com.toedter.calendar.JDateChooser();

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
        titulo.setText("Agendar cita");
        panelRound1.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 380, 60));

        btnAddCita.setBackground(new java.awt.Color(250, 246, 238));
        btnAddCita.setForeground(new java.awt.Color(120, 79, 71));
        btnAddCita.setText("Nueva cita");
        btnAddCita.setColor(new java.awt.Color(250, 246, 238));
        btnAddCita.setColorOver(new java.awt.Color(216, 198, 179));
        btnAddCita.setRadius(40);
        btnAddCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCitaActionPerformed(evt);
            }
        });
        panelRound1.add(btnAddCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 470, 180, 50));

        txtIdenti.setBackground(new java.awt.Color(251, 246, 239));
        txtIdenti.setForeground(new java.awt.Color(116, 76, 68));
        txtIdenti.setLabelText("Identificación");
        txtIdenti.setLineColor(new java.awt.Color(125, 84, 75));
        panelRound1.add(txtIdenti, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 270, -1));

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

        inicio.setBackground(new java.awt.Color(251, 246, 239));
        inicio.setForeground(new java.awt.Color(116, 76, 68));
        inicio.setModel(new javax.swing.SpinnerNumberModel(0, null, 23, 1));
        inicio.setLabelText("Hora de inicio");
        panelRound1.add(inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 370, 140, -1));

        fin.setBackground(new java.awt.Color(251, 246, 239));
        fin.setForeground(new java.awt.Color(116, 76, 68));
        fin.setLabelText("Hora final");
        panelRound1.add(fin, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 370, 140, -1));
        panelRound1.add(DateChooseCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, 270, 50));

        PrincipalPanel.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, 730, 540));

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

    private void btnAddCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCitaActionPerformed
        String identificacion = txtIdenti.getText().trim();
        String horaInicioStr = inicio.getValue().toString();
        String horaFinStr = fin.getValue().toString();
        Date fechaSeleccionada = DateChooseCita.getDate();
        Calendar cal = Calendar.getInstance();
        cal.setTime(fechaSeleccionada);
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

        String diaSemana = "";
        switch (dayOfWeek) {
            case Calendar.SUNDAY:
                diaSemana = "Domingo";
                break;
            case Calendar.MONDAY:
                diaSemana = "Lunes";
                break;
            case Calendar.TUESDAY:
                diaSemana = "Martes";
                break;
            case Calendar.WEDNESDAY:
                diaSemana = "Miércoles";
                break;
            case Calendar.THURSDAY:
                diaSemana = "Jueves";
                break;
            case Calendar.FRIDAY:
                diaSemana = "Viernes";
                break;
            case Calendar.SATURDAY:
                diaSemana = "Sábado";
                break;
            default:
                diaSemana = "Error";
                break;
        }

        try {
            String checkDoctorSql = "SELECT COUNT(*) FROM doctores WHERE IdDoctor = ?";
            try (PreparedStatement checkPst = reg.prepareStatement(checkDoctorSql)) {
                checkPst.setInt(1, idDoctor);
                ResultSet rs = checkPst.executeQuery();
                if (rs.next() && rs.getInt(1) == 0) {
                    JOptionPane.showMessageDialog(this, "El doctor con Id " + idDoctor + " no existe.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            String getPacienteSql = "SELECT IdPaciente FROM pacientes WHERE Identificacion = ?";
            int idPaciente = -1;
            try (PreparedStatement getPst = reg.prepareStatement(getPacienteSql)) {
                getPst.setString(1, identificacion);
                ResultSet rs = getPst.executeQuery();
                if (rs.next()) {
                    idPaciente = rs.getInt("IdPaciente");
                } else {
                    JOptionPane.showMessageDialog(this, "El paciente con identificación " + identificacion + " no existe.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            if (existeCita(idDoctor, fechaSeleccionada, horaInicioStr)) {
                JOptionPane.showMessageDialog(this, "Ya existe una cita para el mismo doctor a la misma hora de inicio.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int horaInicio = Integer.parseInt(horaInicioStr);
            int horaFin = Integer.parseInt(horaFinStr);

            Date fechaCita = DateChooseCita.getDate();
            if (!verificarHorarioConsulta(fechaCita, horaInicio, horaFin)) {
                JOptionPane.showMessageDialog(this, "La hora de inicio o fin no está dentro del horario de consulta para ese día.");
                return;
            }

            String sql = "INSERT INTO citas (IdDoctor, IdPaciente, DiaSemana, HoraInicio, HoraFin, FechaCita, DiaNumero) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement pst = reg.prepareStatement(sql)) {
                pst.setInt(1, idDoctor);
                pst.setInt(2, idPaciente);
                pst.setString(3, diaSemana);
                pst.setInt(4, horaInicio);
                pst.setInt(5, horaFin);
                pst.setDate(6, new java.sql.Date(fechaSeleccionada.getTime()));
                pst.setInt(7, cal.get(Calendar.DAY_OF_MONTH));

                int rowsAffected = pst.executeUpdate();

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "La cita se ha agregado correctamente.", "Cita Agregada", JOptionPane.INFORMATION_MESSAGE);
                    new MenuDocCitas(idDoctor).setVisible(true);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo agregar la cita.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al agregar la cita: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnAddCitaActionPerformed

    private boolean existeCita(int idDoctor, Date fechaSeleccionada, String horaInicio) throws SQLException {
        String existingCitaSql = "SELECT COUNT(*) FROM citas WHERE IdDoctor = ? AND FechaCita = ? AND HoraInicio = ?";
        try (PreparedStatement existingCitaPst = reg.prepareStatement(existingCitaSql)) {
            existingCitaPst.setInt(1, idDoctor);
            existingCitaPst.setDate(2, new java.sql.Date(fechaSeleccionada.getTime()));
            existingCitaPst.setString(3, horaInicio);
            ResultSet rs = existingCitaPst.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                return true; 
            }
        }
        return false; 
    }

    private boolean estaEnHorario(int idDoctor, String diaSemana, int horaInicio, int horaFin) {
        String sql = "SELECT HoraInicio, HoraFin FROM horariosconsultas WHERE IdDoctor = ? AND DiaSemana = ?";
        try (PreparedStatement pst = reg.prepareStatement(sql)) {
            pst.setInt(1, idDoctor);
            pst.setString(2, diaSemana);
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    int horaInicioConsulta = rs.getInt("HoraInicio");
                    int horaFinConsulta = rs.getInt("HoraFin");

                    System.out.println("Horario doctor - Inicio: " + horaInicioConsulta + ", Fin: " + horaFinConsulta);

                    if (horaInicio >= horaInicioConsulta && horaFin <= horaFinConsulta) {
                        return true;
                    }
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al verificar horario de consulta: " + ex.getMessage());
        }
        return false;
    }

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        MenuDocCitas menuPrincipal = new MenuDocCitas(idDoctor);
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
            java.util.logging.Logger.getLogger(AddCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new AddCita(idDoctor).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateChooseCita;
    private javax.swing.JPanel PrincipalPanel;
    private Items.MyButton btnAddCita;
    private Items.MyButton btnRegresar;
    private Items.Spinner fin;
    private Items.Spinner inicio;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel2;
    private Items.PanelRound panelRound1;
    private javax.swing.JLabel titulo;
    private Items.TextField txtIdenti;
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
