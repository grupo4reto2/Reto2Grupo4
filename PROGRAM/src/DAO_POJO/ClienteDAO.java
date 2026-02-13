package DAO_POJO;

import clases.*;
import DAO_POJO.*;
import utils.conexion;
import utils.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClienteDAO {

    public void mostrarClientes() throws SQLException {

        String consulta1 = "select * from Cliente";

        try (Connection conn = conexion.getConnection();
		         PreparedStatement sentencia1 = conn.prepareStatement(consulta1);
		         ResultSet resultado1 = sentencia1.executeQuery()) {

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            throw ex;
        }
    }
}
