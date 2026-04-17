package logica;

public class LiderGimnasio extends Entrenador  {
	private int numeroA; 
	private boolean estado;
	private String nombre;
	
	public LiderGimnasio(String nombre, Pokemon equipoPokemones, int numeroA, boolean estado, String nombre2) {
		super(nombre, equipoPokemones);
		this.numeroA = numeroA;
		this.estado = estado;
		nombre = nombre2;
	} 
	
	

}
