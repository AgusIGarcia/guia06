package died.guia06;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import died.guia06.util.Registro;

/**
 * Clase que representa un curso. Un curso se identifica por su ID y por su nombre y ciclo lectivo.
 * Un curso guarda una lista de los inscriptos actuales que tienen.
 * Un curso, al aprobarlo, otorga una cantidad de creditos definidas en el curso.
 * Un curso requiere que para inscribirnos tengamos al menos la cantidad de creditos requeridas, y que haya cupo disponible
 * @author marti
 *
 */
public class Curso {

	private Integer id;
	private String nombre;
	private Integer cicloLectivo;
	private Integer cupo; 
	private List<Alumno> inscriptos;
	private Integer creditos;
	private Integer creditosRequeridos;
	
	private Registro log;
	
	public Curso() {
		super();
		this.inscriptos = new ArrayList<Alumno>();
		this.log = new Registro();
	}
	
	

	public Curso(Integer id, String nombre, Integer cicloLectivo, Integer cupo, Integer creditos,
			Integer creditosRequeridos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cicloLectivo = cicloLectivo;
		this.cupo = cupo;
		this.creditos = creditos;
		this.creditosRequeridos = creditosRequeridos;
		this.inscriptos = new ArrayList<Alumno>();
		this.log = new Registro();
	}



	/**
	 * Este método, verifica si el alumno se puede inscribir y si es así lo agrega al curso,
	 * agrega el curso a la lista de cursos en los que está inscripto el alumno y retorna verdadero.
	 * Caso contrario retorna falso y no agrega el alumno a la lista de inscriptos ni el curso a la lista
	 * de cursos en los que el alumno está inscripto.
	 * 
	 * Para poder inscribirse un alumno debe
	 * 		a) tener como minimo los creditos necesarios
	 *      b) tener cupo disponibles
	 *      c) puede estar inscripto en simultáneo a no más de 3 cursos del mismo ciclo lectivo.
	 * @param a
	 * @return
	 */
	public Boolean inscribir(Alumno a) throws ExcepcionInscripcion, RegistroAuditoriaException{
		
		boolean cumpleCreditos = a.creditosObtenidos() >= this.creditosRequeridos;
		boolean cumpleMateriasCiclo = a.cantidadCursosCiclo(this.cicloLectivo) < 3;
		boolean hayCupo = inscriptos.size() < cupo;
		
		if(!cumpleCreditos) throw new ExcepcionInscripcion("No posee creditos suficientes");
		if(!cumpleMateriasCiclo) throw new ExcepcionInscripcion("Ya esta inscripto en 3 materias de este ciclo lectivo");
		if(!hayCupo) throw new ExcepcionInscripcion("No hay mas cupo");
		
		inscriptos.add(a);
		a.inscripcionAceptada(this);
		try {
			log.registrar(this, "inscribir ",a.toString());
			System.out.println("Inscripto correctamente.");
			return true;
		} 
		catch (IOException e) {
			throw new RegistroAuditoriaException();
		}
		
	}
	
	
	/**
	 * imprime los inscriptos en orden alfabetico
	 */
	public void imprimirInscriptos() {
		this.inscriptos.sort(null);
		try {
			System.out.println(this.inscriptos.toString());
			log.registrar(this, "imprimir listado",this.inscriptos.size()+ " registros ");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void imprimirInscriptos(Comparator<Alumno> c) {
		inscriptos.sort(c);
		try {
			System.out.println(this.inscriptos.toString());
			log.registrar(this, "imprimir listado",this.inscriptos.size()+ " registros ");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int getCreditos() {
		return creditos;
	}
	public int getCicloLectivo() {
		return cicloLectivo;
	}

}
