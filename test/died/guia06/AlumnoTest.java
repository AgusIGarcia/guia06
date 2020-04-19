package died.guia06;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AlumnoTest {
	
	Alumno a1 = new Alumno("Ricardo Perez",25311);
	Alumno a2 = new Alumno("Orlando Alvarez",25311);
	Alumno a3 = new Alumno("Carlos Oviedo", 26354);
	
	Curso c1 = new Curso(1, "DIED", 2020, 35, 20,0);
	Curso c2 = new Curso(1, "AEDD", 2018, 60, 10,0);
	Curso c3 = new Curso(1, "Paradigmas", 2019, 40, 15,0);
	
	@Test
	void testCreditosObtenidosInicial() {
		assertEquals(a1.creditosObtenidos(),0);
	}

	@Test
	void testInscripcionAceptada() {
		a1.inscripcionAceptada(c1);
		assertTrue(a1.getCursando().contains(c1));
	}	
	
	@Test
	void testAprobar() {
		a1.inscripcionAceptada(c2);
		a1.aprobar(c2);
		assertFalse(a1.getCursando().contains(c2));
	}
	
	@Test
	void testCreditosObtenidos() {
		a1.inscripcionAceptada(c3);
		a1.aprobar(c3);
		assertEquals(a1.creditosObtenidos(),15);
	}
	
	@Test
	void testEquals() {
		assertTrue(a1.equals(a2));	
		//PREGUNTAR
	}
	
	@Test
	void testCompare() {
		assertTrue(a1.compareTo(a2)>0);
	}


}
