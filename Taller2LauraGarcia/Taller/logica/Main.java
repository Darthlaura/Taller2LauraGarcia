package logica;

import java.util.*;
import java.io.*;
import java.util.random.*;

import sun.awt.dnd.SunDragSourceContextPeer;



public class Main {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		GestorArchivo gestor = new GestorArchivo(); 
		ArrayList<Pokemon> pokedex = new ArrayList<Pokemon>();
	    ArrayList<Habitat> habitats = new ArrayList<Habitat>(); 
	    ArrayList<LiderGimnasio> gimnasios = new ArrayList<LiderGimnasio>(); 
	    ArrayList<AltoMando> altoMando = new ArrayList<AltoMando>(); 
	    
	    
	    try {
	    	
	    	
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
		
		
		
		
		while(continuar) {
			manejoMenu(teclado, pokedex, habitats, gimnasios, altoMando);
			
		}

		 
		teclado.close();
	}

	public static int retornoMenu(Scanner teclado) throws IllegalArgumentException {
		int opcion = 0;

		do {
			System.out.println("1) Continuar.");
			System.out.println("2) Nueva Partida.");
			System.out.println("3) Salir.");
			System.out.print("Ingrese Opcion: ");
			opcion = Integer.valueOf(teclado.nextLine());

			if (opcion < 1 || opcion > 3) {

				System.out.println("Opcion fuera del rango");
			}

		} while (opcion < 1 || opcion > 3);

		return opcion;

	}

	public static int menuContinuar(Scanner teclado)  throws IllegalArgumentException{
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
			opcionMenuContinuar = Integer.valueOf(teclado.nextLine());
			if (opcionMenuContinuar < 1 || opcionMenuContinuar > 8) {
				System.out.println("opcion fuera del rango");

			}
		} while (opcionMenuContinuar < 1 || opcionMenuContinuar > 8);

		return opcionMenuContinuar;

	}
	
	public static void manejoMenu(Scanner teclado, ArrayList<Pokemon> pokedex,ArrayList<Habitat> habitats,
			ArrayList<LiderGimnasio> gimnasios, ArrayList<AltoMando> altoMado   ) {
		
		int entradaMenuPrincipal=0; 
		
		try {
			entradaMenuPrincipal = retornoMenu(teclado); 
			switch (entradaMenuPrincipal) {
			/**case 1: {
				boolean continuarMenu = true;
				while (continuarMenu) {
					boolean menuInterno; 
				
					menuInterno=controlMenuContinuar(teclado, jugador);
					if(menuInterno == false) {
						continuarMenu = false; 
						break; 
					}
				}
			     break;
			}*/
			case 2: {
				System.out.println("Ingresa Apodo: ");
				String nombreJugador = teclado.nextLine();
				
				ArrayList<Pokemon> equipoJugador = new ArrayList<Pokemon>(); 
				Jugador jugador = new Jugador(nombreJugador,0, equipoJugador);
				System.out.println("Bienvenido " + jugador.getNombre() +  "!!");
				boolean continuarMenu = true; 
				
				while (continuarMenu) {
					continuarMenu = controlMenuContinuar(teclado,jugador);
					
				}
				
				
				
				break;
			}
			
			case 3: {
				
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + entradaMenuPrincipal);
			}
			
		}catch (IllegalArgumentException e) {
			System.out.println("Accion fuera del rango");
		}
		
		
	}
	
	public static boolean controlMenuContinuar(Scanner teclado, Jugador jugador, ArrayList<Pokemon> pokedex, ArrayList<Habitat> habitats) {
		int entradaMenuContinuar=0;
		boolean continuar= false;
		try {
			entradaMenuContinuar= menuContinuar(teclado); 
			switch (entradaMenuContinuar) {
			case 1: {
				jugador.mostrarEquipo();
				continuar = true ;  
				return continuar;  
			}
			case 2: { 
				System.out.println("salir a capturar mostrar sonas ");
			    salirACapturar(teclado, jugador, pokedex, habitats);
				continuar = true ;  
				return continuar;
			}
			case 3: {
				System.out.println("cambiar el pokemon");
				accesoPc(teclado,jugador); 
				continuar = true ;  
				return continuar;
			}
			case 4: {
				System.out.println("Retar gim ");
				//ir a retar 
				continuar = true ;  
				return continuar;
			}
			case 5: {
				System.out.println("Desafio alto mando");
				// ir a desafiar al alto mando
				continuar = true ;  
				return continuar; 
			}
			case 6: {
				jugador.curarPokemones();
				//esta funcion es del jugador 
				continuar = true ;  
				return continuar; 
			}
			case 7: {
				System.out.println("guardar");
				//sobre escribir el archivo
				continuar = true ;  
				return continuar;
			}
			case 8: {
				System.out.println("Nos vemos Entrenador");
				return false;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + entradaMenuContinuar);
			}
			
			
			
		}catch (IllegalArgumentException e) {
			// TODO: handle exception
		
			continuar = true ;  
			return continuar;
		
		
	}

	}
	
	private static void accesoPc(Scanner teclado, Jugador jugador) {
		ArrayList<Pokemon> pokemonesJugador = jugador.getEquipoPokemones(); 
		
		
		if(pokemonesJugador.size() ==0) {
			System.out.println("No tienes Pokemon capturados."); 
			return; 
			
			
		}
		
		System.out.println("Pokemones capturados: ");
		for (int i =0; i < pokemonesJugador. size(); i++) {
			Pokemon p = pokemonesJugador.get(i); 
			System.out.println((1+1)+ ")" + p.getTipoPokemon() + "| " + p.getTipo() + "| " + p.getEstado());
			System.out.println("Que desea hacer ?: ");
			System.out.println("1) Cambiar Pokemon: ");
			System.out.println("2) Salir: ");
			System.out.println("Ingrese Opcion ");
			
			int opcionPc = Integer.valueOf(teclado.nextLine()); 
	        if (opcionPc ==2) {
	        	System.out.println("Saliendo del Pc....");
	        	return; 
	        
	        }
	        
	        if(opcionPc != 1) {
	        	System.out.println("Opcion fuera de rango.");
	        	return;
	        }
			
		}
		
		// TODO Auto-generated method stub
		
	}

	public static void salirACapturar(Scanner teclado, Jugador jugador, ArrayList<Pokemon> pokedex, ArrayList<Habitat> habitats) {
		
		System.out.println("Donde deseas ir a explorar?");
		System.out.println("Zonas disponibles: ");
		
		
		//validaciones 
		for (int i= 0; i< habitats.size(); i++) {
			System.out.println((i+1) + ")" + habitats.get(i).getZona() );
			
		}
		System.out.println((habitats.size() + 1 ) + ") Volver al Menu" );  // volver al menu luego de imprimir la ultima zona 
		
		
		//Zona elegida por el usuario
		System.out.println("Ingrese Zona: ");
		int opcionZona = Integer.valueOf(teclado.nextLine()); 
		
		if(opcionZona == habitats.size() +1) { 
			System.out.println("Volviendo al menu....");  //muestra la opcion de volver al menu
			return;
		}
		if (opcionZona < 1 || opcionZona > habitats.size()+1) {
			System.out.println("Zona fuera del rango. ");
			return;
		}
	
		
		Habitat habitastElegido = habitats.get(opcionZona - 1); 
		String zonaElegida = habitastElegido.getZona(); 
		
		System.out.println("Elegiste explorar: " + zonaElegida );
		
		
		ArrayList<Pokemon> pokemonesDeLaZona = new ArrayList<Pokemon>(); 
		
		for(int i =0; i < pokedex.size(); i++) {
			Pokemon p = pokedex.get(i);
			
			if (p.getHabitat().equalsIgnoreCase(zonaElegida)) {
				pokemonesDeLaZona.add(p);
				
				
			}
		}
		
		//si la lista esta vacia no hay pokemones que capturar 
		if (pokemonesDeLaZona.size() ==0) {
			System.out.println("No hay Pokemon en esta zona. ");
			return; 
			
		}
		Random random = new Random(); 
		int posicionAleatoria = random.nextInt(pokemonesDeLaZona.size()); 
		Pokemon pokemonEncontrado = pokemonesDeLaZona.get(posicionAleatoria); 
		System.out.println("Ha aparecido un pokemon " + pokemonEncontrado.getTipoPokemon());
		
		System.out.println("Que deseas hacer? ");
		System.out.println("1) Capturar");
		System.out.println("2) Huir");
		System.err.println("Ingrese Opcion"); 
		
		int opcionCaptura = Integer.valueOf(teclado.nextLine()); 
		
		if (opcionCaptura ==1) {
			
			if (jugador.tienePokemon(pokemonEncontrado.getTipoPokemon())){
				System.out.println("Ya tienes este pokemon");
				
			}else {
			
			
			jugador.agregarPokemon(pokemonEncontrado);
			System.out.println(pokemonEncontrado.getTipoPokemon() + "Capturado ocn exito!!");
			System.out.println(pokemonEncontrado.getTipoPokemon()+ "ha sido agregado a tu equipo ");
			
			
			}
			
		} else if (opcionCaptura ==2) {
			System.out.println("Has huido del Pokemon");
			
			
		}else {
			
			System.out.println("Opcion fuera del rango.. ");
		}
		
		
		
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
}