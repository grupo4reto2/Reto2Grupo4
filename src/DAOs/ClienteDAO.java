package DAOs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClienteDAO {

    public static void main(String[] args) {
        String url = "jdbc:mysql://10.5.6.136:3309/reto2_g4_true";
        String user = "ander";
        String pass = "Elorrieta00-";

        String[] consultas = {
            "select C.DNICliente, C.Nombre, C.Apellido, C.Correo, max(CO.descuento) as descuento_maximo " +
            "from Compra CO join Cliente C on CO.DNICliente = C.DNICliente " +
            "group by C.DNICliente, C.Nombre, C.Apellido " +
            "order by descuento_maximo desc Limit 5;",

            "SELECT C.DNICliente, C.Nombre, C.Apellido, C.Correo, COUNT(E.IDEntrada) AS TotalEntradas " +
            "FROM Cliente C JOIN Compra CO ON C.DNICliente = CO.DNICliente " +
            "JOIN Entrada E ON CO.IDCompra = E.IDCompra " +
            "GROUP BY C.DNICliente, C.Nombre, C.Apellido, C.Correo " +
            "ORDER BY TotalEntradas DESC LIMIT 1;",

            "SELECT C.DNICliente, C.Nombre, C.Apellido, C.Correo, max(CO.Importe) AS DineroGastado " +
            "FROM Cliente C JOIN Compra CO ON C.DNICliente = CO.DNICliente " +
            "GROUP BY C.DNICliente, C.Nombre, C.Apellido, C.Correo " +
            "ORDER BY DineroGastado DESC Limit 1;"
        };

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             Statement sentencia = conn.createStatement()) {

            for (int i = 0; i < consultas.length; i++) {
                try (ResultSet resultado = sentencia.executeQuery(consultas[i])) {
                    System.out.println("---------Consulta " + (i + 1) + "---------");
                    while (resultado.next()) {
                        String dni = resultado.getString("DNICliente");
                        String nombre = resultado.getString("Nombre");
                        String apellido = resultado.getString("Apellido");
                        String correo = resultado.getString("Correo");

                        System.out.println("DNI Cliente: " + dni);
                        System.out.println("Nombre: " + nombre);
                        System.out.println("Apellido: " + apellido);
                        System.out.println("Correo: " + correo);

                        // Dependiendo de la consulta, imprime la columna correcta
                        if (i == 0) {
                            System.out.println("Descuento máximo: " + resultado.getDouble("descuento_maximo"));
                        } else if (i == 1) {
                            System.out.println("Total de entradas: " + resultado.getInt("TotalEntradas"));
                        } else if (i == 2) {
                            System.out.println("Dinero gastado: " + resultado.getDouble("DineroGastado"));
                        }

                        System.out.println("----------------------------");
                    }
                }
            }

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}