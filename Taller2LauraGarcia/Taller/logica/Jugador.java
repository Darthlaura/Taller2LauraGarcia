package logica;

import java.util.ArrayList;

public class Jugador  extends Entrenador {

    private int cantidadMedallas;
    private String estado; 


    public Jugador(String nombre, int cantidadMedallas, ArrayList<Pokemon> equipoPokemones, String estado) {
        super(nombre, equipoPokemones);
        this.cantidadMedallas = cantidadMedallas;
        this.estado= estado;
    }

    public int getCantidadMedallas() {
        return cantidadMedallas;
    }
    public String getEstado() {
    	
    	return estado; 
    }
    
    

}
