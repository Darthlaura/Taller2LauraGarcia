package logica;

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
 
    	public void setCantidadMedalla( int cantidadMedallas) {
    		this.cantidadMedallas  = cantidadMedallas; 
    		
    	}
   
    	public void agregarPokemon( Pokemon pokemon) {
    		equipoPokemones.add(pokemon); 
    		
    }
    
    

}
