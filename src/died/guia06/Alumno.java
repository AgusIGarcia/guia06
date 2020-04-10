package died.guia06;

import java.util.ArrayList;
import java.util.List;


public class Alumno implements Comparable{

	private String nombre;
	private Integer nroLibreta;
	private List<Curso> cursando;
	private List<Curso> aprobados;
	private Integer creditos;

		
	public Alumno() {
		super();
		this.creditos=0;
		this.cursando = new ArrayList<Curso>();
		this.aprobados = new ArrayList<Curso>();
	}

	public Alumno(String nombre, Integer nroLibreta) {
		super();
		this.nombre = nombre;		
		this.nroLibreta = nroLibreta;
		this.creditos=0;
		this.cursando = new ArrayList<Curso>();
		this.aprobados = new ArrayList<Curso>();
	}

	public int creditosObtenidos() {
		return creditos;
	}

	public void aprobar(Curso c) {
		this.cursando.remove(c);
		creditos += c.getCreditos();
	}

	public void inscripcionAceptada(Curso c) {
		this.cursando.add(c);
	}
	
	@Override
	public boolean equals(Object a) {
		return (a instanceof Alumno && this.nroLibreta == ((Alumno)a).nroLibreta);
	}

	@Override
	public int compareTo(Object o) {
		return this.nombre.compareTo(((Alumno)o).nombre);
	}

	public List<Curso> getCursando() {
		return cursando;
	}

	public List<Curso> getAprobados() {
		return aprobados;
	}


	

}
