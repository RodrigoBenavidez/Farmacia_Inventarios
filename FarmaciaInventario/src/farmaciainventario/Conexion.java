package farmaciainventario;

import java.sql.*;

public class Conexion {

    private static Connection cnx = null;

    
    private static String server = "mysql-77920-0.cloudclusters.net";
    private static String port = "19747";
    private static String user = "admin";
    private static String password = "EIWHT191";
    private static String database = "farmacia";
    
    
    public static Connection conectar() {
        if (cnx == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                cnx = DriverManager.getConnection("jdbc:mysql://" + server + ":" + port + "/" + database, user, password);
            } catch (ClassNotFoundException | SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return cnx;
    }

    public static void cerrar() throws SQLException {
        if (cnx != null) {
            cnx.close();
            cnx = null;
        }
    }

}