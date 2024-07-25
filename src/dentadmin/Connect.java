package dentadmin;

import java.sql.*;
import javax.swing.JOptionPane;

public class Connect {

    Connection con = null;

    public Connection conexion() {
        try {
            //Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Tipo de conexion, el servidor, base de datos, usuario, password
            con = DriverManager.getConnection("jdbc:mysql://localhost/dentadmin", "root", "");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Problemas al conectar" + e);
        }
        return con;
    }
    
    

}
