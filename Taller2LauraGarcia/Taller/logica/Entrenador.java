package logica;
//Autor: Laura Garcia 
//Rut: 26427429-k
//Paracelo c2 

import java.util.ArrayList;

public class Entrenador {
    protected String nombre; 
	protected ArrayList<Pokemon> equipoPokemones;
	
	
	public Entrenador(String nombre, ArrayList<Pokemon> equipoPokemones) {
		this.nombre = nombre;
		this.equipoPokemones = equipoPokemones;
	}



	public String getNombre(){
		return nombre;
	}
    
	
	public ArrayList<Pokemon> getEquipoPokemones(){
		return equipoPokemones;
	}


    public void mostrarEquipo(){
    	if (equipoPokemones.size() ==0) {
    		System.out.println("No tienes pokemones en tu equipo");
    		
    	}else {
    		System.out.println("Equipo Actual:");
    		for (int i =0; i < equipoPokemones.size() && i < 6; i++) {
    			Pokemon p = equipoPokemones.get(i);
    			
    			System.out.println((i+ 1) +") "
    			+p.getTipoPokemon()
    			+"| "+ p.getTipo()
    			+ "| " + "Estado : " + p.getEstado() 
    			+ "| Status totales: " + p.calcularStatusTotales());
    			
    			
    		}
    	}


	}
	public boolean tienePokemoVivo(){
		    for (int i = 0; i < equipoPokemones.size() && i < 6; i++) {
		        Pokemon p = equipoPokemones.get(i);

		        if (p.getEstado().equalsIgnoreCase("Vivo")) {
		            return true;
		        }
		    }

		    return false;
		}
	
	
	public Pokemon obtenerPrimerPokemonVivo() {
		
		for (int i =0; i  < equipoPokemones.size() && i < 6; i++) {
			Pokemon p = equipoPokemones.get(i);
			
			if (p.getEstado().equalsIgnoreCase("Vivo")) {
				return p;
				
			}
		}
		return null;
		
	
	
	}
	
	public void curarPokemones() {
		for(int i =0 ; i < equipoPokemones.size();i++) {
			Pokemon p = equipoPokemones.get(i);
			p.setEstado("Vivo"); // asignamos el estado a vivo 
		}
		
		System.out.println("Tu equipo se ha recuperado");
		
	}

}
