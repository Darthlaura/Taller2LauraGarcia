package logica;

import java.util.ArrayList;

public class AltoMando extends Entrenador {

	private int numeroA;
	private boolean estado;
	private ArrayList<String> listaPokemones;

	public AltoMando(int numeroA, String nombre, ArrayList<String> listaPokemones) {
		super(nombre, new ArrayList<Pokemon>());
		this.numeroA = numeroA;
		this.listaPokemones = listaPokemones;
		this.estado = false;
	}

	public int getNumeroA() {
		return numeroA;
	}

	public boolean isEstado() {
		return estado;
	}

	public ArrayList<String> getListaPokemones() {
		return listaPokemones;

	}
}