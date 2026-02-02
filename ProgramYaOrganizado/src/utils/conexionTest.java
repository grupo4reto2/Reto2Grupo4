package utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.sql.*;

class conexionTest {

	@Test
	void test() {
		
		Connection conn = conexion.getConnection();
		
		assertNotNull (conn, "La conexion se realiza correctamente");
	}

}
