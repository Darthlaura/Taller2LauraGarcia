package logica;

import java.util.ArrayList;

public class Entrenador {
    protected String nombre; 
	protected ArrayList<Pokemon> equipoPokemones;
	
	
	public Entrenador(String nombre, ArrayList<Pokemon> equipoPokemones) {
		this.nombre = nombre;
		this.equipoPokemones = equipoPokemones;
	}



	public String getNombre()
	{
		return nombre;
	}
    
	
	public ArrayList<Pokemon> getEquipoPokemones(){
		return equipoPokemones;
	}


    public void mostrarEquipo(){


	}
	public boolean tienePokemoVido(){
		boolean vivo = false;

		return vivo;

	}
	public void obtenerPokemon(){


	}
	
}
