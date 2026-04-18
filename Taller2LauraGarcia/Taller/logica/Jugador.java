package logica;

public class Jugador  extends Entrenador {

    private int cantidadMedallas;


    public Jugador(String nombre, Pokemon equipoPokemones, int cantidadMedallas) {
        super(nombre, equipoPokemones);
        this.cantidadMedallas = cantidadMedallas;
    }

    public int getCantidadMedallas() {
        return cantidadMedallas;
    }
}
