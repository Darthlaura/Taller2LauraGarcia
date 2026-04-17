package logica;


public class Entrenador {
	private String nombre; 
	private  Pokemon equipoPokemones;
	
	
	public Entrenador(String nombre, Pokemon equipoPokemones) {
		this.nombre = nombre;
		this.equipoPokemones = equipoPokemones;
	}


	public Entrenador(String nombre2, Pokemon equipoPokemones2) {
		// TODO Auto-generated constructor stub
	}


	public String getNombre() {
		return nombre;
	}


	public Pokemon getEquipoPokemones() {
		return equipoPokemones;
	} 

	
	
}
