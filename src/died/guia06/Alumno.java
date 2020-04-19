package died.guia06;

import java.util.ArrayList;
import java.util.List;


public class Alumno implements Comparable<Alumno>{

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

	public Integer creditosObtenidos() {
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
	public int compareTo(Alumno o) {
		return this.nombre.compareTo(o.nombre);
	}

	public List<Curso> getCursando() {
		return cursando;
	}

	public List<Curso> getAprobados() {
		return aprobados;
	}

	public int cantidadCursosCiclo(int ciclo) {
		
		int cant = 0;
		for(Curso cc : cursando) {
			if(cc.getCicloLectivo() == ciclo) cant++;
		}
		return cant;
		
	}

	public Integer getNroLibreta() {
		return nroLibreta;
	}

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", nroLibreta=" + nroLibreta + ", cursando=" + cursando + ", aprobados="
				+ aprobados + ", creditos=" + creditos + "]";
	}
	

}
