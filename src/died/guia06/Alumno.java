package died.guia06;

import java.util.List;


public class Alumno implements Comparable{

	private String nombre;
	private Integer nroLibreta;
	private List<Curso> cursando;
	private List<Curso> aprobados;
	private Integer creditos;

		
	public Alumno() {}

	public Alumno(String nombre, Integer nroLibreta) {
		super();
		this.nombre = nombre;
		this.nroLibreta = nroLibreta;
		this.creditos=0;
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
	
	public boolean equals(Alumno a) {
	
		if (this.nroLibreta == a.nroLibreta) return true;
	
	return false;
	}

	@Override
	public int compareTo(Object o) {
		return this.nombre.compareTo(((Alumno)o).nombre);
	}
	

}
