package logica;
//Autor: Laura Garcia 
//Rut: 26427249-k
//Paracelo c2 

import java.util.ArrayList;

public class Jugador  extends Entrenador {

    private int cantidadMedallas;
   


    public Jugador(String nombre, int cantidadMedallas, ArrayList<Pokemon> equipoPokemones) {
        super(nombre, equipoPokemones);
        this.cantidadMedallas = cantidadMedallas;
      
    }

    public int getCantidadMedallas() {
        return cantidadMedallas;
    }
 
    	public void setCantidadMedallas( int cantidadMedallas) {
    		this.cantidadMedallas  = cantidadMedallas; 
    		
    	}
   
    	public void agregarPokemon( Pokemon pokemon) {
    		equipoPokemones.add(pokemon); 
    		
    }
    	
    	
    	public boolean tienePokemon(String nombrePokemon) {
    		for (int i =0; i< equipoPokemones.size(); i++) {
    			
    			Pokemon p = equipoPokemones.get(i); 
    			if (p.getTipoPokemon().equalsIgnoreCase(nombrePokemon)) {
    				return true;
    				
    			}
    			
    			
    		}
    		return false;
    		
    	}
    	
    	
    	
    	
    	
    	
    	
    
    

}
