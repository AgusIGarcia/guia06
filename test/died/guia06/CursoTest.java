package died.guia06;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CursoTest {

	Alumno a1 = new Alumno("Ricardo Perez",25311);
	Alumno a2 = new Alumno("Orlando Alvarez",25311);
	Alumno a3 = new Alumno("Carlos Oviedo", 26354);
	
	Curso c1 = new Curso(1, "DIED", 2020, 1, 20,25);
	Curso c2 = new Curso(1, "AEDD", 2018, 2, 1,0);
	Curso c3 = new Curso(1, "Paradigmas", 2019, 0, 15,0);
	
	@Test
	void testInscripcionCorrecta() {
		try {
			assertTrue(c2.inscribir(a1));
		} catch (ExcepcionInscripcion e) {
			e.printStackTrace();
		} catch (RegistroAuditoriaException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testInscripcionFallaPorCreditos() {
		try {
			c1.inscribir(a1);
			fail("Esta linea no deberia ejecutarse");
		} catch (ExcepcionInscripcion e) {
			assertEquals(e.getMessage(),"No posee creditos suficientes");
		} catch (RegistroAuditoriaException e) {
			e.printStackTrace();
		}
	}	
	
	@Test
	void testInscripcionFallaPorCupo() {
		try {
			c3.inscribir(a1);
			fail("Esta linea no deberia ejecutarse");
		} catch (ExcepcionInscripcion e) {
			assertEquals(e.getMessage(),"No hay mas cupo");
		} catch (RegistroAuditoriaException e) {
			e.printStackTrace();
		}
	}	
	
	@Test
	void testInscripcionFallaPorCantidadDeMaterias() {
		Curso c11 = new Curso(1, "DIED", 2020, 1, 20,0);
		Curso c22 = new Curso(1, "DIED2", 2020, 1, 20,0);
		Curso c33 = new Curso(1, "DIED3", 2020, 1, 20,0);
		Curso c44 = new Curso(1, "DIED4", 2020, 1, 20,0);
		try {
			c11.inscribir(a1);
			c22.inscribir(a1);
			c33.inscribir(a1);
			c44.inscribir(a1);
			fail("Esta linea no deberia ejecutarse");
		} catch (ExcepcionInscripcion e) {
			assertEquals(e.getMessage(),"Ya esta inscripto en 3 materias de este ciclo lectivo");
		} catch (RegistroAuditoriaException e) {
			e.printStackTrace();
		}
	}	
}
