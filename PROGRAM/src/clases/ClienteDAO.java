package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClienteDAO {

    public void mostrarClientes() throws SQLException {

        String consulta1 = "select * from Cliente";

        try (Connection conn = Conexion.getConnection();
		         PreparedStatement sentencia1 = conn.prepareStatement(consulta1);
		         ResultSet resultado1 = sentencia1.executeQuery()) {

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            throw ex;
        }
    }
}