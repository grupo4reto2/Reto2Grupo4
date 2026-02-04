package RETO2;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.time.*;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import utils.conexion;

import clases.Pelicula;
import clases.Sala;
import clases.Sesion;
import clases.Entrada;

class actualBorradorTest {

	private ArrayList<Pelicula> peliculas;
    private ArrayList<Sala> salas;
    private ArrayList<Sesion> sesiones;
    private ArrayList<LocalDateTime> fechas;
	
	@BeforeEach
	void setUp() {
		 peliculas = actualBorrador.cargarCartelera();
	     salas = actualBorrador.cargarSalas();
	     sesiones = actualBorrador.cargarSesiones(peliculas, salas);
	     fechas = actualBorrador.cargarFechas();
	}
	
	
	@Test
	void testGetConexion() {
		Connection conn = conexion.getConnection();
		assertNotNull (conn, "La conexion se realiza correctamente");
	}

	@Test
    void testCargarFechas() {
        assertEquals(7, fechas.size());
        assertEquals(LocalDateTime.of(2026, 2, 1, 10, 0), fechas.get(0));
    }

	@Test
	void testResumenCompra() {
		ArrayList<Entrada> carrito = new ArrayList<>();
		carrito.add(new Entrada(1,2,sesiones.get(0), null, LocalDateTime.now()));
		carrito.add(new Entrada(2,1,sesiones.get(8), null, LocalDateTime.now()));
		
		double total = actualBorrador.resumenCompra(carrito);
		assertEquals(18,total,0.01);
	}

	@Test
	void testCalcularDescuento() {
		double precio = 100;
		
		double precio1 = actualBorrador.calcularDescuento(precio, 1);
		assertEquals(100, precio1, 0.01);
		
		double precio2 = actualBorrador.calcularDescuento(precio, 2);
		assertEquals(80, precio2, 0.01);
		
		double precio3 = actualBorrador.calcularDescuento(precio, 3);
		assertEquals(70, precio3, 0.01);
		
	}

	@Test
	void testCargarSalas() {
		 assertEquals(5, salas.size());
		 assertEquals("Sala 1", salas.get(0).getNombre());
	}

	@Test
	void testContarPeliculas() {
	
		ArrayList<Entrada> carrito = new ArrayList<>();
		carrito.add(new Entrada(1,2,sesiones.get(0), null, LocalDateTime.now()));
		carrito.add(new Entrada(2,1,sesiones.get(1), null, LocalDateTime.now()));
		carrito.add(new Entrada(3,1,sesiones.get(5), null, LocalDateTime.now()));
		
		int numPeliculas = actualBorrador.contarPeliculas(carrito);
		assertEquals(2, numPeliculas);
	}

	@Test
	void testCargarSesiones() {
		assertTrue(sesiones.size()>0);
		
		for (int i=1; i <sesiones.size(); i++) {
			assertTrue(sesiones.get(i).getfecHoraIni().isAfter(sesiones.get(i-1).getfecHoraIni())
					||sesiones.get(i).getfecHoraIni().isEqual(sesiones.get(i-1).getfecHoraIni()));
		}
	}

}
