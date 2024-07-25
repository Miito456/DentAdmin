package dentadmin.AddThings;

import Items.Spinner;
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
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import dentadmin.Admin.AddDoctor;
import dentadmin.Connect;
import dentadmin.LoginDoc;
import dentadmin.Main;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class AddDoctorSchedule extends javax.swing.JFrame {

    FondoPanel fondo = new FondoPanel();

    Connect con = new Connect();
    Connection reg = con.conexion();
    private AddDoctor addDoctorInstance;

    private FileInputStream fis;
    private int longitudBytes;
    private Font customFont;
    private int idDoctor;
    private int doctorId;

    public AddDoctorSchedule(int doctorId) {
        this.doctorId = doctorId;

        this.setContentPane(fondo);
        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
        try {
            Font customFont = loadCustomFont("Recoleta-Regular.ttf").deriveFont(Font.PLAIN, 16);
            setFontRecursively(PrincipalPanel, customFont);
            DiaLun.setFont(loadCustomFont("Recoleta-Regular.ttf").deriveFont(Font.BOLD, 40));

        } catch (Exception e) {
            System.out.println("Font unvaliable" + e);
        }

        System.out.println("Se mando este iddoctor " + idDoctor);
        addSpinnerListeners();

    }

     private void addSpinnerListeners() {
        addSpinnerListener(iniciolunes, finlunes);
        addSpinnerListener(iniciomartes, finmartes);
        addSpinnerListener(iniciomiercoles, finmiercoles);
        addSpinnerListener(iniciojueves, finjueves);
        addSpinnerListener(inicioviernes, finviernes);
        addSpinnerListener(iniciosabado, finsabado);
        addSpinnerListener(iniciodomingo, findomingo);
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
        DiaLun = new javax.swing.JLabel();
        btnAgregarSchedule = new Items.MyButton();
        titulo = new javax.swing.JLabel();
        DiaLun1 = new javax.swing.JLabel();
        DiaLun2 = new javax.swing.JLabel();
        DiaLun3 = new javax.swing.JLabel();
        DiaLun4 = new javax.swing.JLabel();
        DiaLun5 = new javax.swing.JLabel();
        DiaLun6 = new javax.swing.JLabel();
        DiaLun7 = new javax.swing.JLabel();
        findomingo = new Items.Spinner();
        iniciomartes = new Items.Spinner();
        iniciodomingo = new Items.Spinner();
        iniciolunes = new Items.Spinner();
        iniciomiercoles = new Items.Spinner();
        iniciojueves = new Items.Spinner();
        inicioviernes = new Items.Spinner();
        iniciosabado = new Items.Spinner();
        finlunes = new Items.Spinner();
        finmartes = new Items.Spinner();
        finmiercoles = new Items.Spinner();
        finjueves = new Items.Spinner();
        finviernes = new Items.Spinner();
        finsabado = new Items.Spinner();

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

        DiaLun.setBackground(new java.awt.Color(255, 255, 255));
        DiaLun.setForeground(new java.awt.Color(251, 246, 239));
        DiaLun.setText("Agregar horario");
        panelRound1.add(DiaLun, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 30, 480, 60));

        btnAgregarSchedule.setBackground(new java.awt.Color(250, 246, 238));
        btnAgregarSchedule.setForeground(new java.awt.Color(120, 79, 71));
        btnAgregarSchedule.setText("Agregar Horario");
        btnAgregarSchedule.setColor(new java.awt.Color(250, 246, 238));
        btnAgregarSchedule.setColorOver(new java.awt.Color(216, 198, 179));
        btnAgregarSchedule.setRadius(40);
        btnAgregarSchedule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarScheduleActionPerformed(evt);
            }
        });
        panelRound1.add(btnAgregarSchedule, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 470, 180, 50));

        titulo.setBackground(new java.awt.Color(255, 255, 255));
        titulo.setForeground(new java.awt.Color(251, 246, 239));
        titulo.setText("El horario se tomara con el formato de 24 Hrs, toma esto en cuenta al momento de crear el horario");
        panelRound1.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 970, 60));

        DiaLun1.setBackground(new java.awt.Color(255, 255, 255));
        DiaLun1.setForeground(new java.awt.Color(251, 246, 239));
        DiaLun1.setText("Domingo");
        panelRound1.add(DiaLun1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 360, 130, 60));

        DiaLun2.setBackground(new java.awt.Color(255, 255, 255));
        DiaLun2.setForeground(new java.awt.Color(251, 246, 239));
        DiaLun2.setText("Lunes");
        panelRound1.add(DiaLun2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 130, 60));

        DiaLun3.setBackground(new java.awt.Color(255, 255, 255));
        DiaLun3.setForeground(new java.awt.Color(251, 246, 239));
        DiaLun3.setText("Martes");
        panelRound1.add(DiaLun3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 130, 60));

        DiaLun4.setBackground(new java.awt.Color(255, 255, 255));
        DiaLun4.setForeground(new java.awt.Color(251, 246, 239));
        DiaLun4.setText("Miercoles");
        panelRound1.add(DiaLun4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 130, 60));

        DiaLun5.setBackground(new java.awt.Color(255, 255, 255));
        DiaLun5.setForeground(new java.awt.Color(251, 246, 239));
        DiaLun5.setText("Jueves");
        panelRound1.add(DiaLun5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, 130, 60));

        DiaLun6.setBackground(new java.awt.Color(255, 255, 255));
        DiaLun6.setForeground(new java.awt.Color(251, 246, 239));
        DiaLun6.setText("Viernes");
        panelRound1.add(DiaLun6, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 150, 130, 60));

        DiaLun7.setBackground(new java.awt.Color(255, 255, 255));
        DiaLun7.setForeground(new java.awt.Color(251, 246, 239));
        DiaLun7.setText("Sabado");
        panelRound1.add(DiaLun7, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 250, 130, 60));

        findomingo.setBackground(new java.awt.Color(251, 246, 239));
        findomingo.setForeground(new java.awt.Color(116, 76, 68));
        findomingo.setLabelText("Hora final");
        panelRound1.add(findomingo, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 370, 140, -1));

        iniciomartes.setBackground(new java.awt.Color(251, 246, 239));
        iniciomartes.setForeground(new java.awt.Color(116, 76, 68));
        iniciomartes.setModel(new javax.swing.SpinnerNumberModel(0, null, 23, 1));
        iniciomartes.setLabelText("Hora de inicio");
        panelRound1.add(iniciomartes, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, 140, -1));

        iniciodomingo.setBackground(new java.awt.Color(251, 246, 239));
        iniciodomingo.setForeground(new java.awt.Color(116, 76, 68));
        iniciodomingo.setModel(new javax.swing.SpinnerNumberModel(0, null, 23, 1));
        iniciodomingo.setLabelText("Hora de inicio");
        panelRound1.add(iniciodomingo, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 370, 140, -1));

        iniciolunes.setBackground(new java.awt.Color(251, 246, 239));
        iniciolunes.setForeground(new java.awt.Color(116, 76, 68));
        iniciolunes.setModel(new javax.swing.SpinnerNumberModel(0, null, 23, 1));
        iniciolunes.setLabelText("Hora de inicio");
        panelRound1.add(iniciolunes, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 140, -1));

        iniciomiercoles.setBackground(new java.awt.Color(251, 246, 239));
        iniciomiercoles.setForeground(new java.awt.Color(116, 76, 68));
        iniciomiercoles.setModel(new javax.swing.SpinnerNumberModel(0, null, 23, 1));
        iniciomiercoles.setLabelText("Hora de inicio");
        panelRound1.add(iniciomiercoles, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, 140, -1));

        iniciojueves.setBackground(new java.awt.Color(251, 246, 239));
        iniciojueves.setForeground(new java.awt.Color(116, 76, 68));
        iniciojueves.setModel(new javax.swing.SpinnerNumberModel(0, null, 23, 1));
        iniciojueves.setLabelText("Hora de inicio");
        panelRound1.add(iniciojueves, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 410, 140, -1));

        inicioviernes.setBackground(new java.awt.Color(251, 246, 239));
        inicioviernes.setForeground(new java.awt.Color(116, 76, 68));
        inicioviernes.setModel(new javax.swing.SpinnerNumberModel(0, null, 23, 1));
        inicioviernes.setLabelText("Hora de inicio");
        panelRound1.add(inicioviernes, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 160, 140, -1));

        iniciosabado.setBackground(new java.awt.Color(251, 246, 239));
        iniciosabado.setForeground(new java.awt.Color(116, 76, 68));
        iniciosabado.setModel(new javax.swing.SpinnerNumberModel(0, null, 23, 1));
        iniciosabado.setLabelText("Hora de inicio");
        panelRound1.add(iniciosabado, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 260, 140, -1));

        finlunes.setBackground(new java.awt.Color(251, 246, 239));
        finlunes.setForeground(new java.awt.Color(116, 76, 68));
        finlunes.setLabelText("Hora final");
        panelRound1.add(finlunes, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 160, 140, -1));

        finmartes.setBackground(new java.awt.Color(251, 246, 239));
        finmartes.setForeground(new java.awt.Color(116, 76, 68));
        finmartes.setLabelText("Hora final");
        panelRound1.add(finmartes, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 230, 140, -1));

        finmiercoles.setBackground(new java.awt.Color(251, 246, 239));
        finmiercoles.setForeground(new java.awt.Color(116, 76, 68));
        finmiercoles.setLabelText("Hora final");
        panelRound1.add(finmiercoles, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 320, 140, -1));

        finjueves.setBackground(new java.awt.Color(251, 246, 239));
        finjueves.setForeground(new java.awt.Color(116, 76, 68));
        finjueves.setLabelText("Hora final");
        panelRound1.add(finjueves, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 410, 140, -1));

        finviernes.setBackground(new java.awt.Color(251, 246, 239));
        finviernes.setForeground(new java.awt.Color(116, 76, 68));
        finviernes.setLabelText("Hora final");
        panelRound1.add(finviernes, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 160, 140, -1));

        finsabado.setBackground(new java.awt.Color(251, 246, 239));
        finsabado.setForeground(new java.awt.Color(116, 76, 68));
        finsabado.setLabelText("Hora final");
        panelRound1.add(finsabado, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 260, 140, -1));

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


    private void btnAgregarScheduleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarScheduleActionPerformed

        try {
            String inicioLunes = Integer.toString((Integer) iniciolunes.getValue());
            String finLunes = Integer.toString((Integer) finlunes.getValue());
            String inicioMartes = Integer.toString((Integer) iniciomartes.getValue());
            String finMartes = Integer.toString((Integer) finmartes.getValue());
            String inicioMiercoles = Integer.toString((Integer) iniciomiercoles.getValue());
            String finMiercoles = Integer.toString((Integer) finmiercoles.getValue());
            String inicioJueves = Integer.toString((Integer) iniciojueves.getValue());
            String finJueves = Integer.toString((Integer) finjueves.getValue());
            String inicioViernes = Integer.toString((Integer) inicioviernes.getValue());
            String finViernes = Integer.toString((Integer) finviernes.getValue());
            String inicioSabado = Integer.toString((Integer) iniciosabado.getValue());
            String finSabado = Integer.toString((Integer) finsabado.getValue());
            String inicioDomingo = Integer.toString((Integer) iniciodomingo.getValue());
            String finDomingo = Integer.toString((Integer) findomingo.getValue());

            String sql = "INSERT INTO horariosconsultas (IdDoctor, DiaSemana, HoraInicio, HoraFin) VALUES (?, ?, ?, ?)";
            try (PreparedStatement pst = reg.prepareStatement(sql)) {
                pst.setInt(1, doctorId);
                pst.setString(2, "Lunes");
                pst.setString(3, inicioLunes);
                pst.setString(4, finLunes);
                pst.executeUpdate();

                pst.setInt(1, doctorId);
                pst.setString(2, "Martes");
                pst.setString(3, inicioMartes);
                pst.setString(4, finMartes);
                pst.executeUpdate();

                pst.setInt(1, doctorId);
                pst.setString(2, "Miércoles");
                pst.setString(3, inicioMiercoles);
                pst.setString(4, finMiercoles);
                pst.executeUpdate();

                pst.setInt(1, doctorId);
                pst.setString(2, "Jueves");
                pst.setString(3, inicioJueves);
                pst.setString(4, finJueves);
                pst.executeUpdate();

                pst.setInt(1, doctorId);
                pst.setString(2, "Viernes");
                pst.setString(3, inicioViernes);
                pst.setString(4, finViernes);
                pst.executeUpdate();

                pst.setInt(1, doctorId);
                pst.setString(2, "Sábado");
                pst.setString(3, inicioSabado);
                pst.setString(4, finSabado);
                pst.executeUpdate();

                pst.setInt(1, doctorId);
                pst.setString(2, "Domingo");
                pst.setString(3, inicioDomingo);
                pst.setString(4, finDomingo);
                pst.executeUpdate();
            }

            JOptionPane.showMessageDialog(null, "Horario agregado correctamente");
            new Main().setVisible(true);
            this.dispose();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al agregar horario: " + e.getMessage());
            System.out.println("Error: " + e.getMessage());
        }
    }//GEN-LAST:event_btnAgregarScheduleActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddDoctorSchedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddDoctorSchedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddDoctorSchedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddDoctorSchedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LoginDoc loginDoc = new LoginDoc();
                int idDoctor = loginDoc.getIdDoctor();
                new AddDoctorSchedule(idDoctor).setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DiaLun;
    private javax.swing.JLabel DiaLun1;
    private javax.swing.JLabel DiaLun2;
    private javax.swing.JLabel DiaLun3;
    private javax.swing.JLabel DiaLun4;
    private javax.swing.JLabel DiaLun5;
    private javax.swing.JLabel DiaLun6;
    private javax.swing.JLabel DiaLun7;
    private javax.swing.JPanel PrincipalPanel;
    private Items.MyButton btnAgregarSchedule;
    private Items.Spinner findomingo;
    private Items.Spinner finjueves;
    private Items.Spinner finlunes;
    private Items.Spinner finmartes;
    private Items.Spinner finmiercoles;
    private Items.Spinner finsabado;
    private Items.Spinner finviernes;
    private Items.Spinner iniciodomingo;
    private Items.Spinner iniciojueves;
    private Items.Spinner iniciolunes;
    private Items.Spinner iniciomartes;
    private Items.Spinner iniciomiercoles;
    private Items.Spinner iniciosabado;
    private Items.Spinner inicioviernes;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel2;
    private Items.PanelRound panelRound1;
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

}
