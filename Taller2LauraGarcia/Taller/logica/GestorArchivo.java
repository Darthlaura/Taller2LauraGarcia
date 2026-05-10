package logica;
//Autor: Laura Garcia 
//Rut: 26427249-k
//Paracelo c2 

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class GestorArchivo {



	public GestorArchivo() {

	}

	/**
	 * metodo para leer el archivo que contiene los datos de altoMando
	 * 
	 * @param nombreArchivo
	 * @return retorna un ArrayList de tipo AltoMando
	 * @throws FileNotFoundException
	 */
	public ArrayList<AltoMando> abrirArchivoAltoMando(String nombreArchivo) throws FileNotFoundException {
		ArrayList<AltoMando> listaAltoMandoLectura = new ArrayList<AltoMando>();
		File archivo = new File(nombreArchivo);
		Scanner lectura = new Scanner(archivo);

		while (lectura.hasNextLine()) {
			String linea = lectura.nextLine();
			String[] partes = linea.split(";");
			int numeroAltoMando = Integer.parseInt(partes[0]);
			String nombre = partes[1];
			ArrayList<String> listaPokemones = new ArrayList<String>();
			for (int i = 2; i < partes.length; i++) {
				String pokemonLeido = partes[i];
				listaPokemones.add(pokemonLeido);
			}
			AltoMando a = new AltoMando(numeroAltoMando, nombre, listaPokemones);
			listaAltoMandoLectura.add(a);

		}
		lectura.close();
		return listaAltoMandoLectura;

	}

	/**
	 * metodo para leer el archivo de gimnasio
	 * 
	 * @param nombreArchivo
	 * @return una ArrayList de tipo Gimnasio
	 * @throws FileNotFoundException
	 */
	public ArrayList<LiderGimnasio> abrirArchivoGym(String nombreArchivo) throws FileNotFoundException {
		ArrayList<LiderGimnasio> listaGymLectura = new ArrayList<LiderGimnasio>();
		File archivo = new File(nombreArchivo);
		Scanner lectura = new Scanner(archivo);

		while (lectura.hasNextLine()) {
			String linea = lectura.nextLine();
			String[] partes = linea.split(";");
			int numeroGimnasio = Integer.parseInt(partes[0]);
			String nombreLider = partes[1];
			String estado = partes[2];
			int cantidadPokemones = Integer.parseInt(partes[3]);

			ArrayList<String> listaPokemones = new ArrayList<String>();
			for (int i = 4; i < partes.length; i++) {
				String pokemonLeido = partes[i];
				listaPokemones.add(pokemonLeido);
			}
			LiderGimnasio li = new LiderGimnasio(numeroGimnasio, nombreLider, estado, cantidadPokemones,
					listaPokemones);
			listaGymLectura.add(li);

		}
		lectura.close();

		return listaGymLectura;

	}

	/**
	 * metodo para leer el archivo de pokemon
	 * 
	 * @param nombreArchivo
	 * @return retorna un ArrayList<Pokemon>
	 * @throws FileNotFoundException
	 */

	public ArrayList<Pokemon> abrirArchivoPokemon(String nombreArchivo) throws FileNotFoundException {
		ArrayList<Pokemon> listaPokemonLectura = new ArrayList<Pokemon>();
		File archivo = new File(nombreArchivo);
		Scanner lectura = new Scanner(archivo);

		while (lectura.hasNextLine()) {
			String linea = lectura.nextLine();
			String[] partes = linea.split(";");
			String pokemon = partes[0];
			String habitat = partes[1];
			double porcentajeParticipacion = Double.parseDouble(partes[2]);
			int vida = Integer.parseInt(partes[3]);
			int ataque = Integer.parseInt(partes[4]);
			int defensa = Integer.parseInt(partes[5]);
			int ataqueEspecial = Integer.parseInt(partes[6]);
			int defensaEspecial = Integer.parseInt(partes[7]);
			int velocidad = Integer.parseInt(partes[8]);
			String tipo = partes[9];
			Pokemon p = new Pokemon(pokemon, habitat, porcentajeParticipacion, vida, ataque, defensa, ataqueEspecial,
					defensaEspecial, velocidad, tipo);
			listaPokemonLectura.add(p);

		}
		lectura.close();

		return listaPokemonLectura;

	}

	/***
	 * metodo para leer el archivo de habitat
	 * 
	 * @param nombreArchivo
	 * @return ArrayList<Habitat>
	 * @throws FileNotFoundException
	 */
	public ArrayList<Habitat> abrirArchivoHabitat(String nombreArchivo) throws FileNotFoundException {
		ArrayList<Habitat> listaHabitatLectura = new ArrayList<Habitat>();
		File archivo = new File(nombreArchivo);
		Scanner lectura = new Scanner(archivo);

		while (lectura.hasNextLine()) {
		    String linea = lectura.nextLine();
		    String nombreHabitat = linea;
		    
			Habitat h = new Habitat(nombreHabitat);
			listaHabitatLectura.add(h);

		}

		lectura.close();

		return listaHabitatLectura;

	}
	
	public void guardarPartida(String nombreArchivo, Jugador jugador) throws IOException {
	    BufferedWriter escritor = new BufferedWriter(new FileWriter(nombreArchivo));

	    escritor.write(jugador.getNombre() + ";" + jugador.getCantidadMedallas());
	    escritor.newLine();

	    ArrayList<Pokemon> lista = jugador.getEquipoPokemones();

	    for (int i = 0; i < lista.size(); i++) {
	        Pokemon p = lista.get(i);

	        escritor.write(p.getTipoPokemon() + ";" + p.getEstado());
	        escritor.newLine();
	    }

	    escritor.close();
	}

	
	public Jugador cargarPartida(String nombreArchivo, ArrayList<Pokemon> pokedex) throws FileNotFoundException {
	    File archivo = new File(nombreArchivo);
	    Scanner lectura = new Scanner(archivo);

	    String primeraLinea = lectura.nextLine();
	    String[] datosJugador = primeraLinea.split(";");

	    String nombreJugador = datosJugador[0];
	    int cantidadMedallas = Integer.parseInt(datosJugador[1]);

	    ArrayList<Pokemon> pokemonesJugador = new ArrayList<Pokemon>();

	    while (lectura.hasNextLine()) {
	        String linea = lectura.nextLine();
	        String[] partes = linea.split(";");

	        String nombrePokemon = partes[0];
	        String estadoPokemon = partes[1];

	        Pokemon pokemonEncontrado = null;

	        for (int i = 0; i < pokedex.size(); i++) {
	            Pokemon p = pokedex.get(i);

	            if (p.getTipoPokemon().equalsIgnoreCase(nombrePokemon)) {
	                pokemonEncontrado = p;
	            }
	        }
	        if (pokemonEncontrado != null) {
	            Pokemon copiaPokemon = pokemonEncontrado.copiarPokemon();
	            copiaPokemon.setEstado(estadoPokemon);
	            pokemonesJugador.add(copiaPokemon);
	        }
	    }

	    lectura.close();

	    Jugador jugador = new Jugador(nombreJugador, cantidadMedallas, pokemonesJugador);

	    return jugador;
	}
	
	
	
}
