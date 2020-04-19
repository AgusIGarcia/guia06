package died.guia06;

public class App {

	public static void main(String[] args) {
		
		ComparaAlumnoPorLegajo compLeg = new ComparaAlumnoPorLegajo();
		ComparaAlumnosPorCreditos compCred = new ComparaAlumnosPorCreditos();
		
		Alumno a1 = new Alumno("Ricardo Perez",25311);
		Alumno a2 = new Alumno("Orlando Alvarez",25315);
		Alumno a3 = new Alumno("Carlos Oviedo", 26354);
		
		Curso c1 = new Curso(1, "DIED", 2021, 1, 20, 25);
		Curso c2 = new Curso(2, "AEDD", 2020, 2, 10, 0);
		Curso c3 = new Curso(3, "Paradigmas", 2020, 3, 15, 0);
		Curso c4 = new Curso(4, "Disenio", 2020, 40, 15, 0);
		Curso c5 = new Curso(5, "Paradigmas2", 2020, 3, 15, 0);
		Curso c6 = new Curso(6, "Disenio2", 2020, 40, 15, 0);
		
		
		try {
			c2.inscribir(a1);
		} 
		catch (ExcepcionInscripcion e) {
			System.out.println(e.getMessage());
		}
		catch (RegistroAuditoriaException e){
			System.out.println("Error en el registro.");
		}
		
		try {
			c2.inscribir(a2);
		} 
		catch (ExcepcionInscripcion e) {
			System.out.println(e.getMessage());
		}
		catch (RegistroAuditoriaException e){
			System.out.println("Error en el registro.");
		}
		
		try {
			c2.inscribir(a3);
		} 
		catch (ExcepcionInscripcion e) {
			System.out.println(e.getMessage());
		}
		catch (RegistroAuditoriaException e){
			System.out.println("Error en el registro.");
		}
		
		try {
			c1.inscribir(a1);
		} 
		catch (ExcepcionInscripcion e) {
			System.out.println(e.getMessage());
		}
		catch (RegistroAuditoriaException e){
			System.out.println("Error en el registro.");
		}
		
		try {
			c3.inscribir(a1);
			c4.inscribir(a1);
			c5.inscribir(a1);
		} 
		catch (ExcepcionInscripcion e) {
			System.out.println(e.getMessage());
		}
		catch (RegistroAuditoriaException e){
			System.out.println("Error en el registro.");
		}
		try {
			a1.aprobar(c3);
			a1.aprobar(c4);
			c1.inscribir(a1);
		} 
		catch (ExcepcionInscripcion e) {
			System.out.println(e.getMessage());
		}
		catch (RegistroAuditoriaException e){
			System.out.println("Error en el registro.");
		}
		
		
		c2.imprimirInscriptos();
		c2.imprimirInscriptos(compLeg);
		c1.imprimirInscriptos();
		
		
	}
}
