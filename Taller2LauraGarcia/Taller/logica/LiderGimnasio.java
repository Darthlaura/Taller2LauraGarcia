package logica;

import java.util.ArrayList;

public class LiderGimnasio extends Entrenador  {
	private int numeroA; 
	private String estado;
	private int cantidadPokemones; 
	private ArrayList<String> listaPokemones; 
	
	public LiderGimnasio(int numeroA, String nombre, String estado, int cantidadPokemones, ArrayList<String> listaPokemones) {
		super(nombre, new ArrayList<Pokemon>());
		this.numeroA = numeroA;
		this.estado = estado;
		this.cantidadPokemones= cantidadPokemones; 
		this.listaPokemones= listaPokemones; 
		
	}

	public int getNumeroA() {
		return numeroA;
	}

	public String getEstado() {
		return estado;
	}

	public int getCantidadPokemones() {
		return cantidadPokemones;
	}

	public ArrayList<String> getListaPokemones() {
		return listaPokemones;
	}

	
	

}
