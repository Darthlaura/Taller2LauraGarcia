package logica;
//Autor: Laura Garcia 
//Rut: 26427429-k
//Paracelo c2 

import java.util.*;

import java.io.*;
import java.util.random.*;
import java.io.IOException;;

public class Main {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		GestorArchivo gestor = new GestorArchivo();
		ArrayList<Pokemon> pokedex = new ArrayList<Pokemon>();
		ArrayList<Habitat> habitats = new ArrayList<Habitat>();
		ArrayList<LiderGimnasio> gimnasios = new ArrayList<LiderGimnasio>();
		ArrayList<AltoMando> altoMando = new ArrayList<AltoMando>();

		try {
            //abrir los archivos
			pokedex = gestor.abrirArchivoPokemon("Pokedex.txt");
			habitats = gestor.abrirArchivoHabitat("habitat.txt");
			gimnasios = gestor.abrirArchivoGym("gimnasios.txt");
			altoMando = gestor.abrirArchivoAltoMando("altoMando.txt");
             
			System.out.println("Archivos cargados correctamente. ");
			System.out.println("Pokemones cargados:  " + pokedex.size());
			System.out.println("Habitas cargados: " + habitats.size());
			System.out.println("Gimnasios cargados: " + gimnasios.size());
			System.out.println("Alto mando cargado: " + altoMando.size());

		} catch (FileNotFoundException e) {
			System.out.println("Error al imprimir el archivo");
		}

		boolean continuar = true;

		while (continuar) {
			continuar = manejoMenu(teclado, pokedex, habitats, gimnasios, altoMando, gestor);

		}

		teclado.close();
	}

	/**
	 * Metodo para retornar un int para controlar el menu principal 
	 * @param teclado
	 * @return int opcion
	 * @throws IllegalArgumentException
	 */
	public static int retornoMenu(Scanner teclado) throws IllegalArgumentException {
		int opcion = 0;

		do {
			System.out.println("1) Continuar.");
			System.out.println("2) Nueva Partida.");
			System.out.println("3) Salir.");
			System.out.print("Ingrese Opcion: ");
			opcion = leerEntero(teclado); 
			

			if (opcion < 1 || opcion > 3) {

				System.out.println("Opcion fuera del rango");
			}

		} while (opcion < 1 || opcion > 3);

		return opcion;

	}

	/**
	 * Metodo para retornar un int para controlar el menu usuario
	 * @param teclado
	 * @return int opcionMenuContinuar
	 * @throws IllegalArgumentException
	 */
	public static int menuContinuar(Scanner teclado) throws IllegalArgumentException {
		int opcionMenuContinuar = 0;

		do {
			System.out.println("1) Revisar equipo.");
			System.out.println("2) Salie a capturar.");
			System.out.println("3) Acceso al PC (Cambiar Pokemon del equipo).");
			System.out.println("4) Retar un gimnasio.");
			System.out.println("5) Desafio al Alto Mando.");
			System.out.println("6) Curar Pokemon.");
			System.out.println("7) Guardar.");
			System.out.println("8) Guardar y Salir.");
			System.out.print("Ingrese Opcion: ");
			opcionMenuContinuar = leerEntero(teclado); 
			if (opcionMenuContinuar < 1 || opcionMenuContinuar > 8) {
				System.out.println("opcion fuera del rango");

			}
		} while (opcionMenuContinuar < 1 || opcionMenuContinuar > 8);

		return opcionMenuContinuar;

	}

	/**
	 * Metodo para el manejo del menu principal que engobla retorno de menu y menu continuar
	 * 
	 * @param teclado
	 * @param pokedex
	 * @param habitats
	 * @param gimnasios
	 * @param altoMando
	 * @param gestor
	 * @return boolean true o false
	 */
	public static boolean manejoMenu(Scanner teclado, ArrayList<Pokemon> pokedex, ArrayList<Habitat> habitats,
			ArrayList<LiderGimnasio> gimnasios, ArrayList<AltoMando> altoMando, GestorArchivo gestor) {

		int entradaMenuPrincipal = 0;

		try {
			entradaMenuPrincipal = retornoMenu(teclado);
			switch (entradaMenuPrincipal) {
			case 1: {
				try {
					Jugador jugador = gestor.cargarPartida("Registros.txt", pokedex);
					actualizarEstadosGimnasios(jugador, gimnasios);

					System.out.println("Bienvenido " + jugador.getNombre() + "!!");

					boolean continuarMenu = true;

					while (continuarMenu) {
						continuarMenu = controlMenuContinuar(teclado, jugador, pokedex, habitats, gimnasios, altoMando,
								gestor);
					}

				} catch (FileNotFoundException e) {
					System.out.println("No existe una partida guardada.");
				}

				break;
			}
			case 2: {
				System.out.println("Ingresa Apodo: ");
				String nombreJugador = teclado.nextLine();

				ArrayList<Pokemon> equipoJugador = new ArrayList<Pokemon>();
				Jugador jugador = new Jugador(nombreJugador, 0, equipoJugador);

				try {
					gestor.guardarPartida("Registros.txt", jugador);
					System.out.println("Nueva partida creada correctamente.");
				} catch (IOException e) {
					System.out.println("Error al crear la nueva partida.");
				}

				System.out.println("Bienvenido " + jugador.getNombre() + "!!");

				boolean continuarMenu = true;

				while (continuarMenu) {
					continuarMenu = controlMenuContinuar(teclado, jugador, pokedex, habitats, gimnasios, altoMando,
							gestor);
				}

				return false;

			}

			case 3: {
				System.out.println(" Nos vemos entrenador.....");

				return false;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + entradaMenuPrincipal);
			}

		} catch (IllegalArgumentException e) {
			System.out.println("Accion fuera del rango");
		}
		return true;

	}

	
	
         
	
	    /**
	     * Metodo para controlar la entrada de int del usuario en cada uno de los casos donde se requiera, este metodo controlara la entrada de solo numeros
	     * @param teclado
	     * @return int numero
	     */
		public static int leerEntero(Scanner teclado) {
		    int numero = 0;
		    boolean valido = false;

		    while (valido == false) {
		        try {
		            numero = Integer.valueOf(teclado.nextLine());
		            valido = true;
		        } catch (NumberFormatException e) {
		            System.out.println("Debes ingresar un numero.");
		            System.out.print("Intenta nuevamente: ");
		        }
		    }

		    return numero;
		}
		

	
	
	/**
	 * Metodo para controlar el menu del usuario para salir a capturar
	 * @param teclado
	 * @param jugador
	 * @param pokedex
	 * @param habitats
	 * @param gimnasios
	 * @param altoMando
	 * @param gestor
	 * @return boolean true o false
	 */
	public static boolean controlMenuContinuar(Scanner teclado, Jugador jugador, ArrayList<Pokemon> pokedex,
			ArrayList<Habitat> habitats, ArrayList<LiderGimnasio> gimnasios, ArrayList<AltoMando> altoMando,
			GestorArchivo gestor) {
		int entradaMenuContinuar = 0;
		boolean continuar = false;
		try {
			entradaMenuContinuar = menuContinuar(teclado);
			switch (entradaMenuContinuar) {
			case 1: {
				jugador.mostrarEquipo();
				continuar = true;
				return continuar;
			}
			case 2: {
				System.out.println("salir a capturar mostrar zonas ");
				salirACapturar(teclado, jugador, pokedex, habitats);
				continuar = true;
				return continuar;
			}
			case 3: {
				System.out.println("cambiar el pokemon");
				accesoPc(teclado, jugador);
				continuar = true;
				return continuar;
			}
			case 4: {
				retarGimnasio(teclado, jugador, gimnasios, pokedex);
				continuar = true;
				return continuar;
			}
			case 5: {
				desafioAltoMando(teclado, jugador, altoMando, pokedex);

				continuar = true;
				return continuar;
			}
			case 6: {
				jugador.curarPokemones();
				// esta funcion es del jugador
				continuar = true;
				return continuar;
			}
			case 7: {
				try {
					gestor.guardarPartida("Registros.txt", jugador);
					System.out.println("Partida guardada correctamente.");
				} catch (IOException e) {
					System.out.println("Error al guardar la partida.");
				}

				continuar = true;
				return continuar;
			}
			case 8: {
				try {
					gestor.guardarPartida("Registros.txt", jugador);
					System.out.println("Partida guardada correctamente.");
				} catch (IOException e) {
					System.out.println("Error al guardar la partida.");
				}

				System.out.println("Nos vemos entrenador...");
				return false;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + entradaMenuContinuar);
			}

		} catch (IllegalArgumentException e) {
			// TODO Auto-generated method stub

		}


		continuar = true;
		return continuar;

	}

	/**
	 * Metodo que permite desafiar al alto mando
	 * @param teclado
	 * @param jugador
	 * @param altoMando
	 * @param pokedex
	 */
	private static void desafioAltoMando(Scanner teclado, Jugador jugador, ArrayList<AltoMando> altoMando,
			ArrayList<Pokemon> pokedex) {

		if (jugador.getCantidadMedallas() < 8) {
			System.out.println("Necesitas las 8 medallas para desafiar al Alto Mando.");
			return;
		}

		System.out.println("Comienza el desafio del Alto Mando!!");

		for (int i = 0; i < altoMando.size(); i++) {

			AltoMando miembro = altoMando.get(i);

			System.out.println("Te enfrentaras a " + miembro.getNombre() + "!!");

			for (int j = 0; j < miembro.getListaPokemones().size(); j++) {

				String nombrePokemonRival = miembro.getListaPokemones().get(j);
				Pokemon pokemonRival = buscarPokemonPorNombre(nombrePokemonRival, pokedex);

				if (pokemonRival == null) {
					System.out.println("No se encontro el pokemon rival: " + nombrePokemonRival);
					return;
				}

				System.out.println(miembro.getNombre() + " saca a " + pokemonRival.getTipoPokemon() + "!!");

				Pokemon pokemonJugador = jugador.obtenerPrimerPokemonVivo();

				if (pokemonJugador == null) {
					System.out.println("Te has quedado sin pokemones en tu equipo!");
					System.out.println("Volviendo al menu...");
					return;
				}

				System.out.println(jugador.getNombre() + " saca a " + pokemonJugador.getTipoPokemon() + "!!");

				boolean batallaTerminada = false;

				while (batallaTerminada == false) {

					System.out.println("Que deseas hacer?");
					System.out.println("1) Atacar");
					System.out.println("2) Cambiar de Pokemon");
					System.out.println("3) Rendirse");
					System.out.print("Ingrese Opcion: ");

					int opcionBatalla = leerEntero(teclado); 

					if (opcionBatalla == 3) {
						System.out.println("Te has rendido. Volviendo al menu...");
						return;
					}

					if (opcionBatalla < 1 || opcionBatalla > 3) {
						System.out.println("Opcion fuera de rango.");
					}

					if (opcionBatalla == 2) {
						jugador.mostrarEquipo();

						int limiteEquipo = jugador.getEquipoPokemones().size();

						if (limiteEquipo > 6) {
							limiteEquipo = 6;
						}

						System.out.println("Ingrese el numero del pokemon a usar: ");
						int opcionCambio = leerEntero(teclado);

						if (opcionCambio < 1 || opcionCambio > limiteEquipo) {
							System.out.println("Solo puedes elegir uno de los primeros 6 Pokemon.");
						} else {
							Pokemon nuevoPokemon = jugador.getEquipoPokemones().get(opcionCambio - 1);

							if (nuevoPokemon.getEstado().equalsIgnoreCase("Debilitado")) {
								System.out.println("No puedes usar Pokemon debilitado.");
							} else {
								pokemonJugador = nuevoPokemon;
								System.out.println("Adelante " + pokemonJugador.getTipoPokemon() + "!!");
							}
						}
					}

					if (opcionBatalla == 1) {

						int statsJugador = pokemonJugador.calcularStatusTotales();
						int statsRival = pokemonRival.calcularStatusTotales();

						double efectividadJugador = TablaTipos.obtenerEfectividad(pokemonJugador.getTipo(),
								pokemonRival.getTipo());

						double efectividadRival = TablaTipos.obtenerEfectividad(pokemonRival.getTipo(),
								pokemonJugador.getTipo());

						double puntajeJugador = statsJugador * efectividadJugador;
						double puntajeRival = statsRival * efectividadRival;

						System.out.println(pokemonJugador.getTipoPokemon() + " -> " + puntajeJugador + " puntos");
						System.out.println(pokemonRival.getTipoPokemon() + " -> " + puntajeRival + " puntos");

						if (puntajeJugador > puntajeRival) {
							System.out.println("Ha ganado " + pokemonJugador.getTipoPokemon() + "!");
							pokemonRival.setEstado("Debilitado");
						} else {
							System.out.println("Ha ganado " + pokemonRival.getTipoPokemon() + "! "
									+ pokemonJugador.getTipoPokemon() + " ha sido derrotado...");
							pokemonJugador.setEstado("Debilitado");
						}

						batallaTerminada = true;
					}
				}
			}
		}

		System.out.println("Felicidades! Has derrotado al Alto Mando!");
		System.out.println("Ahora eres campeon Pokemon!");
	}

	/**
	 * Metodo para retar al gimnasio 
	 * @param teclado
	 * @param jugador
	 * @param gimnasios
	 */
	private static void retarGimnasio(Scanner teclado, Jugador jugador, ArrayList<LiderGimnasio> gimnasios,
			ArrayList<Pokemon> pokedex) {

		System.out.println("A cual Lider deseas retar? ");

		for (int i = 0; i < gimnasios.size(); i++) {
			LiderGimnasio lider = gimnasios.get(i);
			System.out.println((i + 1) + ") " + lider.getNombre() + " - Estado: " + lider.getEstado());
		}

		System.out.println((gimnasios.size() + 1) + ") Volver al menu.");
		System.out.print("Ingrese Opcion: ");

		int opcionGimnasio = leerEntero(teclado);
		

		if (opcionGimnasio == gimnasios.size() + 1) {
			System.out.println("Volviendo al menu...");
			return;
		}

		if (opcionGimnasio < 1 || opcionGimnasio > gimnasios.size() + 1) {
			System.out.println("Opcion fuera del rango.");
			return;
		}

		int indiceGimnasio = opcionGimnasio - 1;

		if (indiceGimnasio > jugador.getCantidadMedallas()) {
			LiderGimnasio liderElegido = gimnasios.get(indiceGimnasio);

			System.out.println("Calmado Entrenador!! No puedes retar a " + liderElegido.getNombre()
					+ " sin haber derrotado a los lideres anteriores!!");
			return;
		}

		LiderGimnasio liderElegido = gimnasios.get(indiceGimnasio);

		if (liderElegido.getEstado().equalsIgnoreCase("Derrotado")) {
			System.out.println("Ya derrotaste a este lider de gimnasio.");
			return;
		}

		System.out.println("Desafiando a " + liderElegido.getNombre() + "!!");

		if (jugador.tienePokemoVivo() == false) {
			System.out.println("No tienes Pokemon vivos para combatir.");
			return;
		}

		for (int i = 0; i < liderElegido.getListaPokemones().size(); i++) {

			String nombrePokemonRival = liderElegido.getListaPokemones().get(i);
			Pokemon pokemonRival = buscarPokemonPorNombre(nombrePokemonRival, pokedex);

			if (pokemonRival == null) {
				System.out.println("No se encontro el pokemon rival: " + nombrePokemonRival);
				return;
			}

			System.out.println(liderElegido.getNombre() + " saca a " + pokemonRival.getTipoPokemon() + "!!");

			Pokemon pokemonJugador = jugador.obtenerPrimerPokemonVivo();

			if (pokemonJugador == null) {
				System.out.println("Te has quedado sin pokemones en tu equipo!");
				System.out.println("Volviendo al menu...");
				return;
			}

			System.out.println(jugador.getNombre() + " saca a " + pokemonJugador.getTipoPokemon() + "!!");

			boolean pokemonRivalDerrotado = false;

			while (pokemonRivalDerrotado == false) {

				if (pokemonJugador == null || pokemonJugador.getEstado().equalsIgnoreCase("Debilitado")) {
					pokemonJugador = jugador.obtenerPrimerPokemonVivo();

					if (pokemonJugador == null) {
						System.out.println("Te has quedado sin pokemones en tu equipo!");
						System.out.println("Volviendo al menu...");
						return;
					}

					System.out.println(jugador.getNombre() + " saca a " + pokemonJugador.getTipoPokemon() + "!!");
				}

				System.out.println("Que deseas hacer?");
				System.out.println("1) Atacar");
				System.out.println("2) Cambiar de pokemon");
				System.out.println("3) Rendirse");
				System.out.print("Ingrese una opcion: ");

				int opcionBatalla = leerEntero(teclado); 

				if (opcionBatalla == 3) {
					System.out.println("Te has rendido. Volviendo al menu...");
					return;
				}

				if (opcionBatalla < 1 || opcionBatalla > 3) {
					System.out.println("Opcion fuera de rango.");
				}

				if (opcionBatalla == 2) {
					jugador.mostrarEquipo();

					int limiteEquipo = jugador.getEquipoPokemones().size();

					if (limiteEquipo > 6) {
						limiteEquipo = 6;
					}

					System.out.print("Ingrese el numero del pokemon a usar: ");
					int opcionCambio = leerEntero(teclado); 
					

					if (opcionCambio < 1 || opcionCambio > limiteEquipo) {
						System.out.println("Solo puedes elegir uno de los primeros 6 Pokemon.");
					} else {
						Pokemon nuevoPokemon = jugador.getEquipoPokemones().get(opcionCambio - 1);

						if (nuevoPokemon.getEstado().equalsIgnoreCase("Debilitado")) {
							System.out.println("No puedes usar Pokemon debilitado.");
						} else {
							pokemonJugador = nuevoPokemon;
							System.out.println("Adelante " + pokemonJugador.getTipoPokemon() + "!!");
						}
					}
				}

				if (opcionBatalla == 1) {

					int statsJugador = pokemonJugador.calcularStatusTotales();
					int statsRival = pokemonRival.calcularStatusTotales();

					double efectividadJugador = TablaTipos.obtenerEfectividad(pokemonJugador.getTipo(),
							pokemonRival.getTipo());

					double efectividadRival = TablaTipos.obtenerEfectividad(pokemonRival.getTipo(),
							pokemonJugador.getTipo());

					double puntajeJugador = statsJugador * efectividadJugador;
					double puntajeRival = statsRival * efectividadRival;

					System.out.println(pokemonJugador.getTipoPokemon() + " : " + puntajeJugador + " puntos");
					System.out.println(pokemonRival.getTipoPokemon() + " : " + puntajeRival + " puntos");

					if (puntajeJugador > puntajeRival) {
						System.out.println("Ha ganado " + pokemonJugador.getTipoPokemon() + "!");
						pokemonRival.setEstado("Debilitado");
						pokemonRivalDerrotado = true;
					} else {
						System.out.println("Ha ganado " + pokemonRival.getTipoPokemon() + "! "
								+ pokemonJugador.getTipoPokemon() + " ha sido derrotado...");
						pokemonJugador.setEstado("Debilitado");

						if (jugador.tienePokemoVivo() == false) {
							System.out.println("Te has quedado sin pokemones en tu equipo!");
							System.out.println("Volviendo al menu...");
							return;
						}
					}
				}
			}
		}

		System.out.println("Has derrotado a " + liderElegido.getNombre() + "!");
		System.out.println("Has ganado una medalla!");

		liderElegido.marcarComoDerrotado();
		jugador.setCantidadMedallas(jugador.getCantidadMedallas() + 1);
	}

	/**
	 * Metodo para buscar pokemon por nombre 
	 * @param nombrePokemon
	 * @param pokedex
	 * @return
	 */
	public static Pokemon buscarPokemonPorNombre(String nombrePokemon, ArrayList<Pokemon> pokedex) {

		for (int i = 0; i < pokedex.size(); i++) {
			Pokemon p = pokedex.get(i);
			if (p.getTipoPokemon().equalsIgnoreCase(nombrePokemon)) {

				return p; // si lo encuentra retorna p

			}

		}
		return null;

	}

	/**
	 * Metodo para acceso al pc
	 * @param teclado
	 * @param jugador
	 */
	private static void accesoPc(Scanner teclado, Jugador jugador) {
		ArrayList<Pokemon> pokemonesJugador = jugador.getEquipoPokemones();

		if (pokemonesJugador.size() == 0) {
			System.out.println("No tienes Pokemon capturados.");
			return;
		}

		System.out.println("Pokemones capturados:");

		for (int i = 0; i < pokemonesJugador.size(); i++) {
			Pokemon p = pokemonesJugador.get(i);

			System.out
					.println((i + 1) + ") " + p.getTipoPokemon() + " | " + p.getTipo() + " | Estado: " + p.getEstado());
		}

		System.out.println("Que desea hacer?");
		System.out.println("1) Cambiar Pokemon");
		System.out.println("2) Salir");
		System.out.print("Ingrese Opcion: ");

		int opcionPc = leerEntero(teclado);

		if (opcionPc == 2) {
			System.out.println("Saliendo del PC...");
			return;
		}

		if (opcionPc != 1) {
			System.out.println("Opcion fuera de rango.");
			return;
		}

		System.out.print("Ingrese el numero del primer Pokemon a cambiar: ");
		int posicion1 = leerEntero(teclado); 

		System.out.print("Ingrese el numero del segundo Pokemon a cambiar: ");
		int posicion2 = leerEntero(teclado); 

		if (posicion1 < 1 || posicion1 > pokemonesJugador.size() || posicion2 < 1
				|| posicion2 > pokemonesJugador.size()) {

			System.out.println("Una de las posiciones esta fuera de rango.");
			return;
		}

		Pokemon aux = pokemonesJugador.get(posicion1 - 1);
		pokemonesJugador.set(posicion1 - 1, pokemonesJugador.get(posicion2 - 1));
		pokemonesJugador.set(posicion2 - 1, aux);

		System.out.println("Pokemon cambiados correctamente.");

	

	}

	/**
	 * Metodo que permite al usuario salir a capturar
	 * 
	 * @param teclado
	 * @param jugador
	 * @param pokedex
	 * @param habitats
	 */
	public static void salirACapturar(Scanner teclado, Jugador jugador, ArrayList<Pokemon> pokedex,
			ArrayList<Habitat> habitats) {

		System.out.println("Donde deseas ir a explorar?");
		System.out.println("Zonas disponibles: ");

		// validaciones
		for (int i = 0; i < habitats.size(); i++) {
			System.out.println((i + 1) + ")" + habitats.get(i).getZona());

		}
		System.out.println((habitats.size() + 1) + ") Volver al Menu"); // volver al menu luego de imprimir la ultima
																		// zona

		// Zona elegida por el usuario
		System.out.println("Ingrese Zona: ");
		int opcionZona = leerEntero(teclado);

		if (opcionZona == habitats.size() + 1) {
			System.out.println("Volviendo al menu...."); // muestra la opcion de volver al menu
			return;
		}
		if (opcionZona < 1 || opcionZona > habitats.size() + 1) {
			System.out.println("Zona fuera del rango. ");
			return;
		}

		Habitat habitastElegido = habitats.get(opcionZona - 1);
		String zonaElegida = habitastElegido.getZona();

		System.out.println("Elegiste explorar: " + zonaElegida);

		ArrayList<Pokemon> pokemonesDeLaZona = new ArrayList<Pokemon>();

		for (int i = 0; i < pokedex.size(); i++) {
			Pokemon p = pokedex.get(i);

			if (p.getHabitat().equalsIgnoreCase(zonaElegida)) {
				pokemonesDeLaZona.add(p);

			}
		}

		// si la lista esta vacia no hay pokemones que capturar
		if (pokemonesDeLaZona.size() == 0) {
			System.out.println("No hay Pokemon en esta zona. ");
			return;

		}
		Random random = new Random();

		double numeroAleatorio = random.nextDouble(); // número entre 0.0 y 1.0
		double acumulado = 0;
		Pokemon pokemonEncontrado = null;

		for (int i = 0; i < pokemonesDeLaZona.size(); i++) {
			Pokemon p = pokemonesDeLaZona.get(i);

			acumulado = acumulado + p.getPorcentajeAparicion();

			if (numeroAleatorio <= acumulado) {
				pokemonEncontrado = p;
				break;
			}
		}

		if (pokemonEncontrado == null) {
			pokemonEncontrado = pokemonesDeLaZona.get(pokemonesDeLaZona.size() - 1);
		}

		System.out.println("Ha aparecido un pokemon " + pokemonEncontrado.getTipoPokemon());
		System.out.println("Que deseas hacer?");
		System.out.println("1) Capturar");
		System.out.println("2) Huir");
		System.out.print("Ingrese Opcion: ");

		int opcionCaptura = leerEntero(teclado); 
		

		if (opcionCaptura == 1) {

		    if (jugador.tienePokemon(pokemonEncontrado.getTipoPokemon())) {
		        System.out.println("Ya tienes este pokemon.");

		    } else {

		        Pokemon copiaPokemon = pokemonEncontrado.copiarPokemon();
		        jugador.agregarPokemon(copiaPokemon);

		        System.out.println(pokemonEncontrado.getTipoPokemon() + " capturado con exito!!");
		        System.out.println(pokemonEncontrado.getTipoPokemon() + " ha sido agregado a tu equipo.");
		    }

		} else if (opcionCaptura == 2) {

		    System.out.println("Has huido del Pokemon.");

		} else {

		    System.out.println("Opcion fuera del rango.");
		}

	}
	
	/**
	 * Metodo para actualizar Estado de gimnasios
	 * @param jugador
	 * @param gimnasios
	 */
	public static void actualizarEstadosGimnasios(Jugador jugador, ArrayList<LiderGimnasio> gimnasios) {
	    int medallas = jugador.getCantidadMedallas();

	    for (int i = 0; i < gimnasios.size(); i++) {
	        LiderGimnasio lider = gimnasios.get(i);

	        if (i < medallas) {
	            lider.marcarComoDerrotado();
	        } else {
	            lider.setEstado("Sin derrotar");
	        }
	    }
	}
	
	
	

}
